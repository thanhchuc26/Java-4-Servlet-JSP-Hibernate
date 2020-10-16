<%-- 
    Document   : listStudent
    Created on : Jul 14, 2020, 6:20:37 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forTokens var="it" items="java, c#, js, html" delims=",">    
            <p>Token: ${it}</p>
        </c:forTokens>
        <%
            String[] provinces={"Hue","Saigon","Hanoi"};
            request.setAttribute("provinces", provinces);
        %>
        <c:forEach var="it" items="${provinces}">
            <p>${it}</p>
        </c:forEach>
        <table border="1">
            <c:forEach var="i" begin="1" end="10">
                <tr>
                    <td>${i}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
