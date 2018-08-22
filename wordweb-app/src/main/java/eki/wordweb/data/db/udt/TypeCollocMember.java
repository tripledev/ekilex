/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.udt;


import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.udt.records.TypeCollocMemberRecord;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.UDTImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TypeCollocMember extends UDTImpl<TypeCollocMemberRecord> {

    private static final long serialVersionUID = -1217989617;

    /**
     * The reference instance of <code>public.type_colloc_member</code>
     */
    public static final TypeCollocMember TYPE_COLLOC_MEMBER = new TypeCollocMember();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeCollocMemberRecord> getRecordType() {
        return TypeCollocMemberRecord.class;
    }

    /**
     * The attribute <code>public.type_colloc_member.lexeme_id</code>.
     */
    public static final UDTField<TypeCollocMemberRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_COLLOC_MEMBER, "");

    /**
     * The attribute <code>public.type_colloc_member.word_id</code>.
     */
    public static final UDTField<TypeCollocMemberRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_COLLOC_MEMBER, "");

    /**
     * The attribute <code>public.type_colloc_member.word</code>.
     */
    public static final UDTField<TypeCollocMemberRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, TYPE_COLLOC_MEMBER, "");

    /**
     * The attribute <code>public.type_colloc_member.form</code>.
     */
    public static final UDTField<TypeCollocMemberRecord, String> FORM = createField("form", org.jooq.impl.SQLDataType.CLOB, TYPE_COLLOC_MEMBER, "");

    /**
     * The attribute <code>public.type_colloc_member.homonym_nr</code>.
     */
    public static final UDTField<TypeCollocMemberRecord, Integer> HOMONYM_NR = createField("homonym_nr", org.jooq.impl.SQLDataType.INTEGER, TYPE_COLLOC_MEMBER, "");

    /**
     * The attribute <code>public.type_colloc_member.weight</code>.
     */
    public static final UDTField<TypeCollocMemberRecord, BigDecimal> WEIGHT = createField("weight", org.jooq.impl.SQLDataType.NUMERIC(14, 4), TYPE_COLLOC_MEMBER, "");

    /**
     * No further instances allowed
     */
    private TypeCollocMember() {
        super("type_colloc_member", null, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }
}
