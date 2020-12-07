package eki.wordweb.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import eki.common.constant.GlobalConstant;
import eki.common.data.ExceptionStat;
import eki.common.data.SearchStat;
import eki.wordweb.data.SearchValidation;
import eki.wordweb.data.WordsData;

@Component
public class StatDataCollector implements GlobalConstant {

	private static Logger logger = LoggerFactory.getLogger(StatDataCollector.class);

	@Value("${stat.service.enabled:false}")
	private boolean serviceEnabled;

	@Value("${stat.service.url}")
	private String serviceUrl;

	@Value("${stat.service.key}")
	private String serviceKey;

	@Async
	public void postExceptionStat(Throwable exception) {

		if (!serviceEnabled || exception == null) {
			return;
		}

		String exceptionName = exception.getClass().getName();
		String exceptionMessage = exception.getMessage();
		ExceptionStat exceptionStat = new ExceptionStat(exceptionName, exceptionMessage);

		HttpHeaders headers = createHeaders();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<ExceptionStat> exceptionStatEntity = new HttpEntity<>(exceptionStat, headers);
		try {
			restTemplate.postForObject(serviceUrl + "/exception", exceptionStatEntity, String.class);
		} catch (RestClientException e) {
			logger.error("posting exception stat data failed: {}", e.getMessage());
		}
	}

	@Async
	public void postSearchStat(SearchValidation searchValidation, WordsData wordsData, String searchMode, String userAgent) {

		if (!serviceEnabled) {
			return;
		}

		String searchWord = searchValidation.getSearchWord();
		Integer homonymNr = searchValidation.getHomonymNr();
		List<String> destinLangs = searchValidation.getDestinLangs();
		List<String> datasetCodes = searchValidation.getDatasetCodes();
		String searchUri = searchValidation.getSearchUri();
		int resultCount = wordsData.getResultCount();
		boolean resultsExist = wordsData.isResultsExist();
		boolean isSingleResult = wordsData.isSingleResult();

		SearchStat searchStat = new SearchStat();
		searchStat.setSearchWord(searchWord);
		searchStat.setHomonymNr(homonymNr);
		searchStat.setSearchMode(searchMode);
		searchStat.setDestinLangs(destinLangs);
		searchStat.setDatasetCodes(datasetCodes);
		searchStat.setSearchUri(searchUri);
		searchStat.setResultCount(resultCount);
		searchStat.setResultsExist(resultsExist);
		searchStat.setSingleResult(isSingleResult);
		searchStat.setUserAgent(userAgent);

		HttpHeaders headers = createHeaders();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<SearchStat> searchStatEntity = new HttpEntity<>(searchStat, headers);
		try {
			restTemplate.postForObject(serviceUrl + "/search", searchStatEntity, String.class);
		} catch (RestClientException e) {
			logger.error("posting search stat data failed: {}", e.getMessage());
		}
	}

	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set(STAT_API_KEY_HEADER_NAME, serviceKey);
		return headers;
	}

}
