/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.tables;


import eki.wordweb.data.db.Indexes;
import eki.wordweb.data.db.Keys;
import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.tables.records.LexicalDecisionResultRecord;

import java.sql.Timestamp;
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
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexicalDecisionResult extends TableImpl<LexicalDecisionResultRecord> {

    private static final long serialVersionUID = -521900106;

    /**
     * The reference instance of <code>public.lexical_decision_result</code>
     */
    public static final LexicalDecisionResult LEXICAL_DECISION_RESULT = new LexicalDecisionResult();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexicalDecisionResultRecord> getRecordType() {
        return LexicalDecisionResultRecord.class;
    }

    /**
     * The column <code>public.lexical_decision_result.id</code>.
     */
    public final TableField<LexicalDecisionResultRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexical_decision_result_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexical_decision_result.data_id</code>.
     */
    public final TableField<LexicalDecisionResultRecord, Long> DATA_ID = createField("data_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexical_decision_result.remote_addr</code>.
     */
    public final TableField<LexicalDecisionResultRecord, String> REMOTE_ADDR = createField("remote_addr", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.lexical_decision_result.local_addr</code>.
     */
    public final TableField<LexicalDecisionResultRecord, String> LOCAL_ADDR = createField("local_addr", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.lexical_decision_result.session_id</code>.
     */
    public final TableField<LexicalDecisionResultRecord, String> SESSION_ID = createField("session_id", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.lexical_decision_result.answer</code>.
     */
    public final TableField<LexicalDecisionResultRecord, Boolean> ANSWER = createField("answer", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.lexical_decision_result.delay</code>.
     */
    public final TableField<LexicalDecisionResultRecord, Long> DELAY = createField("delay", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexical_decision_result.created</code>.
     */
    public final TableField<LexicalDecisionResultRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("statement_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.lexical_decision_result</code> table reference
     */
    public LexicalDecisionResult() {
        this(DSL.name("lexical_decision_result"), null);
    }

    /**
     * Create an aliased <code>public.lexical_decision_result</code> table reference
     */
    public LexicalDecisionResult(String alias) {
        this(DSL.name(alias), LEXICAL_DECISION_RESULT);
    }

    /**
     * Create an aliased <code>public.lexical_decision_result</code> table reference
     */
    public LexicalDecisionResult(Name alias) {
        this(alias, LEXICAL_DECISION_RESULT);
    }

    private LexicalDecisionResult(Name alias, Table<LexicalDecisionResultRecord> aliased) {
        this(alias, aliased, null);
    }

    private LexicalDecisionResult(Name alias, Table<LexicalDecisionResultRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.LEXICAL_DECISION_RESULT_DATA_ID_IDX, Indexes.LEXICAL_DECISION_RESULT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LexicalDecisionResultRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXICAL_DECISION_RESULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexicalDecisionResultRecord> getPrimaryKey() {
        return Keys.LEXICAL_DECISION_RESULT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexicalDecisionResultRecord>> getKeys() {
        return Arrays.<UniqueKey<LexicalDecisionResultRecord>>asList(Keys.LEXICAL_DECISION_RESULT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexicalDecisionResultRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexicalDecisionResultRecord, ?>>asList(Keys.LEXICAL_DECISION_RESULT__LEXICAL_DECISION_RESULT_DATA_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexicalDecisionResult as(String alias) {
        return new LexicalDecisionResult(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexicalDecisionResult as(Name alias) {
        return new LexicalDecisionResult(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LexicalDecisionResult rename(String name) {
        return new LexicalDecisionResult(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LexicalDecisionResult rename(Name name) {
        return new LexicalDecisionResult(name, null);
    }
}
