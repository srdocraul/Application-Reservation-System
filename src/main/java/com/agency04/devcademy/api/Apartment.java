package com.agency04.devcademy.api;

import javax.persistence.*;

@Entity
@Table(name = "Apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long apartment_id;
    private int categorization = 1;
    private int personCount = 1;
    private String imageUrl;
    private boolean freeCancellation = true;
    private double price;
    @OneToMany
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;

    public Apartment() {
    }

    public Apartment(long apartment_id, int categorization, int personCount, String imageUrl, boolean freeCancellation, double price, Accommodation accommodation) {
        this.apartment_id = apartment_id;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.freeCancellation = freeCancellation;
        this.price = price;
        this.accommodation = accommodation;
    }

    public long getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(long apartment_id) {
        this.apartment_id = apartment_id;
    }

    public int getCategorization() {
        return categorization;
    }

    public void setCategorization(int categorization) {
        this.categorization = categorization;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartment_id=" + apartment_id +
                ", categorization=" + categorization +
                ", personCount=" + personCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", freeCancellation=" + freeCancellation +
                ", price=" + price +
                ", accommodation=" + accommodation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (apartment_id != apartment.apartment_id) return false;
        if (categorization != apartment.categorization) return false;
        if (personCount != apartment.personCount) return false;
        if (freeCancellation != apartment.freeCancellation) return false;
        if (Double.compare(apartment.price, price) != 0) return false;
        if (imageUrl != null ? !imageUrl.equals(apartment.imageUrl) : apartment.imageUrl != null) return false;
        return accommodation != null ? accommodation.equals(apartment.accommodation) : apartment.accommodation == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (apartment_id ^ (apartment_id >>> 32));
        result = 31 * result + categorization;
        result = 31 * result + personCount;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (freeCancellation ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (accommodation != null ? accommodation.hashCode() : 0);
        return result;
    }
}
