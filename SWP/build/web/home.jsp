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

        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

    </head>

    <body>

        <c:if test="${sessionScope.acc.isManager == false && sessionScope.acc.isAdmin == false}">
            <jsp:include page="employee-dashboard.jsp"></jsp:include>
        </c:if>
        <c:if test="${sessionScope.acc.isManager == true || sessionScope.acc.isAdmin == true}">
            <jsp:include page="manager-dashboard.jsp"></jsp:include>
        </c:if>      

    </body>
