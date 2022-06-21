<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate;" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    DateFormat df = new SimpleDateFormat("EEE-d-MMM-yyyy");
    String date = df.format(new java.util.Date()).trim();

    public String addOneDay(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE-d-MMM-yyyy");
        LocalDate day = LocalDate.parse(date, df);
        return df.format(day.plusDays(1));
    }
    String date2 = addOneDay(date);
    String date3 = addOneDay(date2);
    String date4 = addOneDay(date3);
    String date5 = addOneDay(date4);
    String date6 = addOneDay(date5);
    String date7 = addOneDay(date6);
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
        <title>Shift & Schedule - HRMS admin template</title>

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
                                <h3 class="page-title">Daily Scheduling</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="employees.html">Employees</a></li>
                                    <li class="breadcrumb-item active">Shift Scheduling</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <a href="schedule?do=shift" class="btn add-btn m-r-5">Shifts</a>
                                <a href="#" class="btn add-btn m-r-5" data-toggle="modal" data-target="#add_schedule"> Assign Shifts</a>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Content Starts -->
                    <!-- Search Filter -->
                    <div class="row filter-row">
                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating">
                                <label class="focus-label">Employee</label>
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-3"> 
                            <div class="form-group form-focus select-focus">
                                <select class="select floating"> 
                                    <option>All Department</option>
                                    <option value="1">Finance</option>
                                    <option value="2">Finance and Management</option>
                                    <option value="3">Hr & Finance</option>
                                    <option value="4">ITech</option>
                                </select>
                                <label class="focus-label">Department</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-2">  
                            <div class="form-group form-focus focused">
                                <div class="cal-icon">
                                    <input class="form-control floating datetimepicker" type="text">
                                </div>
                                <label class="focus-label">From</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-2">  
                            <div class="form-group form-focus focused">
                                <div class="cal-icon">
                                    <input class="form-control floating datetimepicker" type="text">
                                </div>
                                <label class="focus-label">To</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-2">  
                            <a href="#" class="btn btn-success btn-block"> Search </a>  
                        </div>     
                    </div>
                    <!-- Search Filter -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable">
                                    <thead>
                                        <tr>
                                            <th>Scheduled Shift</th>
                                            <th>Date</th>
                                            <th>Shift</th>
                                            <th>From</th>
                                            <th>To</th>                                          
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-02.jpg"></a>
                                                    <a href="profile.html">John Doe <span>Web Designer</span></a>
                                                </h2>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-09.jpg"></a>
                                                    <a href="profile.html">Richard Miles <span>Web Developer</span></a>
                                                </h2>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-10.jpg"></a>
                                                    <a href="profile.html">John Smith <span>Android Developer</span></a>
                                                </h2>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-05.jpg"></a>
                                                    <a href="profile.html">Mike Litorus <span>IOS Developer</span></a>
                                                </h2>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-11.jpg"></a>
                                                    <a href="profile.html">Wilmer Deluna <span>Team Leader</span></a>
                                                </h2>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-12.jpg"></a>
                                                    <a href="profile.html">Jeffrey Warden <span>Web Developer</span></a>
                                                </h2>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>

                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-13.jpg"></a>
                                                    <a href="profile.html">Bernardo Galaviz <span>Web Developer</span></a>
                                                </h2>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <h2>
                                                        <a href="#" data-toggle="modal" data-target="#edit_schedule" style="border:2px dashed #1eb53a">
                                                            <span class="username-info m-b-10">6:30 am - 9:30 pm ( 14 hrs 15 mins)</span>
                                                            <span class="userrole-info">Web Designer - SMARTHR</span>
                                                        </a>
                                                    </h2>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="user-add-shedule-list">
                                                    <a href="#" data-toggle="modal" data-target="#add_schedule">
                                                        <span><i class="fa fa-plus"></i></span>
                                                    </a>
                                                </div>
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

            <!-- Add Schedule Modal -->
            <div id="add_schedule" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add Schedule</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Department <span class="text-danger">*</span></label>
                                            <select class="select">
                                                <option value="">Select</option>
                                                <option value="">Development</option>
                                                <option value="1">Finance</option>
                                                <option value="2">Finance and Management</option>
                                                <option value="3">Hr & Finance</option>
                                                <option value="4">ITech</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Employee Name <span class="text-danger">*</span></label>
                                            <select class="select">
                                                <option value="">Select </option>
                                                <option value="1">Richard Miles </option>
                                                <option value="2">John Smith</option>
                                                <option value="3">Mike Litorus </option>
                                                <option value="4">Wilmer Deluna</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Date</label>
                                            <div class="cal-icon"><input class="form-control datetimepicker" type="text"></div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Shifts <span class="text-danger">*</span></label>
                                            <select class="select">
                                                <option value="">Select </option>
                                                <option value="1">10'o clock Shift</option>
                                                <option value="2">10:30 shift</option>
                                                <option value="3">Daily Shift </option>
                                                <option value="4">New Shift</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Min Start Time  <span class="text-danger">*</span></label>
                                            <div class="input-group time timepicker">
                                                <input class="form-control"><span class="input-group-append input-group-addon"><span class="input-group-text"><i class="fa fa-clock-o"></i></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Start Time  <span class="text-danger">*</span></label>
                                            <div class="input-group time timepicker">
                                                <input class="form-control"><span class="input-group-append input-group-addon"><span class="input-group-text"><i class="fa fa-clock-o"></i></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Max Start Time  <span class="text-danger">*</span></label>
                                            <div class="input-group time timepicker">
                                                <input class="form-control"><span class="input-group-append input-group-addon"><span class="input-group-text"><i class="fa fa-clock-o"></i></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Min End Time  <span class="text-danger">*</span></label>
                                            <div class="input-group time timepicker">
                                                <input class="form-control"><span class="input-group-append input-group-addon"><span class="input-group-text"><i class="fa fa-clock-o"></i></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">End Time   <span class="text-danger">*</span></label>
                                            <div class="input-group time timepicker">
                                                <input class="form-control"><span class="input-group-append input-group-addon"><span class="input-group-text"><i class="fa fa-clock-o"></i></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Max End Time <span class="text-danger">*</span></label>
                                            <div class="input-group time timepicker">
                                                <input class="form-control"><span class="input-group-append input-group-addon"><span class="input-group-text"><i class="fa fa-clock-o"></i></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Break Time  <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text">
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Accept Extra Hours </label>
                                            <div class="custom-control custom-switch">
                                                <input type="checkbox" class="custom-control-input" id="customSwitch1" checked="">
                                                <label class="custom-control-label" for="customSwitch1"></label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Publish </label>
                                            <div class="custom-control custom-switch">
                                                <input type="checkbox" class="custom-control-input" id="customSwitch2" checked="">
                                                <label class="custom-control-label" for="customSwitch2"></label>
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
            <!-- /Add Schedule Modal -->

            <!-- Edit Schedule Modal -->
            <div id="edit_schedule" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Schedule</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Department <span class="text-danger">*</span></label>
                                            <select class="select">
                                                <option value="">Select</option>
                                                <option selected value="">Development</option>
                                                <option value="1">Finance</option>
                                                <option value="2">Finance and Management</option>
                                                <option value="3">Hr & Finance</option>
                                                <option value="4">ITech</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Employee Name <span class="text-danger">*</span></label>
                                            <select class="select">
                                                <option value="">Select </option>
                                                <option selected value="1">Richard Miles </option>
                                                <option value="2">John Smith</option>
                                                <option value="3">Mike Litorus </option>
                                                <option value="4">Wilmer Deluna</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Date <span class="text-danger">*</span></label>
                                            <div class="cal-icon"><input class="form-control datetimepicker" type="text"></div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Shifts <span class="text-danger">*</span></label>
                                            <select class="select">
                                                <option value="">Select </option>
                                                <option value="1">10'o clock Shift</option>
                                                <option value="2">10:30 shift</option>
                                                <option value="3">Daily Shift </option>
                                                <option  selected value="4">New Shift</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Min Start Time  <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="06:11 am">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Start Time  <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="06:30 am">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Max Start Time  <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="08:12 am">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Min End Time  <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="09:12 pm">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">End Time   <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="09:30 pm">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Max End Time <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="09:45 pm">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Break Time  <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" value="45">
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                                            <label class="custom-control-label" for="customCheck1">Recurring Shift</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Repeat Every</label>
                                            <select class="select">
                                                <option value="">1 </option>
                                                <option value="1">2</option>
                                                <option value="2">3</option>
                                                <option value="3">4</option>
                                                <option  selected value="4">5</option>
                                                <option value="3">6</option>
                                            </select>
                                            <label class="col-form-label">Week(s)</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group wday-box">

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="monday" class="days recurring" checked="" onclick="return false;"><span class="checkmark">M</span></label>

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="tuesday" class="days recurring" checked="" onclick="return false;"><span class="checkmark">T</span></label>

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="wednesday" class="days recurring" checked="" onclick="return false;"><span class="checkmark">W</span></label>

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="thursday" class="days recurring" checked="" onclick="return false;"><span class="checkmark">T</span></label>

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="friday" class="days recurring" checked="" onclick="return false;"><span class="checkmark">F</span></label>

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="saturday" class="days recurring" onclick="return false;"><span class="checkmark">S</span></label>

                                            <label class="checkbox-inline"><input type="checkbox" name="week_days[]" value="sunday" class="days recurring" onclick="return false;"><span class="checkmark">S</span></label>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-form-label">End On <span class="text-danger">*</span></label>
                                            <div class="cal-icon"><input class="form-control datetimepicker" type="text"></div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck2">
                                            <label class="custom-control-label" for="customCheck2">Indefinite</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Accept Extra Hours </label>
                                            <div class="custom-control custom-switch">
                                                <input type="checkbox" class="custom-control-input" id="customSwitch3" checked="">
                                                <label class="custom-control-label" for="customSwitch3"></label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Publish </label>
                                            <div class="custom-control custom-switch">
                                                <input type="checkbox" class="custom-control-input" id="customSwitch4" checked="">
                                                <label class="custom-control-label" for="customSwitch4"></label>
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
            <!-- /Edit Schedule Modal -->
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

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>