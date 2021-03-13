
import com.bakerysystem.Model.Product;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Themba
 */
public class ClientForTestingREST {
    
    
    public static void main(String [] args){
        runClient();
                
    }
    
      public static void runClient(){
        String url = "http://10.0.0.110:8084/BakerySystemRest/app/product?productid=3";
        Client restClient = ClientBuilder.newClient();
        WebTarget webTarget = restClient.target(url).resolveTemplate("orderid", "12345");
        System.out.println("Fetching Product...");
        Product prod = webTarget.request().accept("application/json").get(Product.class);
        System.out.println("RETURNED :\n " + prod);
    }
    
}
