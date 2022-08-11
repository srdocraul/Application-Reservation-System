package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
public class Location extends SuperClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5, name = "postal_code")
    private Integer postalCode;

    @JsonIgnore
    @OneToMany(mappedBy = "location", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Accommodation> accommodation = new ArrayList<>();

    public void mapFrom(Location source) {
        this.setTitle(source.getTitle());
        this.setSubtitle(source.getSubtitle());
        this.setPostalCode(source.getPostalCode());
    }
}
