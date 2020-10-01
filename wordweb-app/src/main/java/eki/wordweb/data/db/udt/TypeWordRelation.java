/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.udt;


import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.udt.records.TypeWordRelationRecord;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.DSL;
import org.jooq.impl.SchemaImpl;
import org.jooq.impl.UDTImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TypeWordRelation extends UDTImpl<TypeWordRelationRecord> {

    private static final long serialVersionUID = -1288996282;

    /**
     * The reference instance of <code>public.type_word_relation</code>
     */
    public static final TypeWordRelation TYPE_WORD_RELATION = new TypeWordRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeWordRelationRecord> getRecordType() {
        return TypeWordRelationRecord.class;
    }

    /**
     * The attribute <code>public.type_word_relation.word_group_id</code>.
     */
    public static final UDTField<TypeWordRelationRecord, Long> WORD_GROUP_ID = createField(DSL.name("word_group_id"), org.jooq.impl.SQLDataType.BIGINT, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word_rel_type_code</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> WORD_REL_TYPE_CODE = createField(DSL.name("word_rel_type_code"), org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.relation_status</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> RELATION_STATUS = createField(DSL.name("relation_status"), org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.order_by</code>.
     */
    public static final UDTField<TypeWordRelationRecord, Long> ORDER_BY = createField(DSL.name("order_by"), org.jooq.impl.SQLDataType.BIGINT, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word_id</code>.
     */
    public static final UDTField<TypeWordRelationRecord, Long> WORD_ID = createField(DSL.name("word_id"), org.jooq.impl.SQLDataType.BIGINT, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> WORD = createField(DSL.name("word"), org.jooq.impl.SQLDataType.CLOB, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word_prese</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> WORD_PRESE = createField(DSL.name("word_prese"), org.jooq.impl.SQLDataType.CLOB, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.homonym_nr</code>.
     */
    public static final UDTField<TypeWordRelationRecord, Integer> HOMONYM_NR = createField(DSL.name("homonym_nr"), org.jooq.impl.SQLDataType.INTEGER, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.homonyms_exist</code>.
     */
    public static final UDTField<TypeWordRelationRecord, Boolean> HOMONYMS_EXIST = createField(DSL.name("homonyms_exist"), org.jooq.impl.SQLDataType.BOOLEAN, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.lang</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> LANG = createField(DSL.name("lang"), org.jooq.impl.SQLDataType.CHAR(3), TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.aspect_code</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> ASPECT_CODE = createField(DSL.name("aspect_code"), org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word_type_codes</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String[]> WORD_TYPE_CODES = createField(DSL.name("word_type_codes"), org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.lex_complexities</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String[]> LEX_COMPLEXITIES = createField(DSL.name("lex_complexities"), org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_WORD_RELATION, "");

    /**
     * No further instances allowed
     */
    private TypeWordRelation() {
        super("type_word_relation", null, null, false);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC != null ? Public.PUBLIC : new SchemaImpl(DSL.name("public"));
    }
}
