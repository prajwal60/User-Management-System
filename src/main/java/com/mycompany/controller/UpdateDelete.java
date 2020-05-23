/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author united
 */
public class UpdateDelete {
    private final String driver_path = "com.mysql.cj.jdbc.Driver";
    private final String database_path = "jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC";
    private final String user_name = "root";
    private final String password = "";
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String gender;
    private String user_birthdate;
   
    
    public void updateuser() throws ClassNotFoundException{

		try{
                    Class.forName(driver_path);
                    Connection conn = DriverManager.getConnection(database_path,user_name, password);

	           String sql = "UPDATE userdb SET first_name=?, last_name=?, email=?, gender=?, user_birthdate=?, user_password=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, first_name);
			statement.setString(2, last_name);
			statement.setString(3, username);
			statement.setString(4, email);
                        statement.setString(5, gender);
                        statement.setString(6, user_birthdate);
                      

	        int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
    
    public void deleteUser(){
      try{
        Class.forName(driver_path);  
        Connection conn = DriverManager.getConnection(database_path,user_name, password);
			
      String sql = "DELETE FROM Userdb WHERE username=?";
			
     PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, username);
			

			
			
         int rowsDeleted = statement.executeUpdate();
			
               if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {		
            Logger.getLogger(UpdateDelete.class.getName()).log(Level.SEVERE, null, ex);
        }		
    } 
}
    

