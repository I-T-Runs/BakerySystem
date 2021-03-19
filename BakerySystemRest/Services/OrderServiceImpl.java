/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Model.Order;
import com.bakerysystem.dao.OrderDao;
import com.bakerysystem.dao.OrderDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author keoagile
 */
public class OrderServiceImpl implements OrderService{
    
    private OrderDao od ;

    public OrderServiceImpl() {
        
        od = new OrderDaoImpl();
    
    }

    @Override
    public boolean addOrder(Order order) {
        return od.addOrder(order);
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
}
