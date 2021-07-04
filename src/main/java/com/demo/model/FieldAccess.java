package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This entity being mapped using field access. @Id annotation indicates
 * that the id field is the persistent identifier or primary key for the entity
 * and that field access should be assumed. The other fields are then defaulted to
 * being persistent, and they get mapped to columns of the same name.
 */
@Entity
public class FieldAccess {
    @Id
    private Long id;
    private String name;
    private Long salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
