/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.dao;

import com.softech.helpers.DatabaseHelper;
import com.softech.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author June
 */
public class UserDao {
    public boolean insertUser(User user) throws Exception{
        String sql = "INSERT INTO [User](Password, Name, Gender) VALUES(?, ?, ?)";
        try(Connection con = DatabaseHelper.openConnection();   
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getName());
            ps.setBoolean(3, user.isGender());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean updateUser(User user) throws Exception{
        String sql = "UPDATE [User] SET Password = ?, Name = ?, Gender = ? WHERE Username = ?";
        try(Connection con = DatabaseHelper.openConnection();   PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getName());
            ps.setBoolean(3, user.isGender());
            ps.setInt(4, user.getUsername());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    public User findbyId(int username) throws Exception{
      
        String sql = "SELECT * FROM [User] WHERE Username = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ){
            ps.setInt(1, username);
            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getInt("Username"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getBoolean("gender"));
                
                return user;
            }
            return null;
        }
    }
    
    public List<User> findAll() throws Exception{
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM [User]";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ){
            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getInt("Username"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getBoolean("gender"));
                list.add(user);
            }
            return list;
        }
    }
}
