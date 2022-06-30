<%-- 
    Document   : profile.jsp
    Created on : Jun 11, 2022, 4:15:49 PM
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
        <title>Employee Profile - HRMS admin template</title>

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

        <!-- Datetimepicker CSS -->
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

        <!-- Tagsinput CSS -->
        <link rel="stylesheet" href="plugins/bootstrap-tagsinput/bootstrap-tagsinput.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/edit.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="assets/js/html5shiv.min.js"></script>
                <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            $(function () {
                $("#edit_family_info").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var id = myArray[0];
                    var cur_name = $(e.relatedTarget).attr('data-name');
                    var relationship = myArray[1];
                    var dob = myArray[2];
                    var phone = myArray[3];
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
                    $(e.currentTarget).find('input[name="name"]').val(cur_name);
                    $(e.currentTarget).find('input[name="cur_name"]').val(cur_name);
                    $(e.currentTarget).find('input[name="relationship"]').val(relationship);
                    $(e.currentTarget).find('input[name="dob"]').val(dob);
                    $(e.currentTarget).find('input[name="phone"]').val(phone);
                });
            });
            $(function () {
                $("#edit_experience_info").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var cur_role = $(e.relatedTarget).attr('data-role');
                    var id = myArray[0];
                    var start_date = myArray[1];
                    var end_date = myArray[2];
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
                    $(e.currentTarget).find('input[name="cur_role"]').val(cur_role);
                    $(e.currentTarget).find('input[name="role"]').val(cur_role);
                    $(e.currentTarget).find('input[name="start_date"]').val(start_date);
                    $(e.currentTarget).find('input[name="end_date"]').val(end_date);
                });
            });

            $(function () {
                $("#delete_family_info").on("show.bs.modal", function (e) {
                    var id = $(e.relatedTarget).attr('data-id');
                    var name = $(e.relatedTarget).attr('data-name');
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
                    $(e.currentTarget).find('input[name="name"]').val(name);
                });
            });

            $(function () {
                $("#delete_experience").on("show.bs.modal", function (e) {
                    var id = $(e.relatedTarget).attr('data-id');
                    var role = $(e.relatedTarget).attr('data-role');
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
                    $(e.currentTarget).find('input[name="role"]').val(role);
                });
            });
            $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            })

            function checkEditPfInfo() {
                if (document.getElementById('address1').value != "") {
                    alert("Edit successfully!")
                } else {
                    alert("Cannot input blank, please enter all values!");
                }
            }
