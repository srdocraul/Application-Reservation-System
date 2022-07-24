package com.agency04.devcademy.api;

import javax.persistence.*;
import java.util.List;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String subtitle;
    private String description;

    @OneToMany(targetEntity = Apartment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_fk", referencedColumnName = "id")
    private List<Apartment> apartments;

    public Accommodation() {
    }

    public Accommodation(String title, String subtitle, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}