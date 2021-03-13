/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsrestclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */
public class BSRestClient {

    
    public static void main(String[] args) {
        tap();
    }

    public static void tap(){
        try {
            String url = "http://localhost:8084/TempBakery4ShopTesting/app/resources/product/{productid}";
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url).resolveTemplate("productid", 110321);
            System.out.println("Fetching Product...");
            String prod = webTarget.request().accept("application/json").get(String.class);
            System.out.println("RETURNED :\n " + prod);
            
        } catch (Exception ex) {
            Logger.getLogger(BSRestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
