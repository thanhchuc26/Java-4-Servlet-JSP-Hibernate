/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.testservlet;

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
@WebServlet(name="HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in service");
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In dopost");
        try(PrintWriter out = resp.getWriter()){
            String name = req.getParameter("name");
            out.println("<h1>Hello: " + name + "</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in doget");
        try(PrintWriter out = resp.getWriter()){
            out.println("<h1>Hello! How are you today?</h1>");
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Init");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }
    
}
