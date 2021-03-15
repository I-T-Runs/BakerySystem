package Controller;

import com.bakerysystem.Model.Product;
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

    public HttpURLConnection connectServerG(String endpoint) {
        try {
            //CONNECT
            URL urlObj = new URL(endpoint);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("accept", "application/json");
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
        } catch (MalformedURLException ex) {
            ex.getMessage();
        } catch (ProtocolException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
        return urlConn;
    }

    public HttpURLConnection connectServerP(String endpoint) {
        try {
            //CONNECT
            URL urlObj = new URL(endpoint);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("accept", "application/json");
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
        } catch (MalformedURLException ex) {
            ex.getMessage();
        } catch (ProtocolException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
        return urlConn;
    }

    public void writeJSONToServer(Object object) {
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
        }
    }

    public Object readJSONFromServer(Object object) {
        Object retObject = null;
        try {
            //READ
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String value = null;
            while ((value = br.readLine()) != null) {
                System.out.println(value);
            }
            retObject = om.readValue(br, object.getClass());
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
