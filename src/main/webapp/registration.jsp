<%-- 
    Document   : registration
    Created on : Apr 27, 2020, 1:11:03 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script>
            
        </script>
    </head>
    <body>
          <div class="main">

        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form action="Signup" method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="firstname" id="name" placeholder="First Name"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="lastname" id="name" placeholder="Last Name"/>
                            </div>
                            <div class="form-group">
                                <label for="username"><i class="zmdi zmdi-account zmdi-accounts-add"></i></label>
                                <input type="text" name="username" id="username" placeholder="Username"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email"/>
                            </div>                            
                            <div class="form-group">
                                <label for="gender"><i class="zmdi zmdi-male-female"></i></label>
                                <input type="text" name="gender" id="gender" placeholder="Gender"/>
                            </div>                            
                            <div class="form-group">
                                <label for="date"><i class="zmdi zmdi-calendar"></i></label>
                                <input type="date" name="birthdate" id="date" placeholder="Birthdate mm/dd/yyyy"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass1" id="pass" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="pass2" id="re_pass" placeholder="Repeat your password"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <h3 style="color:red">${message}</h3>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="index.jsp" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Sing in  Form -->
      

    </div>
        
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    </body>
    
</html>
