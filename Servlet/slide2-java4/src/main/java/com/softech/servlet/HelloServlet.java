/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author June
 */
@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service method");
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()){
            String id = req.getParameter("studentId");
            out.println("<h1>doPost method</h1>");
            out.println("<h1>Student ID: " + id + "</h1>");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()){
            String id = req.getParameter("studentId");
            out.println("<h1>doPost method</h1>");
            out.println("<h1>Student ID: " + id + "</h1>");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init(); 
        System.out.println("init method");
    }

    @Override
    public void destroy() {
        super.destroy(); 
        System.out.println("destroy method");
    }
    
}
