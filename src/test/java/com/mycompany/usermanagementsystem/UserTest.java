/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagementsystem;

import java.util.HashSet;
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
public class UserTest {
    
    public UserTest() {
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


    @Test
    public void testUsername_exists() {
        System.out.println("username_exists");
        String username = "pguragain3";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.username_exists(username);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of empty_fields_detected method, of class User.
     */
    @Test
    public void testEmpty_fields_detected() {
        System.out.println("empty_fields_detected");
        User u = new User();
        u.setFirst_name("");
        u.setLast_name("");
        u.setUsername("");
        u.setEmail("");
        u.setGender("");
        u.setUser_birthdate("");
        u.setUser_password1("");
        u.setUser_passsword2("");
        boolean expResult = true;
        boolean result = u.empty_fields_detected();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of password_mismatch method, of class User.
     */
    @Test
    public void testPassword_mismatch() {
        System.out.println("password_mismatch");
        User instance = new User();
        instance.setUser_password1("abcd");
        instance.setUser_passsword2("efgh");
        boolean expResult = true;
        boolean result = instance.password_mismatch();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of adduser method, of class User.
     */
    @Test
    public void testAdduser() {
        System.out.println("adduser");
        User u = new User();
        u.setFirst_name("Prabesh");
        u.setLast_name("Guragain");
        u.setUsername("pguragain100");
        u.setEmail("p@ggg");
        u.setGender("male");
        u.setUser_birthdate("2020-04-29");
        u.setUser_password1("asdf");
        u.setUser_passsword2("asdf");
        u.setUser_is_admin("false");
        u.setUser_created_date("2020-04-29");
        u.setUser_blocked_status("false");
        
        u.adduser();
        
        boolean result = u.username_exists("pguragain100");
        assertEquals(result,true);
    }
    
}
