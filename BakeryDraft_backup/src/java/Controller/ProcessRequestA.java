package Controller;

import Model.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class ProcessRequestA {

    private HttpURLConnection urlConn;
    private BufferedReader br;
    private BufferedWriter bw;
    private ObjectMapper om;

    public abstract void processTheRequest(HttpServletRequest request, HttpServletResponse response);

    public void connectServer(String endpoint) {
        try {
            //CONNECT
            URL urlObj = new URL(endpoint);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("accept", "application/json");
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("Cannot connect...");
            }
        } catch (MalformedURLException ex) {
            ex.getMessage();
        } catch (ProtocolException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void writeToServer(Object object) {
        try {
            //WRITE
            om = new ObjectMapper().configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
            bw = new BufferedWriter(new OutputStreamWriter(urlConn.getOutputStream()));
            bw.write(om.writeValueAsString(object));
            bw.flush();
        } catch (ProtocolException ex) {
            Logger.getLogger(ProcessRequestA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProcessRequestA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProcessRequestA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //CLOSE
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }
    }

    public Object readFromServer() {
        Object retObject = null;
        try {
            //READ
            System.out.println("Connection Successful, reading in data.");
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            //retObject = om.readValue(br, obj.getClass());
            String value = null;
            while ((value = br.readLine()) != null) {
                System.out.println(value);
            }

        } catch (MalformedURLException ex) {
            ex.getMessage();
        } catch (ProtocolException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            //CLOSE
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }
        return retObject;
    }

    protected ArrayList<Product> receiveProducts() {
        ArrayList<Product> catalogue = null;
        Product[] products = null;
        try {
            String url = "http://10.7.7.111:8080/BakerySystemRest/app/products/catalogue";
            Client restClient = ClientBuilder.newClient();
            WebTarget webTarget = restClient.target(url);
            System.out.println("Fetching Products...");

            ObjectMapper ob = new ObjectMapper();
            String s = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
            products = ob.readValue(s, Product[].class);
//            System.out.println("RETURNED :\n " + prod);
            catalogue = new ArrayList(Arrays.asList(products));

        } catch (Exception ex) {
            System.out.println("ERROR: Couldn't get products");
        }

        return catalogue;
    }

    protected ArrayList<Product> receiveProduct() {
        return null;
    }

}
