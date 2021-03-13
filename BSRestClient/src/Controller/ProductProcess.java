package Controller;

import Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

public class ProductProcess extends ProcessRequestA {

//    public static void main(String[] args) {
//        try {
//            new ProductProcess().processTheRequest();
//        } catch (ProtocolException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
//    }
    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productId");
        //String jsonString = "{\"ProductID\":" + id + "}";
        //String jsonString = "{\"\":\"\",\"\":\"\",\"\":" + val + "}";
//        sendResponseToServer(response, jsonString);
//        sendResponseToController(request, response);
          getResponseFromServer();
    }

    @Override
    protected void sendResponseToServer(HttpServletResponse response, String jsonString) {
        PrintWriter pw = null;
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            pw = response.getWriter();
            try {
                pw.print(jsonString);
                pw.flush();
            } finally {
                pw.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void getResponseFromServer() throws MalformedURLException, ProtocolException, IOException {
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(getBaseURI());
        String jsonObj = target.path("/product").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("I got Object from db : "+ jsonObj);
        
        ObjectMapper oMapper = new ObjectMapper();
        Product prod = oMapper.readValue(jsonObj, Product.class);
        System.out.println("I have the Object named"+ prod.getProductName());
        //return Prod;
        

//        String url = "http://localhost:8084/BakerySystemRest/app/product?productId={productId}";
//        ClientConfig config = new ClientConfig();
//        Client client = ClientBuilder.newClient(config);
//        WebTarget target = client.target(url).resolveTemplate("productId", "1");
//        
//        String jsonString = target.request().accept("application/json").get(String.class);
//        ObjectMapper om = new ObjectMapper();
//        Product prod = (Product)om.readValue(jsonString, Product.class);
//        System.out.println("Product Name : "+prod.getProductName());
//        System.out.println("I received : "+jsonString);



//        String url = "http://192.168.189.54:8080/BakerySystemRest/app/catalogue";
//        HttpURLConnection urlConn = null;
//        BufferedReader br = null;
//
//        try {
//            URL urlObj;
//            urlObj = new URL(url);
//            urlConn = (HttpURLConnection) urlObj.openConnection();
//            urlConn.setRequestMethod("GET");
//            urlConn.setRequestProperty("Accept", "application/json");
//            urlConn.setConnectTimeout(5000);
//            urlConn.setReadTimeout(5000);
//            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                System.out.println("Cannot connect...");
//                return;
//            }
//            System.out.println("Connection Successful, reading in data.");
//            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
//            String value = null;
//            while ((value = br.readLine()) != null) {
//                System.out.println(value);
//            }
//        } finally {
//            if (br != null) {
//                br.close();
//            }
//            if (urlConn != null) {
//                urlConn.disconnect();
//            }
//        }
    }

    @Override
    protected void sendResponseToController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("Guest/SignIn.jsp");
        view.forward(request, response);
    }
    
    private static URI getBaseURI(){
            return UriBuilder.fromUri("http://localhost:8084/BakerySystemRest").build();
        }
    //main method test below
//    public static void main(String [] args){
//        try {
//            new ProductProcess().getResponseFromServer();
//        } catch (ProtocolException ex) {
//            System.out.println("Error: "+ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("Error: "+ex.getMessage());
//        }
//    }

}
