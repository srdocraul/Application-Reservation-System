package com.agency04.devcademy.model;

import javax.persistence.*;

@Entity
@Table(name = "Location")
public class Location extends Auditable<String> {
    @Column(length = 150)
    private String name;
    private Integer postalCode;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Accommodation accommodation;

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

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
