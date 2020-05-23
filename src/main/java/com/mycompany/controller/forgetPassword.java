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

    static final int value = Gen.Verify();
    static final int pd = value;

    public static int pass() {
        int passed = pd;
        return passed;
    }
    public static String sender ;
    public forgetPassword() {

        System.out.println("sd =  " + value + " pd " + pd + "");

    }

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String to = request.getParameter("to");
        sender = to;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC", username, password);

            String query = "select * from userdb where user_email=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, to);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String subject = ("Verification Code of User management System");
                String message = ("Your Verification code is :" + value + "/n Please enter this code in verification field to change your Password");
                String user = ("systemverify247@gmail.com");
                String pass = ("prajwal10");

                EmailUtility.send(to, subject, message, user, pass);
                RequestDispatcher RD = request.getRequestDispatcher("verification.jsp");
                System.out.println("Verification code Sent:" + value);
                out.println("Verification code Sent");

                RD.include(request, response);

            } else {
                RequestDispatcher RD = request.getRequestDispatcher("forgetPassword.jsp");
                out.println("Sorry ! You dont have account in this system");
                System.out.println("Verification code Sent:" + value);
                RD.include(request, response);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
