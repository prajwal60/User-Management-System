<%-- 
    Document   : Homepage
    Created on : Apr 27, 2020, 2:04:37 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <h1>User details</h1>
        <% 
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birthdate = request.getParameter("birthdate");
            String password = request.getParameter("password");        
        %>
        <table border="1">
           
            <tbody>
                <tr>
                    <td>First Name : </td>
                    <td> <%= firstName%> </td>
                </tr>
                <tr>
                    <td>Last Name : </td>
                    <td><%= lastName%></td>
                </tr>
                <tr>
                    <td>Username : </td>
                    <td><%= username%></td>
                </tr>
                <tr>
                    <td>Email : </td>
                    <td><%= email%></td>
                </tr>
                <tr>
                    <td>Gender : </td>
                    <td><%= gender%></td>
                </tr>
                <tr>
                    <td>Birthdate : </td>
                    <td><%= birthdate%></td>
                </tr>
                <tr>
                    <td>Password : </td>
                    <td><%= password%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
