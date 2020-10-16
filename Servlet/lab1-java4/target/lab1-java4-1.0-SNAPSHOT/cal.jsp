<%-- 
    Document   : cal
    Created on : Aug 22, 2020, 8:05:19 PM
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
        <form action="CalculatorController">
            Number 1: <input type="text" name="num1"> <br><br>
            Number 2: <input type="text" name="num2"> <br> <br>
            <input type="submit" name="action" value="+">
            <input type="submit" name="action" value="-">
            <input type="submit" name="action" value="*">
            <input type="submit" name="action" value="/">
        </form>
    </body>
</html>
