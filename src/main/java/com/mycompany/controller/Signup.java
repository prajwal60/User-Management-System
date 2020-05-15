/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.model.User;

/**
 *
 * @author Asus
 */
public class Signup extends HttpServlet {
    
    
    EncryptionDecryption ed = new EncryptionDecryption();
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
           
           if(u.username_exists(request.getParameter("username"))==true || u.password_mismatch()==true){
           out.println("Username exists or password mismatch");
           }
           else if(u.empty_fields_detected()==true){
            out.println("Empty fields detected");
        }
           else{
            u.adduser();
           
            out.println("All right");
           }
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
