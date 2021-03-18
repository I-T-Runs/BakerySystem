import com.bakerysystem.client.AccountsClient;
import com.bakerysystem.model.Customer;
import com.bakerysystem.processes.AccountProcessesHandler;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class Simple extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
            String username =request.getParameter("txtUsername");
	    String password =request.getParameter("txtPassword");
                

            Customer cus = null;//new Customer(16, "firstname", "lastname", "email", "tel-home", "mobile-no", "identityNo", 0, "password");//(Customer) new AccountsClient().login(username, password);

//            request.setAttribute("retcust", retCust);
            if (cus != null) {
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                
                out.print("Error in provided username or password!");
                rd.include(request, response);
            }                
//		if(p.equals("servlet")){
////			RequestDispatcher rd=request.getRequestDispatcher("welcome");
//			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
//			
//                        rd.forward(request, response);
//			
//		}
//		else{
//			out.print("Sorry username or password error!");
//			RequestDispatcher rd=request.getRequestDispatcher("login.html");
//			rd.include(request, response);
//		}


		
	}

}
