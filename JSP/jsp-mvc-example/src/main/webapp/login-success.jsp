<%-- 
    Document   : login-success
    Created on : Jul 11, 2020, 10:47:52 PM
    Author     : June
--%>

<%@page import="com.softech.jsp.mvc.example.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You are successfully logged in!</h1>
        <%
            LoginBean bean = (LoginBean)request.getAttribute("bean");
            out.print("Welcome, " + bean.getName());
        %>
    </body>
</html>
