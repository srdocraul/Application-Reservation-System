package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "accommodation")
@Data
@NoArgsConstructor
public class Accommodation extends LocationTitleAndSubtitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Size(min = 1, max = 5, message = "Category must be between 1 and 5 stars")
    private Integer categorization;
    @Enumerated(EnumType.STRING)
    private AccommodationType type;
    private Integer personCount;
    @Lob
    private Byte[] image;
    private Double price;
    private String ownerName;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean freeCancellation;
    private String linkForFacebook;
    private String linkForInstagram;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @JsonIgnore
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
        this.setImage(source.getImage());
        this.setPrice(source.getPrice());
        this.setFreeCancellation(source.getFreeCancellation());
    }
}