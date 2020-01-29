/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.ViewWwFreeformSourceLinkRecord;
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
public class ViewWwFreeformSourceLink extends TableImpl<ViewWwFreeformSourceLinkRecord> {

    private static final long serialVersionUID = -254702677;

    /**
     * The reference instance of <code>public.view_ww_freeform_source_link</code>
     */
    public static final ViewWwFreeformSourceLink VIEW_WW_FREEFORM_SOURCE_LINK = new ViewWwFreeformSourceLink();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ViewWwFreeformSourceLinkRecord> getRecordType() {
        return ViewWwFreeformSourceLinkRecord.class;
    }

    /**
     * The column <code>public.view_ww_freeform_source_link.word_id</code>.
     */
    public final TableField<ViewWwFreeformSourceLinkRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.view_ww_freeform_source_link.source_links</code>.
     */
    public final TableField<ViewWwFreeformSourceLinkRecord, TypeSourceLinkRecord[]> SOURCE_LINKS = createField("source_links", eki.ekilex.data.db.udt.TypeSourceLink.TYPE_SOURCE_LINK.getDataType().getArrayDataType(), this, "");

    /**
     * Create a <code>public.view_ww_freeform_source_link</code> table reference
     */
    public ViewWwFreeformSourceLink() {
        this(DSL.name("view_ww_freeform_source_link"), null);
    }

    /**
     * Create an aliased <code>public.view_ww_freeform_source_link</code> table reference
     */
    public ViewWwFreeformSourceLink(String alias) {
        this(DSL.name(alias), VIEW_WW_FREEFORM_SOURCE_LINK);
    }

    /**
     * Create an aliased <code>public.view_ww_freeform_source_link</code> table reference
     */
    public ViewWwFreeformSourceLink(Name alias) {
        this(alias, VIEW_WW_FREEFORM_SOURCE_LINK);
    }

    private ViewWwFreeformSourceLink(Name alias, Table<ViewWwFreeformSourceLinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private ViewWwFreeformSourceLink(Name alias, Table<ViewWwFreeformSourceLinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ViewWwFreeformSourceLink(Table<O> child, ForeignKey<O, ViewWwFreeformSourceLinkRecord> key) {
        super(child, key, VIEW_WW_FREEFORM_SOURCE_LINK);
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
    public ViewWwFreeformSourceLink as(String alias) {
        return new ViewWwFreeformSourceLink(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFreeformSourceLink as(Name alias) {
        return new ViewWwFreeformSourceLink(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwFreeformSourceLink rename(String name) {
        return new ViewWwFreeformSourceLink(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwFreeformSourceLink rename(Name name) {
        return new ViewWwFreeformSourceLink(name, null);
    }
}
