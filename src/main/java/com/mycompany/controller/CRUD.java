/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

//import com.mycompany.model.User;
//import static java.lang.System.out;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Your Name <Prajwal Ghimire>
// */
//public class CRUD {
//
//    /**
//     * AbstractDAO.java This DAO class provides CRUD database operations for the
//     * table users in the database.
//     *
//     *
//     *
//     */
//    public class UserDAO {
//
//        private static final String Update_user = "UPDATE userdb SET first_name=?, last_name=?,username=?, email=?, gender=?, user_birthdate=? WHERE id=?";
//        
//
//        public UserDAO() {
//        }
//
//        public User updateUser(int id) {
//            User u = new User();
//            // Step 1: Establishing a Connection
//            try (Connection con = ConnectionClass.getConnection();
//                    // Step 2:Create a statement using connection object
//                    PreparedStatement preparedStatement = con.prepareStatement(Update_user);) {
//                preparedStatement.setInt(1, id);
//                System.out.println(preparedStatement);
//                // Step 3: Execute the query or update query
//                ResultSet rs = preparedStatement.executeQuery();
//
//                // Step 4: Process the ResultSet object.
//                while (rs.next()) {
//                    String fname = u.getFirst_name();
//                    String lname = u.getLast_name();
//                    String uname = u.getUsername();
//                    String email = u.getEmail();
//                    String gender = u.getGender();
//                    String birthdate = u.getUser_birthdate();
//                    u = new User(fname, lname, uname, email, gender, birthdate);
//                }
//            } catch (SQLException e) {
//                out.print(e);
//            }
//            return u;
//        }







//
//    }
//}
