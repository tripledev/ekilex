package eki.wordweb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import eki.common.constant.FormMode;
import eki.common.constant.GlobalConstant;
import eki.common.service.util.LexemeLevelPreseUtil;
import eki.wordweb.constant.SystemConstant;
import eki.wordweb.constant.WebConstant;
import eki.wordweb.data.CollocationTuple;
import eki.wordweb.data.Form;
import eki.wordweb.data.Lexeme;
import eki.wordweb.data.Paradigm;
import eki.wordweb.data.SearchContext;
import eki.wordweb.data.SearchFilter;
import eki.wordweb.data.TypeCollocMember;
import eki.wordweb.data.Word;
import eki.wordweb.data.WordData;
import eki.wordweb.data.WordForm;
import eki.wordweb.data.WordSearchElement;
import eki.wordweb.data.WordsData;
import eki.wordweb.service.db.CommonDataDbService;
import eki.wordweb.service.db.SearchDbService;
import eki.wordweb.service.util.ClassifierUtil;
import eki.wordweb.service.util.CollocConversionUtil;
import eki.wordweb.service.util.EtymConversionUtil;
import eki.wordweb.service.util.LexemeConversionUtil;
import eki.wordweb.service.util.ParadigmConversionUtil;
import eki.wordweb.service.util.WordConversionUtil;

public abstract class AbstractSearchService implements SystemConstant, WebConstant, GlobalConstant {

	@Autowired
	protected SearchDbService searchDbService;

	@Autowired
	protected CommonDataDbService commonDataDbService;

	@Autowired
	protected ClassifierUtil classifierUtil;

	@Autowired
	protected WordConversionUtil wordConversionUtil;

	@Autowired
	protected LexemeConversionUtil lexemeConversionUtil;

	@Autowired
	protected CollocConversionUtil collocConversionUtil;

	@Autowired
	protected EtymConversionUtil etymConversionUtil;

	@Autowired
	protected ParadigmConversionUtil paradigmConversionUtil;

	@Autowired
	protected LexemeLevelPreseUtil lexemeLevelPreseUtil;

	public abstract SearchContext getSearchContext(SearchFilter searchFilter);

	public abstract WordData getWordData(Long wordId, SearchFilter searchFilter, String displayLang);

	@Transactional
	public Map<String, List<String>> getWordsByInfixLev(String wordInfix, SearchFilter searchFilter, int limit) {

		SearchContext searchContext = getSearchContext(searchFilter);
		Map<String, List<WordSearchElement>> results = searchDbService.getWordsByInfixLev(wordInfix, searchContext, limit);
		List<WordSearchElement> wordGroup = results.get(WORD_SEARCH_GROUP_WORD);
		List<WordSearchElement> formGroup = results.get(WORD_SEARCH_GROUP_FORM);
		if (CollectionUtils.isEmpty(wordGroup)) {
			wordGroup = new ArrayList<>();
		}
		if (CollectionUtils.isEmpty(formGroup)) {
			formGroup = new ArrayList<>();
		}
		List<String> prefWords = wordGroup.stream().map(WordSearchElement::getWord).collect(Collectors.toList());
		List<String> formWords = formGroup.stream().map(WordSearchElement::getWord).collect(Collectors.toList());
		if (CollectionUtils.isNotEmpty(prefWords)) {
			prefWords.forEach(formWords::remove);
			int prefWordsCount = prefWords.size();
			int formWordsCount = formWords.size();
			int requiredPrefWordsCount = Math.min(prefWordsCount, limit - formWordsCount);
			prefWords = prefWords.subList(0, requiredPrefWordsCount);
		}
		Map<String, List<String>> searchResultCandidates = new HashMap<>();
		searchResultCandidates.put("prefWords", prefWords);
		searchResultCandidates.put("formWords", formWords);
		return searchResultCandidates;
	}

