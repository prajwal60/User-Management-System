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
public class History {
    private int history_id;
    private int user_id;
    private String time;
    private String action_performed;

    public History(int user_id, String time, String action_performed) {
        this.user_id = user_id;
        this.time = time;
        this.action_performed = action_performed;
    }

    public History(int history_id, int user_id, String time, String action_performed) {
        this.history_id = history_id;
        this.user_id = user_id;
        this.time = time;
        this.action_performed = action_performed;
    }
    
    
    
    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAction_performed() {
        return action_performed;
    }

    public void setAction_performed(String action_performed) {
        this.action_performed = action_performed;
    }
    
    
}
