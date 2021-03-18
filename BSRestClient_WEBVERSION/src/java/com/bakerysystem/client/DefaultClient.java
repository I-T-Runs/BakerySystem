package com.bakerysystem.client;

import com.bakerysystem.model.Customer;
import com.bakerysystem.extraz.Helper;
import com.bakerysystem.properties.BSConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Default Client [THE DOER OF ALL THINGS CRUD]
 *  - Don't ask why I created this guy [SECRET: Probably got lazy again]
 * 
 * @author Themba
 */
public class DefaultClient <T> {
    
    private String URL;
    
    public DefaultClient(String parentPathOfFunctions){
        URL = new BSConfig().getURL(parentPathOfFunctions);
        System.out.println("URL in DC: " + URL);
    }
    
    public String create(T obj, String methodPath){
        String responseRes;
        
        {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(URL + methodPath);
            
            responseRes = target.request().post(Entity.json(Helper.convert2Json(obj))).readEntity(String.class);
        }
        
        return responseRes;
    }
    
     //   Create : CHECKED | Retrieve : _all__|_1_ : CHECKED | Update : CHECKED | Delete : CHECKED        
    public static void main(String [] agr){
       DefaultClient dc = new DefaultClient<>("users");
       String response = dc.get(17, "user/{id}").toString();//.getAll("accounts").toString();//.get(17, "user/{id}").toString();//.create(new Customer("Themba", "Ndwandwe", "themba.ndwandwe@yahoo.com", "NA", "0823527###", "#############", 101, "password"), "register"); //.remove(14, "remove/{id}");//.update(new Customer(8, "first", "last", "email@something.com", "tel-home", "mobile-no", "identityNo", 0, "password"), "editdetails");
       System.out.println(response);
    }
    
    public   ArrayList<T> getAll(String methodPath) {
        ArrayList<T> objects = null;//T [] objects = null;
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + methodPath);

            
            System.out.println("Fetching User...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper ob = new ObjectMapper();
            T [] multInst = (T[]) (T) ob.readValue(s, Object[].class);
            objects = new ArrayList(Arrays.asList(multInst)); 
            
        } catch (Exception ex) {
            System.err.println("ERROR: Couldnt retrieve product");
        }

        return objects;
    }
    
    public   T get(int objID, String methodPath) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + methodPath).resolveTemplate("id", objID);

            
            System.out.println("Fetching User...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);

            System.out.println(s);
            
            ObjectMapper ob = new ObjectMapper();
            T obj =  (T) ob.readValue(s, Object.class);

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
