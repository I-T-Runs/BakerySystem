/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client.facades;

import Model.Customer;
import Model.Product;
import Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.catalina.WebResource;

/**
 *
 * @author Themba
 */
public class AccountsHandlerClient {
    
     public static User login(String username, String password) {
        try {
            String url = "http://10.7.7.111:8080/BakerySystemRest/app/users/login/{username}/{password}";
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url).resolveTemplate("username", username);
            webTarget = client.target(url).resolveTemplate("password", password);
            
            System.out.println("Fetching User...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            
            ObjectMapper ob = new ObjectMapper();
            User user = (User) ob.readValue(s,User.class);
            
            System.out.println("Login successfull");
            
            return user;
        } catch (IOException ex) {
            System.err.println("ERROR: Couldnt retrieve product");
        }
        
        return new User("blank_username", "blank_email", "blank_pass", "no_type");
    }
     
    public static String register(){
        String generatedResponse = "";
        try
        {
            String url = "http://10.7.7.111:8080/BakerySystemRest/app/users/register";
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            User reg = new User("mthiz","lp@gmail.com","password","admin");
            
          //  webTarget.request().post(Entity.json(reg),User.class);
            
//            reg = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(reg),User.class);
//            Invocation.Builder ib = 

            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(reg, MediaType.APPLICATION_JSON));


//            Response response = webTarget.request().post(Entity.entity(reg, MediaType.APPLICATION_JSON));
            // sdfsdfsdf
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return generatedResponse;
    }
    
    public static void register2(){
        String url = "http://10.7.7.111:8080/BakerySystemRest/app/users/register";
        HttpURLConnection con = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        
        
        User reg = new User("mthiz","lp@gmail.com","password","admin");
        Customer reg = new Customer(0, "adasda", null, null);
        
        String json = "{\"cusName\":\"Themba\",\"amount\":655,\"address\":\"Somewhere in Rosebank\",\"theorder\":100121}";
        
        try {
            URL urlObj = new URL(url);
            con = (HttpURLConnection) urlObj.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
             con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            
            writer = new PrintWriter(con.getOutputStream());
            writer.println(json);
            writer.flush();
            
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String dataIn = null;
            System.out.println("READING RESPONSE: " + "\n");
            while((dataIn=reader.readLine()) != null){
                System.out.println(dataIn);
            }
        
            
        } catch (MalformedURLException ex) {
ex.getMessage();        } catch (IOException ex) {
ex.getMessage();        }finally{
            try {
                reader.close();
                writer.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
            if(con!= null){
                con.disconnect();
            }
        }    
    }

     public static void main(String  [] args){
         System.out.print(register());
     }
    
}
