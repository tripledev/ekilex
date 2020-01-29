/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.udt.records;


import eki.ekilex.data.db.udt.TypeSourceLink;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UDTRecordImpl;


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
public class TypeSourceLinkRecord extends UDTRecordImpl<TypeSourceLinkRecord> implements Record4<Long, String, String, String> {

    private static final long serialVersionUID = 1200666299;

    /**
     * Setter for <code>public.type_source_link.source_id</code>.
     */
    public void setSourceId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.type_source_link.source_id</code>.
     */
    public Long getSourceId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.type_source_link.type</code>.
     */
    public void setType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.type_source_link.type</code>.
     */
    public String getType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.type_source_link.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.type_source_link.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.type_source_link.value</code>.
     */
    public void setValue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.type_source_link.value</code>.
     */
    public String getValue() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return TypeSourceLink.SOURCE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TypeSourceLink.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TypeSourceLink.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TypeSourceLink.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getSourceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getSourceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeSourceLinkRecord value1(Long value) {
        setSourceId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeSourceLinkRecord value2(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeSourceLinkRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeSourceLinkRecord value4(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeSourceLinkRecord values(Long value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TypeSourceLinkRecord
     */
    public TypeSourceLinkRecord() {
        super(TypeSourceLink.TYPE_SOURCE_LINK);
    }

    /**
     * Create a detached, initialised TypeSourceLinkRecord
     */
    public TypeSourceLinkRecord(Long sourceId, String type, String name, String value) {
        super(TypeSourceLink.TYPE_SOURCE_LINK);

        set(0, sourceId);
        set(1, type);
        set(2, name);
        set(3, value);
    }
}