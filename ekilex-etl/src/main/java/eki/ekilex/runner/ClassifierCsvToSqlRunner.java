package eki.ekilex.runner;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eki.common.constant.ClassifierName;
import eki.ekilex.data.transform.ClassifierMapping;

// does not handle LANG, DOMAIN, LABEL_TYPE
@Component
public class ClassifierCsvToSqlRunner extends AbstractClassifierRunner {

	private static Logger logger = LoggerFactory.getLogger(ClassifierCsvToSqlRunner.class);

	private static final String INSERT_MAIN_CLASSIFIER_TEMPLATE = "insert into ${name} (code) values ('${code}');";

	private static final String INSERT_MAIN_CLASSIFIER_LABEL_TEMPLATE = "insert into ${name}_label (code, value, lang, type) values ('${code}', '${value}', '${lang}', '${type}');";

	private List<String> classifierNames;

	@Override
	void initialise() throws Exception {

		classifierNames = new ArrayList<>();
		classifierNames.add(REGISTER);
		classifierNames.add(POS);
		classifierNames.add(DERIV);
		classifierNames.add(MORPH);
		classifierNames.add(LEXEME_TYPE);
		classifierNames.add(MEANING_STATE);
		classifierNames.add(MEANING_TYPE);
	}

	public void execute() throws Exception {

		List<ClassifierMapping> existingClassifiers = loadExistingMainClassifiers();

		StringBuffer insertClassifBuf = new StringBuffer();
		StringBuffer insertClassifLabelBuf = new StringBuffer();

		composeMainClassifierSql(existingClassifiers, insertClassifBuf, insertClassifLabelBuf);

		FileOutputStream classifierSqlStream = new FileOutputStream(CLASSIFIER_MAIN_SQL_PATH);

		IOUtils.write(insertClassifBuf, classifierSqlStream, StandardCharsets.UTF_8);
		IOUtils.write("\n", classifierSqlStream, StandardCharsets.UTF_8);
		IOUtils.write(insertClassifLabelBuf, classifierSqlStream, StandardCharsets.UTF_8);

		classifierSqlStream.flush();
		classifierSqlStream.close();
	}

	private void composeMainClassifierSql(List<ClassifierMapping> existingClassifiers, StringBuffer insertClassifBuf, StringBuffer insertClassifLabelBuf) {

		List<String> insertClassifiers = new ArrayList<>();
		String sql;

		for (ClassifierMapping classifier : existingClassifiers) {

			String lexName = classifier.getLexName();
			String lexCode = classifier.getLexCode();
			String lexValue = classifier.getLexValue();
			String lexValueLang = classifier.getLexValueLang();
			String lexValueType = classifier.getLexValueType();

			if (isValuedCell(lexName)
					&& isValuedCell(lexCode)
					&& isValuedCell(lexValue)
					&& isValuedCell(lexValueLang)
					&& isValuedCell(lexValueType)) { // code + label

				ClassifierName classifierName = ClassifierName.valueOf(lexName.toUpperCase());
				if (!classifierName.hasLabel()) {
					logger.warn("Unable to create label for classifier {} since it has no label", lexName);
				}
				String classifKey = composeRow(CLASSIFIER_KEY_SEPARATOR, lexName, lexCode);
				if (!insertClassifiers.contains(classifKey)) {
					insertClassifiers.add(classifKey);
					sql = composeInsertClassifier(lexName, lexCode);
					insertClassifBuf.append(sql);
					insertClassifBuf.append('\n');
				}
				sql = composeInsertClassifierLabel(lexName, lexCode, lexValue, lexValueLang, lexValueType);
				insertClassifLabelBuf.append(sql);
				insertClassifLabelBuf.append('\n');

			} else if (isValuedCell(lexName) && isValuedCell(lexCode)) { // no label, only code

				String classifKey = composeRow(CLASSIFIER_KEY_SEPARATOR, lexName, lexCode);
				if (!insertClassifiers.contains(classifKey)) {
					insertClassifiers.add(classifKey);
					sql = composeInsertClassifier(lexName, lexCode);
					insertClassifBuf.append(sql);
					insertClassifBuf.append('\n');
				}

			} else {
				logger.warn("Unmapped data row: \"{}\"", classifier.toString());
				continue;
			}
		}
	}

	private String composeInsertClassifier(String name, String code) {

		String sql = new String(INSERT_MAIN_CLASSIFIER_TEMPLATE);
		sql = StringUtils.replace(sql, "${name}", name);
		sql = StringUtils.replace(sql, "${code}", code);
		return sql;
	}

	private String composeInsertClassifierLabel(String name, String code, String value, String lang, String type) {

		String sql = new String(INSERT_MAIN_CLASSIFIER_LABEL_TEMPLATE);
		sql = StringUtils.replace(sql, "${name}", name);
		sql = StringUtils.replace(sql, "${code}", code);
		sql = StringUtils.replace(sql, "${value}", value);
		sql = StringUtils.replace(sql, "${lang}", lang);
		sql = StringUtils.replace(sql, "${type}", type);
		return sql;
	}

	private boolean isValuedCell(String cellValue) {
		return StringUtils.isNotBlank(cellValue) && !StringUtils.equals(cellValue, emptyCellValue);
	}
}
