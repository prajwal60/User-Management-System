<%-- 
    Document   : homepage
    Created on : Apr 28, 2020, 3:36:52 PM
    Author     : Prajwal Ghimire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                        <a href="registration.jsp" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h3 style="color:green">${message}</h3>
                        <h2 class="form-title">Login</h2>
                        <form action="Login" method="POST" class="register-form" id="login-form"  >
                            <div class="form-group">
                                <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" placeholder="Username"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" name="Login" id="signin" class="form-submit" value="Log in"/>
                            </div>
                            <a href="forgetPassword.jsp" class="signup-image-link">Forgot Your Password?</a>
                            <a href="TermsAndConditions.jsp" class="signup-image-link"><h3>Guest?? Read Terms and conditions</h3></a>
                        </form>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    </body>
</html>
