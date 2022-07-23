<%-- 
    Document   : salary-view
    Created on : Jun 30, 2022, 1:12:26 PM
    Author     : DELL
--%>

<%@page import="model.DAOSalary"%>
<%@page import="java.util.List"%>
<%@page import="entity.Salary"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>Salary - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Lineawesome CSS -->
        <link rel="stylesheet" href="css/line-awesome.min.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="js/html5shiv.min.js"></script>
                <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <!-- Page Wrapper -->
                <div class="page-wrapper">

                    <!-- Page Content -->
                    <div class="content container-fluid">

                        <!-- Page Header -->
                        <div class="page-header">
                            <div class="row align-items-center">
                                <div class="col">
                                    <h3 class="page-title">Payslip</h3>
                                    <ul class="breadcrumb">
                                    <%--<c:if test="${sessionScope.acc.isManager == true}">--%>
                                    <!--<li class="breadcrumb-item"><a href="dashboard?do=manager">Dashboard</a></li>-->
                                    <%--</c:if>--%>
                                    <%--<c:if test="${sessionScope.acc.isManager == false}">--%>
                                    <!--<li class="breadcrumb-item"><a href="dashboard?do=employee">Dashboard</a></li>-->
                                    <%--</c:if>--%>
                                    <!--<li class="breadcrumb-item">Payroll</li>-->
                                    <c:if test="${sessionScope.acc.isAdmin == true}">
                                        <li class="breadcrumb-item"><a href="salary?do=list">Employee Salary</a></li>
                                        </c:if>
                                    <li class="breadcrumb-item active">Payslip</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <div class="btn-group btn-group-sm">
                                    <!--                                        <button class="btn btn-white">CSV</button>
                                                                            <button class="btn btn-white">PDF</button>
                                                                            <button class="btn btn-white"><i class="fa fa-print fa-lg"></i> Print</button>-->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body">
                                    <%
                                        LocalDateTime now = LocalDateTime.now();
                                        Salary s = (Salary) request.getAttribute("s");
                                    %>
                                    <h4 class="payslip-title">Payslip for the month of <%=now.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + now.getYear()%></h4>
                                    <div class="row">
                                        <div class="col-sm-6 m-b-20">
                                            <img src="img/profiles/avatar-05.jpg" class="inv-logo" alt="" style="border-radius: 50px;">
                                            <ul class="list-unstyled mb-0">
                                                <li>Dreamguy's Technologies</li>
                                                <li>3864 Quiet Valley Lane,</li>
                                                <li>Sherman Oaks, CA, 91403</li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6 m-b-20">
                                            <div class="invoice-details">
                                                <h3 class="text-uppercase">Payslip #<%= s.getPayslip_number()%></h3>
                                                <ul class="list-unstyled">
                                                    <li>Salary Month: <span><%=now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)%>, <%=now.getYear()%></span></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 m-b-20">
                                            <ul class="list-unstyled">
                                                <li>EmployeeName: <h4 class="mb-0" style="display: inline;"> <strong><%= s.getFirst_name() + " " + s.getLast_name()%></strong></h4></li>
                                                <li>Employee ID: <%= s.getProfile_id()%></li>
                                                <li>Job: <span><%= s.getJob_title()%></span></li>
                                                <li>Joining Date: <%= s.getHire_date()%></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div>
                                                <h4 class="m-b-10"><strong>Earnings</strong></h4>
                                                <table class="table table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td><strong>Basic Salary</strong> <span class="float-right">$<%= Math.round(s.getBasic_salary())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Dearness Allowance (D.A.)</strong> <span class="float-right">$<%= Math.round(s.getDA())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>House Rent Allowance (H.R.A.)</strong> <span class="float-right">$<%= Math.round(s.getHRA())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Conveyance</strong> <span class="float-right">$<%= Math.round(s.getConveyance())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Allowance</strong> <span class="float-right">$<%= Math.round(s.getAllowance())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Medical Allowance</strong> <span class="float-right">$<%= Math.round(s.getMedical_allowance())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Total Earnings</strong> <span class="float-right"><strong>$<%= Math.round(s.getBasic_salary() + s.getDA() + s.getHRA() + s.getConveyance() + s.getAllowance() + s.getMedical_allowance())%></strong></span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div>
                                                <h4 class="m-b-10"><strong>Deductions</strong></h4>
                                                <table class="table table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td><strong>Tax Deducted at Source (T.D.S.)</strong> <span class="float-right">$<%= Math.round(s.getTDS())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Provident Fund</strong> <span class="float-right">$<%= Math.round(s.getPF())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>ESI</strong> <span class="float-right">$<%= Math.round(s.getESI())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Leave</strong> <span class="float-right">$<%= Math.round(s.getLeave())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Loan</strong> <span class="float-right">$<%= Math.round(s.getLoan())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Professional Tax</strong> <span class="float-right">$<%= Math.round(s.getProfessional_tax())%></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Total Deductions</strong> <span class="float-right"><strong>$<%= Math.round(s.getTDS() + s.getPF() + s.getESI() + s.getLeave() + s.getLoan() + s.getProfessional_tax())%></strong></span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="col-sm-12">
                                            <%String wordNumber = DAOSalary.convertNumberToWord(Math.round(s.getNet_salary()));%>
                                            <p><strong>Net Salary: $<%= Math.round(s.getNet_salary())%></strong> (<%= wordNumber%>.)</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="js/jquery.slimscroll.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>
