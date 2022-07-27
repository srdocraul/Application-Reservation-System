package com.agency04.devcademy.model;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "accommodations")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String subtitle;
    private String description;

    private enum type {
        Room,
        Apartment,
        MobileHome;
    }

    public type accommodationType;
    private Integer categorization;
    private Integer personCount;
    private String imageUrl;
    private Double price;

    public Accommodation(Long id, String title, String subtitle, String description, Integer categorization, type accommodationType, Integer personCount, String imageUrl, Double price) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.categorization = categorization;
        this.accommodationType = accommodationType;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}