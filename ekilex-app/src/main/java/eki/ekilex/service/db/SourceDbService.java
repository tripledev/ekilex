package eki.ekilex.service.db;

import static eki.ekilex.data.db.Tables.DEFINITION;
import static eki.ekilex.data.db.Tables.DEFINITION_FREEFORM;
import static eki.ekilex.data.db.Tables.DEFINITION_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.FREEFORM;
import static eki.ekilex.data.db.Tables.FREEFORM_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.LEXEME;
import static eki.ekilex.data.db.Tables.LEXEME_FREEFORM;
import static eki.ekilex.data.db.Tables.LEXEME_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.MEANING_FREEFORM;
import static eki.ekilex.data.db.Tables.SOURCE;
import static eki.ekilex.data.db.Tables.SOURCE_FREEFORM;
import static eki.ekilex.data.db.Tables.SOURCE_LIFECYCLE_LOG;
import static eki.ekilex.data.db.Tables.WORD_ETYMOLOGY_SOURCE_LINK;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.SelectHavingStep;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.common.constant.FreeformType;
import eki.common.constant.GlobalConstant;
import eki.common.constant.SourceType;
import eki.ekilex.constant.SearchEntity;
import eki.ekilex.constant.SearchKey;
import eki.ekilex.constant.SearchOperand;
import eki.ekilex.data.SearchCriterion;
import eki.ekilex.data.SearchCriterionGroup;
import eki.ekilex.data.SearchFilter;
import eki.ekilex.data.SourceProperty;
import eki.ekilex.data.SourcePropertyTuple;
import eki.ekilex.data.db.tables.Definition;
import eki.ekilex.data.db.tables.DefinitionFreeform;
import eki.ekilex.data.db.tables.DefinitionSourceLink;
import eki.ekilex.data.db.tables.Freeform;
import eki.ekilex.data.db.tables.FreeformSourceLink;
import eki.ekilex.data.db.tables.Lexeme;
import eki.ekilex.data.db.tables.LexemeFreeform;
import eki.ekilex.data.db.tables.LexemeSourceLink;
import eki.ekilex.data.db.tables.MeaningFreeform;
import eki.ekilex.data.db.tables.Source;
import eki.ekilex.data.db.tables.SourceFreeform;
import eki.ekilex.data.db.tables.records.FreeformRecord;
import eki.ekilex.service.db.util.SearchFilterHelper;

@Component
public class SourceDbService implements GlobalConstant {

	@Autowired
	private SearchFilterHelper searchFilterHelper;

	private DSLContext create;

	@Autowired
	public SourceDbService(DSLContext context) {
		create = context;
	}

	public List<SourcePropertyTuple> getSource(Long sourceId) {

		Source s = SOURCE.as("s");
		SourceFreeform sff = SOURCE_FREEFORM.as("sff");
		Freeform sp = FREEFORM.as("sp");
		Condition where = s.ID.equal(sourceId);
		Field<Boolean> spmf = DSL.field(DSL.val(Boolean.FALSE));

		return getSources(s, sff, sp, spmf, where);
	}

	public List<SourcePropertyTuple> getSources(String searchFilterWithMetaCharacters, SourceType sourceType) {
		return getSources(searchFilterWithMetaCharacters, sourceType, null);
	}

	public List<SourcePropertyTuple> getSources(String searchFilterWithMetaCharacters, SourceType sourceType, Long sourceIdToExclude) {
	
		String searchFilter = searchFilterWithMetaCharacters.replace("*", "%").replace("?", "_").toLowerCase();
	
		Source s = SOURCE.as("s");
		SourceFreeform sff = SOURCE_FREEFORM.as("sff");
		Freeform sp = FREEFORM.as("sp");
		SourceFreeform sffc = SOURCE_FREEFORM.as("sffc");
		Freeform spc = FREEFORM.as("spc");
	
		SelectConditionStep<Record1<Long>> existCondition =
				DSL
				.select(sffc.ID)
				.from(sffc, spc)
				.where(
						sffc.SOURCE_ID.eq(s.ID)
						.and(sffc.FREEFORM_ID.eq(spc.ID))
						.and(DSL.lower(spc.VALUE_TEXT).like(searchFilter)));
	
		if (sourceType != null) {
			existCondition = existCondition.and(s.TYPE.eq(sourceType.name()));
		}
		if (sourceIdToExclude != null) {
			existCondition = existCondition.and(sffc.SOURCE_ID.notEqual(sourceIdToExclude));
		}
		Condition sex = DSL.exists(existCondition);
		Field<Boolean> spmf = DSL.field(DSL.lower(sp.VALUE_TEXT).like(searchFilter));
	
		return getSources(s, sff, sp, spmf, sex);
	}

