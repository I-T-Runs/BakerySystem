<%-- 
    Document   : GuestShop
    Created on : 03 Mar 2021, 10:08:43 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
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
    </head>
    <body class="w3-light-grey w3-content w3-center" id='body' style="max-width:1600px">

        <!-- Sidebar/menu -->
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
            <a href="Guest/SignIn.jsp" onclick="w3_close()" class="w3-bar-item w3-button">ACCOUNT</a>
            <a href="#viewcart" onclick="w3_close()" class="w3-bar-item w3-button">VIEW CART</a>
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
        <!-- Cart/Right Side Menu-->

        <button id="openNavc" class="w3-button w3-teal w3-xlarge w3-display-topright" onclick="openCart();">&#9776;</button>

        <div class="w3-sidebar w3-bar-block w3-card w3-animate-right" style="display:none;right:0;" id="mySidebarc">
            <button onclick="closeCart()" class="w3-bar-item w3-button w3-large">Close &times;</button>
            <h3>Your Cart</h3>

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

        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-16">
            <span class="w3-left w3-padding">The Dough Knot</span>
            <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="w3_open()">☰</a>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px">

            <!-- Push down content on small screens --> 
            <div class="w3-hide-large" style="margin-top:83px"></div>

            <!-- Photo grid -->
            <div class="w3-row">
                <div class="w3-third card" id='productcard'>
                    <div class="card">
                        <img src="Images/macaroons.jpg" style="width:100%" onclick="onClick(this)" >
                        <h1>Macaroons</h1>
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

        <!-- Footer -->
        <footer class="w3-container w3-padding-32 w3-grey">  
            <div class="w3-row-padding">
                <div class="w3-third">
                </div>

                <div class="w3-third">

                </div>


            </div>
        </footer>


        <!-- End page content -->


    </body>
</html>