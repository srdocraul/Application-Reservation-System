package com.agency04.devcademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 100, name = "title")
    private String title;
    @Column(length = 150, name = "subtitle")
    private String subtitle;
    @Column(length = 5, name = "postal_code")
    private Integer postalCode;

    @OneToOne
    private Accommodation accommodation;

    public void mapFrom(Location source) {
        this.setTitle(source.getTitle());
        this.setSubtitle(source.getSubtitle());
        this.setPostalCode(source.getPostalCode());
    }
}
