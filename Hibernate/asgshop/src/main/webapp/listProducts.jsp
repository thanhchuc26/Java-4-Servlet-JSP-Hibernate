<%-- 
    Document   : listProducts
    Created on : Jul 21, 2020, 10:29:03 PM
    Author     : June
--%>

<%@page import="java.util.List"%>
<%@page import="com.softech.asgshop.entities.ProductEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.softech.asgshop.controllers.ProductEntityJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of Product</h1>
        <hr>
        <a href="addOrEditProduct.jsp"></a>
        <table>
            <tr>
                <td>Product ID</td>
                <td>Name</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Description</td>
                <td>&nbsp;</td>
            </tr>
            <%
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.softech_asgshop_war_1.0-SNAPSHOTPU");
                ProductEntityJpaController controller = new ProductEntityJpaController(emf);
                List<ProductEntity> list = controller.findProductEntityEntities();
                for (ProductEntity productEntity : list) {
                        request.setAttribute("entity", productEntity);
            %>
            <tr>                   
                <td>${entity.productId}</td>
                <td>${entity.name}</td>
                <td>${entity.price}</td>
                <td>${entity.quantity}</td>
                <td>${entity.description}</td>
                <td>View 
                    <a href="addOrEditProduct.jsp?id=${entity.productId}">Edit</a>
                    Delete</td>
            </tr>
            <%}%>
        </table>
        
    </body>
</html>