	private List<SourcePropertyTuple> getSources(Source s, SourceFreeform sff, Freeform sp, Field<Boolean> spmf, Condition where) {
	
		Field<Boolean> sptnf = DSL.field(sp.TYPE.eq(FreeformType.SOURCE_NAME.name()));
	
		return create
				.select(
						s.ID.as("source_id"),
						s.TYPE.as("source_type"),
						sp.ID.as("source_property_id"),
						sp.TYPE.as("source_property_type"),
						sp.VALUE_TEXT.as("source_property_value_text"),
						sp.VALUE_DATE.as("source_property_value_date"),
						spmf.as("source_property_match")
						)
				.from(
						s
						.innerJoin(sff).on(s.ID.eq(sff.SOURCE_ID))
						.innerJoin(sp).on(sff.FREEFORM_ID.eq(sp.ID)))
				.where(where)
				.orderBy(
						s.ID,
						sptnf.desc(),
						sp.ORDER_BY)
				.fetch()
				.into(SourcePropertyTuple.class);
	}

	public List<SourcePropertyTuple> getSources(SearchFilter searchFilter) throws Exception {

		List<SearchCriterionGroup> searchCriteriaGroups = searchFilter.getCriteriaGroups();

		Source s = SOURCE.as("s");
		SourceFreeform sff = SOURCE_FREEFORM.as("sff");
		Freeform sp = FREEFORM.as("sp");
		SourceFreeform sffc = SOURCE_FREEFORM.as("sffc");
		Freeform spc = FREEFORM.as("spc");

		Condition where = DSL.noCondition();

		for (SearchCriterionGroup searchCriterionGroup : searchCriteriaGroups) {
			List<SearchCriterion> searchCriteria = searchCriterionGroup.getSearchCriteria();
			if (CollectionUtils.isEmpty(searchCriteria)) {
				continue;
			}
			SearchEntity searchEntity = searchCriterionGroup.getEntity();
			if (SearchEntity.SOURCE.equals(searchEntity)) {
				boolean containsSearchKeys;

				containsSearchKeys = searchFilterHelper.containsSearchKeys(searchCriteria, SearchKey.VALUE);
				if (containsSearchKeys) {
					Condition innerWhere = sffc.SOURCE_ID.eq(s.ID).and(sffc.FREEFORM_ID.eq(spc.ID));
					innerWhere = searchFilterHelper.applyValueFilters(SearchKey.VALUE, searchCriteria, spc.VALUE_TEXT, innerWhere, true);

					Condition whereExists = DSL.exists(DSL
							.select(sffc.ID)
							.from(sffc, spc)
							.where(innerWhere));

					where = where.and(whereExists);
				}

				containsSearchKeys = searchFilterHelper.containsSearchKeys(searchCriteria, SearchKey.DATASET_USAGE);
				if (containsSearchKeys) {
					where = applySourceLinkDatasetFilters(searchCriteria, where);
				}
			}
		}

		Field<Boolean> spmf = DSL.field(DSL.falseCondition());
		return getSources(s, sff, sp, spmf, where);
	}

