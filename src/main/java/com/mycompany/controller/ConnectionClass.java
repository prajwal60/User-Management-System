/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguragain3
 */
public class ConnectionClass {
    private static final String driver_path = "com.mysql.cj.jdbc.Driver";
    private static final String database_path = "jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC";
    private static final String user_name = "root";
    private static final String password = "";
    
    public static Connection getConnection(){
        try{
            Class.forName(driver_path);
            Connection conn = DriverManager.getConnection(database_path, user_name, password);
            return conn;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
