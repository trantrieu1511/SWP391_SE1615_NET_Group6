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
        <title>Reports - HRMS admin template</title>

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

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">

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
                                    <h3 class="page-title">Project Reports</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="dashboard?do=manager">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Project Reports</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- /Page Header -->

                        <!-- Content Starts -->

                        <!-- Search Filter -->
                        <div class="row filter-row">
                            <div class="col-sm-6 col-md-3">Project name</div>
                            <div class="col-sm-6 col-md-3">Status</div>
                        </div>
                        <form action="report" do="post">
                            <input type="hidden" name="do" value="searchProjectReport">
                            <div class="row filter-row">
                                <div class="col-sm-6 col-md-3">  
                                    <input class="form-control floating" name="name" id="name" type="text" pattern="[A-Za-z]{1,20}" value="${name}">
                                </div>
                                <div class="col-sm-6 col-md-3">                               
                                    <select class="form-control floating select" name="status" id="status">
                                        <option value="" disabled selected hidden></option>
                                        <option value="All">
                                            All
                                        </option>
                                        <option value="0">
                                            Pending
                                        </option>
                                        <option value="1">
                                            Doing
                                        </option>
                                        <option value="2">
                                            Done
                                        </option>
                                    </select>
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
                                    <thead>
                                        <tr>
                                            <th>Project Title</th>
                                            <th>Client Name</th>
                                            <th>Period</th>
                                            <th>Status</th>
                                            <th>Manager</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
                                            <tr>
                                                <td>
                                                    <a href="project?do=view&title=${o.title}">${o.title}</a>
                                                </td>
                                                <td>                                             
                                                    <a>${o.client}</a>                                     
                                                </td>
                                                <td>${o.period}</td>
                                                <td>
                                                    <c:if test="${o.status == 0}"><div>Pending</div></c:if>
                                                    <c:if test="${o.status == 1}"><div>Doing</div></c:if>
                                                    <c:if test="${o.status == 2}"><div>Done</div></c:if>
                                                    </td>    
                                                    <td>${o.manager}</td>
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

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="js/jquery.slimscroll.min.js"></script>
        
        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
            <c:if test="${status != 'Status'}">
                $("#status").val(${status});
            </c:if>
                $("#status").select2({
                    width: '100%',
                    allowClear: false,
                    minimumResultsForSearch: -1
                });
            });
            $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            })
        </script>

    </body>
</html>