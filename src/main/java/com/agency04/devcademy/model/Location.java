package com.agency04.devcademy.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
public class Location extends SuperClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Column(length = 5, name = "postal_code")
    private Integer postalCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Accommodation accommodation;

    public void mapFrom(Location source) {
        this.setTitle(source.getTitle());
        this.setSubtitle(source.getSubtitle());
        this.setPostalCode(source.getPostalCode());
    }
}
