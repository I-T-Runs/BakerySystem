package Model;

import java.util.ArrayList;

public class Customer extends User {

    private String customerId;
    private String customerName;
    private Order order;
    private ArrayList<AddressClass> ownedAddresses;

    public Customer() {
    }

    public Customer(String customerId, String customerName, Order order, ArrayList<AddressClass> ownedAddresses) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.order = order;
        this.ownedAddresses = ownedAddresses;
    }
    
    public void addToCart(Product product, Cart cart){
        
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<AddressClass> getOwnedAddresses() {
        return ownedAddresses;
    }

    public void setOwnedAddresses(ArrayList<AddressClass> ownedAddresses) {
        this.ownedAddresses = ownedAddresses;
    }

}
