package com.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Combining field access with property access.
 * The @Aceess annotation must be used, or it will be undefined if both
 * fields and properties are annotated.
 */
@Entity
@Access(AccessType.FIELD)
public class MixedAccess {
    public static final String LOCAL_AREA_CODE = "613";

    @Id
    private Long id;

    @Transient
    private String phoneNum;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPhoneNumber() { return phoneNum; }
    public void setPhoneNumber(String num) { this.phoneNum = num; }

    @Access(AccessType.PROPERTY)
    @Column(name = "PHONE")
    public String getPhoneNumberForDb() {
        if (phoneNum.length() == 10) {
            return phoneNum;
        } else {
            return LOCAL_AREA_CODE + phoneNum;
        }
    }

    public void setPhoneNum(String num) {
        if (num.startsWith(LOCAL_AREA_CODE)) {
            phoneNum = num.substring(3);
        } else {
            phoneNum = num;
        }
    }
}
