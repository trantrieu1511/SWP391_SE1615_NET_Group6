<%-- 
    Document   : logout
    Created on : Jun 2, 2022, 8:39:46 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body>
        <!--<h1>Hello World!</h1>-->
        <%
            session.invalidate();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
