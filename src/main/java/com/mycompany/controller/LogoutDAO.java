/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pguragain3
 */
public class LogoutDAO {
    public static void logout(String username,HttpServletRequest request,HttpServletResponse response){
        try{
        int id = UserDAO.getUserID(username);
        History h = new History(id,LocalDateTime.now().toString(),"Logged Out");
        HistoryDAO.addHistory(h);
        
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
        request.setAttribute("message","You Have Been Logged Out Please Re-Login");
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(LogoutDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
