/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
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
public class ChangePassword extends HttpServlet {

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
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
            RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
            
           String old_password=request.getParameter("old_password");
           String new_password=request.getParameter("new_password");
           String confirm_password=request.getParameter("confirm_password");
           String username=(String)session.getAttribute("username");
           
           Boolean wrong_password = ChangePasswordDAO.password_missmatch_check(old_password, username);
           
           if(wrong_password==true){
               request.setAttribute("message", "Your Old Password Doesnt Match with the database");
               rd.forward(request, response);
           }
           else if(!new_password.equals(confirm_password)){
               request.setAttribute("message", "Your New Passwords Mismatch with each other");
               rd.forward(request, response);
           }
           else{
               try{
               ChangePasswordDAO.changePassword(new_password, username);
               request.setAttribute("message","Your Password has changed Please Login Again");
               
//               System.out.println(old_password);
//               System.out.println(new_password);
//               System.out.println(confirm_password);
//               System.out.println(username);
//               System.out.println(Hashing.getHash(new_password));
               
               History h = new History(UserDAO.getUserID(username),LocalDateTime.now().toString(),"Changed Password");
               HistoryDAO.addHistory(h);
               
               LogoutDAO.logout(username, request, response);
               
               } catch (SQLException ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
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
