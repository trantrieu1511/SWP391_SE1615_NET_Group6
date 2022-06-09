<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat"%>
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
        <title>Attendance - HRMS admin template</title>

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

        <!-- Bean -->
        <jsp:useBean id="attendance" class="model.DAOAttendance" scope="request"></jsp:useBean>
        <jsp:useBean id="profile" class="model.DAOProfile" scope="request"></jsp:useBean>

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
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="page-title">Attendance</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Attendance</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Search Filter -->
                    <div class="row filter-row">
                        <div class="col-sm-6 col-md-4">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating" id="name" onkeyup="filter1()">
                                <label class="focus-label">Employee Name</label>
                            </div>
                        </div>                       
                        <div class="col-sm-6 col-md-4"> 
                            <div class="form-group form-focus"><label class="focus-label">Date</label>
                                <div>                                
                                    <input type="date" class="form-control floating" id="date" onchange="filter2(this.value)" onfocus="(this.type = 'date')" onblur="if (!this.value)
                                                this.type = 'text'">
                                </div>
                            </div>
                        </div>                                             
                    </div>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable" id="table">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Date </th>
                                            <th>Punch In</th>
                                            <th>Punch Out</th>
                                            <th>Production</th>                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${attendance.listAll(profile.getByUser(sessionScope.acc.user).getProfile_id())}" var="o">
                                            <tr>
                                                <td>${o.employee_id}</td>
                                                <td>${o.date}</td>
                                                <td>${o.time_in}</td>
                                                <td>${o.time_out}</td>
                                                <td>${o.production_time}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                        function filter1() {
                            var input, filter, table, tr, td, i, txtValue;
                            input = document.getElementById("name");
                            table = document.getElementById("table");
                            tr = table.getElementsByTagName("tr");
                            filter = input.value.toUpperCase();

                            for (i = 0; i < tr.length; i++) {
                                td = tr[i].getElementsByTagName("td")[0];
                                if (td) {
                                    txtValue = td.textContent || td.innerText;
                                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                        tr[i].style.display = "";
                                    } else {
                                        tr[i].style.display = "none";
                                    }
                                }

                            }
                        }
                        function filter2(value) {
                            var filter, table, tr, td, i, date;
                            date = moment(value).format('DD/MM/YYYY');
                            table = document.getElementById("table");
                            tr = table.getElementsByTagName("tr");
                            filter = date.toUpperCase();

                            for (i = 0; i < tr.length; i++) {
                                td = tr[i].getElementsByTagName("td")[1];
                                if (td) {
                                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                        tr[i].style.display = "";
                                    } else {
                                        tr[i].style.display = "none";
                                    }
                                }

                            }
                        }
                    </script> 

                </div>
                <!-- /Page Content -->

            </div>
            <!-- Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="js/jquery.slimscroll.min.js"></script>

        <!-- Chart JS -->
        <script src="plugins/morris/morris.min.js"></script>
        <script src="plugins/raphael/raphael.min.js"></script>
        <script src="js/chart.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

    </body>
</html>