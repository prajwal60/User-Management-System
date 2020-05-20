/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prajwal Ghimire
 */
public class forgetPassword extends HttpServlet {
    
    int code = 111111;
    String forgemail;

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
        Random random = new Random();
           code = random.nextInt(99999);
           forgemail = request.getParameter("forgetEmail");
        try(PrintWriter out = response.getWriter()){  
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "";
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC",username,password);
            
            String query ="select * from userdb where user_email=?";

            PreparedStatement ps=con.prepareStatement(query);  
            ps.setString(1,forgemail);
             
            ResultSet rs=ps.executeQuery();
            String host = "smtp.gmail.com";
            String user = "programmerme100@gmail.com";
            String pass = "prajwal10";
            String to = forgemail;
            String subject = "Resetting code";
            boolean sessionDebug=false;
            String message = "To complete the resetting Password, enter the verification code in the container. /nVerification code: "
                    + ""+ code +"/n Thanks,/n The User Management Team";
            
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.emable","true");
            pros.put("mail.smtp","host");
            pros.put("mail.smtp.port","587");
            pros.put("mail.smtp.auth","true");
            pros.put("mail.smtp.starttls.required","true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getInstance(pros,null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress [] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            out.print("Code has been sent to email");
            RequestDispatcher rd=request.getRequestDispatcher("verifyCode.jsp");
            out.print("Enter the received code below");
            rd.include(request,response);
        }
        catch(Exception e)
        {System.out.println(e);} 
        
           
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
