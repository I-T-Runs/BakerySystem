package com.bakerysystem.model;


import java.util.ArrayList;

public class Order {

    private int orderID;
    private ArrayList<ProductLineItem> orderLineArr;
    private int totalPrice;
    //private Invoice invoice ; 
    private Customer customer;
    private String paymentStatus;
    private int deliveryAddressId;

    public Order(){}
    public Order(int orderID, ArrayList<ProductLineItem> orderLineArr, int totalPrice, Customer customer, String paymentStatus, int deliveryAddressId) {
        this.orderID = orderID;
        this.orderLineArr = orderLineArr;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.paymentStatus = paymentStatus;
        this.deliveryAddressId = deliveryAddressId;
    }
    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderLineArr=" + orderLineArr + ", totalPrice=" + totalPrice + ", customer=" + customer + ", paymentStatus=" + paymentStatus + ", deliveryAddressId=" + deliveryAddressId + '}';
    }
    
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public ArrayList<ProductLineItem> getOrderLineArr() {
        return orderLineArr;
    }
    public void setOrderLineArr(ArrayList<ProductLineItem> orderLineArr) {
        this.orderLineArr = orderLineArr;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public int getDeliveryAddressId() {
        return deliveryAddressId;
    }
    public void setDeliveryAddressId(int deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }
}
