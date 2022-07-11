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

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="assets/js/html5shiv.min.js"></script>
                <script src="assets/js/respond.min.js"></script>
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
                            <div class="row">
                                <div class="col-sm-12">
                                    <h3 class="page-title">Welcome ${sessionScope.acc.isManager}</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item active">Dashboard</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                            <div class="card dash-widget">
                                <div class="card-body">
                                    <span class="dash-widget-icon"><i class="fa fa-cubes"></i></span>
                                    <div class="dash-widget-info">
                                        <h3>${totalPj}</h3>
                                        <span>Projects</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                            <div class="card dash-widget">
                                <div class="card-body">
                                    <span class="dash-widget-icon"><i class="fa fa-usd"></i></span>
                                    <div class="dash-widget-info">
                                        <h3>${totalClient}</h3>
                                        <span>Clients</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                            <div class="card dash-widget">
                                <div class="card-body">
                                    <span class="dash-widget-icon"><i class="fa fa-diamond"></i></span>
                                    <div class="dash-widget-info">
                                        <h3>${totalTask}</h3>
                                        <span>Tasks</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                            <div class="card dash-widget">
                                <div class="card-body">
                                    <span class="dash-widget-icon"><i class="fa fa-user"></i></span>
                                    <div class="dash-widget-info">
                                        <h3>${totalEmp}</h3>
                                        <span>Employees</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-6 text-center">
                                    <div class="card">
                                        <div class="card-body">
                                            <h3 class="card-title">Total Revenue</h3>
                                            <div id="bar-charts"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 text-center">
                                    <div class="card">
                                        <div class="card-body">
                                            <h3 class="card-title">Sales Overview</h3>
                                            <div id="line-charts"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="card-group m-b-30">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between mb-3">
                                            <div>
                                                <span class="d-block">New Employees</span>
                                            </div>
                                            <div>
                                                <span class="text-success">+10%</span>
                                            </div>
                                        </div>
                                        <h3 class="mb-3">10</h3>
                                        <div class="progress mb-2" style="height: 5px;">
                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 70%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <p class="mb-0">Overall Employees 218</p>
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between mb-3">
                                            <div>
                                                <span class="d-block">Earnings</span>
                                            </div>
                                            <div>
                                                <span class="text-success">+12.5%</span>
                                            </div>
                                        </div>
                                        <h3 class="mb-3">$1,42,300</h3>
                                        <div class="progress mb-2" style="height: 5px;">
                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 70%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <p class="mb-0">Previous Month <span class="text-muted">$1,15,852</span></p>
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between mb-3">
                                            <div>
                                                <span class="d-block">Expenses</span>
                                            </div>
                                            <div>
                                                <span class="text-danger">-2.8%</span>
                                            </div>
                                        </div>
                                        <h3 class="mb-3">$8,500</h3>
                                        <div class="progress mb-2" style="height: 5px;">
                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 70%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <p class="mb-0">Previous Month <span class="text-muted">$7,500</span></p>
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between mb-3">
                                            <div>
                                                <span class="d-block">Profit</span>
                                            </div>
                                            <div>
                                                <span class="text-danger">-75%</span>
                                            </div>
                                        </div>
                                        <h3 class="mb-3">$1,12,000</h3>
                                        <div class="progress mb-2" style="height: 5px;">
                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 70%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <p class="mb-0">Previous Month <span class="text-muted">$1,42,000</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>	
                    </div>

                    <!-- Statistics Widget -->
                    <div class="row">
                        <div class="col-md-12 col-lg-12 col-xl-4 d-flex">
                            <div class="card flex-fill dash-statistics">
                                <div class="card-body">
                                    <h5 class="card-title">Statistics</h5>
                                    <div class="stats-list">
                                        <div class="stats-info">
                                            <p>Today Leave <strong>4 <small>/ 65</small></strong></p>
                                            <div class="progress">
                                                <div class="progress-bar bg-primary" role="progressbar" style="width: 31%" aria-valuenow="31" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="stats-info">
                                            <p>Pending Invoice <strong>15 <small>/ 92</small></strong></p>
                                            <div class="progress">
                                                <div class="progress-bar bg-warning" role="progressbar" style="width: 31%" aria-valuenow="31" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="stats-info">
                                            <p>Completed Projects <strong>85 <small>/ 112</small></strong></p>
                                            <div class="progress">
                                                <div class="progress-bar bg-success" role="progressbar" style="width: 62%" aria-valuenow="62" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="stats-info">
                                            <p>Open Tickets <strong>190 <small>/ 212</small></strong></p>
                                            <div class="progress">
                                                <div class="progress-bar bg-danger" role="progressbar" style="width: 62%" aria-valuenow="62" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="stats-info">
                                            <p>Closed Tickets <strong>22 <small>/ 212</small></strong></p>
                                            <div class="progress">
                                                <div class="progress-bar bg-info" role="progressbar" style="width: 22%" aria-valuenow="22" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12 col-lg-6 col-xl-4 d-flex">
                            <div class="card flex-fill">
                                <div class="card-body">
                                    <h4 class="card-title">Task Statistics</h4>
                                    <div class="statistics">
                                        <div class="row">
                                            <div class="col-md-6 col-6 text-center">
                                                <div class="stats-box mb-4">
                                                    <p>Total Tasks</p>
                                                    <h3>385</h3>
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-6 text-center">
                                                <div class="stats-box mb-4">
                                                    <p>Overdue Tasks</p>
                                                    <h3>19</h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="progress mb-4">
                                        <div class="progress-bar bg-purple" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">30%</div>
                                        <div class="progress-bar bg-warning" role="progressbar" style="width: 22%" aria-valuenow="18" aria-valuemin="0" aria-valuemax="100">22%</div>
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 24%" aria-valuenow="12" aria-valuemin="0" aria-valuemax="100">24%</div>
                                        <div class="progress-bar bg-danger" role="progressbar" style="width: 26%" aria-valuenow="14" aria-valuemin="0" aria-valuemax="100">21%</div>
                                        <div class="progress-bar bg-info" role="progressbar" style="width: 10%" aria-valuenow="14" aria-valuemin="0" aria-valuemax="100">10%</div>
                                    </div>
                                    <div>
                                        <p><i class="fa fa-dot-circle-o text-purple mr-2"></i>Completed Tasks <span class="float-right">166</span></p>
                                        <p><i class="fa fa-dot-circle-o text-warning mr-2"></i>Inprogress Tasks <span class="float-right">115</span></p>
                                        <p><i class="fa fa-dot-circle-o text-success mr-2"></i>On Hold Tasks <span class="float-right">31</span></p>
                                        <p><i class="fa fa-dot-circle-o text-danger mr-2"></i>Pending Tasks <span class="float-right">47</span></p>
                                        <p class="mb-0"><i class="fa fa-dot-circle-o text-info mr-2"></i>Review Tasks <span class="float-right">5</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12 col-lg-6 col-xl-4 d-flex">
                            <div class="card flex-fill">
                                <div class="card-body">
                                    <h4 class="card-title">Today Absent <span class="badge bg-inverse-danger ml-2">5</span></h4>
                                    <div class="leave-info-box">
                                        <div class="media align-items-center">
                                            <a href="profile.html" class="avatar"><img alt="" src="assets/img/user.jpg"></a>
                                            <div class="media-body">
                                                <div class="text-sm my-0">Martin Lewis</div>
                                            </div>
                                        </div>
                                        <div class="row align-items-center mt-3">
                                            <div class="col-6">
                                                <h6 class="mb-0">4 Sep 2019</h6>
                                                <span class="text-sm text-muted">Leave Date</span>
                                            </div>
                                            <div class="col-6 text-right">
                                                <span class="badge bg-inverse-danger">Pending</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="leave-info-box">
                                        <div class="media align-items-center">
                                            <a href="profile.html" class="avatar"><img alt="" src="assets/img/user.jpg"></a>
                                            <div class="media-body">
                                                <div class="text-sm my-0">Martin Lewis</div>
                                            </div>
                                        </div>
                                        <div class="row align-items-center mt-3">
                                            <div class="col-6">
                                                <h6 class="mb-0">4 Sep 2019</h6>
                                                <span class="text-sm text-muted">Leave Date</span>
                                            </div>
                                            <div class="col-6 text-right">
                                                <span class="badge bg-inverse-success">Approved</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="load-more text-center">
                                        <a class="text-dark" href="javascript:void(0);">Load More</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /Statistics Widget -->

                    <div class="row">
                        <div class="col-md-6 d-flex">
                            <div class="card card-table flex-fill">
                                <div class="card-header">
                                    <h3 class="card-title mb-0">Invoices</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-nowrap custom-table mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Invoice ID</th>
                                                    <th>Client</th>
                                                    <th>Due Date</th>
                                                    <th>Total</th>
                                                    <th>Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><a href="invoice-view.html">#INV-0001</a></td>
                                                    <td>
                                                        <h2><a href="#">Global Technologies</a></h2>
                                                    </td>
                                                    <td>11 Mar 2019</td>
                                                    <td>$380</td>
                                                    <td>
                                                        <span class="badge bg-inverse-warning">Partially Paid</span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><a href="invoice-view.html">#INV-0002</a></td>
                                                    <td>
                                                        <h2><a href="#">Delta Infotech</a></h2>
                                                    </td>
                                                    <td>8 Feb 2019</td>
                                                    <td>$500</td>
                                                    <td>
                                                        <span class="badge bg-inverse-success">Paid</span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><a href="invoice-view.html">#INV-0003</a></td>
                                                    <td>
                                                        <h2><a href="#">Cream Inc</a></h2>
                                                    </td>
                                                    <td>23 Jan 2019</td>
                                                    <td>$60</td>
                                                    <td>
                                                        <span class="badge bg-inverse-danger">Unpaid</span>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="invoices.html">View all invoices</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 d-flex">
                            <div class="card card-table flex-fill">
                                <div class="card-header">
                                    <h3 class="card-title mb-0">Payments</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">	
                                        <table class="table custom-table table-nowrap mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Invoice ID</th>
                                                    <th>Client</th>
                                                    <th>Payment Type</th>
                                                    <th>Paid Date</th>
                                                    <th>Paid Amount</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><a href="invoice-view.html">#INV-0001</a></td>
                                                    <td>
                                                        <h2><a href="#">Global Technologies</a></h2>
                                                    </td>
                                                    <td>Paypal</td>
                                                    <td>11 Mar 2019</td>
                                                    <td>$380</td>
                                                </tr>
                                                <tr>
                                                    <td><a href="invoice-view.html">#INV-0002</a></td>
                                                    <td>
                                                        <h2><a href="#">Delta Infotech</a></h2>
                                                    </td>
                                                    <td>Paypal</td>
                                                    <td>8 Feb 2019</td>
                                                    <td>$500</td>
                                                </tr>
                                                <tr>
                                                    <td><a href="invoice-view.html">#INV-0003</a></td>
                                                    <td>
                                                        <h2><a href="#">Cream Inc</a></h2>
                                                    </td>
                                                    <td>Paypal</td>
                                                    <td>23 Jan 2019</td>
                                                    <td>$60</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="payments.html">View all payments</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 d-flex">
                            <div class="card card-table flex-fill">
                                <div class="card-header">
                                    <h3 class="card-title mb-0">Clients</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table custom-table mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listClient}" var="o">
                                                <tr>
                                                    <td>
                                                        <a href="client-profile.html">${o.first_name} ${o.last_name}</a>
                                                    </td>
                                                    <td>${o.email}</td>                                                 
                                                </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="client?do=list">View all clients</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 d-flex">
                            <div class="card card-table flex-fill">
                                <div class="card-header">
                                    <h3 class="card-title mb-0">Recent Projects</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table custom-table mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Project Name </th>
                                                    <th>Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listPT}" var="o"> 
                                                <tr>                                                   
                                                    <td>
                                                        <h2><a href="project?do=view&title=${o[0]}">${o[0]}</a></h2>
                                                        <small class="block text-ellipsis">
                                                            <span>${o[1]}</span> <span class="text-muted">pending tasks, </span>
                                                            <span>${o[2]}</span> <span class="text-muted">tasks completed</span>
                                                        </small>
                                                    </td>
                                                    <td>
                                                        <c:if test="${o[3] == 0}"><div>Pending</div></c:if>
                                                        <c:if test="${o[3] == 1}"><div>Doing</div></c:if>
                                                        <c:if test="${o[3] == 2}"><div>Done</div></c:if>
                                                    </td>                                                 
                                                </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="project?do=list">View all projects</a>
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

        <!-- Chart JS -->
        <script src="plugins/morris/morris.min.js"></script>
        <script src="plugins/raphael/raphael.min.js"></script>
        <script src="js/chart.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>