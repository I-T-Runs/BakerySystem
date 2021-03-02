/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Model;

/**
 *
 * @author Themba
 */
class AddressClass {
    private int addressId;
    private String streetAndHouseNo;
    private String suburb;
    private String city;
    private int postalCode;
    
    private boolean withinAComplexOrEstate;
    private String estateOrComplexHouseNumber;

    public AddressClass(int addressId, String streetAndHouseNo, String suburb, String city, int postalCode, boolean withinAComplexOrEstate, String estateOrComplexHouseNumber) {
        this.addressId = addressId;
        this.streetAndHouseNo = streetAndHouseNo;
        this.suburb = suburb;
        this.city = city;
        this.postalCode = postalCode;
        this.withinAComplexOrEstate = withinAComplexOrEstate;
        this.estateOrComplexHouseNumber = estateOrComplexHouseNumber;
    }

    @Override
    public String toString() {
        return "AddressClass{" + "addressId=" + addressId + ", streetAndHouseNo=" + streetAndHouseNo + ", suburb=" + suburb + ", city=" + city + ", postalCode=" + postalCode + ", withinAComplexOrEstate=" + withinAComplexOrEstate + ", estateOrComplexHouseNumber=" + estateOrComplexHouseNumber + '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreetAndHouseNo() {
        return streetAndHouseNo;
    }

    public void setStreetAndHouseNo(String streetAndHouseNo) {
        this.streetAndHouseNo = streetAndHouseNo;
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

    public boolean isWithinAComplexOrEstate() {
        return withinAComplexOrEstate;
    }

    public void setWithinAComplexOrEstate(boolean withinAComplexOrEstate) {
        this.withinAComplexOrEstate = withinAComplexOrEstate;
    }

    public String getEstateOrComplexHouseNumber() {
        return estateOrComplexHouseNumber;
    }

    public void setEstateOrComplexHouseNumber(String estateOrComplexHouseNumber) {
        this.estateOrComplexHouseNumber = estateOrComplexHouseNumber;
    }
    
    
    
}
