<%-- 
    Document   : newbook
    Created on : Jul 9, 2020, 6:56:42 PM
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
        <h1>Use JavaBeans!</h1>
        <jsp:useBean id="bk" class="com.softech.javabean.demo.Book" scope="page"/>
        
        <jsp:setProperty name="bk" property="isbn" value="123"/>
        <h3>Property ISBN: <jsp:getProperty name="bk" property="isbn"/>
            
    </body>
</html>
