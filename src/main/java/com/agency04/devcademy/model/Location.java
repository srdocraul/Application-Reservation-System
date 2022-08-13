package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
public class Location extends LocationTitleAndSubtitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 5)
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
