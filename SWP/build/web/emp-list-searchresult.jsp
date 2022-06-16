<%-- 
    Document   : search-result-emp-list
    Created on : Jun 15, 2022, 7:59:02 PM
    Author     : DELL
--%>

<%@page import="entity.departments"%>
<%@page import="java.util.List"%>
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
        <title>Employees - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Lineawesome CSS -->
        <link rel="stylesheet" href="css/line-awesome.min.css">

        <!-- Datatable CSS -->
        <link rel="stylesheet" href="css/dataTables.bootstrap4.min.css">

        <!-- Select2 CSS -->
        <link rel="stylesheet" href="css/select2.min.css">

        <!-- Datetimepicker CSS -->
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- import js -->
        <script src="js/employee-list_js.js"></script>

        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="js/jquery.slimscroll.min.js"></script>

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>
        <script src="js/edit.js"></script>

        <!-- Model JS -->


        <jsp:useBean id="account" class="model.DAOAccount" scope="request"></jsp:useBean>

        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
    </head>

    <body onpageshow="checkPasswordonpageshow()">

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
                                    <h3 class="page-title">Employee</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="manager-dashboard.jsp">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Employee</li>
                                    </ul>
                                </div>
                                <div class="col-auto float-right ml-auto">
                                    <!--<a href="#" class="btn add-btn" data-toggle="modal" data-id="${sessionScope.acc.profile_id}" data-target="#add_employee"><i class="fa fa-plus"></i> Add Employee</a>-->
                                <div class="view-icons">
                                    <!--                                        <a href="employees.html" class="grid-view btn btn-link"><i class="fa fa-th"></i></a>
                                                                            <a href="employees-list.jsp" class="list-view btn btn-link active"><i class="fa fa-bars"></i></a>-->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable" id="table">                                   
                                    <h4><a href="manager?do=list" style="text-decoration: none; color: grey"> <-- back</a></h4>
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Employee ID</th>
                                            <th name="email">Email</th>
                                            <th>Mobile</th>
                                            <th class="text-nowrap">Join Date</th>
                                            <th>Role</th>
                                            <!--<th class="text-right no-sort">Action</th>-->
                                        </tr>
                                    </thead>                                   
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
                                            <tr>
                                                <td>
                                                    <h2 class="table-avatar">
                                                        <!--<a href="profile.html" class="avatar"><img alt="" src="assets/img/user.jpg"></a>-->
                                                        <a href="profile.jsp">${o.first_name} ${o.last_name} <span>${o.department_name}</span></a>
                                                    </h2>

                                                </td>
                                                <td>${o.profile_id}</td>
                                                <td>${o.email}</td>
                                                <c:choose>
                                                    <c:when test="${o.phone_number.equals('')}">
                                                        <td>N/A</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>${o.phone_number}</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td>${o.hire_date}</td>
                                                <td>${o.job_title}</td>
                                                <!--<td class="text-right">-->
<!--                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-id="${o.profile_id} ${o.first_name} ${o.last_name} ${o.email} ${o.phone_number} ${o.hire_date} ${account.getAccount(o.profile_id).getUser()} ${account.getAccount(o.profile_id).getPass()} ${o.reportto}" data-target="#edit_employee"> <i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_employee" data-id="${o.profile_id}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                        </div>
                                                    </div>-->
                                                <!--</td>-->
                                            </tr>
                                        </c:forEach>
                                    </tbody>                                  
                                </table>
                            </div>
                        </div>
                    </div>




                </div>
            </div>
            <!-- /Page Wrapper -->


        </div>
        <!-- /Main Wrapper -->

    </body>
</html>