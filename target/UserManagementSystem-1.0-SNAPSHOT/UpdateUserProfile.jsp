<%-- 
    Document   : UpdateProfile
    Created on : May 27, 2020, 11:20:46 AM
    Author     : pguragain3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page import="com.mycompany.model.User"%>
    <%
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        if (session.getAttribute("username") == null) {
            request.setAttribute("message", "You need to be logged in !!");
            response.sendRedirect("index.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <style>
        body{
            background-color: #f5f5f5;
        }
        nav{
            display: flex;
            flex-direction: row;

        }

        /* Add a black background color to the top navigation */
        .topnav {
            background-color: #333;
            overflow: hidden;
        }

        /* Style the links inside the navigation bar */
        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        /* Change the color of links on hover */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Add a color to the active/current link */
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-font-smoothing: antialiased;
            -moz-font-smoothing: antialiased;
            -o-font-smoothing: antialiased;
            font-smoothing: antialiased;
            text-rendering: optimizeLegibility;
        }

        body {
            font-family: "Roboto", Helvetica, Arial, sans-serif;
            font-weight: 100;
            font-size: 12px;
            line-height: 30px;
            color: #777;
            background: #9cd1bc;
        }

        .container {
            max-width: 400px;
            width: 100%;
            margin: 0 auto;
            position: relative;
        }

        #contact input[type="text"],
        #contact input[type="email"],
        #contact input[type="tel"],
        #contact input[type="url"],
        #contact textarea,
        #contact button[type="submit"] {
            font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
        }

        #contact {
            background: #F9F9F9;
            padding: 25px;
            margin: 150px 0;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }

        #contact h3 {
            display: block;
            font-size: 30px;
            font-weight: 300;
            margin-bottom: 10px;
        }

        #contact h4 {
            margin: 5px 0 15px;
            display: block;
            font-size: 13px;
            font-weight: 400;
        }

        fieldset {
            border: medium none !important;
            margin: 0 0 10px;
            min-width: 100%;
            padding: 0;
            width: 100%;
        }

        #contact input[type="text"],
        #contact input[type="email"],
        #contact input[type="tel"],
        #contact input[type="url"],
        #contact textarea {
            width: 100%;
            border: 1px solid #ccc;
            background: #FFF;
            margin: 0 0 5px;
            padding: 10px;
        }

        #contact input[type="text"]:hover,
        #contact input[type="email"]:hover,
        #contact input[type="tel"]:hover,
        #contact input[type="url"]:hover,
        #contact textarea:hover {
            -webkit-transition: border-color 0.3s ease-in-out;
            -moz-transition: border-color 0.3s ease-in-out;
            transition: border-color 0.3s ease-in-out;
            border: 1px solid #aaa;
        }

        #contact textarea {
            height: 100px;
            max-width: 100%;
            resize: none;
        }

        #contact button[type="submit"] {
            cursor: pointer;
            width: 100%;
            border: none;
            background: #4CAF50;
            color: #FFF;
            margin: 0 0 5px;
            padding: 10px;
            font-size: 15px;
        }

        #contact button[type="submit"]:hover {
            background: #43A047;
            -webkit-transition: background 0.3s ease-in-out;
            -moz-transition: background 0.3s ease-in-out;
            transition: background-color 0.3s ease-in-out;
        }

        #contact button[type="submit"]:active {
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
        }

        .copyright {
            text-align: center;
        }

        #contact input:focus,
        #contact textarea:focus {
            outline: 0;
            border: 1px solid #aaa;
        }

        ::-webkit-input-placeholder {
            color: #888;
        }

        :-moz-placeholder {
            color: #888;
        }

        ::-moz-placeholder {
            color: #888;
        }

        :-ms-input-placeholder {
            color: #888;
        }
    </style>
    <%
            User u = (User) request.getAttribute("userdata");
        
    %>
    <body>
        <div class="navbar">
            <nav class="topnav">
                <li class="navitems"> <a href="UserDashboard.jsp" class="anchor">Hello ${username} !!!! </a> </li>
                <li class="navitems"> <a href="/User-Management-System/ViewUserProfile" class="anchor">Profile</a> </li>
                <li class="navitems"> <a href="/User-Management-System/ShowHistory?uname=${username}" class="anchor"> History</a> </li>
                <li class="navitems"> <a href="/User-Management-System/TermsAndConditions.jsp" class="anchor">Terms and Conditions</a> </li>
                <li class="navitems"> <a href="/User-Management-System/Logout" class="anchor">Logout</a> </li>
            </nav>
        </div>
        <div class="update_body">
            <div class="container">  
                <form id="contact" action="/User-Management-System/UpdateUser" method="get">
                    <h3>User Update Form</h3>
                    <h4>${message}</h4>
                    <fieldset>
                        <input placeholder="First Name" name="firstname" type="text" tabindex="1" value="<%= u.getFirst_name() %>" required autofocus>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Last Name" name="lastname" type="text" tabindex="1"  value="<%= u.getLast_name() %>" required autofocus>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Username" name="username" type="text" tabindex="1"  value="<%= u.getUsername() %>" required>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Email" name="email" type="email" tabindex="1"  value="<%= u.getEmail() %>" required>
                    </fieldset>
                    <fieldset>
                        <span>Gender  </span>
                        <select  id="gender" name="gender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </fieldset>
                    <fieldset>
                        <span>Birth date  </span>
                        <input placeholder="Birthdate" name="birthdate" type="date" required>
                        <input type="hidden" name="req" value="update">
                    </fieldset>

                    <fieldset>
                        <button type="submit" id="contact-submit">Submit</button>
                    </fieldset>
                    <p>Change Your Password <a href="/User-Management-System/ChangePassword.jsp"><h4>Here</h4></a></p>
                    <p><a href="/User-Management-System/DeleteUserAccount"><h3>Delete Account</h3></a></p>
               
                </form>
            </div>

        </div>
    </body>
</html>