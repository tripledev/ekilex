/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.EkiUserApplication;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EkiUserApplicationRecord extends UpdatableRecordImpl<EkiUserApplicationRecord> implements Record6<Long, Long, String[], String, Timestamp, Boolean> {

    private static final long serialVersionUID = 866310430;

    /**
     * Setter for <code>public.eki_user_application.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.eki_user_application.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.eki_user_application.user_id</code>.
     */
    public void setUserId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.eki_user_application.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.eki_user_application.datasets</code>.
     */
    public void setDatasets(String[] value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.eki_user_application.datasets</code>.
     */
    public String[] getDatasets() {
        return (String[]) get(2);
    }

    /**
     * Setter for <code>public.eki_user_application.comment</code>.
     */
    public void setComment(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.eki_user_application.comment</code>.
     */
    public String getComment() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.eki_user_application.created</code>.
     */
    public void setCreated(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.eki_user_application.created</code>.
     */
    public Timestamp getCreated() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.eki_user_application.is_reviewed</code>.
     */
    public void setIsReviewed(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.eki_user_application.is_reviewed</code>.
     */
    public Boolean getIsReviewed() {
        return (Boolean) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, String[], String, Timestamp, Boolean> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, Long, String[], String, Timestamp, Boolean> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return EkiUserApplication.EKI_USER_APPLICATION.ID;
    }

    @Override
    public Field<Long> field2() {
        return EkiUserApplication.EKI_USER_APPLICATION.USER_ID;
    }

    @Override
    public Field<String[]> field3() {
        return EkiUserApplication.EKI_USER_APPLICATION.DATASETS;
    }

    @Override
    public Field<String> field4() {
        return EkiUserApplication.EKI_USER_APPLICATION.COMMENT;
    }

    @Override
    public Field<Timestamp> field5() {
        return EkiUserApplication.EKI_USER_APPLICATION.CREATED;
    }

    @Override
    public Field<Boolean> field6() {
        return EkiUserApplication.EKI_USER_APPLICATION.IS_REVIEWED;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getUserId();
    }

    @Override
    public String[] component3() {
        return getDatasets();
    }

    @Override
    public String component4() {
        return getComment();
    }

    @Override
    public Timestamp component5() {
        return getCreated();
    }

    @Override
    public Boolean component6() {
        return getIsReviewed();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getUserId();
    }

    @Override
    public String[] value3() {
        return getDatasets();
    }

    @Override
    public String value4() {
        return getComment();
    }

    @Override
    public Timestamp value5() {
        return getCreated();
    }

    @Override
    public Boolean value6() {
        return getIsReviewed();
    }

    @Override
    public EkiUserApplicationRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public EkiUserApplicationRecord value2(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public EkiUserApplicationRecord value3(String[] value) {
        setDatasets(value);
        return this;
    }

    @Override
    public EkiUserApplicationRecord value4(String value) {
        setComment(value);
        return this;
    }

    @Override
    public EkiUserApplicationRecord value5(Timestamp value) {
        setCreated(value);
        return this;
    }

    @Override
    public EkiUserApplicationRecord value6(Boolean value) {
        setIsReviewed(value);
        return this;
    }

    @Override
    public EkiUserApplicationRecord values(Long value1, Long value2, String[] value3, String value4, Timestamp value5, Boolean value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EkiUserApplicationRecord
     */
    public EkiUserApplicationRecord() {
        super(EkiUserApplication.EKI_USER_APPLICATION);
    }

    /**
     * Create a detached, initialised EkiUserApplicationRecord
     */
    public EkiUserApplicationRecord(Long id, Long userId, String[] datasets, String comment, Timestamp created, Boolean isReviewed) {
        super(EkiUserApplication.EKI_USER_APPLICATION);

        set(0, id);
        set(1, userId);
        set(2, datasets);
        set(3, comment);
        set(4, created);
        set(5, isReviewed);
    }
}
