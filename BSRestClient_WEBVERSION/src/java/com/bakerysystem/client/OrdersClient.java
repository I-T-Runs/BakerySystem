/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.model.Order;
import com.bakerysystem.properties.BSConfig;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public class OrdersClient {
    private final static String URL = new BSConfig().getURL("orders");
    private DefaultClient<Order> dc;
    
    
    public OrdersClient() {
            dc = new DefaultClient<>("content");        
    }
    
     public String addOrder(Order admin){
        return dc.create(admin, "add");
    }
    
    public Order getOrder(int userid) {
       return dc.get(userid, "a-pli/{id}");
    }
    
    public   String remove(int userId) {
        return dc.remove(userId, "remove");
    }
    
    public String editOrder(Order cus) {
        return dc.update(cus, "edit");
    }

    public   ArrayList<Order> getAllOrders() {    
        return dc.getAll("all-orders");
    }
    
    public   ArrayList<Order> getCustomersOrders(int userId) {    
        ArrayList<Order> arr = dc.getAll("all-orders");
        ArrayList<Order> usersOrders = new ArrayList<>();
        for (Order order : arr) {
            if(order.getCustomer().getCustomerId() == userId){
                usersOrders.add(order);
            }
        }
        return usersOrders;
    }
    
}
