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
        <script src="js/edit.js"></script>

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        
        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        
        <script type="text/javascript">
        $('#table').dataTable({
            "fnDrawCallback":function(){
                if ( $('#table_paginate span span.paginate_button').size()) {
                    $('#table_paginate')[0].style.display = "block";
                } else {
                    $('#table_paginate')[0].style.display = "none";
                }
            }
        });​
        $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            })
        </script>

    </head>
    <body onload="pagination()">
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
                            <a>Employee Name</a>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <a>Date</a>
                        </div>
                    </div>
                    <form action="manager" do="post">
                        <input type="hidden" name="do" value="searchAttendance">
                        <div class="row filter-row">
                            <div class="col-sm-6 col-md-4">  
                                <input type="text" class="form-control form-focus" name="name" id="inp" pattern="[A-Za-z]{1,20}" value="${name}">                                   
                            </div>                       
                            <div class="col-sm-6 col-md-4">                               
                                <input type="text" class="form-control form-focus datetimepicker" name="date" onkeydown="event.preventDefault()" value="${date}">
                            </div>
                            <div class="col-sm-6 col-md-4">
                                <button class="btn btn-success btn-block"> Search </button>  
                            </div>
                        </div>
                    </form>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable" id="table">
                                    <c:if test="${filter == 'yes'}">
                                        <h4><a href="manager?do=attendance" style="text-decoration: none; color: grey"> <-- back</a></h4>
                                    </c:if>
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Date </th>
                                            <th>Punch In</th>
                                            <th>Punch Out</th>
                                            <th>Production</th>                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
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
                        function pagination() {
                            var table, count, entry;
                            table = document.getElementById("table");
                            count = table.getElementsByTagName("tr").length+1;
                            entry = document.getElementById("table_length").value;
                            if (count <= entry) {
                                document.getElementById("table_paginate").style.display = none;
                            } esle {
                                document.getElementById("table_paginate").style.display = block;
                            }
                        }
                    </script> 

                </div>
                <!-- /Page Content -->

            </div>
            <!-- Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

    </body>
</html>