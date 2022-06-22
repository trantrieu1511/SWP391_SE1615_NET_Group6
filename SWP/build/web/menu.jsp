<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">

            <!-- Header -->
            <div class="header">

                <a id="toggle_btn" href="javascript:void(0);">
                    <span class="bar-icon">
                        <span></span>
                        <span></span>
                        <span></span>
                    </span>
                </a>

                <a id="mobile_btn" class="mobile_btn" href="#sidebar"><i class="fa fa-bars"></i></a>

                <!-- Header Menu -->
                <ul class="nav user-menu">

                    <li class="nav-item dropdown has-arrow main-drop">
                        <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                            <span class="user-img"><img src="img/profiles/avatar-21.jpg" alt="">
                                <span class="status online"></span></span>
                            <span>${sessionScope.acc.user}</span>
                        </a>
                        <div class="dropdown-menu">

                            <a class="dropdown-item" href="profile?do=getmyProfile">My Profile</a>
                            <c:if test="${sessionScope.acc.isAdmin == true}">
                            <a class="dropdown-item" href="settings.html">Settings</a>
                            </c:if>
                            <a class="dropdown-item" href="authentication?do=logout">Logout</a>
                        </div>
                    </li>
                </ul>
                <!-- /Header Menu -->

                <!-- Mobile Menu -->
                <div class="dropdown mobile-user-menu">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                            class="fa fa-ellipsis-v"></i></a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="profile?do=getmyProfile">My Profile</a>
                        <c:if test="${sessionScope.acc.isAdmin == true}">
                            <a class="dropdown-item" href="settings.html">Settings</a>
                        </c:if>
                        <a class="dropdown-item" href="authentication?do=logout">Logout</a>
                    </div>
                </div>
                <!-- /Mobile Menu -->

            </div>
            <div class="sidebar" id="sidebar">
                <div class="sidebar-inner slimscroll">
                    <div id="sidebar-menu" class="sidebar-menu">
                        <ul>
                            <li class="menu-title"> 
                                <span>Main</span>
                            </li>
                            <li class="submenu">
                                <a href="#"><i class="la la-dashboard"></i> <span> Dashboard</span> <span class="menu-arrow"></span></a>
                                <ul style="display: none;">
                                    <c:if test="${sessionScope.acc.isManager == true}">
                                    <li><a href="manager?do=dashboard">Dashboard (Manager)</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.isManager == false}">
                                    <li><a href="employee?do=dashboard">Dashboard (Employee)</a></li>
                                    </c:if>
                                </ul>
                            </li>
                            <li class="menu-title"> 
                                <span>Employees</span>
                            </li>
                            <li class="submenu">
                                <a href="#" class=""><i class="la la-user"></i> <span> Employees</span> <span class="menu-arrow"></span></a>
                                <ul style="display: none;">
                                    <c:if test="${sessionScope.acc.isManager == true && sessionScope.acc.isAdmin == false}">
                                        <li><a href="manager?do=list">All Employees</a></li>
                                        </c:if>
                                    <c:if test="${sessionScope.acc.isManager == true && sessionScope.acc.isAdmin == false}">
                                        <li><a href="manager?do=attendance">Attendance (Manager)</a></li>
                                        </c:if>
                                    <li><a href="employee?do=attendance">Attendance (Employee)</a></li>
                                    <li><a href="departments.jsp">Departments</a></li>
                                    <li><a href="designations.jsp">Designations</a></li>
                                    <li><a href="schedule?do=list">Shift & Schedule</a></li>
                                </ul>
                            </li>
                            <li> 
                                <a href="clients.jsp"><i class="la la-users"></i> <span>Clients</span></a>
                            </li>
                            <li class="submenu">
                                <a href="#"><i class="la la-rocket"></i> <span> Projects</span> <span class="menu-arrow"></span></a>
                                <ul style="display: none;">
                                    <li><a href="project?do=list">Projects</a></li>
                                    <li><a href="task?do=view&&title= ">Task board</a></li>
                                </ul>
                            </li>
                            <li> 
                                <a href="leads.jsp"><i class="la la-user-secret"></i> <span>Leads</span></a>
                            </li>
                            <li class="menu-title"> 
                                <span>HR</span>
                            </li>
                            <li class="menu-title"> 
                                <span>Administration</span>
                            </li>                
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Sidebar -->

    </body>