//            function codeAddress() {
//                alert('ok');
//            }
//            window.onload = codeAddress;

        </script>
        <c:if test="${alert != ''}">
            <script type="text/javascript">
                alert("${alert}");
            </script>
        </c:if>

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
                                <div class="col-sm-12">
                                    <h3 class="page-title">Profile</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="employee-dashboard.jsp">Dashboard</a></li>
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
                                                    <a href="#"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                </div>
                                            </div>
                                            <div class="profile-basic">
                                                <div class="row">
                                                <c:forEach items="${listp}" var="p">
                                                    <div class="col-md-5">
                                                        <div class="profile-info-left">
                                                            <h3 class="user-name m-t-0 mb-0">${p.first_name} ${p.last_name}</h3>
                                                            <h6 class="text-muted">${p.department_name}</h6>
                                                            <small class="text-muted">${p.job_title}</small>
                                                            <div class="staff-id">Employee ID : ${p.profile_id}</div>
                                                            <div class="small doj text-muted">Date of Join : ${p.hire_date}</div>
                                                            <!--<div class="staff-msg"><a class="btn btn-custom" href="chat.html">Send Message</a></div>-->
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                                <div class="col-md-7">
                                                    <ul class="personal-info">
                                                        <c:forEach items="${listp}" var="p">
                                                            <c:forEach items="${listpd}" var="pd">
                                                                <li>
                                                                    <div class="title">Phone:</div>
                                                                    <c:choose>
                                                                        <c:when test="${p.phone_number == ''}">
                                                                            <div class="text">N/A</div>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <div class="text">${p.phone_number}</a></div>
                                                                            </c:otherwise> 
                                                                        </c:choose>
                                                                </li>
                                                                <li>
                                                                    <div class="title">Email:</div>
                                                                    <div class="text">${p.email}</a></div>
                                                                </li>
                                                                <li>
                                                                    <div class="title">Birthday:</div>
                                                                    <div class="text">${pd.dob}</div>
                                                                </li>
                                                                <li>
                                                                    <div class="title">Address:</div>
                                                                    <div class="text">${pd.address}</div>
                                                                </li>
                                                                <li>
                                                                    <div class="title">Gender:</div>
                                                                    <c:choose>
                                                                        <c:when test="${pd.gender == true}">
                                                                            <div class="text">Male</div>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <div class="text">Female</div>
                                                                        </c:otherwise> 
                                                                    </c:choose>
                                                                </li>
                                                                <li>
                                                                    <c:choose>
                                                                        <c:when test="${p.reportto == null}">
                                                                            <div class="title">Reports to:</div>
                                                                            <div class="text">N/A</div>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <div class="title">Reports to:</div>
                                                                            <div class="text">
                                                                                <div class="avatar-box">
                                                                                    <div class="avatar avatar-xs">
                                                                                        <img src="img/profiles/avatar-16.jpg" alt="">
                                                                                    </div>
                                                                                </div>
                                                                                <c:choose>
                                                                                    <c:when test="${(p.reportto!=sessionScope.acc.profile_id)}">
                                                                                        <a href="profile?do=getothersProfile&profile_id=${p.reportto}">
                                                                                            ${p.reportto}
                                                                                        </a>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <a href="profile?do=getmyProfile">
                                                                                            ${p.reportto}
                                                                                        </a>    
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </div>
                                                                        </c:otherwise> 
                                                                    </c:choose>
                                                                </li>
                                                            </c:forEach>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <c:forEach items="${listp}" var="p">
                                            <c:choose>
                                                <c:when test="${p.reportto!=null || sessionScope.acc.isManager==true}">
                                                    <div class="pro-edit"><a data-target="#profile_info" data-toggle="modal" class="edit-icon" href="#" ><i class="fa fa-pencil"></i></a></div>
                                                        </c:when>
                                                        <c:otherwise>

                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--            <div class="card tab-box">
                                    <div class="row user-tabs">
                                        <div class="col-lg-12 col-md-12 col-sm-12 line-tabs">
                                            <ul class="nav nav-tabs nav-tabs-bottom">
                                                <li class="nav-item"><a href="#emp_profile" data-toggle="tab" class="nav-link active">Profile</a></li>
                                                <li class="nav-item"><a href="#emp_projects" data-toggle="tab" class="nav-link">Projects</a></li>
                                                <li class="nav-item"><a href="#bank_statutory" data-toggle="tab" class="nav-link">Bank & Statutory <small class="text-danger">(Admin Only)</small></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>-->

                    <div class="tab-content">

                        <!-- Profile Info Tab -->
                        <div id="emp_profile" class="pro-overview tab-pane fade show active">
                            <div class="row">
                                <div class="col-md-6 d-flex">
                                    <div class="card profile-box flex-fill">
                                        <div class="card-body">
                                            <h3 class="card-title">Personal Informations 
                                                <c:forEach items="${listp}" var="p">
                                                    <c:choose>
                                                        <c:when test="${p.reportto != null || sessionScope.acc.isManager==true}">
                                                            <a href="#" class="edit-icon" data-toggle="modal" data-target="#personal_info_modal"><i class="fa fa-pencil"></i></a>
                                                            </c:when>
                                                            <c:otherwise>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>


                                            </h3>
                                            <ul class="personal-info">
                                                <!--                                        <li>
                                                                                            <div class="title">Passport No.</div>
                                                                                            <div class="text">9876543210</div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="title">Passport Exp Date.</div>
                                                                                            <div class="text">9876543210</div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="title">Tel</div>
                                                                                            <div class="text"><a href="">9876543210</a></div>
                                                                                        </li>-->
                                                <c:forEach items="${listpd}" var="pd">
                                                    <li>
                                                        <div class="title">Nationality</div>
                                                        <div class="text">${pd.country}</div>
                                                    </li>
                                                    <li>
                                                        <div class="title">Religion</div>
                                                        <div class="text">${pd.religion}</div>
                                                    </li>
                                                    <li>
                                                        <div class="title">Marital status</div>
                                                        <c:choose>
                                                            <c:when test="${pd.isMarried == true}">
                                                                <div class="text">Married</div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="text">Single</div>
                                                            </c:otherwise> 
                                                        </c:choose>
                                                    </li>
                                                    <!--                                                <li>
                                                                                                        <div class="title">Employment of spouse</div>
                                                                                                        <div class="text">No</div>
                                                                                                    </li>-->
                                                    <li>
                                                        <div class="title">No. of children</div>
                                                        <div class="text">${pd.children}</div>
                                                    </li>
                                                    <li><h4 style="margin-top: 30px; margin-bottom: 20px;">Bank information</h4><li>

                                                    <li>
                                                        <div class="title">Bank name</div>
                                                        <div class="text">${pd.bank_name}</div>
                                                    </li>
                                                    <li>
                                                        <div class="title">Bank account No.</div>
                                                        <div class="text">${pd.bank_number}</div>
                                                    </li>
                                                </c:forEach>
                                                <!--                                        <li>
                                                                                            <div class="title">IFSC Code</div>
                                                                                            <div class="text">ICI24504</div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="title">PAN No</div>
                                                                                            <div class="text">TC000Y56</div>
                                                                                        </li>-->
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 d-flex">
                                    <div class="card profile-box flex-fill">
                                        <div class="card-body">
                                            <h3 class="card-title">Emergency Contact</h3>
                                            <!--<h5 class="section-title">Primary</h5>-->
                                            <ul class="personal-info">
                                                <c:forEach items="${listf}" var="f">
                                                    <hr>
                                                    <li>
                                                        <div class="title">Name</div>
                                                        <div class="text">${f.name}</div>
                                                    </li>
                                                    <li>
                                                        <div class="title">Relationship</div>
                                                        <div class="text">${f.relationship}</div>
                                                    </li>
                                                    <li>
                                                        <div class="title">Phone </div>
                                                        <div class="text">${f.phone}</div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                            <hr>
                                            <!--                                        <h5 class="section-title">Secondary</h5>
                                                                                    <ul class="personal-info">
                                                                                        <li>
                                                                                            <div class="title">Name</div>
                                                                                            <div class="text"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="title">Relationship</div>
                                                                                            <div class="text"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="title">Phone </div>
                                                                                            <div class="text"></div>
                                                                                        </li>
                                                                                    </ul>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <!--                        <div class="col-md-6 d-flex">
                                                            <div class="card profile-box flex-fill">
                                                                <div class="card-body">
                                                                    <h3 class="card-title">Bank information</h3>
                                                                    <ul class="personal-info">
                                                                        <li>
                                                                            <div class="title">Bank name</div>
                                                                            <div class="text">ICICI Bank</div>
                                                                        </li>
                                                                        <li>
                                                                            <div class="title">Bank account No.</div>
                                                                            <div class="text">159843014641</div>
                                                                        </li>
                                                                        <li>
                                                                            <div class="title">IFSC Code</div>
                                                                            <div class="text">ICI24504</div>
                                                                        </li>
                                                                        <li>
                                                                            <div class="title">PAN No</div>
                                                                            <div class="text">TC000Y56</div>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <div class="col-md-6 d-flex">
                                    <div class="card profile-box flex-fill">
                                        <div class="card-body">
                                            <h3 class="card-title">Experience 
                                                <c:forEach items="${listp}" var="p">
                                                    <c:choose>
                                                        <c:when test="${p.reportto!=null || sessionScope.acc.isManager==true}">
                                                            <a href="#" class="edit-icon" data-toggle="modal" data-target="#add_experience_info"><i class="fa fa-pencil"></i></a>

                                                        </c:when>
                                                        <c:otherwise>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>

                                            </h3>
                                            <div class="experience-box">
                                                <ul class="experience-list">
                                                    <c:forEach items="${listexp}" var="e">
                                                        <li>
                                                            <div class="experience-user">
                                                                <div class="before-circle"></div>
                                                            </div>
                                                            <div class="experience-content">
                                                                <div class="timeline-content">
                                                                    <a href="#/" class="name">${e.role}</a>
                                                                    <span class="time">${e.start_date} - Present (${e.end_date})</span>
                                                                    <c:forEach items="${listp}" var="p">
                                                                        <c:choose>
                                                                            <c:when test="${p.reportto!=null || sessionScope.acc.isManager==true}">
                                                                                <!--<a href="#" class="edit-icon" data-toggle="modal" data-target="#add_family_info_modal"><i class="fa fa-pencil"></i></a>-->
                                                                                <td class="text-right">
                                                                                    <div class="dropdown dropdown-action" style="text-align: right;">
                                                                                        <a aria-expanded="false" data-toggle="dropdown" class="action-icon dropdown-toggle" href="#"><i class="material-icons">more_vert</i></a>
                                                                                        <div class="dropdown-menu dropdown-menu-right">
                                                                                            <a href="#" class="dropdown-item" data-id="${e.profile_id} ${e.start_date} ${e.end_date}" data-role="${e.role}" data-toggle="modal" data-target="#edit_experience_info"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                                            <a href="#" class="dropdown-item" data-id="${e.profile_id}" data-role="${e.role}" data-toggle="modal" data-target="#delete_experience"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                                                        </div>
                                                                                    </div>
                                                                                </td>
                                                                            </c:when>
                                                                            <c:otherwise>

                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 d-flex">
                                    <div class="card profile-box flex-fill">
                                        <div class="card-body">
                                            <h3 class="card-title">Family Informations 
                                                <c:forEach items="${listp}" var="p">
                                                    <c:choose>
                                                        <c:when test="${p.reportto!=null || sessionScope.acc.isManager==true}">
                                                            <a href="#" class="edit-icon" data-toggle="modal" data-target="#add_family_info_modal"><i class="fa fa-pencil"></i></a>

                                                        </c:when>
                                                        <c:otherwise>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>

                                            </h3>
                                            <div class="table-responsive">
                                                <table class="table table-nowrap">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>Relationship</th>
                                                            <th>Date of Birth</th>
                                                            <th>Phone</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listf}" var="f">
                                                            <tr>
                                                                <td>${f.name}</td>
                                                                <td>${f.relationship}</td>
                                                                <c:choose>
                                                                    <c:when test="${!f.dob.equals('')}">
                                                                        <td>${f.dob}</td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <td>N/A</td>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <td>${f.phone}</td>
                                                                <c:forEach items="${listp}" var="p">
                                                                    <c:choose>
                                                                        <c:when test="${p.reportto!=null || sessionScope.acc.isManager==true}">
                                                                            <!--<a href="#" class="edit-icon" data-toggle="modal" data-target="#family_info_modal"><i class="fa fa-pencil"></i></a>-->
                                                                            <td class="text-right">
                                                                                <div class="dropdown dropdown-action">
                                                                                    <a aria-expanded="false" data-toggle="dropdown" class="action-icon dropdown-toggle" href="#"><i class="material-icons">more_vert</i></a>
                                                                                    <div class="dropdown-menu dropdown-menu-right">
                                                                                        <a href="#" class="dropdown-item" data-toggle="modal" data-id="${f.profile_id} ${f.relationship} ${f.dob} ${f.phone}" data-name="${f.name}" data-target="#edit_family_info"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                                        <a href="#" class="dropdown-item" data-id="${f.profile_id}" data-name="${f.name}" data-toggle="modal" data-target="#delete_family_info"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                                                    </div>
                                                                                </div>
                                                                            </td>
                                                                        </c:when>
                                                                        <c:otherwise>

                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4 d-flex">
                                    <div class="card profile-box flex-fill">
                                        <div class="card-body">
                                            <h3 class="card-title">Account</h3>
                                            <div class="personal-info">
                                                <ul class="personal-info">
                                                    <c:forEach items="${listacc}" var="acc">
                                                        <li>
                                                            <div class="title" style="margin-right: 0px">Username:</div>
                                                            <div class="text">${acc.user}</div>
                                                        </li>
                                                        <li>
                                                            <div class="title" style="margin-right: 0px">Password</div>
                                                            <c:choose>
                                                                <c:when test="${acc.pass!=sessionScope.acc.pass}">
                                                                    <div class="text">*************************</div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="text">${acc.pass}</div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!-- /Profile Info Tab -->

                        <!-- Projects Tab -->
                        <!--            <div class="tab-pane fade" id="emp_projects">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="dropdown profile-action">
                                                            <a aria-expanded="false" data-toggle="dropdown" class="action-icon dropdown-toggle" href="#"><i class="material-icons">more_vert</i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a data-target="#edit_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                <a data-target="#delete_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                                                                    <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="assets/img/profiles/avatar-16.jpg"></a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="project-members m-b-15">
                                                            <div>Team :</div>
                                                            <ul class="team-members">
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="assets/img/profiles/avatar-02.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="assets/img/profiles/avatar-09.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="assets/img/profiles/avatar-10.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="assets/img/profiles/avatar-05.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" class="all-users">+15</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                        <div class="progress progress-xs mb-0">
                                                            <div style="width: 40%" title="" data-toggle="tooltip" role="progressbar" class="progress-bar bg-success" data-original-title="40%"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                        
                                            <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="dropdown profile-action">
                                                            <a aria-expanded="false" data-toggle="dropdown" class="action-icon dropdown-toggle" href="#"><i class="material-icons">more_vert</i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a data-target="#edit_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                <a data-target="#delete_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                                                                    <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="assets/img/profiles/avatar-16.jpg"></a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="project-members m-b-15">
                                                            <div>Team :</div>
                                                            <ul class="team-members">
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="assets/img/profiles/avatar-02.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="assets/img/profiles/avatar-09.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="assets/img/profiles/avatar-10.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="assets/img/profiles/avatar-05.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" class="all-users">+15</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                        <div class="progress progress-xs mb-0">
                                                            <div style="width: 40%" title="" data-toggle="tooltip" role="progressbar" class="progress-bar bg-success" data-original-title="40%"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                        
                                            <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="dropdown profile-action">
                                                            <a aria-expanded="false" data-toggle="dropdown" class="action-icon dropdown-toggle" href="#"><i class="material-icons">more_vert</i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a data-target="#edit_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                <a data-target="#delete_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                                                                    <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="assets/img/profiles/avatar-16.jpg"></a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="project-members m-b-15">
                                                            <div>Team :</div>
                                                            <ul class="team-members">
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="assets/img/profiles/avatar-02.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="assets/img/profiles/avatar-09.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="assets/img/profiles/avatar-10.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="assets/img/profiles/avatar-05.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" class="all-users">+15</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                        <div class="progress progress-xs mb-0">
                                                            <div style="width: 40%" title="" data-toggle="tooltip" role="progressbar" class="progress-bar bg-success" data-original-title="40%"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                        
                                            <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="dropdown profile-action">
                                                            <a aria-expanded="false" data-toggle="dropdown" class="action-icon dropdown-toggle" href="#"><i class="material-icons">more_vert</i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a data-target="#edit_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                <a data-target="#delete_project" data-toggle="modal" href="#" class="dropdown-item"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                                                                    <a href="#" data-toggle="tooltip" title="Jeffery Lalor"><img alt="" src="assets/img/profiles/avatar-16.jpg"></a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="project-members m-b-15">
                                                            <div>Team :</div>
                                                            <ul class="team-members">
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Doe"><img alt="" src="assets/img/profiles/avatar-02.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Richard Miles"><img alt="" src="assets/img/profiles/avatar-09.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="John Smith"><img alt="" src="assets/img/profiles/avatar-10.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" data-toggle="tooltip" title="Mike Litorus"><img alt="" src="assets/img/profiles/avatar-05.jpg"></a>
                                                                </li>
                                                                <li>
                                                                    <a href="#" class="all-users">+15</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <p class="m-b-5">Progress <span class="text-success float-right">40%</span></p>
                                                        <div class="progress progress-xs mb-0">
                                                            <div style="width: 40%" title="" data-toggle="tooltip" role="progressbar" class="progress-bar bg-success" data-original-title="40%"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>-->
                        <!-- /Projects Tab -->

                        <!-- Bank Statutory Tab -->
                        <!--            <div class="tab-pane fade" id="bank_statutory">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title"> Basic Salary Information</h3>
                                                <form>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Salary basis <span class="text-danger">*</span></label>
                                                                <select class="select">
                                                                    <option>Select salary basis type</option>
                                                                    <option>Hourly</option>
                                                                    <option>Daily</option>
                                                                    <option>Weekly</option>
                                                                    <option>Monthly</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Salary amount <small class="text-muted">per month</small></label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span class="input-group-text">$</span>
                                                                    </div>
                                                                    <input type="text" class="form-control" placeholder="Type your salary amount" value="0.00">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Payment type</label>
                                                                <select class="select">
                                                                    <option>Select payment type</option>
                                                                    <option>Bank transfer</option>
                                                                    <option>Check</option>
                                                                    <option>Cash</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <h3 class="card-title"> PF Information</h3>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">PF contribution</label>
                                                                <select class="select">
                                                                    <option>Select PF contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">PF No. <span class="text-danger">*</span></label>
                                                                <select class="select">
                                                                    <option>Select PF contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Employee PF rate</label>
                                                                <select class="select">
                                                                    <option>Select PF contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Additional rate <span class="text-danger">*</span></label>
                                                                <select class="select">
                                                                    <option>Select additional rate</option>
                                                                    <option>0%</option>
                                                                    <option>1%</option>
                                                                    <option>2%</option>
                                                                    <option>3%</option>
                                                                    <option>4%</option>
                                                                    <option>5%</option>
                                                                    <option>6%</option>
                                                                    <option>7%</option>
                                                                    <option>8%</option>
                                                                    <option>9%</option>
                                                                    <option>10%</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Total rate</label>
                                                                <input type="text" class="form-control" placeholder="N/A" value="11%">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Employee PF rate</label>
                                                                <select class="select">
                                                                    <option>Select PF contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Additional rate <span class="text-danger">*</span></label>
                                                                <select class="select">
                                                                    <option>Select additional rate</option>
                                                                    <option>0%</option>
                                                                    <option>1%</option>
                                                                    <option>2%</option>
                                                                    <option>3%</option>
                                                                    <option>4%</option>
                                                                    <option>5%</option>
                                                                    <option>6%</option>
                                                                    <option>7%</option>
                                                                    <option>8%</option>
                                                                    <option>9%</option>
                                                                    <option>10%</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Total rate</label>
                                                                <input type="text" class="form-control" placeholder="N/A" value="11%">
                                                            </div>
                                                        </div>
                                                    </div>
                        
                                                    <hr>
                                                    <h3 class="card-title"> ESI Information</h3>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">ESI contribution</label>
                                                                <select class="select">
                                                                    <option>Select ESI contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">ESI No. <span class="text-danger">*</span></label>
                                                                <select class="select">
                                                                    <option>Select ESI contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Employee ESI rate</label>
                                                                <select class="select">
                                                                    <option>Select ESI contribution</option>
                                                                    <option>Yes</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Additional rate <span class="text-danger">*</span></label>
                                                                <select class="select">
                                                                    <option>Select additional rate</option>
                                                                    <option>0%</option>
                                                                    <option>1%</option>
                                                                    <option>2%</option>
                                                                    <option>3%</option>
                                                                    <option>4%</option>
                                                                    <option>5%</option>
                                                                    <option>6%</option>
                                                                    <option>7%</option>
                                                                    <option>8%</option>
                                                                    <option>9%</option>
                                                                    <option>10%</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">Total rate</label>
                                                                <input type="text" class="form-control" placeholder="N/A" value="11%">
                                                            </div>
                                                        </div>
                                                    </div>
                        
                                                    <div class="submit-section">
                                                        <button class="btn btn-primary submit-btn" type="submit">Save</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>-->
                        <!-- /Bank Statutory Tab -->

                    </div>
                </div>
                <!-- /Page Content -->

                <!-- Profile Modal -->
                <div id="profile_info" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Profile Information</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="profileDetail" method="post">
                                    <input type="hidden" name="do" value="editProfileInfo">
                                    <div class="row">
                                        <c:forEach items="${listp}" var="p">
                                            <c:forEach items="${listpd}" var="pd">
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
                                        </c:forEach>
                                    </c:forEach>
                                    <div class="submit-section">
                                        <input type="submit" class="btn btn-primary submit-btn" id="create" value="submit">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Profile Modal -->

                <!-- Personal Info Modal -->
                <div id="personal_info_modal" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Personal Information</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="profileDetail" method="post">
                                    <input type="hidden" name="do" value="editPersonalInfo">
                                    <c:forEach items="${listpd}" var="pd">
                                        <input type="hidden" name="profile_id" value="${pd.profile_id}">
                                        <div class="row">

                                            <!--                                        <div class="col-md-6">
                                                                                        <div class="form-group">
                                                                                            <label>Tel</label>
                                                                                            <input class="form-control" type="text">
                                                                                        </div>
                                                                                    </div>-->
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Nationality <span class="text-danger">*</span></label>
                                                    <input class="form-control" type="text" name="country" value="${pd.country}" required="" pattern="[A-Za-z ]{1,20}"
                                                           title="Nationality not contain: Unicode characters, 
                                                           special character e.g: !@#$%^&,. etc.. ; 
                                                           allow uppercase, lowercase letters,
                                                           allow spacing and numeric characters (0-9),
                                                           max length: 20">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Religion <span class="text-danger">*</span></label>
                                                    <div class="form-group">
                                                        <input class="form-control" type="text" name="religion" value="${pd.religion}" required="" pattern="[A-Za-z ]{1,20}"
                                                               title="Religion not contain: Unicode characters, 
                                                               special character e.g: !@#$%^&,. etc.. ; 
                                                               allow uppercase, lowercase letters,
                                                               allow spacing and numeric characters (0-9),
                                                               max length: 20">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Marital status <span class="text-danger">*</span></label>
                                                    <select class="select form-control" name="isMarried">
                                                        <option value="false" ${pd.isMarried==false ? "selected" : ''} >Single</option>
                                                        <option value="true" ${pd.isMarried==true ? "selected" : ''} >Married</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>No. of children </label>
                                                    <input class="form-control" type="text" name="children" value="${pd.children}" pattern="[0-9]{1,2}"
                                                           title="No. of children  
                                                           must be numeric characters (0-9), not allow spacing characters
                                                           max length: 2">
                                                </div>
                                            </div>
                                        </div>
                                        <h4 style="margin-bottom: 20px;">Bank Information</h4>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Bank name <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" name="bank_name" value="${pd.bank_name}" required="" pattern="[A-Za-z ]{1,20}"
                                                           title="Bank name not contain: Unicode characters, 
                                                           special character e.g: !@#$%^&,. etc.. ; 
                                                           allow uppercase, lowercase letters,
                                                           allow spacing and numeric characters (0-9),
                                                           max length: 20">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Bank account No. <span class="text-danger">*</span></label>
                                                    <div class="form-group">
                                                        <input class="form-control" name="bank_number" type="text" value="${pd.bank_number}" required="" pattern="[0-9]{12}"
                                                               title="Bank account No. not allow:  
                                                               special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                               only allow and numeric characters (0-9),
                                                               max length: 12">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Personal Info Modal -->

                <!-- Add Family Info Modal -->
                <div id="add_family_info_modal" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Family Informations</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="familyInfo" method="post">
                                    <div class="form-scroll" style="padding-bottom: 150px;">
                                        <input type="hidden" name="do" value="addFamilyInfo">

                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Add Family Member 
                                                    <!--<a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a>-->
                                                </h3>
                                                <div class="row">
                                                    <c:forEach items="${listp}" var="p">
                                                        <input type="hidden" name="profile_id" value="${p.profile_id}">
                                                    </c:forEach>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Name <span class="text-danger">*</span></label>
                                                            <input class="form-control" type="text" name="name" value="" required placeholder="enter family member name" pattern="[A-Za-z ]{1,50}"
                                                                   title="Name of family member not contain: Unicode characters, 
                                                                   special character e.g: !@#$%^& etc.. and  
                                                                   numeric character: 0-9; max length: 20 and allow spacing characters">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Relationship <span class="text-danger">*</span></label>
                                                            <input class="form-control" type="text" name="relationship" value="" required placeholder="enter family member relationship" pattern="[A-Za-z ]{1,20}"
                                                                   title="Relationship of family member not contain: Unicode characters, 
                                                                   special character e.g: !@#$%^& etc.. and 
                                                                   numeric character: 0-9; max length: 20 and allow spacing characters">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Date of birth </label>
                                                            <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="dob" value="" placeholder="pick a date of birth" onkeydown="event.preventDefault()" pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Phone <span class="text-danger">*</span></label>
                                                            <input class="form-control" type="text" name="phone" value="" required placeholder="enter phone number of 10 numbers" title="phone number must be 10-digit number" pattern="[0-9]{10}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!--                                    <div class="card">
                                                                                <div class="card-body">
                                                                                    <h3 class="card-title">Education Informations <a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a></h3>
                                                                                    <div class="row">
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Name <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Relationship <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Date of birth <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Phone <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="add-more">
                                                                                        <a href="javascript:void(0);"><i class="fa fa-plus-circle"></i> Add More</a>
                                                                                    </div>
                                                                                </div>-->
                                    </div>
                                    <div class="submit-section" style="margin-bottom: 25px;">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Add Family Info Modal -->

                <!-- Edit Family Info Modal -->
                <div id="edit_family_info" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Family Informations</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="familyInfo">
                                    <div class="form-scroll" style="padding-bottom: 150px;">
                                        <input type="hidden" name="do" value="editFamilyInfo">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Edit Family Member 
                                                    <!--<a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a>-->
                                                </h3>
                                                <div class="row">
                                                    <input type="hidden" name="profile_id" value="">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Name <span class="text-danger">*</span></label>
                                                            <input class="form-control" type="text" name="name" value="" required="" placeholder="enter family member name" pattern="[A-Za-z ]{1,50}"
                                                                   title="Name of family member not contain: Unicode characters, 
                                                                   special character e.g: !@#$%^& etc.. and  
                                                                   numeric character: 0-9; max length: 20 and allow spacing characters">
                                                            <input class="form-control" type="hidden" name="cur_name" value="">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Relationship <span class="text-danger">*</span></label>
                                                            <input class="form-control" type="text" name="relationship" value="" required="" placeholder="enter family member relationship" pattern="[A-Za-z ]{1,20}"
                                                                   title="Name of family member not contain: Unicode characters, 
                                                                   special character e.g: !@#$%^& etc.. and  
                                                                   numeric character: 0-9; max length: 20 and allow spacing characters">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Date of birth </label>
                                                            <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="dob" value="" placeholder="pick a date of birth" onkeydown="event.preventDefault()" pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Phone <span class="text-danger">*</span></label>
                                                            <input class="form-control" type="text" name="phone" value="" required="" placeholder="enter phone number of 10 numbers" title="phone number must be 10-digit number" pattern="[0-9]{10}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!--                                    <div class="card">
                                                                                <div class="card-body">
                                                                                    <h3 class="card-title">Education Informations <a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a></h3>
                                                                                    <div class="row">
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Name <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Relationship <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Date of birth <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group">
                                                                                                <label>Phone <span class="text-danger">*</span></label>
                                                                                                <input class="form-control" type="text">
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="add-more">
                                                                                        <a href="javascript:void(0);"><i class="fa fa-plus-circle"></i> Add More</a>
                                                                                    </div>
                                                                                </div>-->
                                    </div>
                                    <div class="submit-section" style="margin-bottom: 25px;">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Family Info Modal -->

                <!-- Emergency Contact Modal -->
                <div id="emergency_contact_modal" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Personal Information</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="card">
                                        <div class="card-body">
                                            <h3 class="card-title">Primary Contact</h3>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Name <span class="text-danger">*</span></label>
                                                        <input type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Relationship <span class="text-danger">*</span></label>
                                                        <input class="form-control" type="text">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Phone <span class="text-danger">*</span></label>
                                                        <input class="form-control" type="text">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Phone 2</label>
                                                        <input class="form-control" type="text">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card">
                                        <div class="card-body">
                                            <h3 class="card-title">Primary Contact</h3>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Name <span class="text-danger">*</span></label>
                                                        <input type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Relationship <span class="text-danger">*</span></label>
                                                        <input class="form-control" type="text">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Phone <span class="text-danger">*</span></label>
                                                        <input class="form-control" type="text">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Phone 2</label>
                                                        <input class="form-control" type="text">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Emergency Contact Modal -->

                <!-- Education Modal -->
                <div id="education_info" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title"> Education Informations</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-scroll">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Education Informations <a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a></h3>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="Oxford University" class="form-control floating">
                                                            <label class="focus-label">Institution</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="Computer Science" class="form-control floating">
                                                            <label class="focus-label">Subject</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <div class="cal-icon">
                                                                <input type="text" value="01/06/2002" class="form-control floating datetimepicker">
                                                            </div>
                                                            <label class="focus-label">Starting Date</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <div class="cal-icon">
                                                                <input type="text" value="31/05/2006" class="form-control floating datetimepicker">
                                                            </div>
                                                            <label class="focus-label">Complete Date</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="BE Computer Science" class="form-control floating">
                                                            <label class="focus-label">Degree</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="Grade A" class="form-control floating">
                                                            <label class="focus-label">Grade</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Education Informations <a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a></h3>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="Oxford University" class="form-control floating">
                                                            <label class="focus-label">Institution</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="Computer Science" class="form-control floating">
                                                            <label class="focus-label">Subject</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <div class="cal-icon">
                                                                <input type="text" value="01/06/2002" class="form-control floating datetimepicker">
                                                            </div>
                                                            <label class="focus-label">Starting Date</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <div class="cal-icon">
                                                                <input type="text" value="31/05/2006" class="form-control floating datetimepicker">
                                                            </div>
                                                            <label class="focus-label">Complete Date</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="BE Computer Science" class="form-control floating">
                                                            <label class="focus-label">Degree</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus focused">
                                                            <input type="text" value="Grade A" class="form-control floating">
                                                            <label class="focus-label">Grade</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="add-more">
                                                    <a href="javascript:void(0);"><i class="fa fa-plus-circle"></i> Add More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Education Modal -->

                <!-- Add Experience Modal -->
                <div id="add_experience_info" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Experience Informations</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="experience">
                                    <div class="form-scroll" style="padding-bottom: 150px">
                                        <input type="hidden" name="do" value="addExperience">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Add Experience Informations 
                                                    <!--<a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a>-->
                                                </h3>
                                                <div class="row">
                                                    <c:forEach items="${listp}" var="p">
                                                        <input type="hidden" name="profile_id" value="${p.profile_id}">
                                                    </c:forEach>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="">Role <span class="text-danger">*</span></label>
                                                            <input type="text" class="form-control" name="role" value="" required="" pattern="[A-Za-z0-9 ]{1,100}" placeholder="Enter your experience here"
                                                                   title="Role not contain: Unicode characters, 
                                                                   special character e.g: !@#$%^& etc..; max length: 100, 
                                                                   allow spacing, numeric characters (0-9), uppercase and lowercase letters">
                                                        </div>
                                                    </div>
                                                    <!--                                                <div class="col-md-6">
                                                                                                        <div class="form-group form-focus">
                                                                                                            <input type="text" class="form-control floating" value="United States">
                                                                                                            <label class="focus-label">Location</label>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="col-md-6">
                                                                                                        <div class="form-group form-focus">
                                                                                                            <input type="text" class="form-control floating" value="Web Developer">
                                                                                                            <label class="focus-label">Job Position</label>
                                                                                                        </div>
                                                                                                    </div>-->
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <div class="form-group">
                                                                <label class="">Period From <span class="text-danger">*</span></label>
                                                                <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="start_date" value="" placeholder="pick a start date" onkeydown="event.preventDefault()" required="" pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <div class="form-group">
                                                                <label class="">Period To</label>
                                                                <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="end_date" value="" placeholder="pick a end date" onkeydown="event.preventDefault()" pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!--                                    <div class="card">
                                                                                <div class="card-body">
                                                                                    <h3 class="card-title">Experience Informations <a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a></h3>
                                                                                    <div class="row">
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <input type="text" class="form-control floating" value="Digital Devlopment Inc">
                                                                                                <label class="focus-label">Company Name</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <input type="text" class="form-control floating" value="United States">
                                                                                                <label class="focus-label">Location</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <input type="text" class="form-control floating" value="Web Developer">
                                                                                                <label class="focus-label">Job Position</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <div class="cal-icon">
                                                                                                    <input type="text" class="form-control floating datetimepicker" value="01/07/2007">
                                                                                                </div>
                                                                                                <label class="focus-label">Period From</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <div class="cal-icon">
                                                                                                    <input type="text" class="form-control floating datetimepicker" value="08/06/2018">
                                                                                                </div>
                                                                                                <label class="focus-label">Period To</label>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="add-more">
                                                                                        <a href="javascript:void(0);"><i class="fa fa-plus-circle"></i> Add More</a>
                                                                                    </div>
                                                                                </div>
                                                                            </div>-->
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Add Experience Modal -->

                <!-- Edit Experience Modal -->
                <div id="edit_experience_info" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Experience Informations</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="experience" method="post">
                                    <div class="form-scroll" style="padding-bottom: 150px">
                                        <input type="hidden" name="do" value="editExperience">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Edit Experience Informations 
                                                    <!--<a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a>-->
                                                </h3>
                                                <div class="row">
                                                    <input type="hidden" name="profile_id" value="">
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <input type="text" class="form-control floating" required="" value="" placeholder="Enter your experience here" name="role" pattern="[A-Za-z0-9 ]{1,100}"
                                                                   title="Role not contain: Unicode characters, 
                                                                   special character e.g: !@#$%^& etc..; max length: 100, 
                                                                   allow spacing, numeric characters (0-9), uppercase and lowercase letters">
                                                            <input type="hidden" class="form-control floating" name="cur_role" value="">
                                                            <label class="focus-label">Role <span class="text-danger">*</span></label>
                                                        </div>
                                                    </div>
                                                    <!--                                                <div class="col-md-6">
                                                                                                        <div class="form-group form-focus">
                                                                                                            <input type="text" class="form-control floating" value="United States">
                                                                                                            <label class="focus-label">Location</label>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="col-md-6">
                                                                                                        <div class="form-group form-focus">
                                                                                                            <input type="text" class="form-control floating" value="Web Developer">
                                                                                                            <label class="focus-label">Job Position</label>
                                                                                                        </div>
                                                                                                    </div>-->
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <div class="form-group">
                                                                <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="start_date" value="" placeholder="pick a start date" onkeydown="event.preventDefault()" required pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                            </div>
                                                            <label class="focus-label">Period From <span class="text-danger">*</span></label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <div class="form-group">
                                                                <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="end_date" value="" placeholder="pick a end date" onkeydown="event.preventDefault()" pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                                            </div>
                                                            <label class="focus-label">Period To</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!--                                    <div class="card">
                                                                                <div class="card-body">
                                                                                    <h3 class="card-title">Experience Informations <a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a></h3>
                                                                                    <div class="row">
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <input type="text" class="form-control floating" value="Digital Devlopment Inc">
                                                                                                <label class="focus-label">Company Name</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <input type="text" class="form-control floating" value="United States">
                                                                                                <label class="focus-label">Location</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <input type="text" class="form-control floating" value="Web Developer">
                                                                                                <label class="focus-label">Job Position</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <div class="cal-icon">
                                                                                                    <input type="text" class="form-control floating datetimepicker" value="01/07/2007">
                                                                                                </div>
                                                                                                <label class="focus-label">Period From</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group form-focus">
                                                                                                <div class="cal-icon">
                                                                                                    <input type="text" class="form-control floating datetimepicker" value="08/06/2018">
                                                                                                </div>
                                                                                                <label class="focus-label">Period To</label>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="add-more">
                                                                                        <a href="javascript:void(0);"><i class="fa fa-plus-circle"></i> Add More</a>
                                                                                    </div>
                                                                                </div>
                                                                            </div>-->
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Experience Modal -->

                <!-- View Experience Modal -->
                <div id="view_experience_info" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Experience Informations</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-scroll">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title">Experience Informations 
                                                    <!--<a href="javascript:void(0);" class="delete-icon"><i class="fa fa-trash-o"></i></a>-->
                                                </h3>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <input type="text" class="form-control floating" value="Digital Devlopment Inc">
                                                            <label class="focus-label">Company Name</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <input type="text" class="form-control floating" value="United States">
                                                            <label class="focus-label">Location</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <input type="text" class="form-control floating" value="Web Developer">
                                                            <label class="focus-label">Job Position</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <div class="cal-icon">
                                                                <input type="text" class="form-control floating datetimepicker" value="01/07/2007">
                                                            </div>
                                                            <label class="focus-label">Period From</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-focus">
                                                            <div class="cal-icon">
                                                                <input type="text" class="form-control floating datetimepicker" value="08/06/2018">
                                                            </div>
                                                            <label class="focus-label">Period To</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- View Experience Modal -->

                <!-- Delete Family Info Modal -->
                <div class="modal custom-modal fade" id="delete_family_info" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form action="familyInfo" do="post">
                                    <input type="hidden" name="do" value="deleteFamilyInfo">
                                    <input type="hidden" name="profile_id">
                                    <input type="hidden" name="name">
                                    <div class="form-header">
                                        <h3>Delete Family Info</h3>
                                        <p>Are you sure want to delete?</p>
                                    </div>
                                    <div class="modal-btn delete-action">
                                        <div class="row">
                                            <div class="col-6">
                                                <input type="submit" value="Delete" href="" class="btn btn-primary continue-btn" style="padding: 10px 75px;">
                                            </div>
                                            <div class="col-6">
                                                <a href="javascript:void(0);" data-dismiss="modal" class="btn btn-primary cancel-btn">Cancel</a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Delete Family Info Modal -->

                <!-- Delete Experience Modal -->
                <div class="modal custom-modal fade" id="delete_experience" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form action="experience" do="post">
                                    <input type="hidden" name="do" value="deleteExperience">
                                    <input type="hidden" name="profile_id">
                                    <input type="hidden" name="role">
                                    <div class="form-header">
                                        <h3>Delete Experience</h3>
                                        <p>Are you sure want to delete?</p>
                                    </div>
                                    <div class="modal-btn delete-action">
                                        <div class="row">
                                            <div class="col-6">
                                                <input type="submit" value="Delete" href="" class="btn btn-primary continue-btn" style="padding: 10px 75px;">
                                            </div>
                                            <div class="col-6">
                                                <a href="javascript:void(0);" data-dismiss="modal" class="btn btn-primary cancel-btn">Cancel</a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Delete Experience Modal -->

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

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Tagsinput JS -->
        <script src="plugins/bootstrap-tagsinput/bootstrap-tagsinput.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>
