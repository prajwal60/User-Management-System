/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pguragain3
 */
public class HistoryDAO {

    static Connection conn = ConnectionClass.getConnection();

    public static void addHistory(History h) throws SQLException {//function for adding entry to history
        int user_id = h.getUser_id();
        String time = h.getTime();
        String action = h.getAction_performed();

        String query = "insert into history (user_id,time,action_performed) values (?,?,?)";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, user_id);
        ps.setString(2, time);
        ps.setString(3, action);

        ps.executeUpdate();

    }
        //return arraylist of data obtained from history table for user
    public static ArrayList<History> getUserHistory(String username) throws SQLException {
        int id = UserDAO.getUserID(username);

        String query = "select * from history where user_id=?"; //get all values for matching userid

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();//put the results in the result set

        ArrayList<History> list = new ArrayList<>();//new arraylist which will store all history

        while (rs.next()) {
            History h = new History(rs.getInt("history_id"), id, rs.getString("time"), rs.getString("action_performed"));//iterate through every row of result set and add it to arraylist
            list.add(h);
        }
        return list;
    }
    
        //return history data for admin in the form of arraylist
    public static ArrayList<History> getAdminHistory() throws SQLException {

        String query = "select * from history";//get all values from userid

        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();//put the results in the result set

        ArrayList<History> list = new ArrayList<>();//new arraylist which will store all history

        while (rs.next()) {
            History h = new History(rs.getInt("history_id"), rs.getInt("user_id"), rs.getString("time"), rs.getString("action_performed"));//iterate through every row of result set and add it to arraylist
            list.add(h);
        }
        return list;
    }

}
