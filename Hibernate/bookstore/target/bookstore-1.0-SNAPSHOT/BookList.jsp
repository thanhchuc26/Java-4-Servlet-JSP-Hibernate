<%-- 
    Document   : BookList
    Created on : Jul 15, 2020, 10:17:43 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Store Application</title>
    </head>
    <body>
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Books</a>
        </h2>
        
    </center>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption> <h2>List of Books</h2> </caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}"/> </td>
                    <td><c:out value="${book.title}"/> </td>
                    <td><c:out value="${book.author}"/> </td>
                    <td><c:out value="${book.price}"/> </td>
                    <td><c:out value="${book.quantity}"/> </td>
                    <td>
                        <a href="/edit?id=<c:out value="${book.id}"/>">Edit</a>
                            &emsp;   
                        <a href="/delete?id=<c:out value="${book.id}"/>">Delete</a> 
                    </td>   
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>
