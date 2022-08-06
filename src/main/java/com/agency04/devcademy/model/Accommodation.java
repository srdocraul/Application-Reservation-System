package com.agency04.devcademy.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accommodations")
@Data
@NoArgsConstructor
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Column(length = 100)
    private String title;
    @Column(length = 200)
    private String subtitle;
    private String description;
    @Column(length = 6)
    private Integer categorization;
    @Enumerated(EnumType.STRING)
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

    public void mapFrom(Accommodation source) {
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
}