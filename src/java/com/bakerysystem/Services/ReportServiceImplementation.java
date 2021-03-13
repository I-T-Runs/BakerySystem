//
//package com.bakerysystem.Services;
//
//import com.bakerysystem.Daos.OrderDAOImpl;
//import com.bakerysystem.Model.Order;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Andrew
// */
//public class ReportServiceImplementation implements ReportService{
//    private OrderDAOImplementation ordDaoImpl;
//    private ArrayList<String> orders;
//    ArrayList<Order> orderObjs;
//
//    public ReportServiceImplementation(){
//        ordDaoImpl = new OrderDAOImplementation();
//    }
//    
//    @Override
//    public ArrayList<String> getPlaced() {
//        orders = new ArrayList<String>();
//        
//        orderObjs = ordDaoImpl.getOrdersPlaced();
//        ObjectMapper oMapper = new ObjectMapper();
//        
//        for(Order o : orderObjs){
//            try {
//                orders.add( (String)oMapper.writeValueAsString(o) );
//            } catch (JsonProcessingException ex) {
//                System.err.println("Error : "+ex.getMessage());
//            }
//        }
//        
//        return this.getOrders();
//    }
//
//    @Override
//    public ArrayList<String> getOutStanding() {
//        orders = new ArrayList<String>();
//        
//        orderObjs = ordDaoImpl.getOutstandingOrders();
//        ObjectMapper oMapper = new ObjectMapper();
//        
//        for(Order o : orderObjs){
//            try {
//                orders.add( (String)oMapper.writeValueAsString(o) );
//            } catch (JsonProcessingException ex) {
//                System.err.println("Error : "+ex.getMessage());
//            }
//        }
//        
//        return this.getOrders();
//    }
//
//    @Override
//    public ArrayList<String> getDelivered() {
//        orders = new ArrayList<String>();
//        
//        orderObjs = ordDaoImpl.getOrdersDelivered();
//        ObjectMapper oMapper = new ObjectMapper();
//        
//        for(Order o : orderObjs){
//            try {
//                orders.add( (String)oMapper.writeValueAsString(o) );
//            } catch (JsonProcessingException ex) {
//                System.err.println("Error : "+ex.getMessage());
//            }
//        }
//        
//        return this.getOrders();
//    }
//    
//    private ArrayList<String> getOrders(){
//        return this.orders;
//    }
//    private void setOrders(ArrayList<String> orderList){
//        this.orders =  orderList;
//    }
//    
//}
