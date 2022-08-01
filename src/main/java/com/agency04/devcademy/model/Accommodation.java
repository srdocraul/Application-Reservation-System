package com.agency04.devcademy.model;

import javax.persistence.*;

@Entity
@Table(name = "accommodations")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private Integer categorization;
    private type accommodationType;
    private Integer personCount;
    private String imageUrl;
    private Double price;
    private String ownerName;
    private String hasFacebook;
    private String hasInstagram;
    private String nameLocation;
    private Integer postalCodeLocation;

    public Accommodation() {
    }

    public Accommodation(Long id, String title, String subtitle, String description,
                         Integer categorization, type accommodationType, Integer personCount,
                         String imageUrl, Double price, String ownerName, String hasFacebook,
                         String hasInstagram, Location location) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.categorization = categorization;
        this.accommodationType = accommodationType;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.price = price;
        this.ownerName = ownerName;
        this.hasFacebook = hasFacebook;
        this.hasInstagram = hasInstagram;
        this.nameLocation = location.name;
        this.postalCodeLocation = location.postalCode;
    }

    public Accommodation(type accommodationType) {
        this.accommodationType = accommodationType;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public Integer getPostalCodeLocation() {
        return postalCodeLocation;
    }

    public void setPostalCodeLocation(Integer postalCodeLocation) {
        this.postalCodeLocation = postalCodeLocation;
    }

    public String getHasFacebook() {
        return hasFacebook;
    }

    public void setHasFacebook(String hasFacebook) {
        this.hasFacebook = hasFacebook;
    }

    public String getHasInstagram() {
        return hasInstagram;
    }

    public void setHasInstagram(String hasInstagram) {
        this.hasInstagram = hasInstagram;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public type getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(type accommodationType) {
        this.accommodationType = accommodationType;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "accommodationType=" + accommodationType +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", categorization=" + categorization +
                ", personCount=" + personCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", ownerName='" + ownerName + '\'' +
                ", hasFacebook='" + hasFacebook + '\'' +
                ", hasInstagram='" + hasInstagram + '\'' +
                ", nameLocation='" + nameLocation + '\'' +
                ", postalCodeLocation=" + postalCodeLocation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void mapFrom(Accommodation source) {
        this.setId(source.getId());
        this.setTitle(source.getTitle());
        this.setSubtitle(source.getTitle());
        this.setDescription(source.getDescription());
        this.setCategorization(source.getCategorization());
        this.setAccommodationType(source.getAccommodationType());
        this.setPersonCount(source.getPersonCount());
        this.setImageUrl(source.getImageUrl());
        this.setPrice(source.getPrice());
    }

    private enum type {
        Room, Apartment, MobileHome
    }
}