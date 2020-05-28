/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

/**
 *
 * @author pguragain3
 */
public class User {

    public User(int user_id, String first_name, String last_name, String username, String email, String gender, String user_birthdate, String user_is_admin, String user_blocked_status, String user_created_date) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.user_birthdate = user_birthdate;
        this.user_is_admin = user_is_admin;
        this.user_blocked_status = user_blocked_status;
        this.user_created_date = user_created_date;
    }

    
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

    public User(String first_name, String last_name, String username, String email, String gender, String user_birthdate) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.user_birthdate = user_birthdate;
    }

    public User() {
    }
    
    
    
    /**
     * @return the user_id
     */

    

    public User(int user_id,String first_name, String last_name, String username, String email, String gender, String user_birthdate) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.user_birthdate = user_birthdate;
    }

  
    
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
}
