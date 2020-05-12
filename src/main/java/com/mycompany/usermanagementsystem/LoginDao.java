package com.mycompany.usermanagementsystem;
import java.sql.*;  
  
public class LoginDao { 
    
public static boolean validate(String name,String pass){  
boolean status=false;  
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/user_management?serverTimezone=UTC");  
      
        PreparedStatement ps=con.prepareStatement(  
        "select * from userdb where username=? and user_password=?");  
        ps.setString(1,name);  
        ps.setString(2,pass);  

        ResultSet rs=ps.executeQuery();  
        status=rs.next();  
          
    }catch(Exception e){System.out.println(e);}  
return status;  
}  
}  