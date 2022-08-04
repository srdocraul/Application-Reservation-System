package com.agency04.devcademy.model;

import javax.persistence.*;

@Entity
@Table(name = "Location", uniqueConstraints = {@UniqueConstraint(name = "UniqueCityAndPostalCode", columnNames = {"name", "postalCode"})})
public class Location {
    public String name;
    public Integer postalCode;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Location() {
    }

    public Location(String name, Integer postalCode) {
        this.setName(name);
        this.setPostalCode(postalCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
