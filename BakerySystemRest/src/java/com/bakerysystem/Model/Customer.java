package com.bakerysystem.Model;

import com.bakerysystem.Model.Order;
import java.util.ArrayList;

public class Customer extends User {

    private int customerId;
    private String Title;
    private String firstName;
    private String lastName;
    private String email;
    private String telephonehome;
    private String telephonemobile;
    private String ID;
    private int addressId;
    private String address;
    private String password;
    private Cart cart;

    public Customer() {
    }

    public Customer(int customerId, String Title, String firstName, String lastName, String email, String telephonehome, String telephonemobile, String ID, int addressId, String address, String password, Cart cart) {
        this.customerId = customerId;
        this.Title = Title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephonehome = telephonehome;
        this.telephonemobile = telephonemobile;
        this.ID = ID;
        this.addressId = addressId;
        this.address = address;
        this.password = password;
        this.cart = cart;
    }

    public Customer(String firstName, String lastName, String email, String telephonemobile, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephonemobile = telephonemobile;
        this.address = address;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephonehome() {
        return telephonehome;
    }

    public void setTelephonehome(String telephonehome) {
        this.telephonehome = telephonehome;
    }

    public String getTelephonemobile() {
        return telephonemobile;
    }

    public void setTelephonemobile(String telephonemobile) {
        this.telephonemobile = telephonemobile;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

