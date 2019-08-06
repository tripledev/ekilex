/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.tables.records;


import eki.wordweb.data.db.tables.MviewWwMeaning;
import eki.wordweb.data.db.udt.records.TypeDefinitionRecord;
import eki.wordweb.data.db.udt.records.TypeDomainRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MviewWwMeaningRecord extends TableRecordImpl<MviewWwMeaningRecord> implements Record8<Long, String, TypeDomainRecord[], String[], String[], String[], String[], TypeDefinitionRecord[]> {

    private static final long serialVersionUID = -1620067976;

    /**
     * Setter for <code>public.mview_ww_meaning.meaning_id</code>.
     */
    public void setMeaningId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.meaning_id</code>.
     */
    public Long getMeaningId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.complexity</code>.
     */
    public void setComplexity(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.complexity</code>.
     */
    public String getComplexity() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.domain_codes</code>.
     */
    public void setDomainCodes(TypeDomainRecord... value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.domain_codes</code>.
     */
    public TypeDomainRecord[] getDomainCodes() {
        return (TypeDomainRecord[]) get(2);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.image_files</code>.
     */
    public void setImageFiles(String... value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.image_files</code>.
     */
    public String[] getImageFiles() {
        return (String[]) get(3);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.systematic_polysemy_patterns</code>.
     */
    public void setSystematicPolysemyPatterns(String... value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.systematic_polysemy_patterns</code>.
     */
    public String[] getSystematicPolysemyPatterns() {
        return (String[]) get(4);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.semantic_types</code>.
     */
    public void setSemanticTypes(String... value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.semantic_types</code>.
     */
    public String[] getSemanticTypes() {
        return (String[]) get(5);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.learner_comments</code>.
     */
    public void setLearnerComments(String... value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.learner_comments</code>.
     */
    public String[] getLearnerComments() {
        return (String[]) get(6);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.definitions</code>.
     */
    public void setDefinitions(TypeDefinitionRecord... value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.definitions</code>.
     */
    public TypeDefinitionRecord[] getDefinitions() {
        return (TypeDefinitionRecord[]) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, TypeDomainRecord[], String[], String[], String[], String[], TypeDefinitionRecord[]> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, TypeDomainRecord[], String[], String[], String[], String[], TypeDefinitionRecord[]> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return MviewWwMeaning.MVIEW_WW_MEANING.MEANING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return MviewWwMeaning.MVIEW_WW_MEANING.COMPLEXITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeDomainRecord[]> field3() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DOMAIN_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field4() {
        return MviewWwMeaning.MVIEW_WW_MEANING.IMAGE_FILES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field5() {
        return MviewWwMeaning.MVIEW_WW_MEANING.SYSTEMATIC_POLYSEMY_PATTERNS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field6() {
        return MviewWwMeaning.MVIEW_WW_MEANING.SEMANTIC_TYPES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field7() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEARNER_COMMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeDefinitionRecord[]> field8() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DEFINITIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getComplexity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDomainRecord[] component3() {
        return getDomainCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component4() {
        return getImageFiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component5() {
        return getSystematicPolysemyPatterns();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component6() {
        return getSemanticTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component7() {
        return getLearnerComments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDefinitionRecord[] component8() {
        return getDefinitions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getComplexity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDomainRecord[] value3() {
        return getDomainCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value4() {
        return getImageFiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value5() {
        return getSystematicPolysemyPatterns();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value6() {
        return getSemanticTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value7() {
        return getLearnerComments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDefinitionRecord[] value8() {
        return getDefinitions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value1(Long value) {
        setMeaningId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value2(String value) {
        setComplexity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value3(TypeDomainRecord... value) {
        setDomainCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value4(String... value) {
        setImageFiles(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value5(String... value) {
        setSystematicPolysemyPatterns(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value6(String... value) {
        setSemanticTypes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value7(String... value) {
        setLearnerComments(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value8(TypeDefinitionRecord... value) {
        setDefinitions(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord values(Long value1, String value2, TypeDomainRecord[] value3, String[] value4, String[] value5, String[] value6, String[] value7, TypeDefinitionRecord[] value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MviewWwMeaningRecord
     */
    public MviewWwMeaningRecord() {
        super(MviewWwMeaning.MVIEW_WW_MEANING);
    }

    /**
     * Create a detached, initialised MviewWwMeaningRecord
     */
    public MviewWwMeaningRecord(Long meaningId, String complexity, TypeDomainRecord[] domainCodes, String[] imageFiles, String[] systematicPolysemyPatterns, String[] semanticTypes, String[] learnerComments, TypeDefinitionRecord[] definitions) {
        super(MviewWwMeaning.MVIEW_WW_MEANING);

        set(0, meaningId);
        set(1, complexity);
        set(2, domainCodes);
        set(3, imageFiles);
        set(4, systematicPolysemyPatterns);
        set(5, semanticTypes);
        set(6, learnerComments);
        set(7, definitions);
    }
}
