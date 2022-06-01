<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Profile"%>

<%-- 
    Document   : editStaff
    Created on : Jun 1, 2022, 11:52:10 AM
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

        
        <!-- Edit Employee Modal -->
        <div id="edit_employee" role="dialog" style="margin: 10px 400px 80px 400px;">
            <div role="document">
                <div class="modal-content">
                    <div class="modal-header" style="display: block;">
                        <h5 class="modal-title" style="display: block;
                            text-align: center;">Edit Staff</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <!-- <span aria-hidden="true">&times;</span> -->
                        </button>
                    </div>
                    <div class="modal-body">
                        <%
                            ResultSet rsJob = (ResultSet) request.getAttribute("rsJob");
                            ResultSet rsManager = (ResultSet) request.getAttribute("rsManager");
                            ResultSet rsDepartment = (ResultSet) request.getAttribute("rsDepartment");
                            ResultSet rsProfile = (ResultSet) request.getAttribute("rsProfile");
                            if (rsProfile.next()) {
                        %>
                        <form action="ControllerProfile" method="post">
                            <input type="hidden" name="do" value="editStaff">

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                        <input class="form-control" type="text" id="first_name" name="first_name" required value="<%=rsProfile.getString(2)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Last Name <span class="text-danger">*</span></label>
                                        <input class="form-control" type="text" id="last_name" name="last_name" required value="<%=rsProfile.getString(3)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                        <input class="form-control" type="text" id="username" name="username" required value="<%=rsProfile.getString(12)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                        <input class="form-control" type="email" id="email" name="email" required value="<%=rsProfile.getString(4)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Password <span class="text-danger">*</span></label>
                                        <input class="form-control" type="password" name="password" id="password"
                                               onkeyup="checkconfirmPassword(this)" required value="<%=rsProfile.getString(13)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Confirm Password <span class="text-danger">*</span></label>
                                        <input class="form-control" type="password" name="confirm_password" id="confirm_password"
                                               onkeyup="checkPassword(this)" required value="<%=rsProfile.getString(13)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Staff ID <span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" id="profile_id" name="profile_id" required pattern="[A-Z]{5}" placeholder="Enter 5 Captal letter!" value="<%=rsProfile.getString(1)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Joining Date <span class="text-danger">*</span></label>
                                        <div><input class="form-control" type="date" id="hire_date" name="hire_date" required value="<%=rsProfile.getString(6)%>"></div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">Phone </label>
                                        <input class="form-control" type="text" id="phone_number" name="phone_number" value="<%=rsProfile.getString(5)%>">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-form-label">ReportsTo <span class="text-danger">*</span></label>
                                        <select class="select" id="ReportsTo" name="ReportsTo">
                                            <%while (rsManager.next()) {%>
                                            <option value="<%=rsManager.getString(1)%>" <%= (rsManager.getString(1).equals(rsProfile.getString(9)) ? " selected" : "")%>><%= rsManager.getString(2) + " " + rsManager.getString(3)%></option>
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
                                            <option value="<%= rsDepartment.getInt(1)%>" <%= (rsDepartment.getInt(1) == rsProfile.getInt(11) ? " selected" : "")%>><%= rsDepartment.getString(2)%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Designation <span class="text-danger">*</span></label>
                                        <select class="select" id="job_id" name="job_id">
                                            <!-- <option>Select Designation</option> -->
                                            <%while (rsJob.next()) {%>
                                            <option value="<%= rsJob.getInt(1)%>" <%= (rsJob.getInt(1) == rsProfile.getInt(7) ? " selected" : "")%>><%= rsJob.getString(2)%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <span id="wrong_pass_alert"></span>
                            <div class="submit-section">
                                <input type="submit" class="btn btn-primary submit-btn" id="create" name="submit" onclick="wrong_pass_alert()" value="commit edit">
                            </div>
                        </form>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Edit Employee Modal -->
        

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

