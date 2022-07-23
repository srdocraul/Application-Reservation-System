package com.agency04.devcademy.api;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String subtitle;
    private String description;

    @OneToMany
    @JoinColumn(name = "accommodation_apartment", nullable = false)
    private Set<Accommodation> accommodation = new HashSet<>();

    public Accommodation() {
    }

    public Accommodation(String first_apartment, String this_is_subtitle, String this_is_description) {
    }

    public Accommodation(Long id, String title, String subtitle, String description) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;

    }

    public Set<Accommodation> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Set<Accommodation> accommodation) {
        this.accommodation = accommodation;
    }

    public Accommodation(Set<Accommodation> accommodation) {
        this.accommodation = accommodation;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void getApartments() {
    }
}