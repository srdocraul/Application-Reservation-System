package com.agency04.devcademy.api;

import javax.persistence.*;
import java.util.List;

@Entity
public class Apartment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer categorization = 1;
    private Integer personCount =1;
    private String imageUrl;
    private Boolean freeCancellation = true;
    private Double price;

    @ManyToOne(targetEntity = Accommodation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private List<Accommodation> accommodation;

    public Apartment() {
    }

    public Apartment(Integer categorization, Integer personCount, String imageUrl, Boolean freeCancellation, Double price) {
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.freeCancellation = freeCancellation;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategorization() {
        return categorization;
    }

    public void setCategorization(Integer categorization) {
        this.categorization = categorization;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(Boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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