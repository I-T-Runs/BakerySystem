package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String id = request.getParameter("pro");
        String jsonString = "{\"ProductID\":" + id + "}";
        //String jsonString = "{\"\":\"\",\"\":\"\",\"\":" + val + "}";
        sendResponseToServer(response, jsonString);
        sendResponseToController(request, response);
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
        String url = "http://localhost:8080/BakerySystemRest/app/product/1";
        HttpURLConnection urlConn = null;
        BufferedReader br = null;

        try {
            URL urlObj;
            urlObj = new URL(url);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("accept", "application/json");
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("Cannot connect...");
                return;
            }
            System.out.println("Connection Successful, reading in data.");
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String value = null;
            while ((value = br.readLine()) != null) {
                System.out.println(value);
            }
        } finally {
            if (br != null) {
                br.close();
            }
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }
    }

    @Override
    protected void sendResponseToController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("Guest/SignIn.jsp");
        view.forward(request, response);
    }

}
