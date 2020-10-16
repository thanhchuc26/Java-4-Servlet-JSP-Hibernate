<%-- 
    Document   : calc
    Created on : Jul 9, 2020, 7:01:45 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculator!</h1>
        <form method="post">
            a: <input type="text" name="num1"> <br> <br>
            b: <input type="text" name="num2"> <br> <br>
            <input type="submit" value="Add">
        </form>
        <hr>
        <%
            if(request.getMethod().equals("POST")){
        %>
        <jsp:useBean id="number" class="com.softech.javabean.demo.Number" scope="page"/>
        <jsp:setProperty name="number" property="*"/>
        <h3>Result: <%= number.add() %> </h3>
        <%}%>
    </body>
</html>
