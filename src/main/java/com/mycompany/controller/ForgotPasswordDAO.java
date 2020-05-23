/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Your Name Prajwal Ghimire
 */
public class ForgotPasswordDAO {
    
    public void ForgotPasswordDAO(String email,String pass){
        boolean status = false;
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "";
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC",username,password);
            String id = "SELECT user_id FROM userdb WHERE user_email = "+email+"";
            Integer _id = Integer.parseInt(id);
            String query ="UPDATE userdb SET password=? WHERE id ="+_id+"";

            PreparedStatement ps=con.prepareStatement(query);  
            ps.setString(1,pass);  
            ResultSet rs=ps.executeQuery();           
            if (rs.next()){
                status = true;
            }
            else
                status = false;
            
        }
        catch(Exception e)
        {System.out.println(e);} 
        
    }
    
    
}
