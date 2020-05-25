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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class AddingUser extends HttpServlet {

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
            String uname = request.getParameter("username");
            u.setUsername(request.getParameter("username"));
            String em = request.getParameter("email");
            u.setEmail(request.getParameter("email"));
            u.setGender(request.getParameter("gender"));
            u.setUser_birthdate(request.getParameter("birthdate"));
            u.setUser_is_admin("false");
            u.setUser_created_date(java.time.LocalDate.now().toString());
            u.setUser_blocked_status("false");
            int passwor = Gen.Pass();
            int a = passwor;
            final String passw = String.valueOf(a);
            out.print(passw);
            u.setUser_password1(passw);
            u.setUser_passsword2(passw);
            HttpSession session = request.getSession(true);
            RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
            RequestDispatcher rd1 = request.getRequestDispatcher("homepage.jsp");

            if (UserDAO.username_exists(u) == true) {//check if the username already exists
                session.setAttribute("message", "Username already exists !!!");
                rd.forward(request, response);

            } else if (UserDAO.username_exists(u) == true) {//check if the email already used
                session.setAttribute("message", "Email already used !!!");
                rd.forward(request, response);

            } else if (UserDAO.password_mismatch(u) == true) {//check if passwords mismatch
                session.setAttribute("message", "Passwords don't match !!!!!");
                rd.forward(request, response);
            } else if (UserDAO.empty_fields_detected(u) == true) {//check if there are empty fields
                session.setAttribute("message", "Empty fields detected");
                rd.forward(request, response);
            } else if (UserDAO.password_short_length(u) == true) {//check if the password is of appropriate length
                session.setAttribute("message", "Password must be at least 8 characters");

                rd.forward(request, response);
            } else if (UserDAO.invallid_date(u) == true) {//check if the birth date selected is invalid
                session.setAttribute("message", "Birth date cannot be ahead of current date ");
                rd.forward(request, response);
            } else {
                UserDAO.addUser(u);//Add user
                String subject = ("Your Username and Password");
                String message = ("Your Username is : " + uname + ""
                        + "And Password is : " + passw + " "
                        + " Note: Since we are unknown about your password for security purpose you can change it.");
                String user = ("systemverify247@gmail.com");
                String pass = ("prajwal10");

                EmailUtility.send(em, subject, message, user, pass);

                session.setAttribute("message", "Successfully registered. Now you can sign in");
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
