<%-- 
    Document   : dashboard
    Created on : Jul 7, 2020, 8:45:46 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Dashboard!</h1>
    </body>
</html>
