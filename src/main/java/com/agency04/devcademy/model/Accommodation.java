package com.agency04.devcademy.model;

import javax.persistence.*;
import java.util.Objects;

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
    private String linkForFacebook;
    private String linkForInstagram;
    private String getLocationName;
    private Integer getLocationPostalCode;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    public Accommodation() {
    }

    public Accommodation(type accommodationType) {
        this.accommodationType = accommodationType;
    }

    public void Location(Location location) {
        this.getLocationName = location.name;
        this.getLocationPostalCode = location.postalCode;
    }

    public String getLinkForFacebook() {
        return linkForFacebook;
    }

    public void setLinkForFacebook(String linkForFacebook) {
        this.linkForFacebook = linkForFacebook;
    }

    public String getLinkForInstagram() {
        return linkForInstagram;
    }

    public void setLinkForInstagram(String linkForInstagram) {
        this.linkForInstagram = linkForInstagram;
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
                ", hasFacebook='" + linkForFacebook + '\'' +
                ", hasInstagram='" + linkForInstagram + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        return Objects.equals(id, that.id);
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

    public String getGetLocationName() {
        return getLocationName;
    }

    public void setGetLocationName(String getLocationName) {
        this.getLocationName = getLocationName;
    }

    public Integer getGetLocationPostalCode() {
        return getLocationPostalCode;
    }

    private enum type {
        Room, Apartment, MobileHome
    }
}