/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

/**
 *
 * @author Your Name <Prajwal Ghimire>
 */
public class Search {
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

    public Search() {
    }

    public Search(int user_id, String first_name, String last_name, String username, String email, String gender, String user_birthdate, String user_is_admin, String user_blocked_status, String user_created_date) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser_birthdate() {
        return user_birthdate;
    }

    public void setUser_birthdate(String user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public String getUser_password1() {
        return user_password1;
    }

    public void setUser_password1(String user_password1) {
        this.user_password1 = user_password1;
    }

    public String getUser_password2() {
        return user_password2;
    }

    public void setUser_password2(String user_password2) {
        this.user_password2 = user_password2;
    }

    public String getUser_is_admin() {
        return user_is_admin;
    }

    public void setUser_is_admin(String user_is_admin) {
        this.user_is_admin = user_is_admin;
    }

    public String getUser_blocked_status() {
        return user_blocked_status;
    }

    public void setUser_blocked_status(String user_blocked_status) {
        this.user_blocked_status = user_blocked_status;
    }

    public String getUser_created_date() {
        return user_created_date;
    }

    public void setUser_created_date(String user_created_date) {
        this.user_created_date = user_created_date;
    }
 
    
    
    
    
    
    
}
