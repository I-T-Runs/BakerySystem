package Controller;

import com.bakerysystem.Model.Customer;
import com.bakerysystem.client.AccountsClient;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        String em = request.getParameter("em");
        String pw = request.getParameter("pw");

        Customer logcust = (Customer) new AccountsClient().login(em, pw);

        if (logcust != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("logcust", logcust);
            request.getRequestDispatcher("shop4.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
