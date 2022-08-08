package com.agency04.devcademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
public class Location extends SuperClass {

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
