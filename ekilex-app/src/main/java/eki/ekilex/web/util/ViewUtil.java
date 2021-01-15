package eki.ekilex.web.util;

import java.text.DecimalFormat;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.common.constant.TextDecoration;
import eki.ekilex.data.DecoratedWordType;
import eki.ekilex.service.CommonDataService;

@Component
public class ViewUtil implements InitializingBean {

	private static final String LEXEME_WEIGHT_PATTERN = "#.##";

	private Map<String, String> languageIso2Map = null;

	private DecimalFormat lexemeWeightFormat;

	@Autowired
	private CommonDataService commonDataService;

	@Override
	public void afterPropertiesSet() {
		lexemeWeightFormat = new DecimalFormat(LEXEME_WEIGHT_PATTERN);
	}

	public String getLangIso2(String langIso3) {
		if (StringUtils.isBlank(langIso3)) {
			return "-";
		}
		if (languageIso2Map == null) {
			languageIso2Map = commonDataService.getLanguageIso2Map();
		}
		String langIso2 = languageIso2Map.get(langIso3);
		if (StringUtils.isBlank(langIso2)) {
			return "?";
		}
		return langIso2;
	}

	public String getWordValueMarkup(DecoratedWordType word) {

		String wordPrese = new String(word.getWordValuePrese());
		if (word.isSuffixoid()) {
			wordPrese = "-" + wordPrese;
		} else if (word.isPrefixoid()) {
			wordPrese = wordPrese + "-";
		}
		StringBuilder htmlBuf = new StringBuilder();
		htmlBuf.append("<span>");
		String foreignMarkupCode = TextDecoration.FOREIGN.getCode();
		if (word.isForeign() && !StringUtils.contains(wordPrese, foreignMarkupCode)) {
			htmlBuf.append('<');
			htmlBuf.append(foreignMarkupCode);
			htmlBuf.append('>');
			htmlBuf.append(wordPrese);
			htmlBuf.append("</");
			htmlBuf.append(foreignMarkupCode);
			htmlBuf.append('>');
		} else {
			htmlBuf.append(wordPrese);
		}
		htmlBuf.append("</span>");
		return htmlBuf.toString();
	}

	public String getFormattedLexemeWeight(Float lexemeWeight) {
		return lexemeWeightFormat.format(lexemeWeight);
	}

	public String composeFunction(String functionName, Object... args) {
		String functionSignature = functionName + "(" + StringUtils.join(args, ',') + ")";
		return functionSignature;
	}
}
