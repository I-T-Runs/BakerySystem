/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.bakerysystem.Model.Customer;
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class RegistrationProcess extends ProcessRequestA {

    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fname = (String) request.getParameter("fn");
            String lname = (String) request.getParameter("ln");
            String email = (String) request.getParameter("ue");
            String contactNum = (String) request.getParameter("cn");
            String deliveryAddr = (String) request.getParameter("da");
            String password = (String) request.getParameter("pass");
//
//            // -------------------- for test
            Customer customer = new Customer(0, fname, lname, email, null, contactNum, null, 0, password);
//            // -------------------- end for test
//                  
//            Customer customer = new Customer(fname, lname, email, contactNum, deliveryAddr, password);
            HttpURLConnection conn = connectServerP("http://10.7.7.111:8080/BakerySystemRest/app/users/register");
            writeJSONToServer(customer);

//            Customer retCust = (Customer) readJSONFromServer(customer);
//            request.setAttribute("retcust", retCust);
            RequestDispatcher view = request.getRequestDispatcher("indexCS.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }
}
