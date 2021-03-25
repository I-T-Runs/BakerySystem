/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Themba
 */
public class ProductsClient {
//    private static String url;
   // private String URL = new BSConfig().getURL("products");
    private String URL = "http://localhost:8080/BakerySystemRest/app/products/";
    
    DefaultClient<Product> dc ;
    
    public ProductsClient(){
        dc = new DefaultClient<Product>("products");
        System.out.println(URL);
//        URL = new BSConfig().getURL("products");
    }

    public ArrayList<Product> recieveProducts() {
       
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL + "catalogue");
        ArrayList<Product> rr = new ArrayList();
        try {
            rr = new ArrayList(Arrays.asList(new ObjectMapper().readValue(target.request().accept(MediaType.APPLICATION_JSON).get(String.class), Product[].class)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return rr;
        
//        return catalogue;
    }

    public Product recieveProduct(int productID){
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL + "product/{id}").resolveTemplate("id",productID);
        
        Product prod = null;
        try {
            prod = new ObjectMapper().readValue(target.request().accept(MediaType.APPLICATION_JSON).get(String.class), Product.class);
        } catch (IOException ex) {
            Logger.getLogger(ProductsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prod;
        
    }

    public  String addProduct(Product newProd) {
       
        return dc.create(newProd, "add-product") ;
    }

    public static void main(String [] args){
        
//            System.out.println(new ProductsClient().recieveProduct(1).getProductName());
            //        System.out.println();
            ArrayList<Product> arr = new ProductsClient().recieveProducts();
            if(arr.isEmpty()){
                System.out.println("yebo iyabheda");
            }
            for (Product object : arr) {
                System.out.println(object.getProductName());
            }
        
    }
}