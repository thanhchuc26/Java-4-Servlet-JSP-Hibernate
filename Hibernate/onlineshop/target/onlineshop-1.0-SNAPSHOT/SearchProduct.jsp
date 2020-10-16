<%-- 
    Document   : SearchProduct
    Created on : Jul 25, 2020, 7:11:36 PM
    Author     : June
--%>

<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="com.softech.onlineshop.entities.ShopEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.softech.onlineshop.controllers.ShopEntityJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, tr, td {
            border: 2px solid black;
            text-align: center;
            border-collapse: collapse;
        }
        tr, td{
            padding: 5px;
        }
    </style>
    <body style="text-align: center">
        Name: <input type="text" name="name"> <br> <br>
        <table style="width: 50%"">
            <tr>
                <td>Name</td>
                <td>Quantity</td>
                <td>Unit Price</td>
                <td>Manufacturer</td>
            </tr>
            <%
                if(request.getMethod().equals("POST")){
                    String name = request.getParameter("name");
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.softech_onlineshop_war_1.0-SNAPSHOTPU");
                    EntityManager manager = emf.createEntityManager();
                    Query findByName = manager.createNamedQuery("ShopEntity.findByName");
                    findByName.setParameter("name", name);

                    List<ShopEntity> list = findByName.getResultList();
                    for (ShopEntity shopEntity : list) {
                            request.setAttribute("entity", shopEntity);
            %>
            <tr>                   
                <td>${entity.name}</td>
                <td>${entity.quantity}</td>
                <td>${entity.unitprice}</td>
                <td>${entity.manufacturer}</td>
            </tr>
            <%}%>
            <%}%>
        </table>
    </body>
</html>
