<!DOCTYPE html>
<html lang="en">
    <title>My Account</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
    <style>
        body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
        body {font-size:16px;}
        .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
        .w3-half img:hover{opacity:1}
    </style>
    <body>

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-white w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
            <div class="w3-container">
                <h3 class="w3-padding-64"><b>MY<br>ACCOUNT</b></h3>
            </div>
            <div class="w3-bar-block">
                <a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">ACCOUNT DETAILS</a> 
                <a href="#showcase" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">VIEW CART</a> 
                <a href="#services" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">ORDER HISTORY</a> 
                <a href="#designers" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">SHOP</a> 
            </div>
        </nav>

        <!-- Top menu on small screens -->
        <header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding">
            <a href="javascript:void(0)" class="w3-button w3-white w3-margin-right" onclick="w3_open()">?</a>
            <span>The Dough Knot</span>
        </header>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:340px;margin-right:40px">

            <!-- Header -->
            <div class="w3-container" style="margin-top:80px" id="showcase">

            </div>

            <!-- Edit Account Details -->
            <editor-fold defaultstate="collapsed" desc="Sign In">
                <div id="editacc" class="modal">
                    <form class="modal-content animate" action="" method="post">
                        <div class="imgcontainer">
                            <h2>Account Details</h2></br>
                        </div>

                        <div class="w3-container">
                            <label for="uname"><b>First Name</b></label></br>
                            <input type="text" placeholder="Enter Username" name="fn" required></br></br>

                            <label for="uname"><b>Last Name</b></label></br>
                            <input type="text" placeholder="Enter Username" name="ln" required></br></br>

                            <label for="psw"><b>Email Address</b></label></br>
                            <input type="text" placeholder="Enter Password" name="ue" required></br></br>

                            <label for="psw"><b>Home Contact Number</b></label></br>
                            <input type="text" placeholder="Enter Password" name="cn" required></br></br>

                            <label for="psw"><b>Mobile Contact Number</b></label></br>
                            <input type="text" placeholder="Enter Password" name="cn" required></br></br>

                            <label for="psw"><b>Delivery Address</b></label></br>
                            <input type="text" placeholder="Enter Password" name="da" required></br></br>

                            <button type="button" type="submit">Submit</button>

                        </div>
                    </form>
                </div>
            </editor-fold>

            <!-- View Cart -->
            <editor-fold defaultstate="collapsed" desc="Sign In">
                <div id="viewcart" class="modal">
                    <form class="modal-content animate" action="" method="post">
                        <div class="imgcontainer">
                            <h2>Account Details</h2></br>
                        </div>

                        <div class="w3-container">/
                            <label for="uname"><b>First Name</b></label></br>


                            <button type="button" type="submit">Submit</button>

                        </div>
                    </form>
                </div>
            </editor-fold>

            <script>
                // Script to open and close sidebar
                function w3_open() {
                    document.getElementById("mySidebar").style.display = "block";
                    document.getElementById("myOverlay").style.display = "block";
                }

                function w3_close() {
                    document.getElementById("mySidebar").style.display = "none";
                    document.getElementById("myOverlay").style.display = "none";
                }

                function () {
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

    </body>
</html>
