  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.Model.Customer;
import com.bakerysystem.Model.Product;
import com.bakerysystem.extraz.Helper;
import com.bakerysystem.properties.BSConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Default Client [THE DOER OF ALL THINGS CRUD] - Don't ask why I created this
 * guy [SECRET: Probably got lazy again]
 *
 * @author Themba
 */
public class DefaultClient<T> {

    private String URL;

    public DefaultClient(String parentPathOfFunctions) {
        URL = new BSConfig().getURL(parentPathOfFunctions);
        System.out.println(URL);
    }

    public String create(T obj, String methodPath) {
        String responseRes;

        {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(URL + methodPath);

            responseRes = target.request().post(Entity.json(Helper.convert2Json(obj))).readEntity(String.class);
        }

        return responseRes;
    }

    //   Create : CHECKED | Retrieve : _all__|_1_ : CHECKED | Update : CHECKED | Delete : CHECKED        
public static void main(String[] args) {
    try{
        /*
        DefaultClient dc = new DefaultClient("products");
    ArrayList<Product> arr = dc.getAll("catalogue");
        */
        
        DefaultClient<Product> dc = new DefaultClient("users");
        
        List<Product> arr = dc.getAll("accounts");
        System.out.println((Product)arr.get(0));
        System.out.println(arr.get(1));
//        ArrayList<Product> arrr = new ArrayList();
        for (Product product : arr) {
            System.out.println(product.getProductName());
//              arrr.add(product);
        }
        
    }catch(Exception ex){
        System.out.println("The error -> " + ex.getMessage());
    }
    
    }
        
//        DefaultClient dc = new DefaultClient<>("users");
//        String response = dc.get(17, "user/{id}").toString();//.getAll("accounts").toString();//.get(17, "user/{id}").toString();//.create(new Customer("Themba", "Ndwandwe", "themba.ndwandwe@yahoo.com", "NA", "0823527###", "#############", 101, "password"), "register"); //.remove(14, "remove/{id}");//.update(new Customer(8, "first", "last", "email@something.com", "tel-home", "mobile-no", "identityNo", 0, "password"), "editdetails");
//        System.out.println(response);
    

    public List<Product> getAll(String methodPath) {
        Object objects = null;//T [] objects = null;
       List<Product> products = null;
//        try {
//            Client client = ClientBuilder.newClient();
//            WebTarget webTarget = client.target(URL + methodPath);
//
//            System.out.println("Fetching User...");
//            
//            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
//System.out.println(s);
//            ObjectMapper ob = new ObjectMapper();
//            Object[]multInst =  Arrays.as(ob.readValue(s, Customer[].class));
//            System.out.println(((Customer)multInst[0]).getFirstName());
////            objects = Arrays.asList(multInst);
//          //  products = (List<Product>) multInst;
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }

        return products;
    }

    public T get(int objID, String methodPath) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + methodPath).resolveTemplate("id", objID);

            System.out.println("Fetching User...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);

            System.out.println(s);

            ObjectMapper ob = new ObjectMapper();
            T obj = (T) ob.readValue(s, Object.class);

            return obj;
        } catch (Exception ex) {
            System.err.println("ERROR: Couldnt retrieve product");
        }

        return null;
    }

    public String update(T cus, String methodPath) {
        Response generatedResponse = null;
        String s = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + methodPath);

            generatedResponse = webTarget.request().put(Entity.json(Helper.convert2Json(cus)));
            s = generatedResponse.readEntity(String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public String remove(int objId, String methodPath) {
        //Response generatedResponse = null;
        String s = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + methodPath).resolveTemplate("id", objId);

            s = webTarget.request().accept("application/json").delete().readEntity(String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
   

}
