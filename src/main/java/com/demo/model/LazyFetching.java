package com.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class LazyFetching {
    @Id
    private Long id;

    /**
     * if no annotation, default @Basic
     */
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "COMM")
    private String commnets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommnets() {
        return commnets;
    }

    public void setCommnets(String commnets) {
        this.commnets = commnets;
    }
}
