<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String date = df.format(new java.util.Date());
%>
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

        <!-- Main Stylesheet -->
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">

            <jsp:include page="index.jsp"></jsp:include>

            <!-- Page Wrapper -->
            <div class="page-wrapper">
                
                <!-- /Page Content -->
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

                    <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <div class="card punch-status">
                                <div class="card-body">
                                    <h5 class="card-title">Timesheet <small class="text-muted"><%=date%></small></h5> 
                                    <div class="punch-info">
                                        <div class="punch-hours">
                                            <jsp:include page="clock.jsp"></jsp:include>  
                                        </div>
                                    </div>
                                    <div class="punch-btn-section">
                                        <%String bt = (String) request.getAttribute("button");%>
                                        <c:if test="${button == null}">
                                            <a href="employee" button id="in" onclick="punch(this.id)" type="button" class="btn btn-primary punch-btn" name="punch">Punch In</button></a>
                                        </c:if>
                                        <c:if test="${button == 'out'}">
                                            <a href="employee" button id="out" onclick="punch(this.id)" type="button" class="btn btn-primary punch-btn" name="punch">Punch Out</button></a>
                                        </c:if>
                                        <c:if test="${button == 'in'}">
                                            <a href="employee" button id="in" onclick="punch(this.id)" type="button" class="btn btn-primary punch-btn" name="punch">Punch In</button></a>
                                        </c:if>                 
                                        <script type="text/javascript">
                                            function punch(id)
                                            {
                                                if (id == "out") {
                                                    document.getElementById(id).href = "employee?do=punchout&&user=${sessionScope.acc.user}";
                                                    var today = new Date();
                                                    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
                                                    document.getElementById(id).innerHTML = "Punch In";
                                                    document.getElementById(id).id = "in";
                                                } else {
                                                    document.getElementById(id).href = "employee?do=punchin&&user=${sessionScope.acc.user}";
                                                    var today = new Date();
                                                    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
                                                    document.getElementById(id).innerHTML = "Punch Out";
                                                    document.getElementById(id).id = "out";
                                                }
                                            }
                                        </script>
                                    </div>                                  
                                </div>
                            </div>
                        </div>                      
                        <div class="col-md-4"></div>
                    </div>

                    <!-- Search Filter -->
                    <div class="row filter-row"> 
                        <div class="col-sm-6 col-md-4"> 
                            <div class="form-group form-focus"><label class="focus-label">Date</label>
                                <div>                                
                                    <input type="date" class="form-control floating" id="date" onchange="filter2(this.value)" onfocus="(this.type = 'date')" onblur="if (!this.value) this.type = 'text'">
                                </div>
                            </div>
                        </div>    
                    </div>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable mb-0" id="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Date </th>
                                            <th>Punch In</th>
                                            <th>Punch Out</th>
                                            <th>Production</th>                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list_attendance}" var="o">
                                            <tr>
                                                <td>${o.id}</td>
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
                </div>
                <!-- /Page Content -->

                <script type="text/javascript">
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

    </body>
</html>