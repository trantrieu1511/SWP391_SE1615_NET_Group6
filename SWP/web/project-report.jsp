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
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Project Reports</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Content Starts -->
                    <!-- Search Filter -->
                    <div class="row filter-row">

                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <div class="cal-icon">
                                    <select class="form-control floating select">
                                        <option>
                                            Name1
                                        </option>
                                        <option>
                                            Name2
                                        </option>
                                    </select>
                                </div>
                                <label class="focus-label">Project Name</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <div class="cal-icon">
                                    <select class="form-control floating select">
                                        <option>
                                            Active
                                        </option>
                                        <option>
                                            Pending
                                        </option>
                                    </select>
                                </div>
                                <label class="focus-label">Status</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">  
                            <a href="#" class="btn btn-success btn-block"> Search </a>  
                        </div>     
                    </div>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table mb-0 datatable">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Project Title</th>
                                            <th>Client Name</th>
                                            <th>Start Date</th>
                                            <th>End Date</th>
                                            <th>Status</th>
                                            <th>Team</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>
                                                <a href="project-view.html">Hospital Administration</a>
                                            </td>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="client-profile.html" class="avatar"><img src="img/profiles/avatar-19.jpg" alt=""></a>
                                                    <a href="client-profile.html">Global Technologies</a>
                                                </h2>
                                            </td>
                                            <td>9 Jan 2021</td>
                                            <td>10 Apr 2021</td>
                                            <td>
                                                <div class="dropdown action-label">
                                                    <a href="#" class="btn btn-white btn-sm btn-rounded"><i class="fa fa-dot-circle-o text-success"></i> Active </a>

                                                </div>
                                            </td>
                                            <td>
                                                <ul class="team-members">
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="John Doe"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="Richard Miles"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="John Smith"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="Mike Litorus"><img alt="" src="img/profiles/avatar-05.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" class="all-users">+15</a>
                                                    </li>
                                                </ul>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>
                                                <a href="project-view.html">Office Management</a>
                                            </td>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="client-profile.html" class="avatar"><img src="img/profiles/avatar-29.jpg" alt=""></a>
                                                    <a href="client-profile.html">Delta Infotech</a>
                                                </h2>
                                            </td>
                                            <td>10 Dec 2021</td>
                                            <td>2 May 2021</td>
                                            <td>
                                                <div class="action-label">
                                                    <a href="" class="btn btn-white btn-sm btn-rounded"><i class="fa fa-dot-circle-o text-success"></i> Active </a>

                                                </div>
                                            </td>
                                            <td>
                                                <ul class="team-members text-nowrap">
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="John Doe"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="Richard Miles"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="John Smith"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                    </li>
                                                    <li>
                                                        <a href="#" title="" data-toggle="tooltip" data-original-title="Mike Litorus"><img alt="" src="img/profiles/avatar-05.jpg"></a>
                                                    </li>
                                                    <li class="dropdown avatar-dropdown">
                                                        <a href="#" class="all-users dropdown-toggle" data-toggle="dropdown" aria-expanded="false">+15</a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <div class="avatar-group">
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-02.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-09.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-10.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-05.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-11.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-12.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-13.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-01.jpg">
                                                                </a>
                                                                <a class="avatar avatar-xs" href="#">
                                                                    <img alt="" src="img/profiles/avatar-16.jpg">
                                                                </a>
                                                            </div>
                                                            <div class="avatar-pagination">
                                                                <ul class="pagination">
                                                                    <li class="page-item">
                                                                        <a class="page-link" href="#" aria-label="Previous">
                                                                            <span aria-hidden="true">«</span>
                                                                            <span class="sr-only">Previous</span>
                                                                        </a>
                                                                    </li>
                                                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                                    <li class="page-item">
                                                                        <a class="page-link" href="#" aria-label="Next">
                                                                            <span aria-hidden="true">»</span>
                                                                            <span class="sr-only">Next</span>
                                                                        </a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </td>



                                        </tr>
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

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>