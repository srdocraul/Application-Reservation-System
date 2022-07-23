package com.agency04.devcademy.api;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int categorization = 1;
    private int personCount = 1;
    private String imageUrl;
    private boolean freeCancellation = true;
    private double price;

    @OneToMany
    @JoinColumn(name = "accommodation_room", nullable = false)
    private Set<Accommodation> accommodation = new HashSet<>();

    public Room(Long id, int categorization, int personCount, String imageUrl, boolean freeCancellation, double price, Set<Accommodation> accommodation) {
        this.id = id;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.freeCancellation = freeCancellation;
        this.price = price;
        this.accommodation = accommodation;
    }

    public Room() {
    }

    public int getCategorization() {
        return categorization;
    }

    public void setCategorization(int categorization) {
        this.categorization = categorization;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Accommodation> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Set<Accommodation> accommodation) {
        this.accommodation = accommodation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}