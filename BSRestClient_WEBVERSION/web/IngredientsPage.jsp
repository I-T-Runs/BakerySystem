<%-- 
    Document   : IngredientsPage
    Created on : 17 Mar 2021, 4:32:12 AM
    Author     : Themba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ingredients</title>
    </head>
    <body>
        <h1>Ingredients</h1>
        <table>
            <thead>
                <tr>
                    <th>INGR CODE</th>
                    <th>INGREDIENT NAME</th>
                    <th>QUANTITY</th>
                    <th>ACTIVITY</th>
                </tr>
            </thead>
            <tbody>
               <% for(int i = 0 ; i < listIngr.size(); i++){>&
            </tbody>
        </table>
    </body>    
</html>
