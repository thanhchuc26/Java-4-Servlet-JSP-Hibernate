<%-- 
    Document   : AddNewProduct
    Created on : Jul 25, 2020, 6:35:58 PM
    Author     : June
--%>

<%@page import="com.softech.onlineshop.entities.ShopEntity"%>
<%@page import="com.softech.onlineshop.controllers.ShopEntityJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="text-align: center;">
        <h1>Add New Product</h1>
        <hr>
        <form method="POST">
            Product ID: <input type="text" name="productId"> <br><br>
            Name: <input type="text" name="name"> <br><br>
            Unit Price: <input type="text" name="unitprice"> <br><br>
            Quantity: <input type="text" name="quantity"> <br><br>
            Manufacturer: <select name="manufacturer"> 
                <Option value="Sony">Sony</Option>
                <Option value="SamSung">SamSung</Option>
                </select><br><br>
            Description: <textarea name="description" cols="30" rows="10"></textarea> <br>
        </form>
        <hr>
        <input type="submit" name="action" value="Save">
        <input type="submit" name="action" value="Search">
        <%
            if (request.getMethod().equals("POST")) {
        %>
        <jsp:useBean id="entity" class="com.softech.onlineshop.entities.ShopEntity" scope="page"/>
        <jsp:setProperty name="entity" property="*"/>
        <%            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.softech_onlineshop_war_1.0-SNAPSHOTPU");
            ShopEntityJpaController controller = new ShopEntityJpaController(emf);
            String action = request.getParameter("action");
            if (action != null && action.equals("Save")) {
                controller.create(entity);
                out.println("<h3>Product Saved</h3>");
            } else {
                response.sendRedirect("SearchProduct.jsp");
            }
        %>
        <%}%>
    </body>
</html>
