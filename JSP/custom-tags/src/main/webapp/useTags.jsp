<%-- 
    Document   : useTags
    Created on : Jul 14, 2020, 7:22:59 PM
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tlds/mytagslib"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:TableTagHandler color="red" cols="4" rows="5"/>
        <c:TableTagHandler color="yellow" cols="4" rows="5"/>
        
        <c:HelloTagHandler/>
        <c:HelloTagHandler/>
        <c:HelloTagHandler/>
        <c:HelloTagHandler/>
        <c:HelloTagHandler/>
        <c:HelloTagHandler/>
    </body>
</html>
