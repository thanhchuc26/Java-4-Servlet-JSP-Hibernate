/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.jsp.mvc.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author June
 */
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       
       String name = request.getParameter("name");
       String password = request.getParameter("password");
       
       LoginBean bean = new LoginBean();
       bean.setName(name);
       bean.setPassword(password);
       request.setAttribute("bean", bean);
       
       boolean status = bean.validate();
       
       if(status){
           RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
           rd.forward(request, response);
       }else{
           RequestDispatcher rd = request.getRequestDispatcher("login-fail.jsp");
           rd.forward(request, response);
       }       
    }

    @Override
    protected void doGet(HttpServletRequest hsr, HttpServletResponse hsr1) throws ServletException, IOException{
        doPost(hsr, hsr1);
    }
}
