package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * property access mode
 * The type of property is determined by the return type of the getter
 * method and must be the same type of the single parameter passed into
 * the setter method.
 * The mapping annotations for a property must be on the getter method.
 */
@Entity
public class PropertyAccess {
    private Long id;
    private String name;
    private Long wage;

    /**
     * The provider will use property access to get and set the state
     * of the entity.
     * @return id
     */
    @Id
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

    /**
     * The name and salary Properties will be made persistent by the virtue of
     * the getter and setter that exist for them, and will be mapped to NAME
     * and SALARY columns.
     * By specifying property access, we are telling the provider
     * to ignore the entity fields and use only the getter and setter for naming.
     * @return wage
     */
    public Long getSalary() {
        return wage;
    }

    public void setSalary(Long salary) {
        this.wage = salary;
    }
}
