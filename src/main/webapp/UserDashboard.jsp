<%--
    Document   : UserDashboard
    Created on : May 25, 2020, 1:20:03 PM
    Author     : pguragain3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    if(session.getAttribute("username")==null){
        response.sendRedirect("index.jsp");
    }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User History</title>
    </head>
    <body>
        <form class="" action="/User-Management-System/ShowHistory" method="GET">
          <input type="hidden" name="uname" value="${username}"><br>
            <input type="submit" name="" value="History">

        </form>
    </body>
</html>
