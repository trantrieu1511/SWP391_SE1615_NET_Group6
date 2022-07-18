<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <body>
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
        <!-- /Header -->

        <!-- Sidebar -->
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
                                <c:choose>
                                    <c:when test="${sessionScope.acc.isManager == true || sessionScope.acc.isAdmin == true}">
                                        <li><a href="dashboard?do=manager">Dashboard (Manager)</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="dashboard?do=employee">Dashboard (Employee)</a></li>
                                        </c:otherwise>
                                    </c:choose>
                            </ul>
                        </li>
                        <li class="menu-title"> 
                            <span>Employees</span>
                        </li>
                        <li class="submenu">
                            <a href="#" class=""><i class="la la-user"></i> <span> Employees</span> <span class="menu-arrow"></span></a>
                            <ul style="display: none;">
                                <c:if test="${sessionScope.acc.isManager == true && sessionScope.acc.isAdmin == false}">
                                    <li><a href="manager?do=list">All Staffs</a></li>
                                    </c:if>

                                <c:if test="${sessionScope.acc.isManager == true && sessionScope.acc.isAdmin == false}">
                                    <li><a href="manager?do=attendance">Attendance (Manager)</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.isManager == false && sessionScope.acc.isAdmin == false}">
                                    <li><a href="employee?do=attendance">Attendance (Employee)</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.isAdmin == true}">
                                    <li><a href="leave?do=leaveAdmin">Leaves (Admin)</a></li>
                                    </c:if>
                                    <c:choose>
                                        <c:when test="${sessionScope.acc.isManager == true}">
                                        <li><a href="leave?do=leaveManager">Leaves (Manager)</a></li>
                                        <li><a href="leave?do=myLeave">My Leaves</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="leave?do=myLeave">My Leaves</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                <li><a href="departments.jsp">Departments</a></li>
                                <li><a href="designations.jsp">Designations</a></li>
                                    <c:if test="${sessionScope.acc.isManager == true && sessionScope.acc.isAdmin == false}">
                                    <li><a href="schedule?do=list">Shift & Schedule</a></li>
                                    </c:if>
                            </ul>
                        </li>
                        <li> 
                            <a href="client?do=list"><i class="la la-users"></i> <span>Clients</span></a>
                        </li>
                        <li class="submenu">
                            <a href="#"><i class="la la-rocket"></i> <span> Projects</span> <span class="menu-arrow"></span></a>
                            <ul style="display: none;">
                                <li><a href="project?do=list">Projects</a></li>
                            </ul>
                        </li>
                        <li> 
                            <a href="leads.jsp"><i class="la la-user-secret"></i> <span>Leads</span></a>
                        </li>

                        <li class="menu-title"> 
                            <span>HR</span>
                        </li>
                        <li class="submenu">
                            <a href="#" class="active subdrop"><i class="la la-money"></i> <span> Payroll </span> <span class="menu-arrow"></span></a>
                            <ul style="display: block;">
                                <c:choose>
                                    <c:when test="${sessionScope.acc.isAdmin==true}">
                                        <li><a href="salary?do=list"> Employee Salary </a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="salary?do=getmyPayslip"> Payslip </a></li>
                                        </c:otherwise>
                                    </c:choose>
                                <!--<li><a href="payroll-items.jsp"> Payroll Items </a></li>-->
                            </ul>
                        </li>
                        <c:if test="${sessionScope.acc.isManager == true || sessionScope.acc.isAdmin == true}">
                            <li class="submenu">
                                <a href="#"><i class="la la-pie-chart"></i> <span> Reports </span> <span class="menu-arrow"></span></a>
                                <ul style="display: none;">
                                    <!--                                    <li><a href="expense-reports.html"> Expense Report </a></li>
                                                                        <li><a href="invoice-reports.html"> Invoice Report </a></li>
                                                                        <li><a href="payments-reports.html"> Payments Report </a></li>-->
                                    <li><a href="report?do=project"> Project Report </a></li>
                                    <li><a href="report?do=task"> Task Report </a></li>
                                    <!--                                    <li><a href="user-reports.html"> User Report </a></li>-->
                                    <li><a href="report?do=employee"> Employee Report </a></li>
                                    <!--                                    <li><a href="payslip-reports.html"> Payslip Report </a></li>
                                                                        <li><a href="attendance-reports.html"> Attendance Report </a></li>
                                                                        <li><a href="leave-reports.html"> Leave Report </a></li>-->
                                    <li><a href="report?do=daily"> Daily Report </a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li class="menu-title"> 
                            <span>Administration</span>
                        </li>
                        <c:if test="${sessionScope.acc.isAdmin == true}">
                            <li><a href="authentication?do=list"><i class="la la-user"></i> <span>Account Manager</span></a></li>
                            <li><a href="job?do=list"><i class="la la-rocket"></i> <span>JOB Manager</span></a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- /Sidebar -->
</body>
