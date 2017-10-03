/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.Rection;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RectionRecord extends UpdatableRecordImpl<RectionRecord> implements Record3<Long, Long, String> {

    private static final long serialVersionUID = 522128349;

    /**
     * Setter for <code>public.rection.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.rection.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.rection.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.rection.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.rection.value</code>.
     */
    public void setValue(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.rection.value</code>.
     */
    public String getValue() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Rection.RECTION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Rection.RECTION.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Rection.RECTION.VALUE;
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
    public Long component2() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getValue();
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
    public Long value2() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectionRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectionRecord value2(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectionRecord value3(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectionRecord values(Long value1, Long value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RectionRecord
     */
    public RectionRecord() {
        super(Rection.RECTION);
    }

    /**
     * Create a detached, initialised RectionRecord
     */
    public RectionRecord(Long id, Long lexemeId, String value) {
        super(Rection.RECTION);

        set(0, id);
        set(1, lexemeId);
        set(2, value);
    }
}
