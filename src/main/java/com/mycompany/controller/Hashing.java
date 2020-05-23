/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguragain3
 */
public class Hashing {
    public static String getHash(String password){
        try{
            //Create MessaageDigest instance for MD5 hashing
            MessageDigest md = MessageDigest.getInstance("MD5");
            //update the digest by adding password's bytes
            md.update(password.getBytes());
            //Get the hash's bytes in decimal format
            byte[] hashbytes = md.digest();
            //convert it into hexadecimal format
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< hashbytes.length ;i++)
            {
                sb.append(Integer.toString((hashbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hash in hexadecimal format
            String finalHash = sb.toString();
            return finalHash;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hashing.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
