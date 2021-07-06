package com.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class LargeObject {
    @Id
    private Long id;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "PIC")
    private Byte[] picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }
}
