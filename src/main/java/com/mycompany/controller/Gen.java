/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;


import java.util.Random;

/**
 *
 * @author Your Name <Prajwal Ghimire>
 */
public class Gen {
 
   public static int Verify(){
       int code=0;
       int reg_code=0;
      for(int i=0;i<1;i++){
      if (reg_code==0){
        Random random = new Random();
        code = random.nextInt((999999 - 111111) + 1) + 111111;
        reg_code=code;
        i=0;
        }
      else{
         break;
     }
     
       }
     
    return reg_code;
   }
   
   public static int Pass(){
   
   Random random =new Random();
   int pass = random.nextInt((999999999-111111111)-1)+111111111;
   return pass;
   
   }
}
