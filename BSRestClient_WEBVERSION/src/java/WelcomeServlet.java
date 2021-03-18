
import com.bakerysystem.model.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//		String n=request.getParameter("userName");
//		out.print("Welcome "+n);
        ArrayList<Ingredient> arr = new ArrayList<>();

        Ingredient i1, i2, i3, i4, i5, i6;
        i1 = new Ingredient(0, "Royal Brand Eggs", 120); // quantity
        i2 = new Ingredient(0, "Clover Vanilla Milk", 40); // litres
        i3 = new Ingredient(0, "Brown Sugar", 60); // 
        i4 = new Ingredient(0, "Asian Baking Powder", 100);
        i5 = new Ingredient(0, "Ceberros Salt", 20); // kg
        i6 = new Ingredient(0, "Cake Flour", 80);// kg

        arr.add(i1);
        arr.add(i2);
        arr.add(i3);
        arr.add(i4);
        arr.add(i5);
        arr.add(i6);
        
        request.setAttribute("ingredients", arr);
        request.getRequestDispatcher("IngredientsPage.jsp").forward(request, response);
    }

}
