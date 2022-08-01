package com.agency04.devcademy.model;

public class Location {
    public String name;
    public Integer postalCode;

    public Location(String name, Integer postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public Location() {
        isDuplicate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    private void isDuplicate() {
        //TODO: if this location with same name and postCode exists, then throw exception
        System.out.println("Throw error if duplicate");
    }
}
