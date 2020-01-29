/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.ViewWwDefinitionSourceLinkRecord;
import eki.ekilex.data.db.udt.records.TypeSourceLinkRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class ViewWwDefinitionSourceLink extends TableImpl<ViewWwDefinitionSourceLinkRecord> {

    private static final long serialVersionUID = -1133154533;

    /**
     * The reference instance of <code>public.view_ww_definition_source_link</code>
     */
    public static final ViewWwDefinitionSourceLink VIEW_WW_DEFINITION_SOURCE_LINK = new ViewWwDefinitionSourceLink();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ViewWwDefinitionSourceLinkRecord> getRecordType() {
        return ViewWwDefinitionSourceLinkRecord.class;
    }

    /**
     * The column <code>public.view_ww_definition_source_link.meaning_id</code>.
     */
    public final TableField<ViewWwDefinitionSourceLinkRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.view_ww_definition_source_link.source_links</code>.
     */
    public final TableField<ViewWwDefinitionSourceLinkRecord, TypeSourceLinkRecord[]> SOURCE_LINKS = createField("source_links", eki.ekilex.data.db.udt.TypeSourceLink.TYPE_SOURCE_LINK.getDataType().getArrayDataType(), this, "");

    /**
     * Create a <code>public.view_ww_definition_source_link</code> table reference
     */
    public ViewWwDefinitionSourceLink() {
        this(DSL.name("view_ww_definition_source_link"), null);
    }

    /**
     * Create an aliased <code>public.view_ww_definition_source_link</code> table reference
     */
    public ViewWwDefinitionSourceLink(String alias) {
        this(DSL.name(alias), VIEW_WW_DEFINITION_SOURCE_LINK);
    }

    /**
     * Create an aliased <code>public.view_ww_definition_source_link</code> table reference
     */
    public ViewWwDefinitionSourceLink(Name alias) {
        this(alias, VIEW_WW_DEFINITION_SOURCE_LINK);
    }

    private ViewWwDefinitionSourceLink(Name alias, Table<ViewWwDefinitionSourceLinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private ViewWwDefinitionSourceLink(Name alias, Table<ViewWwDefinitionSourceLinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ViewWwDefinitionSourceLink(Table<O> child, ForeignKey<O, ViewWwDefinitionSourceLinkRecord> key) {
        super(child, key, VIEW_WW_DEFINITION_SOURCE_LINK);
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
    public ViewWwDefinitionSourceLink as(String alias) {
        return new ViewWwDefinitionSourceLink(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwDefinitionSourceLink as(Name alias) {
        return new ViewWwDefinitionSourceLink(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwDefinitionSourceLink rename(String name) {
        return new ViewWwDefinitionSourceLink(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwDefinitionSourceLink rename(Name name) {
        return new ViewWwDefinitionSourceLink(name, null);
    }
}
