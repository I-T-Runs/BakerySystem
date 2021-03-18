package com.bakerysystem.client;

import com.bakerysystem.model.Customer;
import com.bakerysystem.extraz.Helper;
import com.bakerysystem.properties.BSConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
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

    private final static String URL = new BSConfig().getURL("users");
    private DefaultClient<Customer> dc;
    
    
    public AccountsClient() {
            dc = new DefaultClient<>("users");        
    }

    public   Customer login(String username, String password) {
        try {
            Client client = ClientBuilder.newClient();
//            Map map = new HashMap();
//            map.put("username", username);
//            map.put("password", password);
//            WebTarget webTarget = client.target(URL + "login/{username}/{password}").resolveTemplate(map.keySet(),map.values());
//            //  "http://localhost:8080/BakerySystemRest/app/"
            WebTarget webTarget = client.target(URL + "login/" + username + "/" + password);

            
            System.out.println("Fetching User...");
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper ob = new ObjectMapper();
            Customer user = (Customer) ob.readValue(s, Customer.class);

            System.out.println("Login successfull");

            return user;
        } catch (IOException ex) {
            System.err.println("ERROR: Couldnt retrieve product");
        }

        return null;
    }

    public   String recoverAccount(String providedEmail) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL + "recover/{email}").resolveTemplate("email", providedEmail);

        String r = target.request().accept("application/json").get(String.class);

        //                   EXPECT "Link sent if user account exists"
        return  r;
    }

    public   Customer register(Customer newUser) {
        Response generatedResponse = null;
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/BakerySystemRest/app/users/register");//client.target(URL + "register");

            Response r = target.request().post(Entity.json(Helper.convert2Json(newUser)));//post(Entity.json(Helper.convert2Json(newUser)));
            
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

    public String addAdmin(Customer admin){
        return dc.create(admin, "add");
    }
    
    public Customer getAccount(int userid) {
       return dc.get(userid, "user/{id}");
    }
    
    public   String remove(int userId) {
        return dc.remove(userId, "remove");
    }
    
    public String updateDetails(Customer cus) {
        return dc.update(cus, "update");
    }

    public   ArrayList<Customer> getAllAccounts() {    
        return dc.getAll("accounts");
    }

     public static void main(String[] args) {
         System.out.println(new AccountsClient().getAccount(17));
String s = new AccountsClient().getAllAccounts().toString();
//        String s = new AccountsClient().updateDetails(new Customer(16, "firstname", "lastname", "email", "tel-home", "mobile-no", "identityNo", 0, "password")); // 
//        String s = new AccountsClient().remove(13); // 
        System.out.println(s);
//        new AccountsClient().register(new Customer(0, "firstname", "lastname", "email", "tel-home", "mobile-no", "identityNo", 0, "password"));
//        Customer u = new AccountsClient().login("email0@gmail", "password");
//        if(u == null){
//            System.out.println("Unregistered User!");
//        }else{
//            System.out.println(u.getFirstName());
//        }
        
    }
    
}

