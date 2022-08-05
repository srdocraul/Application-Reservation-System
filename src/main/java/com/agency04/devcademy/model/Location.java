package com.agency04.devcademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
public class Location extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 150)
    private String name;
    private Integer postalCode;

    @OneToOne
    private Accommodation accommodation;
}