	private Condition applySourceLinkDatasetFilters(List<SearchCriterion> searchCriteria, Condition where) {

		Source s = SOURCE.as("s");
		Definition d = DEFINITION.as("d");
		Lexeme l = LEXEME.as("l");
		LexemeSourceLink lsl = LEXEME_SOURCE_LINK.as("lsl");
		DefinitionSourceLink dsl = DEFINITION_SOURCE_LINK.as("dsl");
		FreeformSourceLink ffsl = FREEFORM_SOURCE_LINK.as("ffsl");
		LexemeFreeform lff = LEXEME_FREEFORM.as("lff");
		MeaningFreeform mff = MEANING_FREEFORM.as("mff");
		DefinitionFreeform dff = DEFINITION_FREEFORM.as("dff");

		List<SearchCriterion> filteredCriteria = searchCriteria.stream()
				.filter(c -> c.getSearchKey().equals(SearchKey.DATASET_USAGE) && c.getSearchValue() != null)
				.collect(toList());

		if (CollectionUtils.isNotEmpty(filteredCriteria)) {
			for (SearchCriterion criterion : filteredCriteria) {
				SearchOperand searchOperand = criterion.getSearchOperand();
				if (SearchOperand.EQUALS.equals(searchOperand)) {
					String datasetCode = criterion.getSearchValue().toString();

					SelectHavingStep<Record1<Long>> selectLexemeSourceLinks = DSL
									.select(l.ID)
									.from(l, lsl)
									.where(
											l.DATASET_CODE.eq(datasetCode)
													.and(l.TYPE.eq(LEXEME_TYPE_PRIMARY))
													.and(lsl.LEXEME_ID.eq(l.ID))
													.and(lsl.SOURCE_ID.eq(s.ID)));

					SelectHavingStep<Record1<Long>> selectDefinitionSourceLinks = DSL
									.select(l.ID)
									.from(l, d, dsl)
									.where(
											l.DATASET_CODE.eq(datasetCode)
													.and(l.TYPE.eq(LEXEME_TYPE_PRIMARY))
													.and(d.MEANING_ID.eq(l.MEANING_ID))
													.and(dsl.DEFINITION_ID.eq(d.ID))
													.and(dsl.SOURCE_ID.eq(s.ID)));

					SelectHavingStep<Record1<Long>> selectLexemeFreeformSourceLinks = DSL
									.select(l.ID)
									.from(l, lff, ffsl)
									.where(
											l.DATASET_CODE.eq(datasetCode)
													.and(l.TYPE.eq(LEXEME_TYPE_PRIMARY))
													.and(lff.LEXEME_ID.eq(l.ID))
													.and(ffsl.FREEFORM_ID.eq(lff.FREEFORM_ID))
													.and(ffsl.SOURCE_ID.eq(s.ID)));

					SelectHavingStep<Record1<Long>> selectMeaningFreeformSourceLinks = DSL
									.select(l.ID)
									.from(l, mff, ffsl)
									.where(
											l.DATASET_CODE.eq(datasetCode)
													.and(l.TYPE.eq(LEXEME_TYPE_PRIMARY))
													.and(mff.MEANING_ID.eq(l.MEANING_ID))
													.and(ffsl.FREEFORM_ID.eq(mff.FREEFORM_ID))
													.and(ffsl.SOURCE_ID.eq(s.ID)));

					SelectHavingStep<Record1<Long>> selectDefinitionFreeformSourceLinks = DSL
									.select(l.ID)
									.from(l, d, dff, ffsl)
									.where(
											l.DATASET_CODE.eq(datasetCode)
													.and(l.TYPE.eq(LEXEME_TYPE_PRIMARY))
													.and(d.MEANING_ID.eq(l.MEANING_ID))
													.and(dff.DEFINITION_ID.eq(d.ID))
													.and(ffsl.FREEFORM_ID.eq(dff.FREEFORM_ID))
													.and(ffsl.SOURCE_ID.eq(s.ID)));

					Table<Record1<Long>> all = selectLexemeSourceLinks
							.unionAll(selectDefinitionSourceLinks)
							.unionAll(selectLexemeFreeformSourceLinks)
							.unionAll(selectMeaningFreeformSourceLinks)
							.unionAll(selectDefinitionFreeformSourceLinks)
							.asTable("all");

					where = where.andExists(DSL.select(all.field("id")).from(all));
				}
			}
		}
		return where;
	}

	public Long getSourceId(Long sourcePropertyId) {

		return create
				.select(SOURCE_FREEFORM.SOURCE_ID)
				.from(SOURCE_FREEFORM, FREEFORM)
				.where(
						SOURCE_FREEFORM.FREEFORM_ID.eq(FREEFORM.ID)
								.and(FREEFORM.ID.eq(sourcePropertyId)))
				.fetchSingleInto(Long.class);
	}

