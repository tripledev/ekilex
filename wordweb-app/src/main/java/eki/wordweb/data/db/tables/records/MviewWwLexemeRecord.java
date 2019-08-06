/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.tables.records;


import eki.wordweb.data.db.tables.MviewWwLexeme;
import eki.wordweb.data.db.udt.records.TypeUsageRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record16;
import org.jooq.Row16;
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
public class MviewWwLexemeRecord extends TableRecordImpl<MviewWwLexemeRecord> implements Record16<Long, Long, Long, Integer, Integer, Integer, String, Long, String[], String[], String[], String[], String[], String[], String[], TypeUsageRecord[]> {

    private static final long serialVersionUID = 169146653;

    /**
     * Setter for <code>public.mview_ww_lexeme.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.word_id</code>.
     */
    public void setWordId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.meaning_id</code>.
     */
    public void setMeaningId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.meaning_id</code>.
     */
    public Long getMeaningId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.level1</code>.
     */
    public void setLevel1(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.level1</code>.
     */
    public Integer getLevel1() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.level2</code>.
     */
    public void setLevel2(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.level2</code>.
     */
    public Integer getLevel2() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.level3</code>.
     */
    public void setLevel3(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.level3</code>.
     */
    public Integer getLevel3() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.complexity</code>.
     */
    public void setComplexity(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.complexity</code>.
     */
    public String getComplexity() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.lex_order_by</code>.
     */
    public void setLexOrderBy(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.lex_order_by</code>.
     */
    public Long getLexOrderBy() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.register_codes</code>.
     */
    public void setRegisterCodes(String... value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.register_codes</code>.
     */
    public String[] getRegisterCodes() {
        return (String[]) get(8);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.pos_codes</code>.
     */
    public void setPosCodes(String... value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.pos_codes</code>.
     */
    public String[] getPosCodes() {
        return (String[]) get(9);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.deriv_codes</code>.
     */
    public void setDerivCodes(String... value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.deriv_codes</code>.
     */
    public String[] getDerivCodes() {
        return (String[]) get(10);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.advice_notes</code>.
     */
    public void setAdviceNotes(String... value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.advice_notes</code>.
     */
    public String[] getAdviceNotes() {
        return (String[]) get(11);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.public_notes</code>.
     */
    public void setPublicNotes(String... value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.public_notes</code>.
     */
    public String[] getPublicNotes() {
        return (String[]) get(12);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.grammars</code>.
     */
    public void setGrammars(String... value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.grammars</code>.
     */
    public String[] getGrammars() {
        return (String[]) get(13);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.governments</code>.
     */
    public void setGovernments(String... value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.governments</code>.
     */
    public String[] getGovernments() {
        return (String[]) get(14);
    }

    /**
     * Setter for <code>public.mview_ww_lexeme.usages</code>.
     */
    public void setUsages(TypeUsageRecord... value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.mview_ww_lexeme.usages</code>.
     */
    public TypeUsageRecord[] getUsages() {
        return (TypeUsageRecord[]) get(15);
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<Long, Long, Long, Integer, Integer, Integer, String, Long, String[], String[], String[], String[], String[], String[], String[], TypeUsageRecord[]> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<Long, Long, Long, Integer, Integer, Integer, String, Long, String[], String[], String[], String[], String[], String[], String[], TypeUsageRecord[]> valuesRow() {
        return (Row16) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.MEANING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.LEVEL1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.LEVEL2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.LEVEL3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.COMPLEXITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.LEX_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field9() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.REGISTER_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field10() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.POS_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field11() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.DERIV_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field12() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.ADVICE_NOTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field13() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.PUBLIC_NOTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field14() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.GRAMMARS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field15() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.GOVERNMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeUsageRecord[]> field16() {
        return MviewWwLexeme.MVIEW_WW_LEXEME.USAGES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getLevel1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getLevel2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getLevel3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getComplexity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getLexOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component9() {
        return getRegisterCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component10() {
        return getPosCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component11() {
        return getDerivCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component12() {
        return getAdviceNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component13() {
        return getPublicNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component14() {
        return getGrammars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component15() {
        return getGovernments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeUsageRecord[] component16() {
        return getUsages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getLevel1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getLevel2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getLevel3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getComplexity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getLexOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value9() {
        return getRegisterCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value10() {
        return getPosCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value11() {
        return getDerivCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value12() {
        return getAdviceNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value13() {
        return getPublicNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value14() {
        return getGrammars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value15() {
        return getGovernments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeUsageRecord[] value16() {
        return getUsages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value1(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value2(Long value) {
        setWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value3(Long value) {
        setMeaningId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value4(Integer value) {
        setLevel1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value5(Integer value) {
        setLevel2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value6(Integer value) {
        setLevel3(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value7(String value) {
        setComplexity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value8(Long value) {
        setLexOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value9(String... value) {
        setRegisterCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value10(String... value) {
        setPosCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value11(String... value) {
        setDerivCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value12(String... value) {
        setAdviceNotes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value13(String... value) {
        setPublicNotes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value14(String... value) {
        setGrammars(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value15(String... value) {
        setGovernments(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord value16(TypeUsageRecord... value) {
        setUsages(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeRecord values(Long value1, Long value2, Long value3, Integer value4, Integer value5, Integer value6, String value7, Long value8, String[] value9, String[] value10, String[] value11, String[] value12, String[] value13, String[] value14, String[] value15, TypeUsageRecord[] value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MviewWwLexemeRecord
     */
    public MviewWwLexemeRecord() {
        super(MviewWwLexeme.MVIEW_WW_LEXEME);
    }

    /**
     * Create a detached, initialised MviewWwLexemeRecord
     */
    public MviewWwLexemeRecord(Long lexemeId, Long wordId, Long meaningId, Integer level1, Integer level2, Integer level3, String complexity, Long lexOrderBy, String[] registerCodes, String[] posCodes, String[] derivCodes, String[] adviceNotes, String[] publicNotes, String[] grammars, String[] governments, TypeUsageRecord[] usages) {
        super(MviewWwLexeme.MVIEW_WW_LEXEME);

        set(0, lexemeId);
        set(1, wordId);
        set(2, meaningId);
        set(3, level1);
        set(4, level2);
        set(5, level3);
        set(6, complexity);
        set(7, lexOrderBy);
        set(8, registerCodes);
        set(9, posCodes);
        set(10, derivCodes);
        set(11, adviceNotes);
        set(12, publicNotes);
        set(13, grammars);
        set(14, governments);
        set(15, usages);
    }
}
