/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author June
 */
public class BookDAO {

    private Connection connection;

    public static Connection connectionSQLServer() throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DB_URL = "jdbc:sqlserver://localhost;";
        String DATABASENAME = "databaseName=DemoDB;";
        String USER = "user=sa;";
        String PASS = "password=123456";

        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        return connection;
    }

    public void Disconnect() throws SQLException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
        }
    }

    public boolean insertBook(Book book) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO book(title, author, price, quantity) VALUES (?, ?, ?, ?)";
        connectionSQLServer();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setFloat(3, book.getPrice());
        ps.setInt(4, book.getQuantity());

        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        Disconnect();
        return rowInserted;
    }

    public List<Book> listAllBooks() throws ClassNotFoundException, SQLException {
        List<Book> listBook = new ArrayList<>();
        String sql = "SELECT * FROM book";
        connectionSQLServer();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("book_id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            float price = rs.getFloat("price");
            int quantity = rs.getInt("quantity");

            Book book = new Book(id, title, author, price, quantity);
            listBook.add(book);
        }
        rs.close();
        st.close();
        Disconnect();
        return listBook;
    }

    public boolean deleteBook(Book book) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM book WHERE book_id = ?";
        connectionSQLServer();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, book.getId());

        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        Disconnect();;
        return rowDeleted;
    }

    public boolean updateBook(Book book) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE book SET title = ?, author = ?, price = ?, quantity = ?";
        sql += "WHERE book_id = ?";
        connectionSQLServer();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setFloat(3, book.getPrice());
        ps.setInt(4, book.getQuantity());
        ps.setInt(5, book.getId());

        boolean rowUpdated = ps.executeUpdate() > 0;
        ps.close();
        Disconnect();
        return rowUpdated;
    }
    
    public Book getBook(int id) throws ClassNotFoundException, SQLException{
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id=?";
        connectionSQLServer();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String title = rs.getString("title");
            String author = rs.getString("author");
            float price = rs.getFloat("price");
            int quantity = rs.getInt("quantity");
            
            book = new Book(id, title, author, price, quantity);
        }
        rs.close();
        ps.close();
        
        return book;
    }
}
