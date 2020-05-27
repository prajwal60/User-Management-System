/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import static com.mycompany.controller.HistoryDAO.conn;
import com.mycompany.model.User;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Your Name <Prajwal Ghimire>
 */
public class SearchDAO {
    
    
    User u = new User();
    
    
    public static ArrayList<User> getUserSearch(String username) throws SQLException {
        
 
 
        String query = "select * from userdb where username=?"; //SQL Query to get all values for matching username

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, username);//Passing username to query

        ResultSet rs = ps.executeQuery();//put the results in the result set

        ArrayList<User> list = new ArrayList<>();//new arraylist which will store all Data of given users

        while (rs.next()) {
            User u = new User(rs.getInt("user_id"),rs.getString("first_name"), rs.getString("last_name"),username,rs.getString("email"),rs.getString("gender"),rs.getString("user_birthdate"),rs.getString("user_is_admin"),rs.getString("user_blocked_status"),rs.getString("user_created_date"));//iterate through every row of result set and add it to arraylist
            list.add(u);
            out.print("allRight");
        }
        return list;
    }
    
}
