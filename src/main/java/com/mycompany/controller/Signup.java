/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.model.User;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
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
            User u = new User();
            /* Get the values from form and set to setters on user class */
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
            RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
            RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
            

            if (UserDAO.email_exists(u) == true) {//check if the username already exists
                request.setAttribute("message", "Username already exists !!!");
                rd.forward(request, response);

            } else if (UserDAO.username_exists(u) == true) {//check if the email already used
                request.setAttribute("message", "Email already used !!!");
                rd.forward(request, response);

            } else if (UserDAO.password_mismatch(u) == true) {//check if passwords mismatch
                request.setAttribute("message", "Passwords don't match !!!!!");
                rd.forward(request, response);
            } else if (UserDAO.empty_fields_detected(u) == true) {//check if there are empty fields
                request.setAttribute("message", "Empty fields detected");
                rd.forward(request, response);
            } else if (UserDAO.password_short_length(u) == true) {//check if the password is of appropriate length
                request.setAttribute("message", "Password must be at least 8 characters");

                rd.forward(request, response);
            } else if (UserDAO.invallid_date(u) == true) {//check if the birth date selected is invalid
                request.setAttribute("message", "Birth date cannot be ahead of current date ");
                rd.forward(request, response);
            } else {
                UserDAO.addUser(u);//Add user
                int id = UserDAO.getUserID(request.getParameter("username"));
                String action = "Signed in as new user";
                String time = LocalDateTime.now().toString();
                History h = new History(id, time, action);
                try {
                    HistoryDAO.addHistory(h);
                } catch (SQLException ex) {
                    Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("message", "Successfully registered. Now you can sign in");
                rd1.forward(request, response);
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
