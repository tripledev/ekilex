/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.RectionRecord;

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
public class Rection extends TableImpl<RectionRecord> {

    private static final long serialVersionUID = -654940896;

    /**
     * The reference instance of <code>public.rection</code>
     */
    public static final Rection RECTION = new Rection();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RectionRecord> getRecordType() {
        return RectionRecord.class;
    }

    /**
     * The column <code>public.rection.id</code>.
     */
    public final TableField<RectionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('rection_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.rection.lexeme_id</code>.
     */
    public final TableField<RectionRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.rection.value</code>.
     */
    public final TableField<RectionRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>public.rection</code> table reference
     */
    public Rection() {
        this(DSL.name("rection"), null);
    }

    /**
     * Create an aliased <code>public.rection</code> table reference
     */
    public Rection(String alias) {
        this(DSL.name(alias), RECTION);
    }

    /**
     * Create an aliased <code>public.rection</code> table reference
     */
    public Rection(Name alias) {
        this(alias, RECTION);
    }

    private Rection(Name alias, Table<RectionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Rection(Name alias, Table<RectionRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.RECTION_LEXEME_ID_IDX, Indexes.RECTION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RectionRecord, Long> getIdentity() {
        return Keys.IDENTITY_RECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RectionRecord> getPrimaryKey() {
        return Keys.RECTION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RectionRecord>> getKeys() {
        return Arrays.<UniqueKey<RectionRecord>>asList(Keys.RECTION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<RectionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RectionRecord, ?>>asList(Keys.RECTION__RECTION_LEXEME_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rection as(String alias) {
        return new Rection(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rection as(Name alias) {
        return new Rection(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Rection rename(String name) {
        return new Rection(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Rection rename(Name name) {
        return new Rection(name, null);
    }
}
