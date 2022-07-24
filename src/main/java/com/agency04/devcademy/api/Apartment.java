package com.agency04.devcademy.api;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "apartment")
public class Apartment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int categorization = 1;
    private int personCount = 1;
    private String imageUrl;
    private boolean freeCancellation = true;
    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_accommodation", nullable = false)
    private Set<Accommodation> accommodation = new HashSet<>();

    public Set<Accommodation> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Set<Accommodation> accommodation) {
        this.accommodation = accommodation;
    }

    public Apartment(Set<Accommodation> accommodation) {
        this.accommodation = accommodation;
    }

    public Apartment(int categorization, int personCount, String imageUrl, boolean freeCancellation, double price) {
        this.id = id;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.freeCancellation = freeCancellation;
        this.price = price;
    }

    public Apartment() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", categorization=" + categorization +
                ", personCount=" + personCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", freeCancellation=" + freeCancellation +
                ", price=" + price +
                ", accommodation=" + accommodation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        return id != null ? id.equals(apartment.id) : apartment.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}