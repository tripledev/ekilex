/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.MeaningDomainRecord;

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
public class MeaningDomain extends TableImpl<MeaningDomainRecord> {

    private static final long serialVersionUID = -506940005;

    /**
     * The reference instance of <code>public.meaning_domain</code>
     */
    public static final MeaningDomain MEANING_DOMAIN = new MeaningDomain();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningDomainRecord> getRecordType() {
        return MeaningDomainRecord.class;
    }

    /**
     * The column <code>public.meaning_domain.id</code>.
     */
    public final TableField<MeaningDomainRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_domain_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.meaning_domain.meaning_id</code>.
     */
    public final TableField<MeaningDomainRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.meaning_domain.domain_code</code>.
     */
    public final TableField<MeaningDomainRecord, String> DOMAIN_CODE = createField("domain_code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.meaning_domain.domain_origin</code>.
     */
    public final TableField<MeaningDomainRecord, String> DOMAIN_ORIGIN = createField("domain_origin", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * Create a <code>public.meaning_domain</code> table reference
     */
    public MeaningDomain() {
        this(DSL.name("meaning_domain"), null);
    }

    /**
     * Create an aliased <code>public.meaning_domain</code> table reference
     */
    public MeaningDomain(String alias) {
        this(DSL.name(alias), MEANING_DOMAIN);
    }

    /**
     * Create an aliased <code>public.meaning_domain</code> table reference
     */
    public MeaningDomain(Name alias) {
        this(alias, MEANING_DOMAIN);
    }

    private MeaningDomain(Name alias, Table<MeaningDomainRecord> aliased) {
        this(alias, aliased, null);
    }

    private MeaningDomain(Name alias, Table<MeaningDomainRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MEANING_DOMAIN_MEANING_ID_DOMAIN_CODE_DOMAIN_ORIGIN_KEY, Indexes.MEANING_DOMAIN_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MeaningDomainRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEANING_DOMAIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeaningDomainRecord> getPrimaryKey() {
        return Keys.MEANING_DOMAIN_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeaningDomainRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningDomainRecord>>asList(Keys.MEANING_DOMAIN_PKEY, Keys.MEANING_DOMAIN_MEANING_ID_DOMAIN_CODE_DOMAIN_ORIGIN_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MeaningDomainRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MeaningDomainRecord, ?>>asList(Keys.MEANING_DOMAIN__MEANING_DOMAIN_MEANING_ID_FKEY, Keys.MEANING_DOMAIN__MEANING_DOMAIN_DOMAIN_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningDomain as(String alias) {
        return new MeaningDomain(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningDomain as(Name alias) {
        return new MeaningDomain(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningDomain rename(String name) {
        return new MeaningDomain(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningDomain rename(Name name) {
        return new MeaningDomain(name, null);
    }
}
