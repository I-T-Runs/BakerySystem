/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.model;

/**
 *
 * @author Themba
 */
public class AddressClass {
    private int addressId;
    private int houseNumber;
    private String streetName;
    private String suburb;
    private String city;
    private int postalCode;

    public AddressClass(int addID, int houseNo, String strName, String suburb, String city, int postCode) {
    
        setAddressId(addID);
        setHouseNumber(houseNo);
        setStreetName(strName);
        setSuburb(suburb);
        setCity(city);
        setPostalCode(postCode);
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address: " + getHouseNumber() + " " + getStreetName() + " " + getSuburb() + " " + getCity() + " " + getPostalCode();
    }
    
    
}