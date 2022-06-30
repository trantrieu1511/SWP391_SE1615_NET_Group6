<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>Daily Report - HRMS admin template</title>

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
        
        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

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
                            <div class="col">
                                <h3 class="page-title">Daily Report</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Daily Report</li>
                                </ul>
                            </div>
                            <div class="col-auto">
                                <button class="btn btn-primary" id="dl-pdf">PDF</button>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Content Starts -->
                    <div class="row justify-content-center">
                        <div class="col-md-3 col-sm-6">
                            <div class="card">
                                <div class="card-body text-center">
                                    <h3><b>${totalEmployee}</b></h3>
                                    <p>Total Employees</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="card">
                                <div class="card-body text-center">
                                    <h3 class="text-success"><b>${present}</b></h3>
                                    <p>Today Present</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="card">
                                <div class="card-body text-center">
                                    <h3 class="text-danger"><b>${absent}</b></h3>
                                    <p>Today Absent</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Search Filter -->
                    <form action="report" do="post">
                        <input type="hidden" name="do" value="searchDailyReport">
                        <div class="row filter-row mb-4">
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input class="form-control floating" name="name" type="text">
                                    <label class="focus-label">${nameFilter}</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3"> 
                                <div class="form-group form-focus select-focus">
                                    <select class="select floating" name="department" id="department"> 
                                        <option value="" disabled selected hidden></option>
                                        <c:forEach items="${listDepartment}" var="o">
                                            <option value="${o.id}">${o.name}</option>  
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">                                  
                            </div>                            
                            <div class="col-sm-6 col-md-3">  
                                <button class="btn btn-success btn-block"> Search </button>  
                            </div>     
                        </div>
                    </form>
                    <!-- /Search Filter -->
                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table mb-0 datatable">
                                    <c:if test="${filter == 'yes'}">
                                        <h4><a href="report?do=daily" style="text-decoration: none; color: grey"> <-- back</a></h4>
                                    </c:if>
                                    <thead>
                                        <tr>
                                            <th>Employee</th>
                                            <th>Date</th>
                                            <th>Department</th>
                                            <th class="text-center">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
                                        <tr>
                                            <td>
                                                <a href="profile.html">${o[1]}</a>
                                            </td>
                                            <td>${o[2]}</td>
                                            <td>${o[3]}</td>
                                            <td class="text-center">
                                                <c:if test="${o[4] == 'Absent'}">
                                                    <a style="color:red;">Absent</a>
                                                </c:if>
                                                <c:if test="${o[4] == 'Present'}">
                                                    <a style="color:green;">Present</a>
                                                </c:if>                                                
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div hidden>
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table" id="PDF">
                                    <thead>
                                        <tr>
                                            <th>Employee</th>
                                            <th>Date</th>
                                            <th>Department</th>
                                            <th class="text-center">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
                                        <tr>
                                            <td>
                                                <a>${o[1]}</a>
                                            </td>
                                            <td>${o[2]}</td>
                                            <td>${o[3]}</td>
                                            <td class="text-center">
                                                <c:if test="${o[4] == 'Absent'}">
                                                    <a style="color:red;">Absent</a>
                                                </c:if>
                                                <c:if test="${o[4] == 'Present'}">
                                                    <a style="color:green;">Present</a>
                                                </c:if>                                                
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- /Content End -->

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

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        
        <!-- PDF JS -->
        <script src="js/html2pdf.bundle.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>
        <script type="text/javascript">
            document.getElementById('dl-pdf').onclick = function() {
                var element = document.getElementById('PDF');
                element.className = "table";
                
                var opt = {
                    margin: 1,
                    filename: 'daily-report.pdf',
                    image: { type: 'jpeg', quality: 0.98 },
                    html2canvas: { scale: 2 },
                    jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
                };
                
                html2pdf(element, opt);
            }
            $( document ).ready(function() {
            <c:if test="${departmentFilter != 'select a department'}">
                            $("#department").val(${departmentFilter});
            </c:if>
                $("#department").select2({
                        width: '100%',
                        placeholder: "${departmentFilter}",
                        allowClear: false
                    });
                });            
        </script>

    </body>
</html>