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

/**
 *
 * @author Themba
 */
public class ProductsHandler {

    public static ArrayList<Product> recieveProducts() {
        ArrayList<Product> catalogue = null;
        Product [] products = null;
        try {
            catalogue = new ArrayList<>();
            
            String url = "http://10.7.7.111:8084/BakerySystemRest/app/catalogue";
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url);
            System.out.println("Fetching Products...");
            
            ObjectMapper ob = new ObjectMapper();
            String s = webTarget.request().accept("application/json").get(String.class);
            products = ob.readValue(s, Product[].class) ;
//            System.out.println("RETURNED :\n " + prod);
            
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ProductsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        catalogue = new ArrayList(Arrays.asList(products));
        
        return catalogue;
    }
    
    public static Product recieveProduct(int productID) {
        try {
            String url = "http://10.7.7.111:8084/BakerySystemRest/app/product/{productid}";
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url).resolveTemplate("productid", productID);
            System.out.println("Fetching Product...");
            String s = webTarget.request().accept("application/json").get(String.class);
            
            ObjectMapper ob = new ObjectMapper();
            Product prod = ob.readValue(s,Product.class);
            
            System.out.println("Fetch successfull");
            
            return prod;
        } catch (IOException ex) {
            Logger.getLogger(ProductsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String [] args){
        
        System.out.println(new ProductsHandler().recieveProducts());
    }
}
