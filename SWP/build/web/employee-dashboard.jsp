<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords"
              content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
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

    </head>

    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

            <div class="page-wrapper">

                <!-- Page Content -->
                <div class="content container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="welcome-box">
                                <div class="welcome-img">
                                    <img alt="" src="assets/img/profiles/avatar-02.jpg">
                                </div>
                                <div class="welcome-det">
                                    <h3>Welcome, ${name}</h3>
                                    <p>${date}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-8 col-md-8">
                            <section class="dash-section">
                                <h1 class="dash-sec-title">Your schedule</h1>
                                <div class="dash-sec-content">
                                    <div class="dash-info-list">
                                        <table class="table table-striped custom-table mb-0">
                                            <thead>
                                                <tr>
                                                    <td>Shift</td>
                                                    <td>Start</td>
                                                    <td>End</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${schedule}" var="o">
                                                    <tr>
                                                        <td>${o.name}</td>
                                                        <td>${o.start_time}</td>
                                                        <td>${o.end_time}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>                                           
                                        </table>                                        
                                    </div>
                                </div>
                            </section>

                            <section class="dash-section">
                                <h1 class="dash-sec-title">Your tasks</h1>
                                <div class="dash-sec-content">
                                    <div class="dash-info-list">
                                        <div class="kanban-board card mb-0">
                                            <div class="card-body">
                                                <div class="kanban-cont">
                                                    <div class="kanban-list kanban-danger">
                                                        <div class="kanban-header">
                                                            <span class="status-title">Pending</span>
                                                        </div>
                                                        <div class="kanban-wrap">
                                                            <c:forEach items="${list0}" var="o">
                                                                <div class="card panel">
                                                                    <div class="kanban-box">
                                                                        <div class="task-board-header">
                                                                            <span class="status-title">${o.name}</span>                                                                         
                                                                        </div>
                                                                        <div class="task-board-body">                                            
                                                                            <div class="kanban-footer">
                                                                                <span class="task-info-cont">
                                                                                    <span class="task-date"><i class="fa fa-clock-o"></i> ${o.deadline}</span>
                                                                                    <span class="task-priority badge bg-inverse-danger"></span>
                                                                                </span>                                                                                                                                                                                                  
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:forEach>
                                                        </div>     
                                                    </div>
                                                    <div class="kanban-list kanban-info">
                                                        <div class="kanban-header">
                                                            <span class="status-title">Progress</span>                                        
                                                        </div>
                                                        <div class="kanban-wrap">
                                                            <c:forEach items="${list1}" var="o">
                                                                <div class="card panel">
                                                                    <div class="kanban-box">
                                                                        <div class="task-board-header">
                                                                            <span class="status-title">${o.name}</span>                                                                          
                                                                        </div>
                                                                        <div class="task-board-body">                                            
                                                                            <div class="kanban-footer">
                                                                                <span class="task-info-cont">
                                                                                    <span class="task-date"><i class="fa fa-clock-o"></i> ${o.deadline}</span>
                                                                                    <span class="task-priority badge bg-inverse-danger"></span>
                                                                                </span>                                                                                                                                                                                                                                      
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:forEach>
                                                        </div>
                                                    </div>                               
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>

                        <div class="col-lg-4 col-md-4">
                            <div class="dash-sidebar">
                                <section>
                                    <h5 class="dash-title">Projects</h5>
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="time-list">
                                                <div class="dash-stats-list">
                                                    <h4>${totalTask}</h4>
                                                    <p>Total Tasks</p>
                                                </div>
                                                <div class="dash-stats-list">
                                                    <h4>${pendingTask}</h4>
                                                    <p>Pending Tasks</p>
                                                </div>
                                            </div>
                                            <div class="request-btn">
                                                <div class="dash-stats-list">
                                                    <h4>${totalPj}</h4>
                                                    <p>Total Projects</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
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

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
