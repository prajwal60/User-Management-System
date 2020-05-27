/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
import com.mycompany.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pguragain3
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
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            if(request.getParameter("req").equals("show")){
                RequestDispatcher rd1 = request.getRequestDispatcher("UpdateProfile.jsp");
                HttpSession session = request.getSession();
            
            String username = (String)session.getAttribute("username");
            
            User u = UserDAO.getUserProfile(username);

            request.setAttribute("userdata", u);
            rd1.forward(request, response);
            }
            else if(request.getParameter("req").equals("update")){
                User u = new User(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("username"),request.getParameter("email"),request.getParameter("gender"),request.getParameter("birthdate"));
               
                HttpSession session = request.getSession();
                session.removeAttribute("username");
                session.invalidate();
                UserDAO.updateUser(u);//Update user
                int id = UserDAO.getUserID(u.getUsername());
                String action = "Updated Profile Info";
                String time = LocalDateTime.now().toString();
                History h = new History(id, time, action);
                try {
                    HistoryDAO.addHistory(h);
                } catch (SQLException ex) {
                    Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("message", "Successfully Updated");
                rd.forward(request, response);
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

