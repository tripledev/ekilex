/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.LexemeGroup;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemeGroupRecord extends UpdatableRecordImpl<LexemeGroupRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = -2111475113;

    /**
     * Setter for <code>public.lexeme_group.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lexeme_group.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lexeme_group.lex_rel_type_code</code>.
     */
    public void setLexRelTypeCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lexeme_group.lex_rel_type_code</code>.
     */
    public String getLexRelTypeCode() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return LexemeGroup.LEXEME_GROUP.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return LexemeGroup.LEXEME_GROUP.LEX_REL_TYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getLexRelTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getLexRelTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeGroupRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeGroupRecord value2(String value) {
        setLexRelTypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeGroupRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LexemeGroupRecord
     */
    public LexemeGroupRecord() {
        super(LexemeGroup.LEXEME_GROUP);
    }

    /**
     * Create a detached, initialised LexemeGroupRecord
     */
    public LexemeGroupRecord(Long id, String lexRelTypeCode) {
        super(LexemeGroup.LEXEME_GROUP);

        set(0, id);
        set(1, lexRelTypeCode);
    }
}
