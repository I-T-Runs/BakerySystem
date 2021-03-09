package com.bakerysystem.client.facades;

import Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Themba
 */
public class ProductsHandler {

    public static ArrayList<Product> recieveProducts() {
        ArrayList<Product> catalogue = null;
        Product [] products = null;
        try {            
            String url = "http://10.7.7.111:8080/BakerySystemRest/app/products/catalogue";
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url);
            System.out.println("Fetching Products...");
            
            ObjectMapper ob = new ObjectMapper();
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            products = ob.readValue(s, Product[].class) ;
//            System.out.println("RETURNED :\n " + prod);
            catalogue = new ArrayList(Arrays.asList(products));    
            
        } catch (Exception ex) {
            System.out.println("ERROR: Couldn't get products");
        }
        
        
        return catalogue;
    }
    
    public static Product recieveProduct(int productID) {
        Product prod = null;
        try {
            String url = "http://10.7.7.111:8080/BakerySystemRest/app/products/product/{productid}";
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url).resolveTemplate("productid", productID);
            System.out.println("Fetching Product...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            
            ObjectMapper ob = new ObjectMapper();
            prod = ob.readValue(s,Product.class);
            
            System.out.println("Fetch successfull");
            
            
        } catch (IOException ex) {
            System.out.println("ERROR: Couldn't get product");
        }
        return prod;
    }

    public static void main(String [] args){
        System.out.println(new ProductsHandler().recieveProducts());
    }
}
