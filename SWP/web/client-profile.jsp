<%-- 
    Document   : client-profile
    Created on : Jun 29, 2022, 8:14:36 PM
    Author     : DELL
--%>

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
        <title>Client Profile - HRMS admin template</title>

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
        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="js/jquery.slimscroll.min.js"></script>

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Task JS -->
        <script src="js/task.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </head>
    <body>

        <jsp:include page="menu.jsp"></jsp:include>

            <!-- Page Wrapper -->
            <div class="page-wrapper">

                <!-- Page Content -->
                <div class="content container-fluid">

                    <!-- Page Header -->
                    <div class="page-header">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="page-title">Client Profile</h3>
                                <ul class="breadcrumb">
                                    <!--                                <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>-->
                                    <li class="breadcrumb-item active">Profile</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <div class="card mb-0">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="profile-view">
                                        <div class="profile-img-wrap">
                                            <div class="profile-img">
                                                <a href="">
                                                    <img src="img/profiles/avatar-19.jpg" alt="">
                                                </a>
                                            </div>
                                        </div>
                                        <div class="profile-basic">
                                            <div class="row">
                                                <div class="col-md-5">
                                                    <div class="profile-info-left">
                                                    <c:forEach items="${listcp}" var="cp">
                                                        <h3 class="user-name m-t-0">${cp.company_name}</h3>
                                                        <h5 class="company-role m-t-0 mb-0">${cp.first_name} ${cp.last_name}</h5>
                                                        <!--                                                        <small class="text-muted">CEO</small>-->
                                                        <div class="staff-id">Employee ID : ${cp.client_id}</div>
                                                    </c:forEach>
                                                    <!--                                                    <div class="staff-msg"><a href="chat.html" class="btn btn-custom">Send Message</a></div>-->
                                                </div>
                                            </div>
                                            <div class="col-md-7">
                                                <ul class="personal-info">
                                                    <c:forEach items="${listcp}" var="cp">
                                                        <li>
                                                            <span class="title">Phone:</span>
                                                            <c:choose>
                                                                <c:when test="${cp.phone_number.equals('')}">
                                                                    <span class="text">N/A</span>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span class="text">${cp.phone_number}</span>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                        </li>
                                                        <li>
                                                            <span class="title">Email:</span>
                                                            <span class="text">${cp.email}</span>
                                                        </li>
                                                    </c:forEach>
                                                    <li>
                                                        <span class="title">Birthday:</span>
                                                        <span class="text">2nd August</span>
                                                    </li>
                                                    <li>
                                                        <span class="title">Address:</span>
                                                        <span class="text">5754 Airport Rd, Coosada, AL, 36020</span>
                                                    </li>
                                                    <li>
                                                        <span class="title">Gender:</span>
                                                        <span class="text">Male</span>
                                                    </li>
                                                </ul>
                                            </div>
                                            <c:choose>
                                                <c:when test="${sessionScope.acc.isManager==true}">
                                                    <div class="pro-edit"><a data-target="#client_profile_info" data-toggle="modal" class="edit-icon" href="#" ><i class="fa fa-pencil"></i></a></div>
                                                        </c:when>
                                                        <c:otherwise>

                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card tab-box">
                    <div class="row user-tabs">
                        <div class="col-lg-12 col-md-12 col-sm-12 line-tabs">
                            <ul class="nav nav-tabs nav-tabs-bottom">
                                <li class="nav-item col-sm-3"><a class="nav-link active" data-toggle="tab" href="#myprojects">Projects</a></li>
                                <li class="nav-item col-sm-3"><a class="nav-link" data-toggle="tab" href="#tasks">Tasks</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12"> 
                        <div class="tab-content profile-tab-content">

                            <!-- Projects Tab -->
                            <div id="myprojects" class="tab-pane fade show active">
                                <div class="row">
                                    <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="dropdown profile-action">
                                                    <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_project"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_project"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                    </div>
                                                </div>
                                                <h4 class="project-title"><a href="project-view.html">Office Management</a></h4>
                                                <small class="block text-ellipsis m-b-15">
                                                    <span class="text-xs">1</span> <span class="text-muted">open tasks, </span>
                                                    <span class="text-xs">9</span> <span class="text-muted">tasks completed</span>
                                                </small>
                                                <p class="text-muted">Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. When an unknown printer took a galley of type and
                                                    scrambled it...
                                                </p>
                                                <div class="pro-deadline m-b-15">
                                                    <div class="sub-title">
                                                        Deadline:
                                                    </div>
                                                    <div class="text-muted">
                                                        17 Apr 2019
                                                    </div>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Project Leader :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="img/profiles/avatar-16.jpg"></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Team :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="img/profiles/avatar-05.jpg"></a>
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
                                                </div>
                                                <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                <div class="progress progress-xs mb-0">
                                                    <div class="progress-bar bg-success" role="progressbar" data-toggle="tooltip" title="40%" style="width: 40%"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="dropdown profile-action">
                                                    <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_project"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_project"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                    </div>
                                                </div>
                                                <h4 class="project-title"><a href="project-view.html">Project Management</a></h4>
                                                <small class="block text-ellipsis m-b-15">
                                                    <span class="text-xs">2</span> <span class="text-muted">open tasks, </span>
                                                    <span class="text-xs">5</span> <span class="text-muted">tasks completed</span>
                                                </small>
                                                <p class="text-muted">Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. When an unknown printer took a galley of type and
                                                    scrambled it...
                                                </p>
                                                <div class="pro-deadline m-b-15">
                                                    <div class="sub-title">
                                                        Deadline:
                                                    </div>
                                                    <div class="text-muted">
                                                        17 Apr 2019
                                                    </div>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Project Leader :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="img/profiles/avatar-16.jpg"></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Team :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="img/profiles/avatar-05.jpg"></a>
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
                                                </div>
                                                <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                <div class="progress progress-xs mb-0">
                                                    <div class="progress-bar bg-success" role="progressbar" data-toggle="tooltip" title="40%" style="width: 40%"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="dropdown profile-action">
                                                    <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_project"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_project"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                    </div>
                                                </div>
                                                <h4 class="project-title"><a href="project-view.html">Video Calling App</a></h4>
                                                <small class="block text-ellipsis m-b-15">
                                                    <span class="text-xs">3</span> <span class="text-muted">open tasks, </span>
                                                    <span class="text-xs">3</span> <span class="text-muted">tasks completed</span>
                                                </small>
                                                <p class="text-muted">Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. When an unknown printer took a galley of type and
                                                    scrambled it...
                                                </p>
                                                <div class="pro-deadline m-b-15">
                                                    <div class="sub-title">
                                                        Deadline:
                                                    </div>
                                                    <div class="text-muted">
                                                        17 Apr 2019
                                                    </div>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Project Leader :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="img/profiles/avatar-16.jpg"></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Team :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="img/profiles/avatar-05.jpg"></a>
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
                                                </div>
                                                <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                <div class="progress progress-xs mb-0">
                                                    <div class="progress-bar bg-success" role="progressbar" data-toggle="tooltip" title="40%" style="width: 40%"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="dropdown profile-action">
                                                    <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_project"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_project"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                    </div>
                                                </div>
                                                <h4 class="project-title"><a href="project-view.html">Hospital Administration</a></h4>
                                                <small class="block text-ellipsis m-b-15">
                                                    <span class="text-xs">12</span> <span class="text-muted">open tasks, </span>
                                                    <span class="text-xs">4</span> <span class="text-muted">tasks completed</span>
                                                </small>
                                                <p class="text-muted">Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. When an unknown printer took a galley of type and
                                                    scrambled it...
                                                </p>
                                                <div class="pro-deadline m-b-15">
                                                    <div class="sub-title">
                                                        Deadline:
                                                    </div>
                                                    <div class="text-muted">
                                                        17 Apr 2019
                                                    </div>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Project Leader :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="img/profiles/avatar-16.jpg"></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="project-members m-b-15">
                                                    <div>Team :</div>
                                                    <ul class="team-members">
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                        </li>
                                                        <li>
                                                            <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="img/profiles/avatar-05.jpg"></a>
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
                                                </div>
                                                <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                <div class="progress progress-xs mb-0">
                                                    <div class="progress-bar bg-success" role="progressbar" data-toggle="tooltip" title="40%" style="width: 40%"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /Projects Tab -->

                            <!-- Task Tab -->
                            <div id="tasks" class="tab-pane fade">
                                <div class="project-task">
                                    <ul class="nav nav-tabs nav-tabs-top nav-justified mb-0">
                                        <li class="nav-item"><a class="nav-link active" href="#all_tasks" data-toggle="tab" aria-expanded="true">All Tasks</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#pending_tasks" data-toggle="tab" aria-expanded="false">Pending Tasks</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#completed_tasks" data-toggle="tab" aria-expanded="false">Completed Tasks</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane show active" id="all_tasks">
                                            <div class="task-wrapper">
                                                <div class="task-list-container">
                                                    <div class="task-list-body">
                                                        <ul id="task-list">
                                                            <li class="task">
                                                                <div class="task-container">
                                                                    <span class="task-action-btn task-check">
                                                                        <span class="action-circle large complete-btn" title="Mark Complete">
                                                                            <i class="material-icons">check</i>
                                                                        </span>
                                                                    </span>
                                                                    <span class="task-label" contenteditable="true">Patient appointment booking</span>
                                                                    <span class="task-action-btn task-btn-right">
                                                                        <span class="action-circle large" title="Assign">
                                                                            <i class="material-icons">person_add</i>
                                                                        </span>
                                                                        <span class="action-circle large delete-btn" title="Delete Task">
                                                                            <i class="material-icons">delete</i>
                                                                        </span>
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li class="task">
                                                                <div class="task-container">
                                                                    <span class="task-action-btn task-check">
                                                                        <span class="action-circle large complete-btn" title="Mark Complete">
                                                                            <i class="material-icons">check</i>
                                                                        </span>
                                                                    </span>
                                                                    <span class="task-label" contenteditable="true">Appointment booking with payment gateway</span>
                                                                    <span class="task-action-btn task-btn-right">
                                                                        <span class="action-circle large" title="Assign">
                                                                            <i class="material-icons">person_add</i>
                                                                        </span>
                                                                        <span class="action-circle large delete-btn" title="Delete Task">
                                                                            <i class="material-icons">delete</i>
                                                                        </span>
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li class="completed task">
                                                                <div class="task-container">
                                                                    <span class="task-action-btn task-check">
                                                                        <span class="action-circle large complete-btn" title="Mark Complete">
                                                                            <i class="material-icons">check</i>
                                                                        </span>
                                                                    </span>
                                                                    <span class="task-label">Doctor available module</span>
                                                                    <span class="task-action-btn task-btn-right">
                                                                        <span class="action-circle large" title="Assign">
                                                                            <i class="material-icons">person_add</i>
                                                                        </span>
                                                                        <span class="action-circle large delete-btn" title="Delete Task">
                                                                            <i class="material-icons">delete</i>
                                                                        </span>
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li class="task">
                                                                <div class="task-container">
                                                                    <span class="task-action-btn task-check">
                                                                        <span class="action-circle large complete-btn" title="Mark Complete">
                                                                            <i class="material-icons">check</i>
                                                                        </span>
                                                                    </span>
                                                                    <span class="task-label" contenteditable="true">Patient and Doctor video conferencing</span>
                                                                    <span class="task-action-btn task-btn-right">
                                                                        <span class="action-circle large" title="Assign">
                                                                            <i class="material-icons">person_add</i>
                                                                        </span>
                                                                        <span class="action-circle large delete-btn" title="Delete Task">
                                                                            <i class="material-icons">delete</i>
                                                                        </span>
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li class="task">
                                                                <div class="task-container">
                                                                    <span class="task-action-btn task-check">
                                                                        <span class="action-circle large complete-btn" title="Mark Complete">
                                                                            <i class="material-icons">check</i>
                                                                        </span>
                                                                    </span>
                                                                    <span class="task-label" contenteditable="true">Private chat module</span>
                                                                    <span class="task-action-btn task-btn-right">
                                                                        <span class="action-circle large" title="Assign">
                                                                            <i class="material-icons">person_add</i>
                                                                        </span>
                                                                        <span class="action-circle large delete-btn" title="Delete Task">
                                                                            <i class="material-icons">delete</i>
                                                                        </span>
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li class="task">
                                                                <div class="task-container">
                                                                    <span class="task-action-btn task-check">
                                                                        <span class="action-circle large complete-btn" title="Mark Complete">
                                                                            <i class="material-icons">check</i>
                                                                        </span>
                                                                    </span>
                                                                    <span class="task-label" contenteditable="true">Patient Profile add</span>
                                                                    <span class="task-action-btn task-btn-right">
                                                                        <span class="action-circle large" title="Assign">
                                                                            <i class="material-icons">person_add</i>
                                                                        </span>
                                                                        <span class="action-circle large delete-btn" title="Delete Task">
                                                                            <i class="material-icons">delete</i>
                                                                        </span>
                                                                    </span>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="task-list-footer">
                                                        <div class="new-task-wrapper">
                                                            <textarea  id="new-task" placeholder="Enter new task here. . ."></textarea>
                                                            <span class="error-message hidden">You need to enter a task first</span>
                                                            <span class="add-new-task-btn btn" id="add-task">Add Task</span>
                                                            <span class="btn" id="close-task-panel">Close</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="pending_tasks"></div>
                                        <div class="tab-pane" id="completed_tasks"></div>
                                    </div>
                                </div>
                            </div>
                            <!-- /Task Tab -->

                        </div>
                    </div>
                </div>
            </div>
            <!-- /Page Content -->

            <!--Client Profile Modal -->
            <div id="client_profile_info" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Profile Information</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="client" method="post">
                                <input type="hidden" name="do" value="editClientProfileInfo">
                                <div class="row">
                                    <%--<c:forEach items="${listp}" var="p">--%>
                                    <%--<c:forEach items="${listpd}" var="pd">--%>
                                    <input type="hidden" name="profile_id" value="${p.profile_id}">
                                    <div class="col-md-12">
                                        <div class="profile-img-wrap edit-img">
                                            <img class="inline-block" src="img/profiles/avatar-02.jpg" alt="user">
                                            <div class="fileupload btn">
                                                <span class="btn-text">edit</span>
                                                <input class="upload" type="file">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <input type="text" class="form-control" value="${p.first_name}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <input type="text" class="form-control" value="${p.last_name}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Birth Date <span class="text-danger">*</span></label>
                                                    <div class="form-group">
                                                        <div class="cal-icon"><input class="form-control datetimepicker" name="dob" type="text" onkeydown="event.preventDefault()" required="" value="${pd.dob}" pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Gender <span class="text-danger">*</span></label>
                                                    <select class="select form-control" name="gender">
                                                        <option value="true" ${pd.gender==true ? "selected" : ''}>Male</option>
                                                        <option value="false" ${pd.gender==false ? "selected" : ''}>Female</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Address <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="address1" name="address" required="" value="${pd.address}" pattern="[A-Za-z0-9., ]{1,100}"
                                                   title="Address not contain: Unicode characters, 
                                                   special character e.g: !@#$%^&,. etc..;  
                                                   allow uppercase, lowercase letters, 
                                                   allow spacing and numeric characters (0-9), max length: 100">
                                        </div>
                                    </div>
                                    <!--                                            <div class="col-md-6">
                                                                                    <div class="form-group">
                                                                                        <label>State</label>
                                                                                        <input type="text" class="form-control" value="New York">
                                                                                    </div>
                                                                                </div>-->
                                    <!--                                            <div class="col-md-6">
                                                                                    <div class="form-group">
                                                                                        <label>Pin Code</label>
                                                                                        <input type="text" class="form-control" value="10523">
                                                                                    </div>
                                                                                </div>-->
                                    <c:choose>
                                        <c:when test="${p.phone_number == ''}">

                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Phone Number</label>
                                                    <input type="text" class="form-control" value="${p.phone_number}" readonly>
                                                </div>
                                            </div>
                                        </c:otherwise> 
                                    </c:choose>

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Department</label>
                                            <input type="text" class="form-control" value="${p.department_name}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Designation</label>
                                            <input type="text" class="form-control" value="${p.job_title}" readonly>
                                        </div>
                                    </div>
                                    <c:choose>
                                        <c:when test="${p.reportto!=null}">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Reports to</label>
                                                    <input type="text" class="form-control" value="${p.reportto}" readonly>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>

                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <%--</c:forEach>--%>
                                <%--</c:forEach>--%>
                                <div class="submit-section">
                                    <input type="submit" class="btn btn-primary submit-btn" id="create" value="submit">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Client Profile Modal -->

        </div>
        <!-- /Page Wrapper -->


    </body>
</html>
