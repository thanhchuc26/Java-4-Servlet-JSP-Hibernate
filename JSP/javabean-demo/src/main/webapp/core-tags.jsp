<%-- 
    Document   : core-tags
    Created on : Jul 9, 2020, 8:47:47 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="num" value="2" scope="page"/>
        <c:if test="${num%2==0}">
            even
        </c:if>
        <c:if test="${num%2!=0}">
            odd
        </c:if>
        <c:choose>
            <c:when test="${num==2}"><h3>Monday</h3></c:when>
            <c:when test="${num==3}"><h3>Tuesday</h3></c:when>
            <c:otherwise>Invalid number!</c:otherwise>
        </c:choose>    
        <h3>Num: ${num}</h3>
        <h3><c:out value="${num}"/></h3>
        <c:remove var="num" scope="page"/>    
    </body>
</html>
