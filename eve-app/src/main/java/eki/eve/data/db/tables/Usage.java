/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.UsageRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Usage extends TableImpl<UsageRecord> {

    private static final long serialVersionUID = -880785616;

    /**
     * The reference instance of <code>public.usage</code>
     */
    public static final Usage USAGE = new Usage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsageRecord> getRecordType() {
        return UsageRecord.class;
    }

    /**
     * The column <code>public.usage.id</code>.
     */
    public final TableField<UsageRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('usage_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.usage.rection_id</code>.
     */
    public final TableField<UsageRecord, Long> RECTION_ID = createField("rection_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.usage.value</code>.
     */
    public final TableField<UsageRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>public.usage</code> table reference
     */
    public Usage() {
        this(DSL.name("usage"), null);
    }

    /**
     * Create an aliased <code>public.usage</code> table reference
     */
    public Usage(String alias) {
        this(DSL.name(alias), USAGE);
    }

    /**
     * Create an aliased <code>public.usage</code> table reference
     */
    public Usage(Name alias) {
        this(alias, USAGE);
    }

    private Usage(Name alias, Table<UsageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Usage(Name alias, Table<UsageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USAGE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UsageRecord, Long> getIdentity() {
        return Keys.IDENTITY_USAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsageRecord> getPrimaryKey() {
        return Keys.USAGE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsageRecord>> getKeys() {
        return Arrays.<UniqueKey<UsageRecord>>asList(Keys.USAGE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UsageRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UsageRecord, ?>>asList(Keys.USAGE__USAGE_RECTION_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usage as(String alias) {
        return new Usage(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usage as(Name alias) {
        return new Usage(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Usage rename(String name) {
        return new Usage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Usage rename(Name name) {
        return new Usage(name, null);
    }
}
