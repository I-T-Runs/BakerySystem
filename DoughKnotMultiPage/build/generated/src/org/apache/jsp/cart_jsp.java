package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bakerysystem.Model.ProductLineItem;
import java.util.ArrayList;
import com.bakerysystem.Model.Cart;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"w3-container\" id=\"cart\">\n");
      out.write("            <span onclick=\"window.open('welcome.jsp').style.display = 'none'\" class=\"close\" title=\"Close Modal\">&times;</span>\n");
      out.write("            <form action=\"cart\" method=\"POST\">\n");
      out.write("                ");
 Cart cart = new Cart(); 
      out.write("\n");
      out.write("                ");
 ArrayList<ProductLineItem> cartArr = new ArrayList<>(); 
      out.write("\n");
      out.write("                ");
 cartArr.add(new ProductLineItem(1, "cookie", 1)); 
      out.write("\n");
      out.write("                ");
 cartArr.add(new ProductLineItem(2, "Brownie", 1)); 
      out.write("\n");
      out.write("                ");
 cartArr.add(new ProductLineItem(3, "cake", 1)); 
      out.write("\n");
      out.write("                ");
 cart.setProducts(cartArr); 
      out.write("\n");
      out.write("                ");
 for (ProductLineItem pli : cartArr) {
      out.write("\n");
      out.write("                <p><a href=\"shop4.jsp\">");
      out.print( pli.getProductName());
      out.write("</a> <span class=\"price\">");
      out.print( pli.getQuantity());
      out.write("</span></p>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                <button><a href=\"confirmorder.jsp\" class=\"w3-button\" style=\"background-color:beige\">Proceed to Checkout</a></button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <style>\n");
      out.write("            body {font-family: Arial, Helvetica, sans-serif;}\n");
      out.write("            * {box-sizing: border-box;}\n");
      out.write("\n");
      out.write("            /* Full-width input fields */\n");
      out.write("            input[type=text], input[type=password] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 15px;\n");
      out.write("                margin: 5px 0 15px 0;\n");
      out.write("                display: inline-block;\n");
      out.write("                border: none;\n");
      out.write("                background: #f1f1f1;\n");
      out.write("                font-size: 22px;\n");
      out.write("                font-family: initial;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            form {\n");
      out.write("                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\n");
      out.write("                border: 40px solid white;\n");
      out.write("                width: 40%; /* Could be more or less, depending on screen size */\n");
      out.write("                overflow: auto; /* Enable scroll if needed */\n");
      out.write("                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);\n");
      out.write("                text-align: center;\n");
      out.write("                border-top-width: 20px;\n");
      out.write("                font-size: 22px;\n");
      out.write("                font-family: initial;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Add a background color when the inputs get focus */\n");
      out.write("            input[type=text]:focus, input[type=password]:focus {\n");
      out.write("                background-color: #ddd;\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Set a style for all buttons */\n");
      out.write("            button {\n");
      out.write("                background-color: burlywood;\n");
      out.write("                color: black;\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 100%;\n");
      out.write("                opacity: 0.9;\n");
      out.write("                font-size: 22px;\n");
      out.write("                font-family: initial;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            button:hover {\n");
      out.write("                opacity:1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Extra styles for the cancel button */\n");
      out.write("            .cancelbtn {\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                background-color: #f44336;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Float cancel and signup buttons and add an equal width */\n");
      out.write("            .cancelbtn, .signupbtn {\n");
      out.write("                float: left;\n");
      out.write("                width: 50%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Add padding to container elements */\n");
      out.write("            .container {\n");
      out.write("                padding: 16px;\n");
      out.write("                margin:auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the horizontal ruler */\n");
      out.write("            hr {\n");
      out.write("                border: 1px solid #f1f1f1;\n");
      out.write("                margin-bottom: 25px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* The Close Button (x) */\n");
      out.write("            .close {\n");
      out.write("                position: absolute;\n");
      out.write("                right: 35px;\n");
      out.write("                top: 15px;\n");
      out.write("                font-size: 40px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: #f1f1f1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .close:hover,\n");
      out.write("            .close:focus {\n");
      out.write("                color: #f44336;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Clear floats */\n");
      out.write("            .clearfix::after {\n");
      out.write("                content: \"\";\n");
      out.write("                clear: both;\n");
      out.write("                display: table;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Change styles for cancel button and signup button on extra small screens */\n");
      out.write("            @media screen and (max-width: 300px) {\n");
      out.write("                .cancelbtn, .signupbtn {\n");
      out.write("                    width: 100%;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
