<%-- 
    Document   : el-demo
    Created on : Jul 9, 2020, 8:08:03 PM
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
        <h4>4 + 5 = ${ 4 + 5 }</h4>
        <h4>4 % 5 = ${ 4 mod 5 }</h4>
        <h4>4 - 5 = ${ 4 - 5 }</h4>
        <h4>4 / 5 = ${ 4 / 5 }</h4>
        <h4>4 * 5 = ${ 4 * 5 }</h4>
        <h4>${empty param.name}</h4>
        <h4>Name: ${param.name}</h4>
        
        <jsp:useBean id="book" scope="request" class="com.softech.javabean.demo.Book" />
        <jsp:setProperty name="book" property="title" value="Expression Language" />
        <h4>Title: ${book.title}</h4>
    </body>
</html>
