/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Your Name <Prajwal Ghimire>
 */
public class Verify extends HttpServlet {
   static final int code = forgetPassword.pass();
    
    
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
        
         try{       
        String ver = request.getParameter("verifyCode");
        Integer verificationCode = Integer.parseInt(ver);
        
        
        if(verificationCode.equals(code)){
        RequestDispatcher RD=request.getRequestDispatcher("forgotPasswordRetrive.jsp");
        out.println("Verification code Matched");
        out.println(code);
        out.println(verificationCode);
        RD.include(request,response);
        }
        else{
        RequestDispatcher RD=request.getRequestDispatcher("verification.jsp");
        out.println(code);
        out.println("Sorry! Verification code Donot Matched");
        RD.include(request,response);
        }}catch(IOException | NumberFormatException | ServletException e){
            out.print(e);
        }
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
