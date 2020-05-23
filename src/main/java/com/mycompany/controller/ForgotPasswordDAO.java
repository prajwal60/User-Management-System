/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Prajwal Ghimire
 */
public class ForgotPasswordDAO {

    Connection con = ConnectionClass.getConnection();

    public boolean ForgotPasswordDAO(String id, String np, String repeat) {
        boolean status = false;
        try {

            String query = "UPDATE userdb SET user_password=? WHERE user_id =?";
            out.print(query);
            PreparedStatement set = con.prepareStatement(query);
            set.setString(1, Hashing.getHash(repeat));
            set.setString(2, id);
            boolean stat = set.executeUpdate() > 0;
            out.print("Passed");
            if (stat = true) {
                status = true;
            } 

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public String getId(String email) throws SQLException {

        String sql = "SELECT user_id FROM userdb WHERE user_email= ?";

        String id;
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, email);           
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            id = resultSet.getString("user_id");
            resultSet.close();
        }
        return id;
       
    }

}
