package Controller;

import Model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductsProcess extends ProcessRequestA {

    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) {
        try {

            // -------------------- for test
            //        ArrayList<Product> products = new ArrayList<Product>();
            //        products.add(new Product(1, "cookie", null, null, 1));
            //        products.add(new Product(2, "cake", null, null, 1));
            //        products.add(new Product(3, "brownie", null, null, 1));
            // -------------------- end for test
            
            ArrayList<Product> products = receiveProducts();
            request.setAttribute("products", products);
            RequestDispatcher view = request.getRequestDispatcher("/test1.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }
}
