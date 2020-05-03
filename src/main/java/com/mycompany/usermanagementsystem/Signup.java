/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pguragain3
 */
public class Signup extends HttpServlet {
    User u = new User();
    String driver_path = "com.mysql.cj.jdbc.Driver";
    String database_path = "jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC";
    String username = "root";
    String password = "";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           u.setFirst_name(request.getParameter("firstname"));
           u.setLast_name(request.getParameter("lastname"));
           u.setUsername(request.getParameter("username"));
           u.setEmail(request.getParameter("email"));
           u.setGender(request.getParameter("gender"));
           u.setUser_birthdate(request.getParameter("birthdate"));
           u.setUser_is_admin("false");
           u.setUser_created_date(java.time.LocalDate.now().toString());
           u.setUser_blocked_status("false");
           u.setUser_password1(request.getParameter("pass1"));
           u.setUser_passsword2(request.getParameter("pass2"));

           
           
           System.out.println("Debugging message 1");
           
           
           Class.forName(driver_path);
           Connection con = DriverManager.getConnection(database_path,username,password);
           
           System.out.println("Debugging message2");
           
           String query = "insert into userdb (user_firstname,user_lastname,username,user_email,user_gender,user_birthdate,user_password,user_is_admin,user_created_date,user_blocked_status) "
                   + "values (?,?,?,?,?,?,?,?,?,?)";
           
           System.out.println("Debugging message 3");
           
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setString(1,u.getFirst_name());
           ps.setString(2,u.getLast_name());
           ps.setString(3,u.getUsername());
           ps.setString(4,u.getEmail());
           ps.setString(5,u.getGender());
           ps.setString(6,u.getUser_birthdate());
           ps.setString(7,u.getUser_password1());
           ps.setString(8,u.getUser_is_admin());
           ps.setString(9,u.getUser_created_date());
           ps.setString(10,u.getUser_blocked_status());
           
           
           if(u.username_exists(request.getParameter("username"))==true || u.password_mismatch()==true){
           out.println("Username exists or password mismatch");
           }
           else if(u.empty_fields_detected()==true){
            out.println("Empty fields detected");
        }
           else{
           ps.executeUpdate();
           
           out.println("All right");
           }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
