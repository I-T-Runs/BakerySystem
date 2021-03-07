/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.coyote.http11.Constants.GET;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String uName = request.getParameter("username");
        String pWord = request.getParameter("password");
        
//        the below is sending message back to service layer of mvc(if there is)
//        this will go all the way to db and return true or false
//        MvcService mvcService = new MvcService();
//        if(mvcService.verifyLogin(uName,pWord)){
//            RequestDispatcher rd = request.getRequestDispatcher("theDoughKnot.jsp");
//            rd.forward(request, response);
//        }else{
//            RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp");
//            rd.forward(request, response);
//        }
        if(uName.equals("Anthony") && pWord.equals("light")){
            RequestDispatcher rd = request.getRequestDispatcher("theDoughKnot.jsp");
            rd.forward(request,response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp");
            rd.forward(request,response);
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
