/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client.facades;

import Model.Product;
import Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
        try
        {
            // Creating a Client
            Client client = Client.create();
            // Resource for accessing our Service
            WebResource webResource = client.resource("http://localhost:8080/BakerySystemRest/app/users/register");
            // Input for send to the service
            String inputMsg = "{\"age\": \"55\", \"name\": \"JavaInterviewPoint1212\"}";
            // Format of the response accepted
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, inputMsg);
            
            System.out.println("Fetching Output....");
            String output = response.getEntity(String.class);
            System.out.println(output);

        } catch (Exception e)
        {

            e.printStackTrace();
        }
        
    }

//     public static void main(String  [] args)
    
}
