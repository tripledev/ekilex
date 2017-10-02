/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables.records;


import eki.eve.data.db.tables.Domain;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class DomainRecord extends UpdatableRecordImpl<DomainRecord> implements Record5<String, String, String, String, String[]> {

    private static final long serialVersionUID = -596381717;

    /**
     * Setter for <code>public.domain.code</code>.
     */
    public void setCode(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.domain.code</code>.
     */
    public String getCode() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.domain.origin</code>.
     */
    public void setOrigin(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.domain.origin</code>.
     */
    public String getOrigin() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.domain.parent_code</code>.
     */
    public void setParentCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.domain.parent_code</code>.
     */
    public String getParentCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.domain.parent_origin</code>.
     */
    public void setParentOrigin(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.domain.parent_origin</code>.
     */
    public String getParentOrigin() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.domain.datasets</code>.
     */
    public void setDatasets(String... value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.domain.datasets</code>.
     */
    public String[] getDatasets() {
        return (String[]) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String[]> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String[]> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Domain.DOMAIN.CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Domain.DOMAIN.ORIGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Domain.DOMAIN.PARENT_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Domain.DOMAIN.PARENT_ORIGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field5() {
        return Domain.DOMAIN.DATASETS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getOrigin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getParentCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getParentOrigin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component5() {
        return getDatasets();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getOrigin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getParentCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getParentOrigin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value5() {
        return getDatasets();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DomainRecord value1(String value) {
        setCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DomainRecord value2(String value) {
        setOrigin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DomainRecord value3(String value) {
        setParentCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DomainRecord value4(String value) {
        setParentOrigin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DomainRecord value5(String... value) {
        setDatasets(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DomainRecord values(String value1, String value2, String value3, String value4, String[] value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DomainRecord
     */
    public DomainRecord() {
        super(Domain.DOMAIN);
    }

    /**
     * Create a detached, initialised DomainRecord
     */
    public DomainRecord(String code, String origin, String parentCode, String parentOrigin, String[] datasets) {
        super(Domain.DOMAIN);

        set(0, code);
        set(1, origin);
        set(2, parentCode);
        set(3, parentOrigin);
        set(4, datasets);
    }
}
