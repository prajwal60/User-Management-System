/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguragain3
 */
public class ChangePasswordDAO {
    static Connection conn  = ConnectionClass.getConnection();
    public static boolean password_missmatch_check(String old_password, String username){
        boolean status=true;
        try{
            
        
        String query = "select user_password from userdb where username = ?";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1,username);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String dbpass = rs.getString("user_password");
            
            if(Hashing.getHash(old_password).equals(dbpass)){
                status=false;
            }
            else{
                status=true;
            }
        }
        
        
    }   catch (SQLException ex) {
            Logger.getLogger(ChangePasswordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static void changePassword(String new_password,String username){
        try{
            String query = "update userdb set user_password=? where username=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1,Hashing.getHash(new_password));
            ps.setString(2, username);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
