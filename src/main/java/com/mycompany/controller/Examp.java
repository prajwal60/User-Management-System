/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Your Name <Prajwal Ghimire>
 */
public class Examp extends HttpServlet {

    public static String receiver;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        try (PrintWriter out = response.getWriter()) {
            out.print(forgetPassword.sender);
            String em = (forgetPassword.sender);
            
            String newPass = request.getParameter("newPassword");
            String repeatPass = request.getParameter("confirmPassword");
            
            if(newPass.isEmpty()||repeatPass.isEmpty()){
                request.setAttribute("message", "All Fields are empty");
            }
            else if(!newPass.equals(repeatPass)){
                request.setAttribute("message", "Password do not match");
            }
            else{ 
                
                ForgotPasswordDAO fp = new ForgotPasswordDAO();
                String id = fp.getId(em);
                
            boolean result = fp.ForgotPasswordDAO(id, newPass, repeatPass);
            if(result = true){
                out.print(result);
            RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
            request.setAttribute("message","Please Login to continue");
            out.print("pw changed");
            rd.include(request, response);
            }
            }
        }catch(Exception e){
            out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
