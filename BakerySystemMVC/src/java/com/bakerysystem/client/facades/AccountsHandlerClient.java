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

/**
 *
 * @author Themba
 */
public class AccountsHandlerClient {
    
     public static User login(String username, String password) {
        try {
            String url = "http://10.7.7.111:8084/BakerySystemRest/app/users/login/{username}/{password}";
            Client accClient = ClientBuilder.newClient();
            WebTarget webTarget = accClient.target(url).resolveTemplate("username", username);
            webTarget = accClient.target(url).resolveTemplate("password", password);
            
            System.out.println("Fetching User...");
            String s = webTarget.request().accept("application/json").get(String.class);
            
            ObjectMapper ob = new ObjectMapper();
            User user = (User) ob.readValue(s,User.class);
            
            System.out.println("Login successfull");
            
            return user;
        } catch (IOException ex) {
            System.err.println("ERROR: Couldnt retrieve product");
        }
        
        return new User("blank_username", "blank_email", "blank_pass", "no_type");
    }

//     public static void main(String  [] args)
    
}
