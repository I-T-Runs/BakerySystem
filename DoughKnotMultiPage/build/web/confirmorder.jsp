<%-- 
    Document   : confirmorder
    Created on : 17 Mar 2021, 12:12:12 PM
    Author     : David
--%>

<%@page import="com.bakerysystem.Model.Cart"%>
<%@page import="com.bakerysystem.Model.ProductLineItem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Confirm Order Form -->
    <editor-fold defaultstate="collapsed" desc="Cart">
        <div id="conforderf" class="">
            <span onclick="window.open('welcome.jsp').style.display = 'none'" class="close" title="Close Modal">&times;</span>
            <form class="" action="confirmorder" style="width:60%;">
                <div class="w3-container w3-center">
                    <% ArrayList<ProductLineItem> cartArr2 = new ArrayList<>(); %>
                    <% cartArr2.add(new ProductLineItem(1, "cookie", 1)); %>
                    <% cartArr2.add(new ProductLineItem(2, "Brownie", 1)); %>
                    <% cartArr2.add(new ProductLineItem(3, "cake", 1));%>
                    <h4>Order <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b><%=cartArr2.size()%></b></span></h4>
                    <% Cart cart2 = new Cart(); %>

                    <% cart2.setProducts(cartArr2); %>
                    <% for (ProductLineItem pli : cartArr2) {%>
                    <p><a href="#"><%= pli.getProductName()%></a> <span class="price"><%= pli.getQuantity()%></span></p>
                        <%}%>
                    <hr>
                    <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
                </div>
                <input type="submit" onclick="window.open('checkoutpaymentdetails.jsp').style.display = 'block'" value="Confirm Order" class="btn">
            </form>

            <style>
                .container {
                    background-color: #f2f2f2;
                    padding: 5px 20px 15px 20px;
                    border: 30px solid lightgrey;
                    border-radius: 3px;
                    z-index: 4;
                }

                input[type=text] {
                    width: 100%;
                    margin-bottom: 20px;
                    padding: 12px;
                    border: 1px solid #ccc;
                    border-radius: 3px;
                }

                form {
                    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                    border: 100px solid white;
                    width: 20%; /* Could be more or less, depending on screen size */
                    overflow: auto; /* Enable scroll if needed */
                    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                    text-align: center;
                    font-size: 22px;
                    font-family: initial;
                }

                label {
                    margin-bottom: 10px;
                    display: block;
                }

                .icon-container {
                    margin-bottom: 20px;
                    padding: 7px 0;
                    font-size: 24px;
                }

                .btn {
                    background-color: burlywood;
                    color: white;
                    padding: 12px;
                    margin: 10px 0;
                    border: none;
                    width: 100%;
                    border-radius: 3px;
                    cursor: pointer;
                    font-size: 17px;
                    font-size: 22px;
                    font-family: initial;
                }

                a {
                    color: #2196F3;
                }

                hr {
                    border: 1px solid lightgrey;
                }

                /* The Close Button (x) */
                .close {
                    position: absolute;
                    right: 35px;
                    top: 15px;
                    font-size: 40px;
                    font-weight: bold;
                    color: #f1f1f1;
                }

                .close:hover,
                .close:focus {
                    color: #f44336;
                    cursor: pointer;
                }

                span.price {
                    float: right;
                    color: grey;
                }

                /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
                @media (max-width: 800px) {
                    .row {
                        flex-direction: column-reverse;
                    }
                    .col-25 {
                        margin-bottom: 20px;
                    }
                }
            </style>
        </div>

    </editor-fold>
</body>
</html>
