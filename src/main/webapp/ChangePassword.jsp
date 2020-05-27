<%-- 
    Document   : ChangePassword
    Created on : May 27, 2020, 11:21:09 AM
    Author     : pguragain3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    if(session.getAttribute("username")==null){
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
    </style>
    <body>
        <div class="navbar">
            <nav class="topnav">
                <li class="navitems"> <a href="#" class="anchor">Hello ${username} !!!! </a> </li>
                <li class="navitems"> <a href="#" class="anchor">Profile</a> </li>
                <li class="navitems"> <a href="/User-Management-System/ShowHistory?uname=${username}" class="anchor"> History</a> </li>
                <li class="navitems"> <a href="/User-Management-System/TermsAndConditions.jsp" class="anchor">Terms and Conditions</a> </li>
                <li class="navitems"> <a href="#" class="anchor">Logout</a> </li>
            </nav>
        </div>
        <div class="profile_body">

        </div>
    </body>
</html>

