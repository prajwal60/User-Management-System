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
           String input_firstname = request.getParameter("firstname");
           String input_lastname = request.getParameter("lastname");
           String input_username = request.getParameter("username");
           String input_email = request.getParameter("email");
           String input_gender = request.getParameter("gender");
           String input_birthdate = request.getParameter("birthdate");
           String input_pass = request.getParameter("pass");
           String user_is_admin = "false";
           String user_created_date = java.time.LocalDate.now().toString();
           String user_blocked_status = "false";
           
           
           System.out.println("Debugging message 1");
           
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","");
           
           System.out.println("Debugging message2");
           
           String query = "insert into userdb (user_firstname,user_lastname,username,user_email,user_gender,user_birthdate,user_password,user_is_admin,user_created_date,user_blocked_status) "
                   + "values (?,?,?,?,?,?,?,?,?,?)";
           
           System.out.println("Debugging message 3");
           
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setString(1,input_firstname);
           ps.setString(2,input_lastname);
           ps.setString(3,input_username);
           ps.setString(4,input_email);
           ps.setString(5,input_gender);
           ps.setString(6,input_birthdate);
           ps.setString(7,input_pass);
           ps.setString(8,user_is_admin);
           ps.setString(9,user_created_date);
           ps.setString(10,user_blocked_status);
           
           ps.executeUpdate();
           
           out.println("All right");
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
