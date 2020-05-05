/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagementsystem;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author PrabeshG
 */
public class EncryptionDecryption {
        public String getEncryptedValue(String input){
            try{
                SecretKey key = generateKey();
                Cipher cp = Cipher.getInstance("AES");
                byte[] encryptedData = encryptString(input,key,cp);
                String encryptedString = new String(encryptedData);
                return encryptedString;
            }
            catch(Exception e){
                return null;
            }
        }
        
        public String getDecryptedValue(String input){
            try{
                byte[] toByte=input.getBytes();
                SecretKey key = generateKey();
                Cipher cp = Cipher.getInstance("AES");
                String decryptedValue = decryptString(toByte, key, cp);
                return decryptedValue;
            }
            catch(Exception e){
                return null;
            }
        }
    public SecretKey generateKey(){
        try{
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myKey = keygenerator .generateKey();
            return myKey;
        }
        catch(Exception e){
            System.out.println("Error here");
            return null;
        }
    }
        
    public byte[] encryptString (String dataToEncrypt,SecretKey myKey,Cipher cipher){
        try{
//            System.out.println("Error here");
             byte[] text = dataToEncrypt.getBytes();
//             System.out.println("Error here");
             cipher.init(Cipher.ENCRYPT_MODE, myKey);
             byte[] textEncrypted = cipher.doFinal(text);
             return textEncrypted;
        }
        catch(Exception e){
//            System.out.println("encrypted");
            return null;
            
        }
    }
    public String decryptString (byte[] dataToDecrypt,SecretKey myKey,Cipher cipher){
        try{
            cipher.init(Cipher.DECRYPT_MODE, myKey);
            byte[] texDecrypted = cipher.doFinal(dataToDecrypt);
            String result = new String(texDecrypted);
            return result;
        }
        catch(Exception e){
            System.out.println("decrypted");
            return null;
        }
    }
    }
    

