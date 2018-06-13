package eki.ekilex.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eki.common.constant.FreeformType;
import eki.common.constant.SourceType;
import eki.common.data.Count;
import eki.ekilex.data.transform.Source;

@Component
public class EstermSourceLoaderRunner extends AbstractLoaderRunner {

	private static Logger logger = LoggerFactory.getLogger(EstermSourceLoaderRunner.class);

	private static final String DEFAULT_TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	private static final String ESTERM_SOURCE_CODES_FILE_PATH = "./fileresources/txt/esterm_source_codes.txt";

	private final String allTlinksExp = "//descripGrp/descrip/xref[@Tlink]";
	private final String sourceConceptGroupExp = "/mtf/conceptGrp[languageGrp/language/@type='Allikas']";
	private final String conceptExp = "concept";
	private final String entryClassExp = "system[@type='entryClass']";
	private final String createdByExp = "transacGrp/transac[@type='origination']";
	private final String createdOnExp = "transacGrp[transac/@type='origination']/date";
	private final String modifiedByExp = "transacGrp/transac[@type='modification']";
	private final String modifiedOnExp = "transacGrp[transac/@type='modification']/date";
	/*
	 * Such field has never been found.
	 * Instead, source type is set programmatically.
	 * If the field will be valued in the future, some sort of mapping must be implemented.
	 */
	@Deprecated
	private final String sourceTypeExp = "descripGrp/descrip[@type='Tüüp']";
	private final String termGroupExp = "languageGrp/termGrp";
	private final String termValueExp = "term";
	private final String sourceLtbSourceExp = "descripGrp/descrip[@type='Päritolu']";
	private final String sourceRtExp = "descripGrp/descrip[@type='RT']";
	private final String sourceCelexExp = "descripGrp/descrip[@type='CELEX']";
	private final String sourceWwwExp = "descripGrp/descrip[@type='WWW']";
	private final String sourceAuthorExp = "descripGrp/descrip[@type='Autor']";
	private final String sourceIsbnExp = "descripGrp/descrip[@type='ISBN']";
	private final String sourceIssnExp = "descripGrp/descrip[@type='ISSN']";
	private final String sourcePublisherExp = "descripGrp/descrip[@type='Kirjastus']";
	private final String sourcePublicationYearExp = "descripGrp/descrip[@type='Ilmumisaasta']";
	private final String sourcePublicationPlaceExp = "descripGrp/descrip[@type='Ilmumiskoht']";
	private final String sourcePublicationNameExp = "descripGrp/descrip[@type='Väljaande nimi, nr']";
	private final String sourceNoteExp = "descripGrp/descrip[@type='Märkus']";

	private final String tlinkAttrExp = "Tlink";

	private final String xrefTlinkSourceIsPerson = "EKSPERT";

	private DateFormat defaultDateFormat;

	@Override
	String getDataset() {
		return "est";
	}

	@Override
	void initialise() throws Exception {

		defaultDateFormat = new SimpleDateFormat(DEFAULT_TIMESTAMP_PATTERN);
	}

	@Transactional
	public void execute(String dataXmlFilePath, boolean doReports) throws Exception {

		logger.debug("Starting loading Esterm sources...");

		long t1, t2;
		t1 = System.currentTimeMillis();

		Document dataDoc = xmlReader.readDocument(dataXmlFilePath);

		List<String> sourceCodes = extractEstermSourceCodes(dataDoc);
		logger.debug("Extracted {} source codes", sourceCodes.size());

		List<Element> conceptGroupNodes = dataDoc.selectNodes(sourceConceptGroupExp);
		int conceptGroupCount = conceptGroupNodes.size();
		logger.debug("Extracted {} concept groups", conceptGroupCount);

		List<Element> termGroupNodes;
		Element termNode;
		String valueStr;
		Source sourceObj;
		Long sourceId, sourceTermId;
		FreeformType sourceAttrType;

		Count dataErrorCount = new Count();

		int conceptGroupCounter = 0;
		int progressIndicator = conceptGroupCount / Math.min(conceptGroupCount, 100);

		for (Element conceptGroupNode : conceptGroupNodes) {

			sourceObj = extractAndApplySourceProperties(conceptGroupNode);
			sourceId = createSource(sourceObj);

			termGroupNodes = conceptGroupNode.selectNodes(termGroupExp);

			for (Element termGroupNode : termGroupNodes) {

				termNode = (Element) termGroupNode.selectSingleNode(termValueExp);
				valueStr = termNode.getTextTrim();
				if (StringUtils.isBlank(valueStr)) {
					continue;
				}
				if (sourceCodes.contains(valueStr)) {
					sourceAttrType = FreeformType.SOURCE_CODE;
				} else if (isProbablySourceCode(valueStr)) {
					sourceAttrType = FreeformType.SOURCE_CODE;
				} else {
					sourceAttrType = FreeformType.SOURCE_NAME;
				}
				sourceTermId = createSourceFreeform(sourceId, sourceAttrType, valueStr);

				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.LTB_SOURCE, sourceLtbSourceExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_RT, sourceRtExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_CELEX, sourceCelexExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_WWW, sourceWwwExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_AUTHOR, sourceAuthorExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_ISBN, sourceIsbnExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_ISSN, sourceIssnExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_PUBLISHER, sourcePublisherExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_PUBLICATION_YEAR, sourcePublicationYearExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_PUBLICATION_PLACE, sourcePublicationPlaceExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.SOURCE_PUBLICATION_NAME, sourcePublicationNameExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.PUBLIC_NOTE, sourceNoteExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.CREATED_BY, createdByExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.CREATED_ON, createdOnExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.MODIFIED_BY, modifiedByExp);
				extractAndSaveFreeforms(sourceTermId, termGroupNode, FreeformType.MODIFIED_ON, modifiedOnExp);
			}

			conceptGroupCounter++;
			if (conceptGroupCounter % progressIndicator == 0) {
				int progressPercent = conceptGroupCounter / progressIndicator;
				logger.debug("{}% - {} concept groups iterated", progressPercent, conceptGroupCounter);
			}
		}

