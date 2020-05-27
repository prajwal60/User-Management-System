<%-- 
    Document   : UserHistory
    Created on : May 25, 2020, 8:49:49 AM
    Author     : pguragain3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <%
    if(session.getAttribute("username")==null){
        request.setAttribute("message", "You need to be logged in !!");
        response.sendRedirect("index.jsp");
    }
    %>
    <head>
        <title>Table V01</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
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
    </head>
    <body>
        <div class="navbar">
            <nav class="topnav">
                <li class="navitems"> <a href="#" class="anchor">Hello ${username} !!!! </a> </li>
                <li class="navitems"> <a href="/User-Management-System/ViewUserProfile" class="anchor">Profile</a> </li>
                <li class="navitems"> <a href="/User-Management-System/ShowHistory?uname=${username}" class="anchor"> History</a> </li>
                <li class="navitems"> <a href="/User-Management-System/TermsAndConditions.jsp" class="anchor">Terms and Conditions</a> </li>
                <li class="navitems"> <a href="#" class="anchor">Logout</a> </li>
            </nav>
        </div>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th class="column1">History ID</th>
                                    <th class="column2">Time</th>
                                    <th class="column6">Action Performed</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${userHistory}" var = "history">
                                <tr>
                                    <td class="column1">${history.history_id}</td>
                                    <td class="column2">${history.time}</td>
                                    <td class="column6">${history.action_performed}</td>
                                </tr>
                                </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="src/js/main.js"></script>

    </body>
</html>
