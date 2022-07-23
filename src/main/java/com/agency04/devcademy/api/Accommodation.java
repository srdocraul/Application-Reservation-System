package com.agency04.devcademy.api;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Accommodation")
public class Accommodation {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private long accommodation_id;
    private String title;
    private String subtitle;
    private String description;
    private Set<Room> rooms;
    private Set<Apartment> apartments;
    private Set<MobileHome> mobileHomes;

    public Accommodation(long id, String title, String subtitle, String description, Set<Room> rooms, Set<Apartment> apartments, Set<MobileHome> mobileHomes) {
        this.accommodation_id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.rooms = rooms;
        this.apartments = apartments;
        this.mobileHomes = mobileHomes;
    }

    public Accommodation() {
    }

    public long getId() {
        return accommodation_id;
    }

    public void setId(long id) {
        this.accommodation_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Set<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Set<MobileHome> getMobileHomes() {
        return mobileHomes;
    }

    public void setMobileHomes(Set<MobileHome> mobileHomes) {
        this.mobileHomes = mobileHomes;
    }
}