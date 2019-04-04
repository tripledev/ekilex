/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.LexemeRegionRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
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
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemeRegion extends TableImpl<LexemeRegionRecord> {

    private static final long serialVersionUID = 910328465;

    /**
     * The reference instance of <code>public.lexeme_region</code>
     */
    public static final LexemeRegion LEXEME_REGION = new LexemeRegion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemeRegionRecord> getRecordType() {
        return LexemeRegionRecord.class;
    }

    /**
     * The column <code>public.lexeme_region.id</code>.
     */
    public final TableField<LexemeRegionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_region_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme_region.lexeme_id</code>.
     */
    public final TableField<LexemeRegionRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme_region.region_code</code>.
     */
    public final TableField<LexemeRegionRecord, String> REGION_CODE = createField("region_code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.lexeme_region.process_state_code</code>.
     */
    public final TableField<LexemeRegionRecord, String> PROCESS_STATE_CODE = createField("process_state_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>public.lexeme_region</code> table reference
     */
    public LexemeRegion() {
        this(DSL.name("lexeme_region"), null);
    }

    /**
     * Create an aliased <code>public.lexeme_region</code> table reference
     */
    public LexemeRegion(String alias) {
        this(DSL.name(alias), LEXEME_REGION);
    }

    /**
     * Create an aliased <code>public.lexeme_region</code> table reference
     */
    public LexemeRegion(Name alias) {
        this(alias, LEXEME_REGION);
    }

    private LexemeRegion(Name alias, Table<LexemeRegionRecord> aliased) {
        this(alias, aliased, null);
    }

    private LexemeRegion(Name alias, Table<LexemeRegionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> LexemeRegion(Table<O> child, ForeignKey<O, LexemeRegionRecord> key) {
        super(child, key, LEXEME_REGION);
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
        return Arrays.<Index>asList(Indexes.LEXEME_REGION_LEXEME_ID_IDX, Indexes.LEXEME_REGION_LEXEME_ID_REGION_CODE_KEY, Indexes.LEXEME_REGION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LexemeRegionRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME_REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexemeRegionRecord> getPrimaryKey() {
        return Keys.LEXEME_REGION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexemeRegionRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemeRegionRecord>>asList(Keys.LEXEME_REGION_PKEY, Keys.LEXEME_REGION_LEXEME_ID_REGION_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexemeRegionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemeRegionRecord, ?>>asList(Keys.LEXEME_REGION__LEXEME_REGION_LEXEME_ID_FKEY, Keys.LEXEME_REGION__LEXEME_REGION_REGION_CODE_FKEY, Keys.LEXEME_REGION__LEXEME_REGION_PROCESS_STATE_CODE_FKEY);
    }

    public Lexeme lexeme() {
        return new Lexeme(this, Keys.LEXEME_REGION__LEXEME_REGION_LEXEME_ID_FKEY);
    }

    public Region region() {
        return new Region(this, Keys.LEXEME_REGION__LEXEME_REGION_REGION_CODE_FKEY);
    }

    public ProcessState processState() {
        return new ProcessState(this, Keys.LEXEME_REGION__LEXEME_REGION_PROCESS_STATE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegion as(String alias) {
        return new LexemeRegion(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegion as(Name alias) {
        return new LexemeRegion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeRegion rename(String name) {
        return new LexemeRegion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeRegion rename(Name name) {
        return new LexemeRegion(name, null);
    }
}
