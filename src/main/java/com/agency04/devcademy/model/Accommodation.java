package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "accommodation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Accommodation extends LocationTitleAndSubtitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "The accommodations description", defaultValue = "Description", required = true)
    private String description;
    @Min(1)
    @Max(5)
    @Schema(description = "The accommodations categorization", defaultValue = "Categorization", required = true)
    private Integer categorization;
    @Enumerated(EnumType.STRING)
    @Schema(description = "The accommodations type", defaultValue = "Accommodations Type", required = true)
    private AccommodationType type;
    @Schema(description = "The accommodations person count", defaultValue = "Person Count", required = true)
    private Integer personCount;
    @Lob
    @Schema(description = "The accommodations image", defaultValue = "Image", required = true)
    private Byte[] image;
    @Schema(description = "The accommodations price", defaultValue = "Price", required = true)
    private Double price;
    @Schema(description = "The accommodations owner name", defaultValue = "Owner Name", required = true)
    private String ownerName;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    @Schema(description = "The accommodations  free cancellation", defaultValue = "Free Cancellation", required =
            true)
    private Boolean freeCancellation;
    @Schema(description = "The accommodations facebook profile link", defaultValue = "Facebook", required = true)
    private String linkForFacebook;
    @Schema(description = "The accommodations instagram profile link", defaultValue = "Instagram", required = true)
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