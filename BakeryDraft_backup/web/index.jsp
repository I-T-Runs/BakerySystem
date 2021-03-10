<%-- 
    Document   : test
    Created on : 09 Mar 2021, 11:18:30 AM
    Author     : David
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Sign Up Form -->
    <editor-fold defaultstate="collapsed" desc="Sign Up">
        <div id="signupf" class="modal">

            <form class="modal-content animate" action="/indexCS.jsp" method="post">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('signupf').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    <h2>Sign Up!</h2>
                </div>

                <div class="w3-container">
                    <label for="uname"><b>First Name</b></label>
                    <input type="text" placeholder="Enter Username" name="fn" required>

                    <label for="uname"><b>Last Name</b></label>
                    <input type="text" placeholder="Enter Username" name="ln" required>

                    <label for="psw"><b>Email Address</b></label>
                    <input type="text" placeholder="Enter Password" name="ue" required>

                    <label for="psw"><b>Contact Number</b></label>
                    <input type="text" placeholder="Enter Password" name="cn" required>

                    <label for="psw"><b>Delivery Address</b></label>
                    <input type="text" placeholder="Enter Password" name="da" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="pass" required>

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


</body>
</html>
