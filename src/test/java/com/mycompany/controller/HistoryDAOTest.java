/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.History;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class HistoryDAOTest {
    
    public HistoryDAOTest() {
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
     * Test of addHistory method, of class HistoryDAO.
     */
    @Test
    public void testAddHistory() throws Exception {
        Boolean historyAdded=false;
        System.out.println("addHistory");
        try{
        History h = new History(UserDAO.getUserID("root"),LocalDateTime.now().toString(),"Test Ran for history");
        HistoryDAO.addHistory(h);
        historyAdded=true;
        }
        catch(Exception e){
            historyAdded=false;
        }
        assertEquals(historyAdded,true);
        
    }

    /**
     * Test of getUserHistory method, of class HistoryDAO.
     */
    @Test
    public void testGetUserHistory() throws Exception {
        System.out.println("getUserHistory");
        String username = "root";
        boolean expResult=true;
        ArrayList<History> result = HistoryDAO.getUserHistory(username);
        if(result.isEmpty()){
                expResult=false;
            }
            assertEquals(expResult,true);
    }

    /**
     * Test of getAdminHistory method, of class HistoryDAO.
     */
    @Test
    public void testGetAdminHistory() throws Exception {
        System.out.println("getAdminHistory");
        boolean expResult = true;

            ArrayList<History> result = HistoryDAO.getAdminHistory();
            if(result.isEmpty()){
                expResult=false;
            }
            assertEquals(expResult,true);
            
        

        
    }
    
}
