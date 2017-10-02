/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.ParadigmRecord;

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
public class Paradigm extends TableImpl<ParadigmRecord> {

    private static final long serialVersionUID = 47847658;

    /**
     * The reference instance of <code>public.paradigm</code>
     */
    public static final Paradigm PARADIGM = new Paradigm();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ParadigmRecord> getRecordType() {
        return ParadigmRecord.class;
    }

    /**
     * The column <code>public.paradigm.id</code>.
     */
    public final TableField<ParadigmRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('paradigm_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.paradigm.word_id</code>.
     */
    public final TableField<ParadigmRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.paradigm.example</code>.
     */
    public final TableField<ParadigmRecord, String> EXAMPLE = createField("example", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.paradigm</code> table reference
     */
    public Paradigm() {
        this(DSL.name("paradigm"), null);
    }

    /**
     * Create an aliased <code>public.paradigm</code> table reference
     */
    public Paradigm(String alias) {
        this(DSL.name(alias), PARADIGM);
    }

    /**
     * Create an aliased <code>public.paradigm</code> table reference
     */
    public Paradigm(Name alias) {
        this(alias, PARADIGM);
    }

    private Paradigm(Name alias, Table<ParadigmRecord> aliased) {
        this(alias, aliased, null);
    }

    private Paradigm(Name alias, Table<ParadigmRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PARADIGM_PKEY, Indexes.PARADIGM_WORD_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ParadigmRecord, Long> getIdentity() {
        return Keys.IDENTITY_PARADIGM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ParadigmRecord> getPrimaryKey() {
        return Keys.PARADIGM_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ParadigmRecord>> getKeys() {
        return Arrays.<UniqueKey<ParadigmRecord>>asList(Keys.PARADIGM_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ParadigmRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ParadigmRecord, ?>>asList(Keys.PARADIGM__PARADIGM_WORD_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Paradigm as(String alias) {
        return new Paradigm(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Paradigm as(Name alias) {
        return new Paradigm(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Paradigm rename(String name) {
        return new Paradigm(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Paradigm rename(Name name) {
        return new Paradigm(name, null);
    }
}
