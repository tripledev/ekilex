/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.tables;


import eki.wordweb.data.db.Indexes;
import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.tables.records.MviewWwLexemeSourceLinkRecord;
import eki.wordweb.data.db.udt.records.TypeSourceLinkRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
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
public class MviewWwLexemeSourceLink extends TableImpl<MviewWwLexemeSourceLinkRecord> {

    private static final long serialVersionUID = -242128675;

    /**
     * The reference instance of <code>public.mview_ww_lexeme_source_link</code>
     */
    public static final MviewWwLexemeSourceLink MVIEW_WW_LEXEME_SOURCE_LINK = new MviewWwLexemeSourceLink();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MviewWwLexemeSourceLinkRecord> getRecordType() {
        return MviewWwLexemeSourceLinkRecord.class;
    }

    /**
     * The column <code>public.mview_ww_lexeme_source_link.word_id</code>.
     */
    public final TableField<MviewWwLexemeSourceLinkRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_lexeme_source_link.source_links</code>.
     */
    public final TableField<MviewWwLexemeSourceLinkRecord, TypeSourceLinkRecord[]> SOURCE_LINKS = createField("source_links", eki.wordweb.data.db.udt.TypeSourceLink.TYPE_SOURCE_LINK.getDataType().getArrayDataType(), this, "");

    /**
     * Create a <code>public.mview_ww_lexeme_source_link</code> table reference
     */
    public MviewWwLexemeSourceLink() {
        this(DSL.name("mview_ww_lexeme_source_link"), null);
    }

    /**
     * Create an aliased <code>public.mview_ww_lexeme_source_link</code> table reference
     */
    public MviewWwLexemeSourceLink(String alias) {
        this(DSL.name(alias), MVIEW_WW_LEXEME_SOURCE_LINK);
    }

    /**
     * Create an aliased <code>public.mview_ww_lexeme_source_link</code> table reference
     */
    public MviewWwLexemeSourceLink(Name alias) {
        this(alias, MVIEW_WW_LEXEME_SOURCE_LINK);
    }

    private MviewWwLexemeSourceLink(Name alias, Table<MviewWwLexemeSourceLinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private MviewWwLexemeSourceLink(Name alias, Table<MviewWwLexemeSourceLinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> MviewWwLexemeSourceLink(Table<O> child, ForeignKey<O, MviewWwLexemeSourceLinkRecord> key) {
        super(child, key, MVIEW_WW_LEXEME_SOURCE_LINK);
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
        return Arrays.<Index>asList(Indexes.MVIEW_WW_LEXEME_SOURCE_LINK_WORD_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeSourceLink as(String alias) {
        return new MviewWwLexemeSourceLink(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexemeSourceLink as(Name alias) {
        return new MviewWwLexemeSourceLink(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwLexemeSourceLink rename(String name) {
        return new MviewWwLexemeSourceLink(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwLexemeSourceLink rename(Name name) {
        return new MviewWwLexemeSourceLink(name, null);
    }
}
