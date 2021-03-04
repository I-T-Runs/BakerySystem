package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GuestServlet", urlPatterns = {"/guest"})
public class GuestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        String process = request.getParameter("pro");
        if (process != null) {
            System.out.println("[Controller] Incoming process: " + process);
            ProcessRequestA pra = RequestFactory.createRequestAction(process);
            if (pra != null) {
                pra.processTheRequest(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

abstract class RequestFactory {

    public static ProcessRequestA createRequestAction(String action) {
        switch (Integer.parseInt(action)) {
            case 1:  //product
                return new ProductProcess();
            case 2: //login

            case 3: //register
            default:
        }
        return null;
    }
}
