<%-- 
    Document   : test
    Created on : 09 Mar 2021, 11:18:30 AM
    Author     : David
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Product product = new Product();
            ArrayList<Product> prodArr = (ArrayList<Product>) request.getAttribute("products");
            
            for (int i = 0; i < prodArr.size(); i++) {
                product = prodArr.get(i);
                out.print(product.getProductName());
            }

        %>

    </body>
</html>
