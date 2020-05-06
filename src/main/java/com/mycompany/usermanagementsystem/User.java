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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguragain3
 */
public class User {
    private final String driver_path = "com.mysql.cj.jdbc.Driver";
    private final String database_path = "jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC";
    private final String user_name = "root";
    private final String password = "";
    private int user_id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String gender;
    private String user_birthdate;
    private String user_password1;
    private String user_password2;
    private String user_is_admin;
    private String user_blocked_status;
    private String user_created_date;  
    EncryptionDecryption ed = new EncryptionDecryption();
    
    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the user_birthdate
     */
    public String getUser_birthdate() {
        return user_birthdate;
    }

    /**
     * @param user_birthdate the user_birthdate to set
     */
    public void setUser_birthdate(String user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    /**
     * @return the user_password1
     */
    public String getUser_password1() {
        return user_password1;
    }

    /**
     * @param user_password1 the user_password1 to set
     */
    public void setUser_password1(String user_password1) {
        this.user_password1 = user_password1;
    }

    /**
     * @return the user_passsword2
     */
    public String getUser_password2() {
        return user_password2;
    }

    /**
     * @param user_password2
     */
    public void setUser_passsword2(String user_password2) {
        this.user_password2 = user_password2;
    }

    /**
     * @return the user_is_admin
     */
    public String getUser_is_admin() {
        return user_is_admin;
    }

    /**
     * @param user_is_admin the user_is_admin to set
     */
    public void setUser_is_admin(String user_is_admin) {
        this.user_is_admin = user_is_admin;
    }

    /**
     * @return the user_blocked_status
     */
    public String getUser_blocked_status() {
        return user_blocked_status;
    }

    /**
     * @param user_blocked_status the user_blocked_status to set
     */
    public void setUser_blocked_status(String user_blocked_status) {
        this.user_blocked_status = user_blocked_status;
    }

    /**
     * @return the user_created_date
     */
    public String getUser_created_date() {
        return user_created_date;
    }

    /**
     * @param user_created_date the user_created_date to set
     */
    public void setUser_created_date(String user_created_date) {
        this.user_created_date = user_created_date;
    }
    
    
    public boolean username_exists(String username){
        Boolean result = false;
        try {
            Class.forName(driver_path);
            Connection conn = DriverManager.getConnection(database_path, user_name, password);
            PreparedStatement st = conn.prepareStatement("select * from userdb where username = ?");
        st.setString(1, username);
        ResultSet r1=st.executeQuery();
            if(r1.next()) {
            result = true;
            }
        }
            catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
}
    public boolean empty_fields_detected(){
        if(first_name.isEmpty() ||last_name.isEmpty() ||username.isEmpty() ||email.isEmpty() 
                ||gender.isEmpty() ||user_birthdate.isEmpty() ||user_password1.isEmpty() ||user_password2.isEmpty()){
            return true;
        }
        else return false;
    }
    
    public boolean password_mismatch(){
    if(user_password1.equals(user_password2)){
        return false;
    }
    else return true;
    }
    
    public void adduser(){
        try {
            Class.forName(driver_path);
            Connection con = DriverManager.getConnection(database_path,user_name,password);
            
            String query = "insert into userdb (user_firstname,user_lastname,username,user_email,user_gender,user_birthdate,user_password,user_is_admin,user_created_date,user_blocked_status) "
                   + "values (?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,first_name);
            ps.setString(2,last_name);
            ps.setString(3,username);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setString(6,user_birthdate);
            ps.setString(7,(user_password1));
            ps.setString(8,user_is_admin);
            ps.setString(9,user_created_date);
            ps.setString(10,user_blocked_status);
           
            ps.executeUpdate();
          
           
           
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
