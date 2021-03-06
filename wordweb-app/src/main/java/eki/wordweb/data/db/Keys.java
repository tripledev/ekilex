/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db;


import eki.wordweb.data.db.tables.LexicalDecisionData;
import eki.wordweb.data.db.tables.LexicalDecisionResult;
import eki.wordweb.data.db.tables.SimilarityJudgementData;
import eki.wordweb.data.db.tables.SimilarityJudgementResult;
import eki.wordweb.data.db.tables.records.LexicalDecisionDataRecord;
import eki.wordweb.data.db.tables.records.LexicalDecisionResultRecord;
import eki.wordweb.data.db.tables.records.SimilarityJudgementDataRecord;
import eki.wordweb.data.db.tables.records.SimilarityJudgementResultRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<LexicalDecisionDataRecord, Long> IDENTITY_LEXICAL_DECISION_DATA = Identities0.IDENTITY_LEXICAL_DECISION_DATA;
    public static final Identity<LexicalDecisionResultRecord, Long> IDENTITY_LEXICAL_DECISION_RESULT = Identities0.IDENTITY_LEXICAL_DECISION_RESULT;
    public static final Identity<SimilarityJudgementDataRecord, Long> IDENTITY_SIMILARITY_JUDGEMENT_DATA = Identities0.IDENTITY_SIMILARITY_JUDGEMENT_DATA;
    public static final Identity<SimilarityJudgementResultRecord, Long> IDENTITY_SIMILARITY_JUDGEMENT_RESULT = Identities0.IDENTITY_SIMILARITY_JUDGEMENT_RESULT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<LexicalDecisionDataRecord> LEXICAL_DECISION_DATA_PKEY = UniqueKeys0.LEXICAL_DECISION_DATA_PKEY;
    public static final UniqueKey<LexicalDecisionResultRecord> LEXICAL_DECISION_RESULT_PKEY = UniqueKeys0.LEXICAL_DECISION_RESULT_PKEY;
    public static final UniqueKey<SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_DATA_PKEY = UniqueKeys0.SIMILARITY_JUDGEMENT_DATA_PKEY;
    public static final UniqueKey<SimilarityJudgementResultRecord> SIMILARITY_JUDGEMENT_RESULT_PKEY = UniqueKeys0.SIMILARITY_JUDGEMENT_RESULT_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<LexicalDecisionResultRecord, LexicalDecisionDataRecord> LEXICAL_DECISION_RESULT__LEXICAL_DECISION_RESULT_DATA_ID_FKEY = ForeignKeys0.LEXICAL_DECISION_RESULT__LEXICAL_DECISION_RESULT_DATA_ID_FKEY;
    public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR11_DATA_ID_FKEY = ForeignKeys0.SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR11_DATA_ID_FKEY;
    public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR12_DATA_ID_FKEY = ForeignKeys0.SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR12_DATA_ID_FKEY;
    public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR21_DATA_ID_FKEY = ForeignKeys0.SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR21_DATA_ID_FKEY;
    public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR22_DATA_ID_FKEY = ForeignKeys0.SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR22_DATA_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<LexicalDecisionDataRecord, Long> IDENTITY_LEXICAL_DECISION_DATA = Internal.createIdentity(LexicalDecisionData.LEXICAL_DECISION_DATA, LexicalDecisionData.LEXICAL_DECISION_DATA.ID);
        public static Identity<LexicalDecisionResultRecord, Long> IDENTITY_LEXICAL_DECISION_RESULT = Internal.createIdentity(LexicalDecisionResult.LEXICAL_DECISION_RESULT, LexicalDecisionResult.LEXICAL_DECISION_RESULT.ID);
        public static Identity<SimilarityJudgementDataRecord, Long> IDENTITY_SIMILARITY_JUDGEMENT_DATA = Internal.createIdentity(SimilarityJudgementData.SIMILARITY_JUDGEMENT_DATA, SimilarityJudgementData.SIMILARITY_JUDGEMENT_DATA.ID);
        public static Identity<SimilarityJudgementResultRecord, Long> IDENTITY_SIMILARITY_JUDGEMENT_RESULT = Internal.createIdentity(SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT, SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<LexicalDecisionDataRecord> LEXICAL_DECISION_DATA_PKEY = Internal.createUniqueKey(LexicalDecisionData.LEXICAL_DECISION_DATA, "lexical_decision_data_pkey", new TableField[] { LexicalDecisionData.LEXICAL_DECISION_DATA.ID }, true);
        public static final UniqueKey<LexicalDecisionResultRecord> LEXICAL_DECISION_RESULT_PKEY = Internal.createUniqueKey(LexicalDecisionResult.LEXICAL_DECISION_RESULT, "lexical_decision_result_pkey", new TableField[] { LexicalDecisionResult.LEXICAL_DECISION_RESULT.ID }, true);
        public static final UniqueKey<SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_DATA_PKEY = Internal.createUniqueKey(SimilarityJudgementData.SIMILARITY_JUDGEMENT_DATA, "similarity_judgement_data_pkey", new TableField[] { SimilarityJudgementData.SIMILARITY_JUDGEMENT_DATA.ID }, true);
        public static final UniqueKey<SimilarityJudgementResultRecord> SIMILARITY_JUDGEMENT_RESULT_PKEY = Internal.createUniqueKey(SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT, "similarity_judgement_result_pkey", new TableField[] { SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT.ID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<LexicalDecisionResultRecord, LexicalDecisionDataRecord> LEXICAL_DECISION_RESULT__LEXICAL_DECISION_RESULT_DATA_ID_FKEY = Internal.createForeignKey(Keys.LEXICAL_DECISION_DATA_PKEY, LexicalDecisionResult.LEXICAL_DECISION_RESULT, "lexical_decision_result_data_id_fkey", new TableField[] { LexicalDecisionResult.LEXICAL_DECISION_RESULT.DATA_ID }, true);
        public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR11_DATA_ID_FKEY = Internal.createForeignKey(Keys.SIMILARITY_JUDGEMENT_DATA_PKEY, SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT, "similarity_judgement_result_pair11_data_id_fkey", new TableField[] { SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT.PAIR11_DATA_ID }, true);
        public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR12_DATA_ID_FKEY = Internal.createForeignKey(Keys.SIMILARITY_JUDGEMENT_DATA_PKEY, SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT, "similarity_judgement_result_pair12_data_id_fkey", new TableField[] { SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT.PAIR12_DATA_ID }, true);
        public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR21_DATA_ID_FKEY = Internal.createForeignKey(Keys.SIMILARITY_JUDGEMENT_DATA_PKEY, SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT, "similarity_judgement_result_pair21_data_id_fkey", new TableField[] { SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT.PAIR21_DATA_ID }, true);
        public static final ForeignKey<SimilarityJudgementResultRecord, SimilarityJudgementDataRecord> SIMILARITY_JUDGEMENT_RESULT__SIMILARITY_JUDGEMENT_RESULT_PAIR22_DATA_ID_FKEY = Internal.createForeignKey(Keys.SIMILARITY_JUDGEMENT_DATA_PKEY, SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT, "similarity_judgement_result_pair22_data_id_fkey", new TableField[] { SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT.PAIR22_DATA_ID }, true);
    }
}