	@Transactional
	public WordsData getWords(SearchFilter searchFilter) {

		String searchWord = searchFilter.getSearchWord();
		Integer homonymNr = searchFilter.getHomonymNr();

		SearchContext searchContext = getSearchContext(searchFilter);
		List<Word> allWords = searchDbService.getWords(searchWord, searchContext);
		boolean resultsExist = CollectionUtils.isNotEmpty(allWords);
		wordConversionUtil.setAffixoidFlags(allWords);
		wordConversionUtil.composeHomonymWrapups(allWords, searchContext);
		wordConversionUtil.selectHomonym(allWords, homonymNr);
		List<Word> wordMatchWords = allWords.stream().filter(word -> word.isWordMatch()).collect(Collectors.toList());
		List<String> formMatchWordValues = allWords.stream().filter(word -> word.isFormMatch()).map(Word::getWord).distinct().collect(Collectors.toList());
		int resultCount = CollectionUtils.size(wordMatchWords);
		boolean isSingleResult = resultCount == 1;
		return new WordsData(wordMatchWords, formMatchWordValues, resultCount, resultsExist, isSingleResult);
	}

	protected void compensateNullWords(Long wordId, List<CollocationTuple> collocTuples) {

		for (CollocationTuple tuple : collocTuples) {
			List<TypeCollocMember> collocMembers = tuple.getCollocMembers();
			for (TypeCollocMember collocMem : collocMembers) {
				if (StringUtils.isBlank(collocMem.getWord())) {
					String collocValue = tuple.getCollocValue();
					List<String> collocTokens = Arrays.asList(StringUtils.split(collocValue));
					List<WordForm> wordFormCandidates = searchDbService.getWordFormCandidates(wordId, collocTokens);
					if (CollectionUtils.isEmpty(wordFormCandidates)) {
						tuple.setInvalid(true);
						break;
					}
					WordForm firstAvailableReplacement = wordFormCandidates.get(0);
					collocMem.setWord(firstAvailableReplacement.getWord());
					collocMem.setForm(firstAvailableReplacement.getForm());
				}
			}
		}
	}

	protected WordData composeWordData(
			Word word,
			List<Form> forms,
			List<Paradigm> paradigms,
			List<Lexeme> lexLexemes,
			List<Lexeme> termLexemes,
			List<Lexeme> limTermLexemes) {

		boolean lexemesExist = CollectionUtils.isNotEmpty(lexLexemes) || CollectionUtils.isNotEmpty(termLexemes) || CollectionUtils.isNotEmpty(limTermLexemes);
		boolean relevantDataExists = lexemesExist || CollectionUtils.isNotEmpty(word.getRelatedWords());
		boolean multipleLexLexemesExist = CollectionUtils.size(lexLexemes) > 1;
		String firstAvailableAudioFile = null;
		boolean morphologyExists = false;

		if (CollectionUtils.isNotEmpty(forms)) {
			Form firstAvailableWordForm = forms.stream()
					.filter(form -> form.getMode().equals(FormMode.WORD))
					.findFirst().orElse(null);
			if (firstAvailableWordForm != null) {
				firstAvailableAudioFile = firstAvailableWordForm.getAudioFile();
			}
		}
		if (CollectionUtils.isNotEmpty(paradigms)) {
			morphologyExists = paradigms.stream().anyMatch(paradigm -> StringUtils.isNotBlank(paradigm.getWordClass()));
		}

		WordData wordData = new WordData();
		wordData.setWord(word);
		wordData.setLexLexemes(lexLexemes);
		wordData.setTermLexemes(termLexemes);
		wordData.setLimTermLexemes(limTermLexemes);
		wordData.setParadigms(paradigms);
		wordData.setFirstAvailableAudioFile(firstAvailableAudioFile);
		wordData.setMorphologyExists(morphologyExists);
		wordData.setRelevantDataExists(relevantDataExists);
		wordData.setLexemesExist(lexemesExist);
		wordData.setMultipleLexLexemesExist(multipleLexLexemesExist);
		return wordData;
	}
}
