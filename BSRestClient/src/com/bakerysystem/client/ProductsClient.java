package com.bakerysystem.client;

import Model.Product;
import com.bakerysystem.extraz.Helper;
import com.bakerysystem.properties.BSConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */
public class ProductsClient {
    private static String url;
    public ProductsClient(){
        url = new BSConfig().getURL("products");
    }
    
    public static ArrayList<Product> recieveProducts() {
        ArrayList<Product> catalogue = null;
        Product [] products = null;
        try {            
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url + "catalogue");
            System.out.println("Fetching Products...");
            
            ObjectMapper ob = new ObjectMapper();
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            
            System.out.println(s+"\n");
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
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url + "product/{productid}").resolveTemplate("productid", productID);
            System.out.println("Fetching Product...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            
            ObjectMapper ob = new ObjectMapper();
            prod = ob.readValue(s,Product.class);
           
            System.out.println("Fetch successfull");
        } catch (IOException ex) {
            System.out.println("ERROR: Couldn't get product\n" + ex.getMessage());
        }
        return prod;
    }
    
    public static String addProduct(Product newProd) {
        Response generatedResponse = null;
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(url+"register");
            
            Product prod = newProd;
          
            Response r = target.request().post(Entity.json(Helper.convert2Json(prod))); 
            return r.getEntity().toString();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static void main(String [] args){
        System.out.println(new ProductsClient().recieveProduct(65465));
    }
}
