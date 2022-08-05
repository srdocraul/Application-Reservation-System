package com.agency04.devcademy.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accommodations")
public class Accommodation extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Column(length = 100)
    private String title;
    @Column(length = 200)
    private String subtitle;
    private String description;
    @Column(length = 5)
    private Integer categorization;
    private AccommodationType type;
    private Integer personCount;
    private String imageUrl;

    private Double price;
    private String ownerName;
    private String linkForFacebook;
    private String linkForInstagram;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean freeCancellation;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accommodation")
    private Set<Reservation> reservation;

    public Accommodation() {
    }


    public Boolean getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(Boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
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

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public Set<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(Set<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", categorization=" + categorization +
                ", type=" + type +
                ", personCount=" + personCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", ownerName='" + ownerName + '\'' +
                ", linkForFacebook='" + linkForFacebook + '\'' +
                ", linkForInstagram='" + linkForInstagram + '\'' +
                ", location=" + location +
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
        this.setType(source.getType());
        this.setPersonCount(source.getPersonCount());
        this.setImageUrl(source.getImageUrl());
        this.setPrice(source.getPrice());
        this.setFreeCancellation(source.getFreeCancellation());
    }

    public Location getLocation() {
        return location;
    }

    public Location setLocation(Location location) {
        return this.location = location;
    }
}