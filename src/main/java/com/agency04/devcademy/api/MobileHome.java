package com.agency04.devcademy.api;

import javax.persistence.*;

@Entity
@Table(name = "Mobile Homes")
public class MobileHome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mobileHome_id;
    private int categorization = 1;
    private int personCount = 1;
    private String imageUrl;
    private boolean freeCancellation = true;
    private double price;
    @ManyToOne
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;

    public MobileHome() {
    }

    public MobileHome(long mobileHome_id, int categorization, int personCount, String imageUrl, boolean freeCancellation, double price, Accommodation accommodation) {
        this.mobileHome_id = mobileHome_id;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.freeCancellation = freeCancellation;
        this.price = price;
        this.accommodation = accommodation;
    }

    public long getMobileHome_id() {
        return mobileHome_id;
    }

    public void setMobileHome_id(long mobileHome_id) {
        this.mobileHome_id = mobileHome_id;
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
}
