<%-- 
    Document   : hello
    Created on : Jul 7, 2020, 6:30:40 PM
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
        <h1>Hello World!</h1>
        <h3><%= add(5, 6)%></h3>
        <%
            out.println("<h3>Your name is " + name + "</h3>");
            for (int i = 0; i < 10; i++) {
                out.println("<h4>Hello " + i + "</h4>");
            }
        %>
        <%!
            String name = "HTChuc";

            int add(int a, int b) {
                return a + b;
            }
        %>
    </body>
</html>
