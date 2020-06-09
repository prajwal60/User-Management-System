<%-- 
    Document   : viewusers
    Created on : Jun 1, 2020, 10:13:11 PM
    Author     : jiten
--%>

<%@page import="com.mycompany.model.History"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.controller.HistoryDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
<!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="align-content-lg-center">======================================================</h1>
<h1 class="align-baseline">Users Report</h1>
<h1 class="align-content-lg-center">======================================================</h1>



<main>
                        <form action="" method="POST">
                            <div class="container-fluid">
                                <h1 class="mt-4">User Created List</h1>

                                
                                <div class="card mb-4">
                                    
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered"  width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>User ID</th>
                                                                                                               
                                                        <th>User Detail and Created Date</th>
                                                        

                                                    </tr>
                                                </thead>
                                                <%
                                                    if (session != null) {
                                                        try {
                                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                                            String username = "root";
                                                            String password = "";
                                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC", username, password);

                                                            String query = "select * from userdb";
                                                            PreparedStatement ps = con.prepareStatement(query);
                                                            ResultSet rs = ps.executeQuery();
                                                            while (rs.next()) {
                                                                out.print("<tbody>");
                                                                out.print("<tr><td>");
                                                                out.println(rs.getInt(1));
                                                                out.print("</td>");                                  
                                                                
                                                                
                                                                out.print("<td>");
                                                                out.print("The user having username :- "+rs.getString(4)+" was  created on date "+rs.getString(10)+" .");
                                                                out.print("</td>");
                                                                
                                                                out.print("</tr>");
                                                                out.print("</tbody>");

                                                            }

                                                        } catch (Exception e) {
                                                            out.println(e);
                                                        }
                                                    }
                                                %>

                                            </table>
                                                
                                                <table class="table table-bordered"  width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>History ID</th>
                                                                                                               
                                                        <th>User Detail and Blocked Date</th>
                                                        

                                                    </tr>
                                                </thead>
                                                <%
                                                    if (session != null) {
                                                        try {
                                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                                            String username = "root";
                                                            String password = "";
                                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC", username, password);

                                                            String query = "select * from history where action_performed!=? and action_performed=?";
                                                            PreparedStatement ps = con.prepareStatement(query);
                                                            ps.setString(1, "Logged in to the system");
                                                            ps.setString(2, "Logged Out");
                                                            
                                                            ResultSet rs = ps.executeQuery();
                                                            while (rs.next()) {
                                                                out.print("<tbody>");
                                                                out.print("<tr><td>");
                                                                out.println(rs.getInt(1));
                                                                out.print("</td>");
                                                                out.print("<td>");                                                                
                                                                out.print("The user having user_id :- "+rs.getString(2)+" was blocked on date "+rs.getString(3)+" .");
                                                                out.print("</td>");
                                                                
                                                                out.print("</tr>");
                                                                out.print("</tbody>");

                                                            }

                                                        } catch (Exception e) {
                                                            out.println(e);
                                                        }
                                                    }
                                                %>

                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </main>


<script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>

            <!-- Page level plugins -->
            <script src="vendor/chart.js/Chart.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="js/demo/chart-area-demo.js"></script>
            <script src="js/demo/chart-pie-demo.js"></script>

            <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
            <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
            <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
            <script src="js/demo/datatables-demo.js"></script>
</body>
  
</html>