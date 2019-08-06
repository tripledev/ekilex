/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.udt;


import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.udt.records.TypePublicNoteRecord;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.DSL;
import org.jooq.impl.SchemaImpl;
import org.jooq.impl.UDTImpl;


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
public class TypePublicNote extends UDTImpl<TypePublicNoteRecord> {

    private static final long serialVersionUID = 1504163328;

    /**
     * The reference instance of <code>public.type_public_note</code>
     */
    public static final TypePublicNote TYPE_PUBLIC_NOTE = new TypePublicNote();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypePublicNoteRecord> getRecordType() {
        return TypePublicNoteRecord.class;
    }

    /**
     * The attribute <code>public.type_public_note.value</code>.
     */
    public static final UDTField<TypePublicNoteRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB, TYPE_PUBLIC_NOTE, "");

    /**
     * The attribute <code>public.type_public_note.complexity</code>.
     */
    public static final UDTField<TypePublicNoteRecord, String> COMPLEXITY = createField("complexity", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_PUBLIC_NOTE, "");

    /**
     * No further instances allowed
     */
    private TypePublicNote() {
        super("type_public_note", null, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC != null ? Public.PUBLIC : new SchemaImpl(DSL.name("public"));
    }
}
