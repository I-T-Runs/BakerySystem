/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Model.Order;
import com.bakerysystem.Model.ProductLineItem;
import com.bakerysystem.dao.IngredientDao;
import com.bakerysystem.dao.IngredientDaoImpl;
import com.bakerysystem.dao.OrderDao;
import com.bakerysystem.dao.OrderDaoImpl;
import com.bakerysystem.dao.ProductDao;
import com.bakerysystem.dao.ProductDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author keoagile
 */
public class OrderServiceImpl implements OrderService{
    
    private OrderDao od ;
    private IngredientDao ingrD;
    private ProductDao prodD;

    public OrderServiceImpl() {
        od = new OrderDaoImpl();
        ingrD  = new IngredientDaoImpl();
        prodD = new ProductDaoImpl();
    }

    @Override
    public boolean addOrder(Order order) {
        
        boolean done = od.addOrder(order);
       
        if(done == true){
            for(ProductLineItem pli: order.getOrderLineArr()){
             done = ingrD.reduceIngredients(prodD.getProduct(pli.getProductID()).getRecipeArr(), pli.getQuantity());
            }
        }
        return done;
    }

    @Override
    public Order getOrder(int orderId) {
        return od.getOrder(orderId);
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        return od.getAllOrders();
    }

    @Override
    public ArrayList<Order> getDeliveredOrders() {
        return od.getDeliveredOrders();
    }

    @Override
    public ArrayList<Order> OustandingOrders() {
        return od.OustandingOrders();
    }

    @Override
    public ArrayList<Order> PreparedOrders() {
        return od.PreparedOrders();
    }

    @Override
    public boolean cancelOrder(int orderId) {
        return od.removeOrder(orderId);
    }

    @Override
    public ArrayList<Order> getOrdersByCustomer(int customerId) {
        return od.getOrdersByCustomer(customerId);
    }
}
