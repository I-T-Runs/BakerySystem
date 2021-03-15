package Controller;

import com.bakerysystem.Model.Customer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class PasswordRecoveryProcess extends ProcessRequestA {

    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = (String) request.getParameter("em");
            
            // -------------------- for test
            //Customer customer = new Customer(email);
            // -------------------- end for test

            //connectServer("http://10.7.7.111:8080/BakerySystemRest/app/");
            //writeToServer(customer);
            //Customer retCust = (Customer) readJSONFromServer(customer);

            //request.setAttribute("retcust", retCust);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);
            
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }

}
