/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguragain3
 */
public class UserDAO {

    //Get connection from ConnectionClass
    static Connection conn = ConnectionClass.getConnection();

    public static boolean email_exists(User u) {//check if the email is already in use
        Boolean result = false;
        try {
            PreparedStatement st = conn.prepareStatement("select * from userdb where email = ?");//Query to fetch data from database
            st.setString(1, u.getEmail());
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {//if results exist then
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Check if username exists or not. returns true if user exists else false
    public static boolean username_exists(User u) {
        Boolean result = false;
        try {
            PreparedStatement st = conn.prepareStatement("select * from userdb where username = ?");//Query to fetch data from database
            st.setString(1, u.getUsername());
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {//if results exist then
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean empty_fields_detected(User u) {//check for empty fields
        if (u.getFirst_name().isEmpty() || u.getLast_name().isEmpty() || u.getUsername().isEmpty() || u.getEmail().isEmpty()
                || u.getGender().isEmpty() || u.getUser_birthdate().isEmpty() || u.getUser_password1().isEmpty() || u.getUser_password2().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean password_short_length(User u) {//Checks if the password length is enough
        if (u.getUser_password1().length() < 8) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean password_mismatch(User u) {//checks if the passwords mismatch or not. returns true if passwords missmatch else false
        if (u.getUser_password1().equals(u.getUser_password2())) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean invallid_date(User u) { //check if the birthdate is set ahead to current date
        Boolean status = true;
        String ubirthDate = u.getUser_birthdate();
        String ucreatedDate = u.getUser_created_date();
        Date date1;
        Date date2;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ubirthDate);//generate a simple date format on yyyy-mm-date format
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ucreatedDate);
            if (date1.after(date2)) {// checks if birthdate is after user created date
                status = true;
            } else {
                status = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;

    }

    public static void addUser(User u) {//adds the user to database
        try {
            String query = "insert into userdb (user_firstname,user_lastname,username,user_email,user_gender,user_birthdate,user_password,user_is_admin,user_created_date,user_blocked_status) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";//Sql query for adding user

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, u.getFirst_name());
            ps.setString(2, u.getLast_name());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getGender());
            ps.setString(6, u.getUser_birthdate());
            ps.setString(7, Hashing.getHash(u.getUser_password1()));
            ps.setString(8, u.getUser_is_admin());
            ps.setString(10, u.getUser_blocked_status());
            ps.setString(9, u.getUser_created_date());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getUserID(String username) {
        try {
            String query = "select user_id from userdb where username=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet r1 = ps.executeQuery();
            if (r1.next()) {
                int id = r1.getInt(1);
                return id;
            }
            int id = r1.getInt(1);
            return id;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public static int getUsernameByID(String username) {
        try {
            String query = "select user_id from userdb where username=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet r1 = ps.executeQuery();
            if (r1.next()) {
                int id = r1.getInt(1);
                return id;
            }
            int id = r1.getInt(1);
            return id;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static boolean getUser_is_admin(String username) {
        boolean result = false;
        try {
            String query = "select user_is_admin from userdb where username=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);

            ResultSet r1 = ps.executeQuery();
            if (r1.next()) {
                String res = r1.getString(1);
                if (res.equals("true")) {
                    result = true;
                } else {
                    result = false;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

    public static boolean getUser_blocked_status(String username) {
        boolean result = false;
        try {
            String query = "select user_blocked_status from userdb where username=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);

            ResultSet r1 = ps.executeQuery();
            if (r1.next()) {
                String res = r1.getString(1);
                if (res.equals("true")) {
                    result = true;
                } else {
                    result = false;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

    public static User getUserProfile(String username) {
            User u;
        try {
            String query = "select user_firstname,user_lastname,username,user_email,user_gender,user_birthdate from userdb where username=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,username);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u = new User(rs.getString("user_firstname"),rs.getString("user_lastname"),rs.getString("username"),rs.getString("user_email"),rs.getString("user_gender"),rs.getString("user_birthdate"));
            return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public static void updateUser(User u){
        try {
            String query = "update userdb set user_firstname=?,user_lastname=?,username=?,user_email=?,user_gender=?,user_birthdate=? where username=?";//Sql query for updatng user in database

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, u.getFirst_name());
            ps.setString(2, u.getLast_name());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getGender());
            ps.setString(6, u.getUser_birthdate());
            ps.setString(7, u.getUsername());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
