<%-- 
    Document   : addOrEditProduct
    Created on : Jul 21, 2020, 6:35:37 PM
    Author     : June
--%>

<%@page import="com.softech.asgshop.controllers.ProductEntityJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.softech.asgshop.entities.ProductEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Or Edit Product</h1>
         <%
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.softech_asgshop_war_1.0-SNAPSHOTPU");
            ProductEntityJpaController controller = new ProductEntityJpaController(emf);
            String id = request.getParameter("productId");
            String name = "";
            String price = "";
            String quantity = "";
            String description = "";
            String action = "";
            if (id != null) {
                ProductEntity entity = controller.findProductEntity(Integer.parseInt(id));
                name = entity.getName();
                price = "" + entity.getPrice();
                quantity = "" + entity.getQuantity();
                description = entity.getDescription();
                action = "update";
            }
        %>
        <hr>
        <form method="post">
            <input type="hidden" name="action" value="<%= action%> ">
            Product ID: <input type="text" name="productId" value="<%= id %>"> <br> <br>
            Name: <input type="text" name="name" value="<%= name %>"> <br> <br>
            Price: <input type="number" name="price" value="<%= price %>"> <br> <br>
            Quantity: <input type="number" name="quantity" value="<%= quantity %>"> <br> <br>
            Description: <textarea name="description" id="" cols="30" rows="6" <%= description %>></textarea> <br> <br>
            <input type="submit" value="Add">
            <a href="listProducts.jsp">List Products</a>
        </form>
        <%
            if(request.getMethod().equals("POST")){
                id = request.getParameter("productId");
                name = request.getParameter("name");
                price = request.getParameter("price");
                quantity = request.getParameter("quantity");
                description = request.getParameter("description");
                action = request.getParameter("action");
                
                ProductEntity entity = new ProductEntity();
                //entity.setProductId(Integer.parseInt(id));
                entity.setName(name);
                entity.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
                entity.setQuantity(Integer.parseInt(quantity));
                entity.setDescription(description);
                
                if(action == null || action.equals("")){
                    entity.setProductId(null);
                    controller.create(entity);
            }else{
                entity.setProductId(Integer.parseInt(id));
                controller.edit(entity);
            }
                controller.create(entity);
                out.println("New product saved!");
            }
        %>
    </body>
</html>
