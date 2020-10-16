/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.jvm.hotspot.utilities.soql.SOQLException;

/**
 *
 * @author June
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;
    
    public void init(){
        BookDAO bookDAO = new BookDAO();
    }   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getServletPath();
        try{
            switch(action){
                case "/new":
                    showNewForm(request,response);
                    break;
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void listBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, SQLException, IOException{
        List<Book> listBook = bookDAO.listAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("BookForm.jsp");
        rd.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getBook(id);
        RequestDispatcher rd = request.getRequestDispatcher("BookForm.jsp");
        request.setAttribute("book", existingBook);
        rd.forward(request, response);
    }
    
    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException{
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Book newBook = new Book(quantity, title, author, price, quantity);
        bookDAO.insertBook(newBook);
        response.sendRedirect("list");
    }
    
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Book book = new Book(id, title, author, price, quantity);
        bookDAO.updateBook(book);
        response.sendRedirect("list");
    }
    
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        Book book = new Book(id);
        bookDAO.deleteBook(book);
        response.sendRedirect("list");
    }
}   


 
 