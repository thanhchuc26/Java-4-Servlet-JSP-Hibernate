/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.excercisejdbcservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author June
 */
public class StudentsDAO {
    private Connection connection;
    
    public static Connection connectionSQLServer() throws ClassNotFoundException, SQLException{
        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DB_URL = "jdbc:sqlserver://localhost;";
        String DATABASENAME = "databaseName=DemoDB;";
        String USER = "user=sa;";
        String PASS = "password=123456";

        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        return connection;
    }
    
    public void Disconnect() throws SQLException{
        if(connection != null || !connection.isClosed()){
            connection.close();
        }
    }
    
    public void InsertStudents(Students students) throws ClassNotFoundException, SQLException{
        String SQL = "INSERT INTO Students(username, name) VALUES( ?, ?)";
        connectionSQLServer();
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setString(1, students.getUsername());
        ps.setString(2, students.getUsername());
        ps.executeUpdate();
        ps.close();
        Disconnect();
    }
    public void DeleteStudents(Students students) throws ClassNotFoundException, SQLException{
        String SQL = "DELETE FROM Students WHERE username = ? AND name = ?";
        connectionSQLServer();
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setString(1, students.getUsername());
        ps.setString(2, students.getUsername());
        ps.executeUpdate();
        ps.close();
        Disconnect();
    }
}
