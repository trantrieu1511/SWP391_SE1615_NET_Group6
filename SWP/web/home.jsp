<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords"
              content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>Dashboard - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Lineawesome CSS -->
        <link rel="stylesheet" href="css/line-awesome.min.css">

        <!-- Chart CSS -->
        <link rel="stylesheet" href="plugins/morris/morris.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">
        
        <!-- Bean -->
        <jsp:useBean id="profile" class="model.DAOProfile" scope="request"></jsp:useBean>
        
        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

    </head>

    <body>
        <jsp:include page="menu.jsp"></jsp:include>

        <c:if test="${profile.getByID(sessionScope.acc.profile_id).reportto == null && sessionScope.acc.isAdmin == false}">
            <jsp:include page="manager-dashboard.jsp"></jsp:include>
        </c:if>
        
        <c:if test="${profile.getByID(sessionScope.acc.profile_id).reportto != null && sessionScope.acc.isAdmin == false}">
            <jsp:include page="employee-dashboard.jsp"></jsp:include>
        </c:if>
        
<!--         jQuery 
        <script src="js/jquery-3.5.1.min.js"></script>

         Bootstrap Core JS 
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

         Slimscroll JS 
        <script src="js/jquery.slimscroll.min.js"></script>

         Chart JS 
        <script src="plugins/morris/morris.min.js"></script>
        <script src="plugins/raphael/raphael.min.js"></script>
        <script src="js/chart.js"></script>

         Custom JS 
        <script src="js/app.js"></script>-->
    </body>
