package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location extends LocationTitleAndSubtitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "The location postal code", defaultValue = "Postal Code", required = true)
    private Integer postalCode;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Accommodation> accommodation = new ArrayList<>();

    public Location(String title, String subtitile, Integer postalCode) {
    }

    public void mapFrom(Location source) {
        this.setTitle(source.getTitle());
        this.setSubtitle(source.getSubtitle());
        this.setPostalCode(source.getPostalCode());
    }
}
