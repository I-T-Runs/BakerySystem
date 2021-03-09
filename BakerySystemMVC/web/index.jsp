<%-- 
    Document   : GuestShop
    Created on : 03 Mar 2021, 10:08:43 AM
    Author     : David
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
    <editor-fold defaultstate="collapsed" desc="Sign Up">
        <title>Angel Cakes Bakery</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <style>
            body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
            .w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
            .w3-third img:hover{opacity: 1}
            #navpic{
                height: 200px;
                border-radius: 10%;
                margin-left: 16px;
            }
            #angelcakes{
                height: 500px;
                width:  600px;
                border-radius: 100%;
            }
            .card button {
                border: none;
                outline: 0;
                padding: 12px;
                color: white;
                background-color: #000;
                text-align: center;
                cursor: pointer;
                width: 100%;
                font-size: 18px;
            }

            .card button:hover {
                opacity: 0.7;
            }

        </style>
    </editor-fold>
    <% List<Product> productList = (ArrayList<Product>)request.getAttribute("productArr");
    
        %>
</head>

<body class="w3-light-grey w3-content w3-center" id='body' style="width:900%">
<editor-fold defaultstate="collapsed" desc="Body">
    <!-- Top Nav bar -->
    <editor-fold defaultstate="collapsed" desc="buttons">
        <nav class="w3-bar w3-border w3-padding w3-right" >
            <span>
                <button class="w3-bar-item w3-button w3-brown w3-mobile">SPECIALS</button>
            </span>
            <span>
                <input type="text" class="w3-bar-item w3-input w3-white w3-mobile" placeholder="Search..">
                <button class="w3-bar-item w3-button w3-brown w3-mobile">Go</button>
                <button class="w3-bar-item w3-button w3-brown w3-mobile" onclick="document.getElementById('signinf').style.display = 'block'" style="width:auto;">Sign In</button>
                <button class="w3-bar-item w3-button w3-brown w3-mobile" onclick="openCart()">&#9776;</button>
            </span>
        </nav>
    </editor-fold>

    <!-- Side-bar/menu -->
    <editor-fold defaultstate="collapsed" desc="Sign Up">
        <nav class="w3-sidebar w3-bar-block w3-white w3-animate-left w3-text-grey w3-collapse w3-top w3-center" style="z-index:3;width:300px;font-weight:bold" id="mySidebar"><br>
            <div>
                <img src="Images/doughknotlogo.png" id="navpic"/>
            </div>
            <h3 class="w3-padding-16 w3-center"></h3>
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-hide-large">CLOSE</a>
            <a href="#" onclick="w3_close()" class="w3-bar-item w3-button">FAVORITES</a>
            <a href="#categories" onclick="w3_close()" class="w3-bar-item w3-button">CATEGORIES</a>
            <a href="#allproducts" onclick="w3_close()" class="w3-bar-item w3-button">VIEW ALL PRODUCTS</a>
            <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button">ABOUT</a> 
            <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button">CONTACT</a>
            <a href="#signupf" onclick="w3_close()" class="w3-bar-item w3-button">ACCOUNT</a>
            <a href="#" id="openNavc" onclick ="openCart();w3_close();" class="w3-bar-item w3-button">VIEW CART</a>
        </nav>

        <!--        <button onclick="myFunction('Demo1')" class="w3-button w3-block w3-left-align">
                    Open Section 1</button>
    
                <div id="Demo1" class="w3-container w3-hide">
                    <p>Some text..</p>
                </div>-->

        <script>
            //            function myFunction(id) {
            //                var x = document.getElementById(id);
            //                if (x.className.indexOf("w3-show") == -1) {
            //                    x.className += " w3-show";
            //                } else {
            //                    x.className = x.className.replace(" w3-show", "");
            //                }
            //            }

            // Script to open and close sidebar
            function w3_open() {
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("myOverlay").style.display = "block";
            }

            function w3_close() {
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("myOverlay").style.display = "none";
            }

            // Modal Image Gallery
            function onClick(element) {
                document.getElementById("img01").src = element.src;
                document.getElementById("modal01").style.display = "block";
                var captionText = document.getElementById("caption");
                captionText.innerHTML = element.alt;
            }

        </script>
    </editor-fold>
    <!-- Cart/Right Side Menu-->
    <editor-fold defaultstate="collapsed" desc="Cart">
        <div class="w3-sidebar w3-bar-block w3-card w3-animate-right w3-mobile" style="display:none;right:0;" id="mySidebarc">
            <button onclick="closeCart()" class="w3-bar-item w3-button w3-large">Close &times;</button>
            <h3>Your Cart</h3>
            <div class="col-25">
                <div class="container w3-mobile">
                    <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
                    <p><a href="#">Product 1</a> <span class="price">$15</span></p>
                    <p><a href="#">Product 2</a> <span class="price">$5</span></p>
                    <p><a href="#">Product 3</a> <span class="price">$8</span></p>
                    <p><a href="#">Product 4</a> <span class="price">$2</span></p>
                    <hr>
                    <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
                    </br>
                    <button class="w3-button w3-brown w3-mobile" onclick="document.getElementById('checkoutconf').style.display = 'block'" style="width:auto;">Proceed to Checkout</button>
                </div>
            </div>
        </div>

        <script>
            function openCart() {
                document.getElementById("body").style.marginRight = "25%";
                document.getElementById("body").style.marginLeft = "0%";
                document.getElementById("mySidebarc").style.width = "25%";
                document.getElementById("mySidebarc").style.display = "block";
                document.getElementById("openNavc").style.display = "block";
            }
            function closeCart() {
                document.getElementById("body").style.marginRight = "0%";
                document.getElementById("body").style.marginLeft = "0%";
                document.getElementById("mySidebarc").style.display = "none";
                document.getElementById("openNavc").style.display = "inline-block";
            }
        </script>
    </editor-fold>
    <!-- Sign In Form -->
    <editor-fold defaultstate="collapsed" desc="Sign In">
        <div id="signinf" class="modal">

            <form class="modal-content animate" action="/signin" method="post">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('signinf').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    <h2>Sign In!</h2>
                </div>

                <div class="w3-container">
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>


                    <button type="button" type="submit">Login</button>

                    <button type="button" onclick="document.getElementById('signupf').style.display = 'block'">Sign Up</button>

                    <button type="button" onclick="document.getElementById('signinf').style.display = 'none'">Cancel</button>
                    <label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                    </label>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
        </div>

        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            /* Add a background color when the inputs get focus */
            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            /* Set a style for all buttons */
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }

            button:hover {
                opacity:1;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                padding: 14px 20px;
                background-color: #f44336;
            }

            /* Float cancel and signup buttons and add an equal width */
            .cancelbtn, .signupbtn {
                float: left;
                width: 50%;
            }

            /* Add padding to container elements */
            .container {
                padding: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 3; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: #474e5d;
                padding-top: 50px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 40%; /* Could be more or less, depending on screen size */
            }

            /* Style the horizontal ruler */
            hr {
                border: 1px solid #f1f1f1;
                margin-bottom: 25px;
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

            /* Clear floats */
            .clearfix::after {
                content: "";
                clear: both;
                display: table;
            }

            /* Change styles for cancel button and signup button on extra small screens */
            @media screen and (max-width: 300px) {
                .cancelbtn, .signupbtn {
                    width: 100%;
                }
            }
        </style>
        <script>
            // Get the modal
            var modal = document.getElementById('signinf');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
    </editor-fold>
    <!-- Sign Up Form -->
    <editor-fold defaultstate="collapsed" desc="Sign Up">
        <div id="signupf" class="modal">

            <form class="modal-content animate" action="/signup" method="post">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('signupf').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    <h2>Sign Up!</h2>
                </div>

                <div class="w3-container">
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                    <button type="submit">Sign Up</button>

                    <button type="button" onclick="document.getElementById('signupf').style.display = 'none'" class="">Cancel</button>
                    <label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                    </label>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
        </div>

        <script>
            // Get the modal
            var modal = document.getElementById('signupf');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
    </editor-fold>
    <!-- Top menu on small screens -->
    <editor-fold defaultstate="collapsed" desc="Sign Up">
        <header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-16">
            <span class="w3-left w3-padding">The Dough Knot Bakery</span>
            <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="w3_open()">☰</a>
            <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="openCart()">☰</a>
        </header>
    </editor-fold>
    <!-- Overlay effect when opening side-bar on small screens -->
    <editor-fold defaultstate="collapsed" desc="Sign Up">
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
    </editor-fold>
    <!-- !PAGE CONTENT! -->
    <editor-fold defaultstate="collapsed" desc="">
        <div class="w3-main" style="margin-left:300px">
            <!-- Push down content on small screens --> 
            <editor-fold defaultstate="collapsed" desc="Responsive">
                <div class="w3-hide-large" style="margin-top:83px"></div>
            </editor-fold>
            <!-- Photo grid -->
            <editor-fold defaultstate="collapsed" desc="Cards">
                <div class="w3-row">
                    <div class="w3-third card" id='productcard'>
                        <div class="card">
                            <img src="Images/macaroons.jpg" style="width:100%" onclick="onClick(this)" >
                            <h1><% for(Product p : productList){p.getProductname()}%></h1>
                            <p class="price">R49.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="Images/croissant.jpg" style="width:100%" onclick="onClick(this)" >
                            <h1>Croissant</h1>
                            <p class="price">R19.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="Images/lamear.jpg" style="width:100%" onclick="onClick(this)">
                            <h1>Lamb Ears</h1>
                            <p class="price">R16.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                    </div>

                    <div class="w3-third card" id='productcard'>
                        <div class="card">
                            <img src="Images/pretz.jpg" style="width:100%" onclick="onClick(this)">
                            <h1>Pretzal</h1>
                            <p class="price">R24.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="Images/donuts.jpg" style="width:100%" onclick="onClick(this)">
                            <h1>Donut</h1>
                            <p class="price">R18.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="Images/cupcakes.jpg" style="width:100%" onclick="onClick(this)">
                            <h1>Cupcakes</h1>
                            <p class="price">R28.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                    </div>

                    <div class="w3-third card" id='productcard'>
                        <div class="card">
                            <img src="Images/cinna.jpg" style="width:100%" onclick="onClick(this)" >
                            <h1>Cinnabon</h1>
                            <p class="price">R32.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="Images/pretz2.jpg" style="width:100%" onclick="onClick(this)" >
                            <h1>Large Pretzal</h1>
                            <p class="price">R38.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                        <div class="card">
                            <img src="Images/maccies.jpg" style="width:100%" onclick="onClick(this)" >
                            <h1>Large Macaroons</h1>
                            <p class="price">R27.99</p>
                            <p></p>
                            <p><button>Add to Cart</button></p>
                        </div>
                    </div>
                </div>
            </editor-fold>

            <!-- Pagination -->
            <div class="w3-center w3-padding-32">
                <div class="w3-bar">
                    <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
                    <a href="#" class="w3-bar-item w3-black w3-button">1</a>
                    <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
                    <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
                    <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
                    <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
                </div>
            </div>

            <!-- Modal for full size images on click-->
            <div id="modal01" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display = 'none'">
                <span class="w3-button w3-black w3-xlarge w3-display-topright">×</span>
                <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
                    <img id="img01" class="w3-image">
                    <p id="caption"></p>
                </div>
            </div>


            <!-- About section -->
            <div class="w3-container w3-light-blue w3-center w3-text-black w3-padding-32" id="about">
                <h4><b>About Us</b></h4>
                <img src="Images/angelcakes.jpg" alt="Me" class="w3-image w3-padding-32" id="angelcakes" width="600" height="650">
                <div class="w3-content w3-justify" style="max-width:600px">
                    <h4>Hello! I'm Miss Angel Cakes</h4>
                    <p>Some text about me. I love taking photos of PEOPLE. I am lorem ipsum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
                        dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor
                        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    </p>
                    <p>mail: example@example.com</p>
                    <p>tel: 5353 35531</p>
                    <hr class="w3-opacity">

                </div>
            </div>
        </div>

        <!-- Contact section -->
        <div class="w3-container w3-light-grey w3-padding-32 w3-padding-large" id="contact">
            <div class="w3-content" style="max-width:600px">
                <h4 class="w3-center"><b>Contact Me</b></h4>
                <p> Fill out the form and fill me in with the details :) Let me bake for you!</p>
                <form action="/action_page.php" target="_blank">
                    <div class="w3-section">
                        <label>Name</label>
                        <input class="w3-input w3-border" type="text" name="Name" required>
                    </div>
                    <div class="w3-section">
                        <label>Email</label>
                        <input class="w3-input w3-border" type="text" name="Email" required>
                    </div>
                    <div class="w3-section">
                        <label>Message</label>
                        <input class="w3-input w3-border" type="text" name="Message" required>
                    </div>
                    <button type="submit" class="w3-button w3-block w3-black w3-margin-bottom">Send Message</button>
                </form>
            </div>
        </div>
        <!-- Checkout Form -->
        <editor-fold defaultstate="collapsed" desc="Cart">
            <div id="checkoutconf" class="modal">
                <form class="modal-content animate" action="" style="width:60%;">

                    <div class="row">
                        <div class="col-50">
                            <h3>Billing Address</h3>
                            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                            <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
                            <label for="email"><i class="fa fa-envelope"></i> Email</label>
                            <input type="text" id="email" name="email" placeholder="john@example.com">
                            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                            <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                            <label for="city"><i class="fa fa-institution"></i> City</label>
                            <input type="text" id="city" name="city" placeholder="New York">

                            <div class="row">
                                <div class="col-50">
                                    <label for="state">State</label>
                                    <input type="text" id="state" name="state" placeholder="NY">
                                </div>
                                <div class="col-50">
                                    <label for="zip">Zip</label>
                                    <input type="text" id="zip" name="zip" placeholder="10001">
                                </div>
                            </div>
                        </div>

                        <div class="col-50">
                            <h3>Payment</h3>
                            <label for="fname">Accepted Cards</label>
                            <div class="icon-container">
                                <i class="fa fa-cc-visa" style="color:navy;"></i>
                                <i class="fa fa-cc-amex" style="color:blue;"></i>
                                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                <i class="fa fa-cc-discover" style="color:orange;"></i>
                            </div>
                            <label for="cname">Name on Card</label>
                            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                            <label for="ccnum">Credit card number</label>
                            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                            <label for="expmonth">Exp Month</label>
                            <input type="text" id="expmonth" name="expmonth" placeholder="September">
                            <div class="row">
                                <div class="col-50">
                                    <label for="expyear">Exp Year</label>
                                    <input type="text" id="expyear" name="expyear" placeholder="2018">
                                </div>
                                <div class="col-50">
                                    <label for="cvv">CVV</label>
                                    <input type="text" id="cvv" name="cvv" placeholder="352">
                                </div>
                            </div>
                        </div>

                    </div>
                    <label>
                        <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                    </label>
                    <input type="submit" value="Continue to checkout" class="btn">
                </form>
            </div>
            </div>
            <div class="col-25">
                <div class="container">
                    <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
                    <p><a href="#">Product 1</a> <span class="price">$15</span></p>
                    <p><a href="#">Product 2</a> <span class="price">$5</span></p>
                    <p><a href="#">Product 3</a> <span class="price">$8</span></p>
                    <p><a href="#">Product 4</a> <span class="price">$2</span></p>
                    <hr>
                    <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
                </div>
            </div>
            </div>
            <style>
                * {
                    box-sizing: border-box;
                }

                .row {
                    display: -ms-flexbox; /* IE10 */
                    display: flex;
                    -ms-flex-wrap: wrap; /* IE10 */
                    flex-wrap: wrap;
                    margin: 0 +16px;
                }

                .col-25 {
                    -ms-flex: 25%; /* IE10 */
                    flex: 25%;
                }

                .col-50 {
                    -ms-flex: 50%; /* IE10 */
                    flex: 50%;
                }

                .col-75 {
                    -ms-flex: 75%; /* IE10 */
                    flex: 75%;
                }

                .col-25,
                .col-50,
                .col-75 {
                    padding: 0 16px;
                }

                .container {
                    background-color: #f2f2f2;
                    padding: 5px 20px 15px 20px;
                    border: 1px solid lightgrey;
                    border-radius: 3px;
                }

                input[type=text] {
                    width: 100%;
                    margin-bottom: 20px;
                    padding: 12px;
                    border: 1px solid #ccc;
                    border-radius: 3px;
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
                    background-color: #4CAF50;
                    color: white;
                    padding: 12px;
                    margin: 10px 0;
                    border: none;
                    width: 100%;
                    border-radius: 3px;
                    cursor: pointer;
                    font-size: 17px;
                }

                .btn:hover {
                    background-color: #45a049;
                }

                a {
                    color: #2196F3;
                }

                hr {
                    border: 1px solid lightgrey;
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
        </editor-fold>

        <!-- Footer -->
        <footer class="w3-container w3-padding-32 w3-grey">  
            <div class="w3-row-padding">
                <div class="w3-third">
                </div>

                <div class="w3-third">

                </div>


            </div>
        </footer>

    </editor-fold>
    <!-- End page content -->
</editor-fold>
</body>
</html>
