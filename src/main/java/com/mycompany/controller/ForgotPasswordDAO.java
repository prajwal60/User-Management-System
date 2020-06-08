/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

/**
 *
 * @author Your Name Prajwal Ghimire
 */
public class ForgotPasswordDAO {
    
    public void ForgotPasswordDAO(String email,String pass){
        boolean status = false;
        try{ 
            int idd;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "";
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC",username,password);
            String id = "SELECT user_id FROM userdb WHERE user_email =?";
            PreparedStatement ps1=con.prepareStatement(id);
            ps1.setString(1, email);
            ResultSet rs= ps1.executeQuery();  
            while (rs.next()){
            idd=rs.getInt("user_id");            
            String query ="UPDATE userdb SET user_password=? WHERE user_id =?";
            PreparedStatement ps=con.prepareStatement(query);  
            ps.setString(1,Hashing.getHash(pass)); 
            ps.setInt(2,idd);
            ps.executeUpdate(); 
            History h=new History(idd,  LocalDateTime.now().toString(), "Password Changed");
            HistoryDAO.addHistory(h);
            }    
            
        }
        catch(Exception e)
        {System.out.println(e);} 
        
    }
    
    
}
