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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();

            String name = request.getParameter("username");
            String pass = request.getParameter("your_pass");
            Controller cll = new Controller();

            if (name.isEmpty() && pass.isEmpty()) {
                out.print("Empty Fields ");
            } else if (name.isEmpty()) {
                out.print("Please enter Username");
            } else if (pass.isEmpty()) {
                out.print("Please enter Password");
            }

            if (cll.validate(name, pass) == true) {

                if (UserDAO.getUser_blocked_status(name) == true) {
                    request.setAttribute("message", "You are BLOCKED to access the system");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
                } else if (UserDAO.getUser_is_admin(name) == true) {
                    session.setAttribute("username", name);
                    int id = UserDAO.getUserID(name);//get user id from the username provided above
                    String action = "Logged in to the system";
                    String time = LocalDateTime.now().toString();

                    History h = new History(id, time, action);//History instance

                    HistoryDAO.addHistory(h);//add to history

                    RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
                    rd.include(request, response);
                }
                else if (UserDAO.getUser_is_admin(name) == false) {
                    session.setAttribute("username", name);
                    int id = UserDAO.getUserID(name);//get user id from the username provided above
                    String action = "Logged in to the system";
                    String time = LocalDateTime.now().toString();

                    History h = new History(id, time, action);//History instance

                    HistoryDAO.addHistory(h);//add to history

                    RequestDispatcher rd = request.getRequestDispatcher("TermsAndConditions.jsp");
                    rd.include(request, response);
                }

            } else {
                request.setAttribute("message", "Username or password error");
                
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }

            out.close();

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
