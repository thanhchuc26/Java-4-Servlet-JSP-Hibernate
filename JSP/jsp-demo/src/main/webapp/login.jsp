<%-- 
    Document   : login
    Created on : Jul 7, 2020, 7:15:22 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login to System</h1>
        <hr>
        <form action="" method="POST">
            Username: <input type="text" name="username"> <br><br>
            Password: <input type="password" name="password"> <br><br>
            <input type="submit" value="Login">
            <input type="submit" value="Reset">
        </form>
        <% //scriptlet tag
            if (request.getMethod().equals("POST")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
                    session.setAttribute("username", username);
                    response.sendRedirect("dashboard.jsp");
                } else {
                    out.println("<h3>Invalid username or password!!!</h3>");
                }
            }
        %>
    </body>
</html>
