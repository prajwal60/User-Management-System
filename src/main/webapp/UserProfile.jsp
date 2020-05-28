<%-- 
    Document   : UserProfile
    Created on : May 27, 2020, 9:12:01 AM
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
        <!-- Add icon library -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                max-width: 300px;
                margin: auto;
                text-align: center;
            }

            .title {
                color: grey;
                font-size: 18px;
            }

            button {
                border: none;
                outline: 0;
                display: inline-block;
                padding: 8px;
                color: white;
                background-color: #000;
                text-align: center;
                cursor: pointer;
                width: 100%;
                font-size: 18px;
            }

            a {
                text-decoration: none;
                font-size: 22px;
                color: black;
            }

            button:hover, a:hover {
                opacity: 0.7;
            }
        </style>
    </head>
    <%
    User u = (User)request.getAttribute("userdata");
    %>

    <body>
        <div class="navbar">
            <nav class="topnav">
                <li class="navitems"> <a href="#" class="anchor">Hello ${username} !!!! </a> </li>
                <li class="navitems"> <a href="/User-Management-System/ViewUserProfile" class="anchor">Profile</a> </li>
                <li class="navitems"> <a href="/User-Management-System/ShowHistory?uname=${username}" class="anchor"> History</a> </li>
                <li class="navitems"> <a href="/User-Management-System/TermsAndConditions.jsp" class="anchor">Terms and Conditions</a> </li>
                <li class="navitems"> <a href="/User-Management-system/Logout" class="anchor">Logout</a> </li>
            </nav>
        </div>
        <div class="profile_body">
            <div class="card">
              
                <h1> <%= u.getFirst_name() %> <%= u.getLast_name() %> </h1>
                <p class="title"><%= u.getEmail() %></p>
                <p><%= u.getUsername() %></p>
                <p><%= u.getGender() %></p>
                <p><%= u.getUser_birthdate() %></p>
                
                <p><a href="/User-Management-System/UpdateUser?req=show">Update Profile</a></p>
                
            </div>
        </div>
                                    
    </body>
</html>
