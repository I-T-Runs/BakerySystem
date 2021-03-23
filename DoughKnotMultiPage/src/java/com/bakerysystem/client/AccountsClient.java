/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.Model.Customer;
import com.bakerysystem.extraz.Helper;
import com.bakerysystem.properties.BSConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Themba
 */
public class AccountsClient {

    private String URL ;//= new BSConfig().getURL("users");

    public AccountsClient() {
        URL = new BSConfig().getURL("users");
    }

     public static void main(String[] args) {
         System.out.println("****"+new AccountsClient().URL);
//          for(Customer c : new AccountsClient().getAllAccounts()){
//              System.out.println(c.getFirstName());
//          }
//        String s = new AccountsClient().updateDetails(new Customer(16, "firstname", "lastname", "email", "tel-home", "mobile-no", "identityNo", 0, "password")); // 
//        String s = new AccountsClient().remove(13); // 
//        System.out.println(s);
        //new AccountsClient().register(new Customer(0, "firsjhgvtname", "lastname", "emalkmil", "tel-home", "mobile-no", "identityNo", 0, "password"));
//        Customer u = new AccountsClient().login("email0@gmail", "password");
//        System.out.println(u.getFirstName());
//        if(u == null){
//            System.out.println("Unregistered User!");
//        }else{
//            System.out.println(u.getFirstName());
//        }

    }
    
    public Customer login(String username, String password) {
        Customer user = null;
        try {
            Client client = ClientBuilder.newClient();
            //            Map map = new HashMap();
//            map.put("username", username);
//            map.put("password", password);
//            WebTarget webTarget = client.target(URL + "login/{username}/{password}").resolveTemplate(map.keySet(),map.values());
//            //"http://localhost:8080/BakerySystemRest/app/"
            WebTarget webTarget = client.target(URL + "login/" + username + "/" + password);
            System.out.println("Fetching User...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            ObjectMapper ob = new ObjectMapper();
            user = (Customer) ob.readValue(s, Customer.class);
            System.out.println("Login successfull");
        } catch (IOException ex) {
            Logger.getLogger(AccountsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public String recoverAccount(String providedEmail) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL + "recover/{email}").resolveTemplate("email", providedEmail);

        String r = target.request().accept("application/json").get(String.class);

        //EXPECT "Link sent if user account exists"
        return r;
    }

    public Customer register(Customer newUser) {
        Response generatedResponse = null;
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(URL + "register");//client.target(URL + "register");

            Response r = target.request().post(Entity.json(convert2Json(newUser)));//post(Entity.json(Helper.convert2Json(newUser)));

            System.out.println("\n [" + r.getEntity() + "\n");
            System.out.println("--------------------------------------");

            generatedResponse = r;

            ObjectMapper ob = new ObjectMapper();
            String s = generatedResponse.readEntity(String.class);

            //System.out.println("JASON = " + s);
            Customer u = (Customer) ob.readValue(s, Customer.class);
            return u;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String convert2Json(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            ex.getMessage();
        }
        return null;
    }

    public String remove(int userId) {
        Response generatedResponse = null;
        String s = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + "remove/{userid}").resolveTemplate("userid", userId);

            generatedResponse = webTarget.request().accept("application/json").delete();
            s = generatedResponse.readEntity(String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public String updateDetails(Customer cus) {
        //             ADD OR CHANGE MAIN ADDRESS
        //             EDIT PERSONAL DETAILS

        Response generatedResponse = null;
        String s = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(URL + "editdetails");

            generatedResponse = webTarget.request().put(Entity.json(Helper.convert2Json(cus)));
            s = generatedResponse.readEntity(String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<Customer> getAllAccounts() {
        ArrayList<Customer> catalogue = null;
        Customer[] users = null;
        try {
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(URL + "accounts");

            ObjectMapper ob = new ObjectMapper();
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);

            System.out.println(s + "\n");
            users = ob.readValue(s, Customer[].class);
            catalogue = new ArrayList(Arrays.asList(users));

        } catch (Exception ex) {
            System.out.println("ERROR: Couldn't get users");
        }

        return catalogue;
    }

   

    // check
    public Customer getAccount(int userid) {
        Customer cus = null;
        try {

            Client restClient = ClientBuilder.newClient(); //+ ex.getMessage());
            WebTarget webTarget = restClient.target(URL + "user/" + userid);//.resolveTemplate("userid", userid);
            ObjectMapper ob = new ObjectMapper();
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            System.out.println(s + "\n");
            cus = (Customer) ob.readValue(s, Customer.class);
        } catch (IOException ex) {
            Logger.getLogger(AccountsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cus;
    }
}

/*
Allow registered customers to recover their password and username/email via email.
Allow customers to update/edit their account information.
Allow customers to view their account’s cart.
Allow customers to view their orders placed.
evident
 */
