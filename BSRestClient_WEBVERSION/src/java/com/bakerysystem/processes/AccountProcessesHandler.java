/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.processes;

import com.bakerysystem.model.*;
import com.bakerysystem.client.AccountsClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Themba
 */
public class AccountProcessesHandler {

    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username =request.getParameter("txtUSername");
	    String password =request.getParameter("txtPassword");
                

            Customer cus = (Customer) new AccountsClient().login(username, password);

//            request.setAttribute("retcust", retCust);
            if (cus != null) {
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.print("Sorry username or password error!");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }

//            out.print("Sorry username or password error!");
//			RequestDispatcher rd=request.getRequestDispatcher("login.html");
//			rd.include(request, response);
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }

    public void registerProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstname = (String) request.getParameter("firstname");
            String lastname = (String) request.getParameter("lastname");
            String email = (String) request.getParameter("email");
            String telno = (String) request.getParameter("telelphoneNO");
            String mobile = (String) request.getParameter("mobileNO");
            String idNO = (String) request.getParameter("IdentityNumber");
            String password = (String) request.getParameter("pass");

            Customer cust = (Customer) new AccountsClient().register(new Customer(firstname, lastname, email, telno, mobile, idNO, 0, password));

            request.setAttribute("customer", cust);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }

    public void getAccounts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Customer> users = new AccountsClient().getAllAccounts();

            request.setAttribute("users", users);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }

    public void getAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            Customer user = new AccountsClient().getAccount();

//            request.setAttribute("users", user);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }

    public void removeAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

//            String clientSaid = new AccountsClient().remove(0);
//            request.setAttribute("users", user);
            RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
            ex.getMessage();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientSaid = new AccountsClient().remove(0);
//            request.setAttribute("users", user);

        String firstname = (String) request.getParameter("firstname");
        String lastname = (String) request.getParameter("lastname");
        String email = (String) request.getParameter("email");
        String telno = (String) request.getParameter("telelphoneNO");
        String mobile = (String) request.getParameter("mobileNO");
        String idNO = (String) request.getParameter("IdentityNumber");
        String password = (String) request.getParameter("pass");

        String result = (String) new AccountsClient().updateDetails(new Customer(firstname, lastname, email, telno, mobile, idNO, 0, password));

        request.setAttribute("customer", result);

        RequestDispatcher view = request.getRequestDispatcher("/indexCS.jsp");
        view.forward(request, response);
    }
}
