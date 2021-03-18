package com.bakerysystem.processes;

import com.bakerysystem.client.ProductsClient;
import com.bakerysystem.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Themba
 */
public class ProductProcessHandler {
    
     public void getProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            ArrayList<Product> products = new ProductsClient().getAllProducts();
            
            request.setAttribute("products", products);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);
        
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
     }
     
     public void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
//            Customer user = new AccountsClient().getAccount();
            
//            request.setAttribute("users", user);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);
        
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
     }
     
       public void removeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {

//            String clientSaid = new AccountsClient().remove(0);
//            request.setAttribute("users", user);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp"); // 
            view.forward(request, response);
        
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
     }
       
       public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            //   get Product ID => i 
             Product prod = null; // new ProductsClient().get(prodID);
           
            
            String result = (String) new ProductsClient().updateDetails(prod);
            
            request.setAttribute("product", result);

            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);
       }
}