		logger.debug("Found {} data errors", dataErrorCount);

		t2 = System.currentTimeMillis();
		logger.debug("Done loading in {} ms", (t2 - t1));
	}

	private List<String> extractEstermSourceCodes(Document dataDoc) throws Exception {

		List<String> sourceCodes;
		File estermSourceCodesFile = new File(ESTERM_SOURCE_CODES_FILE_PATH);
		if (estermSourceCodesFile.exists()) {

			logger.debug("Located existing esterm source codes file");
			FileInputStream estermSourceCodesStream = new FileInputStream(estermSourceCodesFile);
			sourceCodes = IOUtils.readLines(estermSourceCodesStream, UTF_8);
			estermSourceCodesStream.close();

		} else {

			logger.debug("No existing esterm source codes file. Extracting from data file...");
			sourceCodes = new ArrayList<>();
			List<Element> tlinkNodes = dataDoc.selectNodes(allTlinksExp);
			for (Element tlinkNode : tlinkNodes) {
				Attribute tlinkAttr = tlinkNode.attribute(tlinkAttrExp);
				String tlinkAttrValue = tlinkAttr.getValue();
				//TODO missing handling of "EKSPERT" type sources
				if (StringUtils.startsWith(tlinkAttrValue, "Allikas:")) {
					String sourceCode = tlinkNode.getTextTrim();
					if (!sourceCodes.contains(sourceCode)) {
						sourceCodes.add(sourceCode);
					}
				}
			}
			FileOutputStream estermSourceCodesStream = new FileOutputStream(estermSourceCodesFile);
			IOUtils.writeLines(sourceCodes, "\n", estermSourceCodesStream, UTF_8);
			estermSourceCodesStream.flush();
			estermSourceCodesStream.close();
		}
		return sourceCodes;
	}

	private Source extractAndApplySourceProperties(Element conceptGroupNode) throws ParseException {

		Source sourceObj = new Source();

		Element valueNode;
		String valueStr;
		long valueLong;
		Timestamp valueTs;

		/*
		 * TODO missing logic to determine about correct source type.
		 * Info about source type is in one or many of the nesting term groups
		 */
		sourceObj.setType(SourceType.UNKNOWN);

		valueNode = (Element) conceptGroupNode.selectSingleNode(conceptExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			sourceObj.setConceptId(valueStr);
		}

		valueNode = (Element) conceptGroupNode.selectSingleNode(entryClassExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			sourceObj.setProcessStateCode(valueStr);
		}

		valueNode = (Element) conceptGroupNode.selectSingleNode(createdByExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			sourceObj.setCreatedBy(valueStr);
		}

		valueNode = (Element) conceptGroupNode.selectSingleNode(createdOnExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			valueLong = defaultDateFormat.parse(valueStr).getTime();
			valueTs = new Timestamp(valueLong);
			sourceObj.setCreatedOn(valueTs);
		}

		valueNode = (Element) conceptGroupNode.selectSingleNode(modifiedByExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			sourceObj.setModifiedBy(valueStr);
		}

		valueNode = (Element) conceptGroupNode.selectSingleNode(modifiedOnExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			valueLong = defaultDateFormat.parse(valueStr).getTime();
			valueTs = new Timestamp(valueLong);
			sourceObj.setModifiedOn(valueTs);
		}

		/* 
		 * Currently suspended
		 * Type now reserved for other logic
		 * 
		valueNode = (Element) conceptGroupNode.selectSingleNode(sourceTypeExp);
		if (valueNode != null) {
			valueStr = valueNode.getTextTrim();
			sourceObj.setType(valueStr);
		}
		*/

		return sourceObj;
	}

	private void extractAndSaveFreeforms(Long sourceTermId, Element termGroupNode, FreeformType freeformType, String sourceTermPropertyExp) throws Exception {

		List<Element> sourceTermPropertyNodes = termGroupNode.selectNodes(sourceTermPropertyExp);
		String valueStr;
		long valueLong;
		Timestamp valueTs;

		for (Element sourceTermPropertyNode : sourceTermPropertyNodes) {
			valueStr = sourceTermPropertyNode.getTextTrim();
			if (StringUtils.isBlank(valueStr)) {
				continue;
			}
			if (FreeformType.CREATED_ON.equals(freeformType)
					|| FreeformType.MODIFIED_ON.equals(freeformType)) {
				valueLong = defaultDateFormat.parse(valueStr).getTime();
				valueTs = new Timestamp(valueLong);
				createFreeformTextOrDate(freeformType, sourceTermId, valueTs, null);
			} else {
				createFreeformTextOrDate(freeformType, sourceTermId, valueStr, null);
			}
		}
	}

	// very rough assumption
	private boolean isProbablySourceCode(String value) {
		if (StringUtils.length(value) > 19) {
			return false;
		}
		final char[] codeSymbols = new char[] {' ', '-', '/', '.', ':', '(', ')'};
		char[] chars = value.toCharArray();
		for (char ch : chars) {
			if (ArrayUtils.contains(codeSymbols, ch)) {
				continue;
			} else if (Character.isUpperCase(ch)) {
				continue;
			} else if (Character.isDigit(ch)) {
				continue;
			}
			return false;
		}
		return true;
	}
}
