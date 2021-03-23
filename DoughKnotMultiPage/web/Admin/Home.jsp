<%-- 
    Document   : Home
    Created on : 22 Mar 2021, 2:42:01 PM
    Author     : Themba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bakerysystem.Model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <style>
            .container {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 1px solid #e3e3e3;
                border-radius: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <center>
                <table>
                    <thead>
                        <tr>
                            <!-- productid | productname | photo | productdescription    | productwarnings    | price | discount | activity | categoryid -->
                            <th>PRODID</th>
                            <th>NAME</th>
                            <th>PHOTO</th>
                            <th>DESCRIPTION</th>
                            <th>WARNINGS</th>
                            <th>PRICE</th>
                            <th>DISCOUNT</th>
                            <th>ACTIVE</th>
                            <th>CATEGORY</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% ArrayList<Product> prods = (ArrayList<Product>) getServletContext().getAttribute("ProductArr"); %>
                        <% for(Product prod : prods){ %>
                            <td>prod.get</td>
                            <td>prod.get</td>
                            <td>prod.get</td>
                            
                        <%}%>
                    </tbody>
                </table>
            </center>
        </div>
    </body>
</html>
