/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.PosLabelRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class PosLabel extends TableImpl<PosLabelRecord> {

    private static final long serialVersionUID = -991387805;

    /**
     * The reference instance of <code>public.pos_label</code>
     */
    public static final PosLabel POS_LABEL = new PosLabel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PosLabelRecord> getRecordType() {
        return PosLabelRecord.class;
    }

    /**
     * The column <code>public.pos_label.code</code>.
     */
    public final TableField<PosLabelRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.pos_label.value</code>.
     */
    public final TableField<PosLabelRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.pos_label.lang</code>.
     */
    public final TableField<PosLabelRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR(3).nullable(false), this, "");

    /**
     * The column <code>public.pos_label.type</code>.
     */
    public final TableField<PosLabelRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>public.pos_label</code> table reference
     */
    public PosLabel() {
        this(DSL.name("pos_label"), null);
    }

    /**
     * Create an aliased <code>public.pos_label</code> table reference
     */
    public PosLabel(String alias) {
        this(DSL.name(alias), POS_LABEL);
    }

    /**
     * Create an aliased <code>public.pos_label</code> table reference
     */
    public PosLabel(Name alias) {
        this(alias, POS_LABEL);
    }

    private PosLabel(Name alias, Table<PosLabelRecord> aliased) {
        this(alias, aliased, null);
    }

    private PosLabel(Name alias, Table<PosLabelRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.POS_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PosLabelRecord>> getKeys() {
        return Arrays.<UniqueKey<PosLabelRecord>>asList(Keys.POS_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PosLabelRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PosLabelRecord, ?>>asList(Keys.POS_LABEL__POS_LABEL_CODE_FKEY, Keys.POS_LABEL__POS_LABEL_LANG_FKEY, Keys.POS_LABEL__POS_LABEL_TYPE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PosLabel as(String alias) {
        return new PosLabel(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PosLabel as(Name alias) {
        return new PosLabel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PosLabel rename(String name) {
        return new PosLabel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PosLabel rename(Name name) {
        return new PosLabel(name, null);
    }
}
