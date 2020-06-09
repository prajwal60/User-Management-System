/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pguragain3
 */
public class UserDAOTest {
    User u = new User();
    
    public UserDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of username_exists method, of class UserDAO.
     */
    @Test
    public void testUsername_exists() {
        System.out.println("username_exists");
        String username = "hauderam1000";
        u.setUsername(username);
        boolean expResult = false;
        boolean result = UserDAO.username_exists(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of empty_fields_detected method, of class UserDAO.
     */
    @Test
    public void testEmpty_fields_detected() {
        System.out.println("empty_fields_detected");
        u.setFirst_name("");
        u.setLast_name("");
        u.setUsername("");
        u.setEmail("");
        u.setGender("");
        u.setUser_birthdate("");
        u.setUser_password1("");
        u.setUser_passsword2("");
        boolean expResult = true;
        boolean result = UserDAO.empty_fields_detected(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of password_short_length method, of class UserDAO.
     */
    @Test
    public void testPassword_short_length() {
        System.out.println("password_short_length");
        String password = "dummy";
        UserDAO.password_short_length(u);
        boolean expResult = true;
        boolean result = UserDAO.password_short_length(u);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of password_mismatch method, of class UserDAO.
     */
    @Test
    public void testPassword_mismatch() {
        System.out.println("password_mismatch");
        u.setUser_password1("abcd");
        u.setUser_passsword2("efgh");
        boolean expResult = true;
        boolean result = UserDAO.password_mismatch(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of invallid_date method, of class UserDAO.
     */
    @Test
    public void testInvallid_date() {
        System.out.println("invallid_date");
        u.setUser_created_date("2020-05-05");
        u.setUser_birthdate("2020-05-06");
        boolean expResult = true;
        boolean result = UserDAO.invallid_date(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("adduser");
        u.setFirst_name("Prabesh");
        u.setLast_name("Guragain");
        u.setUsername("root");
        u.setEmail("p@ggg");
        u.setGender("male");
        u.setUser_birthdate("2020-04-28");
        u.setUser_password1("12345678");
        u.setUser_passsword2("12345678");
        u.setUser_is_admin("true");
        u.setUser_created_date(java.time.LocalDate.now().toString());
        u.setUser_blocked_status("false");
        
        UserDAO.addUser(u);
        
        boolean result = UserDAO.username_exists(u);
        assertEquals(result,true);
        
        
        u.setFirst_name("Prabesh");
        u.setLast_name("Guragain");
        u.setUsername("user");
        u.setEmail("u@ser");
        u.setGender("male");
        u.setUser_birthdate("2020-04-28");
        u.setUser_password1("12345678");
        u.setUser_passsword2("12345678");
        u.setUser_is_admin("false");
        u.setUser_created_date(java.time.LocalDate.now().toString());
        u.setUser_blocked_status("false");
        
        UserDAO.addUser(u);
        
        u.setFirst_name("Dummy");
        u.setLast_name("Account");
        u.setUsername("dummy");
        u.setEmail("dumdum@dummy");
        u.setGender("male");
        u.setUser_birthdate("2020-04-28");
        u.setUser_password1("12345678");
        u.setUser_passsword2("12345678");
        u.setUser_is_admin("false");
        u.setUser_created_date(java.time.LocalDate.now().toString());
        u.setUser_blocked_status("false");
        
        UserDAO.addUser(u);
    }
    
}
