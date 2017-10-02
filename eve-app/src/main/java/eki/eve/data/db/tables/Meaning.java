/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.MeaningRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Meaning extends TableImpl<MeaningRecord> {

    private static final long serialVersionUID = 363427673;

    /**
     * The reference instance of <code>public.meaning</code>
     */
    public static final Meaning MEANING = new Meaning();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningRecord> getRecordType() {
        return MeaningRecord.class;
    }

    /**
     * The column <code>public.meaning.id</code>.
     */
    public final TableField<MeaningRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.meaning.datasets</code>.
     */
    public final TableField<MeaningRecord, String[]> DATASETS = createField("datasets", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.meaning</code> table reference
     */
    public Meaning() {
        this(DSL.name("meaning"), null);
    }

    /**
     * Create an aliased <code>public.meaning</code> table reference
     */
    public Meaning(String alias) {
        this(DSL.name(alias), MEANING);
    }

    /**
     * Create an aliased <code>public.meaning</code> table reference
     */
    public Meaning(Name alias) {
        this(alias, MEANING);
    }

    private Meaning(Name alias, Table<MeaningRecord> aliased) {
        this(alias, aliased, null);
    }

    private Meaning(Name alias, Table<MeaningRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MEANING_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MeaningRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEANING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeaningRecord> getPrimaryKey() {
        return Keys.MEANING_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeaningRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningRecord>>asList(Keys.MEANING_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Meaning as(String alias) {
        return new Meaning(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Meaning as(Name alias) {
        return new Meaning(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Meaning rename(String name) {
        return new Meaning(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Meaning rename(Name name) {
        return new Meaning(name, null);
    }
}
