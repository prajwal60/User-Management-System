/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Asus
 */
public class login extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
          		
		String name=request.getParameter("username");
		String pass=request.getParameter("your_pass");
                Controller cll = new Controller();
                
                if (name.isEmpty() && pass.isEmpty()){
                    out.print("Empty Fields ");
                }
                else if(name.isEmpty()){
                    out.print("Please enter Username");
                }
                else if(pass.isEmpty()){
                    out.print("Please enter Password");
                }
		               
                if(cll.validate(name, pass)==true){
                    RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.include(request,response);
                }
                
                
		else{
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                        out.print("Sorry username or password error");
			rd.include(request,response);
		}
		
		out.close();
        
        }
        


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
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    

}
