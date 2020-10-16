/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.web.hibernate.servlets;

import com.softech.web.hibernate.controllers.StudentEntityJpaController;
import com.softech.web.hibernate.entities.StudentEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author June
 */
@WebServlet(name = "InsertStudentServlet", urlPatterns = {"/InsertStudentServlet"})
public class InsertStudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertStudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
                
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String action = request.getParameter("action");
//            if(action.equals("Insert")){{
//                
//            }
//            if(gender.equals("M")){
//                
//            }
            
            StudentEntity stud = new StudentEntity();
            stud.setUsername(username);
            stud.setName(name);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.softech_web-hibernate_war_1.0-SNAPSHOTPU");
            
            StudentEntityJpaController controller = new StudentEntityJpaController(emf);
            
            controller.create(stud);
            
            out.println("<h1>Student Saved!</h1>");
            out.println("<a href='insertStudent.html'>Insert another student!</a>");
            
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