	public SourceProperty getSourceProperty(Long sourcePropertyId) {

		return create
				.select(
						SOURCE_FREEFORM.SOURCE_ID,
						FREEFORM.ID,
						FREEFORM.TYPE,
						FREEFORM.VALUE_TEXT)
				.from(SOURCE_FREEFORM, FREEFORM)
				.where(
						SOURCE_FREEFORM.FREEFORM_ID.eq(FREEFORM.ID)
						.and(FREEFORM.ID.eq(sourcePropertyId)))
				.fetchOptionalInto(SourceProperty.class)
				.orElse(null);
	}

	public String getSourceNameValue(Long sourceId) {

		return create
				.select(FREEFORM.VALUE_TEXT)
				.from(SOURCE_FREEFORM, FREEFORM)
				.where(SOURCE_FREEFORM.SOURCE_ID.eq(sourceId)
						.and(FREEFORM.ID.eq(SOURCE_FREEFORM.FREEFORM_ID))
						.and(FREEFORM.TYPE.eq(FreeformType.SOURCE_NAME.name())))
				.limit(1)
				.fetchOneInto(String.class);
	}

	public List<String> getSourceNames(String nameSearchFilter, int limit) {

		return create
				.selectDistinct(FREEFORM.VALUE_TEXT)
				.from(FREEFORM)
				.where(FREEFORM.TYPE.eq(FreeformType.SOURCE_NAME.name())
						.and(DSL.lower(FREEFORM.VALUE_TEXT).like('%' + StringUtils.lowerCase(nameSearchFilter) + '%')))
				.orderBy(FREEFORM.VALUE_TEXT)
				.limit(limit)
				.fetchInto(String.class);
	}

	public Long createSource(SourceType sourceType, List<SourceProperty> sourceProperties) {

		Long sourceId =
				create.insertInto(SOURCE, SOURCE.TYPE)
						.values(sourceType.name())
						.returning(SOURCE.ID)
						.fetchOne()
						.getId();

		for (SourceProperty sourceProperty : sourceProperties) {
			createSourceProperty(sourceId, sourceProperty.getType(), sourceProperty.getValueText());
		}
		return sourceId;
	}

	public Long createSourceProperty(Long sourceId, FreeformType type, String valueText) {

		Long sourceFreeformId = create
				.insertInto(FREEFORM, FREEFORM.TYPE, FREEFORM.VALUE_TEXT, FREEFORM.VALUE_PRESE)
				.values(type.name(), valueText, valueText)
				.returning(FREEFORM.ID)
				.fetchOne()
				.getId();
		create.insertInto(SOURCE_FREEFORM, SOURCE_FREEFORM.SOURCE_ID, SOURCE_FREEFORM.FREEFORM_ID).values(sourceId, sourceFreeformId).execute();
		return sourceFreeformId;
	}

	public void updateSourceProperty(Long sourceFreeformId, String valueText) {

		create.update(FREEFORM)
				.set(FREEFORM.VALUE_TEXT, valueText)
				.set(FREEFORM.VALUE_PRESE, valueText)
				.where(FREEFORM.ID.eq(sourceFreeformId))
				.execute();
	}

	public void deleteSourceProperty(Long sourceFreeformId) {

		create.delete(FREEFORM)
				.where(FREEFORM.ID.eq(sourceFreeformId))
				.execute();
		create.delete(SOURCE_FREEFORM)
				.where(SOURCE_FREEFORM.FREEFORM_ID.eq(sourceFreeformId))
				.execute();
	}

	public void updateSourceType(Long sourceId, SourceType type) {

		create.update(SOURCE)
				.set(SOURCE.TYPE, type.name())
				.where(SOURCE.ID.eq(sourceId))
				.execute();
	}

