/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Your Name <Prajwal Ghimire>
 *
 */
public class UpdateUser extends HttpServlet {

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

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

            if (request.getParameter("req").equals("show")) {
                HttpSession s = request.getSession();
                if (s.getAttribute("username") == null) {
                    request.setAttribute("message", "You need to login first");//prevent back button
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd1 = request.getRequestDispatcher("UpdateUserProfile.jsp");
                    HttpSession session = request.getSession();

                    String username = (String) session.getAttribute("username");

                    User u = UserDAO.getUserProfile(username);//calls get user profile function

                    request.setAttribute("userdata", u);
                    rd1.forward(request, response);
                }

            } else if (request.getParameter("req").equals("update")) {
                User u = new User(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("username"), request.getParameter("email"), request.getParameter("gender"), request.getParameter("birthdate"));

                UserDAO.updateUser(u);//Update user

                LogoutDAO.logout(request.getParameter("username"), request, response);
            }
        }

    }

    /* TODO output your page here. You may use following sample code. */
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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        } catch (Exception e) {
            out.print(e);
        }

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
