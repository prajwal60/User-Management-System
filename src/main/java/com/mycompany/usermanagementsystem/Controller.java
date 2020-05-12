/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Asus
 */
public class Controller {
    public static boolean validate(String name,String password){  
    boolean status=false;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC");
            String user = "root";
            String psw = "root";
            String query ="select * from userdb where username=? and user_password=?";

            PreparedStatement ps=con.prepareStatement(query);  
            ps.setString(1,name);  
            ps.setString(2,password); 
            ResultSet rs=ps.executeQuery(); 
            String un = rs.getString("username");
            String pw = rs.getString("user_password");
            if (name.equals(un) && pw.equals(password)){
                status=rs.next();
            }
            System.out.println("Invalid username and Password");
                       
        }
        catch(Exception e)
        {System.out.println(e);} 

    return status;  
    }
    
}
