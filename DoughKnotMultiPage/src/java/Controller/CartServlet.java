package Controller;

import com.bakerysystem.Model.Cart;
import com.bakerysystem.Model.Customer;
import com.bakerysystem.Model.Product;
import com.bakerysystem.Model.ProductLineItem;
import com.bakerysystem.client.AccountsClient;
import com.bakerysystem.client.ProductsClient;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("logcust");

        Product retprod = new ProductsClient().recieveProduct(Integer.parseInt(request.getParameter("prodID")));
        ProductLineItem pli = new ProductLineItem(retprod.getProductID(), retprod.getProductName(), 1);

        customer.getCart().getProducts().add(pli);;

        session.setAttribute("logcust", customer);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