	public void deleteSource(Long sourceId) {

		List<Long> freeformIds = create
				.select(SOURCE_FREEFORM.FREEFORM_ID)
				.from(SOURCE_FREEFORM)
				.where(SOURCE_FREEFORM.SOURCE_ID.eq(sourceId))
				.fetchInto(Long.class);

		for (Long freeformId : freeformIds) {
			create.delete(FREEFORM)
					.where(FREEFORM.ID.eq(freeformId))
					.execute();
		}

		create.delete(SOURCE)
				.where(SOURCE.ID.eq(sourceId))
				.execute();
	}

	public void joinSources(Long targetSourceId, Long originSourceId) {

		Result<FreeformRecord> targetSourceFreeforms = getSourceFreeformRecords(targetSourceId);
		Result<FreeformRecord> originSourceFreeforms = getSourceFreeformRecords(originSourceId);

		List<Long> uniqueFreeformsIds = originSourceFreeforms.stream()
				.filter(origin -> targetSourceFreeforms.stream()
						.noneMatch(target ->
								target.getType().equals(origin.getType())
								&& Objects.nonNull(target.getValueText())
								&& target.getValueText().equals(origin.getValueText())))
				.map(FreeformRecord::getId)
				.collect(Collectors.toList());

		for (Long freeformId : uniqueFreeformsIds) {
			create.update(SOURCE_FREEFORM)
					.set(SOURCE_FREEFORM.SOURCE_ID, targetSourceId)
					.where(
							SOURCE_FREEFORM.SOURCE_ID.eq(originSourceId)
							.and(SOURCE_FREEFORM.FREEFORM_ID.eq(freeformId)))
					.execute();
		}

		create.update(FREEFORM_SOURCE_LINK)
				.set(FREEFORM_SOURCE_LINK.SOURCE_ID, targetSourceId)
				.where(FREEFORM_SOURCE_LINK.SOURCE_ID.eq(originSourceId))
				.execute();

		create.update(SOURCE_LIFECYCLE_LOG)
				.set(SOURCE_LIFECYCLE_LOG.SOURCE_ID, targetSourceId)
				.where(SOURCE_LIFECYCLE_LOG.SOURCE_ID.eq(originSourceId))
				.execute();

		deleteSource(originSourceId);
	}

	public boolean validateSourceDelete(Long sourceId) {

		return create.select(DSL.field(DSL.count(SOURCE.ID).gt(0)).as("is_unbinded"))
				.from(SOURCE)
				.where(
						SOURCE.ID.eq(sourceId)
						.andNotExists(DSL
								.select(DEFINITION_SOURCE_LINK.ID)
								.from(DEFINITION_SOURCE_LINK)
								.where(DEFINITION_SOURCE_LINK.SOURCE_ID.eq(sourceId)))
						.andNotExists(DSL
								.select(FREEFORM_SOURCE_LINK.ID)
								.from(FREEFORM_SOURCE_LINK)
								.where(FREEFORM_SOURCE_LINK.SOURCE_ID.eq(sourceId)))
						.andNotExists(DSL
								.select(LEXEME_SOURCE_LINK.ID)
								.from(LEXEME_SOURCE_LINK)
								.where(LEXEME_SOURCE_LINK.SOURCE_ID.eq(sourceId)))
						.andNotExists(DSL
								.select(WORD_ETYMOLOGY_SOURCE_LINK.ID)
								.from(WORD_ETYMOLOGY_SOURCE_LINK)
								.where(WORD_ETYMOLOGY_SOURCE_LINK.SOURCE_ID.eq(sourceId))))
				.fetchSingleInto(Boolean.class);
	}

	public List<String> getSourceAttributesByType(Long sourceId, FreeformType freeformType) {

		return create
				.select(FREEFORM.VALUE_TEXT)
				.from(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(SOURCE_FREEFORM.FREEFORM_ID)
						.from(SOURCE_FREEFORM)
						.where(SOURCE_FREEFORM.SOURCE_ID.eq(sourceId)
								.and(FREEFORM.TYPE.eq(freeformType.name())))))
				.fetchInto(String.class);
	}

	private Result<FreeformRecord> getSourceFreeformRecords(Long sourceId) {

		return create
				.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(SOURCE_FREEFORM.FREEFORM_ID)
						.from(SOURCE_FREEFORM)
						.where(SOURCE_FREEFORM.SOURCE_ID.eq(sourceId))))
				.fetch();
	}

}
