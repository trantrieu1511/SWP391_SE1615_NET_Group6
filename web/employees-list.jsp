<%@page import="entity.Jobs"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Profile"%>
<%-- 
    Document   : employees-list
    Created on : May 27, 2022, 10:25:31 PM
    Author     : DELL
--%>

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
        <title>Employees - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!-- Lineawesome CSS -->
        <link rel="stylesheet" href="assets/css/line-awesome.min.css">

        <!-- Datatable CSS -->
        <link rel="stylesheet" href="assets/css/dataTables.bootstrap4.min.css">

        <!-- Select2 CSS -->
        <link rel="stylesheet" href="assets/css/select2.min.css">

        <!-- Datetimepicker CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- import js -->
        <script src="js/employee-list_js.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="assets/js/html5shiv.min.js"></script>
                <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">

            <!-- Page Wrapper -->
            <div class="page-wrapper">

                <!-- Page Content -->
                <div class="content container-fluid">

                    <!-- Page Header -->
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="page-title">Employee</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Employee</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_employee"><i class="fa fa-plus"></i> Add Employee</a>
                                <div class="view-icons">
                                    <a href="employees.html" class="grid-view btn btn-link"><i class="fa fa-th"></i></a>
                                    <a href="ControllerProfile" class="list-view btn btn-link active"><i class="fa fa-bars"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Search Filter -->
                    <div class="row filter-row">
                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating">
                                <label class="focus-label">Employee ID</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating">
                                <label class="focus-label">Employee Name</label>
                            </div>
                        </div>
                        <% Vector<Jobs> vectorJobs = (Vector<Jobs>) request.getAttribute("vectorJobs");%>
                        <div class="col-sm-6 col-md-3"> 
                            <div class="form-group form-focus select-focus">
                                <select class="select floating">
                                    <%for (Jobs jobs : vectorJobs) {%>
                                    <option><%= jobs.getJob_title()%></option>
                                    <%}%>
                                </select>
                                <label class="focus-label">Designation</label>
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
                                <table class="table table-striped custom-table datatable">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Employee ID</th>
                                            <th>Email</th>
                                            <th>Mobile</th>
                                            <th class="text-nowrap">Join Date</th>
                                            <th>Role</th>
                                            <th class="text-right no-sort">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%

                                            Vector<Profile> vectorStaff = (Vector<Profile>) request.getAttribute("list");
                                            for (Profile pro : vectorStaff) {
                                        %>
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <a href="profile.html" class="avatar"><img alt="" src="<%= pro.getImg()%>"></a>
                                                    <a href="profile.html"><%= pro.getFirst_name() + " " + pro.getLast_name()%> <span><%= pro.getJob_title()%></span></a>
                                                </h2>
                                            </td>
                                            <td><%= pro.getProfile_id()%></td>
                                            <td><%= pro.getEmail()%></td>
                                            <%if (pro.getPhone_number().equals("")) {%>
                                            <td><%out.print("N/A");%></td>
                                            <%} else {%>
                                            <td><%= pro.getPhone_number()%></td>
                                            <%}%>
                                            <td><%= pro.getHire_date()%></td>
                                            <td>
                                                <div class="dropdown">
                                                    <a href="" class="btn btn-white btn-sm btn-rounded dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><%= pro.getJob_title()%> </a>
                                                    <div class="dropdown-menu">
                                                        <%
//                                                            Vector<Jobs> vectorJobs = (Vector<Jobs>) request.getAttribute("vectorJobs");
                                                            for (Jobs jobs : vectorJobs) {
                                                        %>
                                                        <a class="dropdown-item" href="#"><%= jobs.getJob_title()%></a>
                                                        <%}%>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="text-right">
                                                <div class="dropdown dropdown-action">
                                                    <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a class="dropdown-item" href="ControllerProfile?do=editStaff&profile_id=<%= pro.getProfile_id()%>" > <i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_employee"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->

                <!-- Add Employee Modal -->
                <div id="add_employee" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Staff</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <%
                                    ResultSet rsJobs = (ResultSet) request.getAttribute("rsJobs");
                                    ResultSet rsManager = (ResultSet) request.getAttribute("rsManager");
                                    ResultSet rsDepartment = (ResultSet) request.getAttribute("rsDepartment");
                                %>
                                <form action="ControllerProfile" method="post">
                                    <input type="hidden" name="do" value="addStaff">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="first_name" name="first_name" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Last Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="last_name" name="last_name" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="username" name="username" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                                <input class="form-control" type="email" id="email" name="email" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Password <span class="text-danger">*</span></label>
                                                <input class="form-control" type="password" name="password" id="password" 
                                                       onkeyup="checkconfirmPassword(this)" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Confirm Password <span class="text-danger">*</span></label>
                                                <input class="form-control" type="password" name="confirm_password" id="confirm_password"
                                                       onkeyup="checkPassword(this)" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">  
                                            <div class="form-group">
                                                <label class="col-form-label">Staff ID <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" id="profile_id" name="profile_id" required pattern="[A-Z]{5}" placeholder="Enter 5 Captal letter!">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Joining Date <span class="text-danger">*</span></label>
                                                <div><input class="form-control" type="date" id="hire_date" name="hire_date" required></div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Phone </label>
                                                <input class="form-control" type="text" id="phone_number" name="phone_number">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">ReportsTo <span class="text-danger">*</span></label>
                                                <select class="select" id="ReportsTo" name="ReportsTo">
                                                    <%while (rsManager.next()) {%>
                                                    <option value="<%=rsManager.getString(1)%>"><%= rsManager.getString(2) + " " + rsManager.getString(3)%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Department <span class="text-danger">*</span></label>
                                                <select class="select" id="department_id" name="department_id">
                                                    <!-- <option value="">Select Department</option> -->
                                                    <%while (rsDepartment.next()) {%>
                                                    <option value="<%= rsDepartment.getInt(1)%>"><%= rsDepartment.getString(2)%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Designation <span class="text-danger">*</span></label>
                                                <select class="select" id="job_id" name="job_id">
                                                    <!-- <option>Select Designation</option> -->
                                                    <%
                                                        //Vector<Jobs> vectorJobs = (Vector<Jobs>) request.getAttribute("vectorJobs");
                                                        for (Jobs jobs : vectorJobs) {%>
                                                    <option value="<%= jobs.getJob_id()%>"><%= jobs.getJob_title()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label" for="img">Img </label>
                                                <input class="form-control" type="search" id="img" name="img">
                                            </div>
                                        </div>
                                    </div>
                                    <span id="wrong_pass_alert"></span>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn" id="create" onclick="wrong_pass_alert()">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Add Employee Modal -->


                <!-- Edit Employee Modal -->
                <div id="edit_employee" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Staff</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <%
                                    Object profile_id = session.getAttribute("isedit");
                                    if (profile_id != null) {
                                        ResultSet rsProfile = (ResultSet) request.getAttribute("rsProfile");
                                        if (rsProfile.next()) {
                                %>
                                <form action="ControllerProfile" method="post">
                                    <input type="hidden" name="do" value="editStaff">

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="first_name2" name="first_name2" required value="<%=rsProfile.getString(2)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Last Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="last_name2" name="last_name2" required value="<%=rsProfile.getString(3)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="username2" name="username2" required value="<%=rsProfile.getString(12)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                                <input class="form-control" type="email" id="email2" name="email2" required value="<%=rsProfile.getString(4)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Password <span class="text-danger">*</span></label>
                                                <input class="form-control" type="password" name="password2" id="password2"
                                                       onkeyup="checkconfirmPassword2(this)" required value="<%=rsProfile.getString(13)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Confirm Password <span class="text-danger">*</span></label>
                                                <input class="form-control" type="password" name="confirm_password2" id="confirm_password2"
                                                       onkeyup="checkPassword2(this)" required value="<%=rsProfile.getString(13)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Staff ID <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" id="profile_id2" name="profile_id2" required pattern="[A-Z]{5}" placeholder="Enter 5 Captal letter!" value="<%=rsProfile.getString(1)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Joining Date <span class="text-danger">*</span></label>
                                                <div><input class="form-control" type="date" id="hire_date2" name="hire_date2" required value="<%=rsProfile.getString(6)%>"></div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Phone </label>
                                                <input class="form-control" type="text" id="phone_number2" name="phone_number2" value="<%=rsProfile.getString(5)%>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">ReportsTo <span class="text-danger">*</span></label>
                                                <select class="select" id="ReportsTo2" name="ReportsTo2">
                                                    <%while (rsManager.next()) {%>
                                                    <option value="<%=rsManager.getInt(1)%>" <%= (rsManager.getInt(1) == rsProfile.getInt(1) ? " selected" : "")%>><%= rsManager.getString(2) + " " + rsManager.getString(3)%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Department <span class="text-danger">*</span></label>
                                                <select class="select" id="department_id2" name="department_id2">
                                                    <!-- <option value="">Select Department</option> -->
                                                    <%while (rsJobs.next()) {%>
                                                    <option value="<%= rsJobs.getInt(1)%>" <%= (rsJobs.getInt(1) == rsProfile.getInt(7) ? " selected" : "")%>><%= rsJobs.getString(2)%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Designation <span class="text-danger">*</span></label>
                                                <select class="select" id="job_id2" name="job_id2">
                                                    <!-- <option>Select Designation</option> -->
                                                    <%while (rsDepartment.next()) {%>
                                                    <option value="<%= rsDepartment.getInt(1)%>" <%= (rsDepartment.getInt(1) == rsProfile.getInt(11) ? " selected" : "")%>><%= rsDepartment.getString(2)%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <span id="wrong_pass_alert2"></span>
                                    <div class="submit-section">
                                        <input type="submit" class="btn btn-primary submit-btn" id="create2" name="submit" onclick="wrong_pass_alert2()" value="commit edit">
                                    </div>
                                </form>
                                <%}%>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Employee Modal -->

                
                <!-- Delete Employee Modal -->
                <div class="modal custom-modal fade" id="delete_employee" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="form-header">
                                    <h3>Delete Employee</h3>
                                    <p>Are you sure want to delete?</p>
                                </div>
                                <div class="modal-btn delete-action">
                                    <div class="row">
                                        <div class="col-6">
                                            <%for (Profile pro : vectorStaff) {%>
                                            <a href="ControllerProfile?do=deleteStaff&profile_id=<%= pro.getProfile_id() %>" class="btn btn-primary continue-btn">Delete</a>
                                            <%}%>
                                        </div>
                                        <div class="col-6">
                                            <a href="javascript:void(0);" data-dismiss="modal" class="btn btn-primary cancel-btn">Cancel</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Delete Employee Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

        <script type="text/javascript">
            function getProfile_id(id) {
                document.getElementsByTagName("tr").id = id;

            }

        </script>
        <!-- jQuery -->
        <script src="assets/js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="assets/js/jquery.slimscroll.min.js"></script>

        <!-- Select2 JS -->
        <script src="assets/js/select2.min.js"></script>

        <!-- Datetimepicker JS -->
        <script src="assets/js/moment.min.js"></script>
        <script src="assets/js/bootstrap-datetimepicker.min.js"></script>

        <!-- Datatable JS -->
        <script src="assets/js/jquery.dataTables.min.js"></script>
        <script src="assets/js/dataTables.bootstrap4.min.js"></script>

        <!-- Custom JS -->
        <script src="assets/js/app.js"></script>

    </body>
</html>
