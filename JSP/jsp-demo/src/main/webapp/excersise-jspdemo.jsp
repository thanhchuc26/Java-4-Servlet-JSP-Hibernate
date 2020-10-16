<%-- 
    Document   : excersise-jspdemo
    Created on : Jul 7, 2020, 8:08:31 PM
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
        <h1>Plus two numbers</h1>
        <hr>
        <form action="" method="POST">
            a <input type="text" name="a"> <br> <br>
            b <input type="text" name="b"> <br> <br>
            <input type="submit" value="Add">
        </form>
        <%
            if (request.getMethod().equals("POST")) {
                String a = request.getParameter("a");
                String b = request.getParameter("b");

                int a1 = Integer.parseInt(a);
                int b1 = Integer.parseInt(b);
                int total = a1 + b1;
                if (a != null && b != null) {
                    out.println("<h3>Total of a and b: " + total + "</h3>");
                } else {
                    out.println("Please input value a or b!!!");
                }
            }
        %>
    </body>
</html>
