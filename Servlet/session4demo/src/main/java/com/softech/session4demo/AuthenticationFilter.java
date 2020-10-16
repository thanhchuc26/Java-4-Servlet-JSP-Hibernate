/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.session4demo;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author June
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
             
        Throwable problem = null;
        try {
            System.out.println("In authentication filter");
           // System.out.println("URL: " + request.getRemoteAddr());
            HttpServletRequest hrequest = (HttpServletRequest) request;
            if(hrequest.getRequestURI().contains("Login")){
                chain.doFilter(request, response);
            }else{
                HttpSession session = hrequest.getSession();
                if(session.getAttribute("USERNAME")!=null){
                    chain.doFilter(request, response);
                }else{
                    RequestDispatcher rd = hrequest.getRequestDispatcher("LoginServlet");
                    rd.forward(request, response);
                }
            }
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
