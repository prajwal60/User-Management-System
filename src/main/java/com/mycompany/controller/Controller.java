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
 * @author Asus
 */
public class Controller {

    public boolean validate(String name, String pass) {
        boolean status = false;
        try {
            Connection con = ConnectionClass.getConnection();

            String query = "select * from userdb where username=? and user_password=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, Hashing.getHash(pass));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

}
