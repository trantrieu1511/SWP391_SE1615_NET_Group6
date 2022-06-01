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

        <script>
            function checkPassword2(checkpassword2) {
                var password = document.getElementById('password2').value;
                if (checkpassword2.value != password) {
                    document.getElementById('wrong_pass_alert2').style.color = 'red';
                    document.getElementById('wrong_pass_alert2').innerHTML
                            = '☒ Use same password! Confirm password does not match';
                    document.getElementById('create2').disabled = true;
                    document.getElementById('create2').style.opacity = (0.4);
                } else {
                    document.getElementById('wrong_pass_alert2').style.color = 'green';
                    document.getElementById('wrong_pass_alert2').innerHTML =
                            '🗹 Password Matched';
                    document.getElementById('create2').disabled = false;
                    document.getElementById('create2').style.opacity = (1);
                }
            }
            function checkconfirmPassword2(checkpassword2) {
                var confirm_password = document.getElementById('confirm_password2').value;
                if (checkpassword2.value != confirm_password) {
                    document.getElementById('wrong_pass_alert2').style.color = 'red';
                    document.getElementById('wrong_pass_alert2').innerHTML
                            = '☒ Use same password! Confirm password does not match';
                    document.getElementById('create2').disabled = true;
                    document.getElementById('create2').style.opacity = (0.4);
                } else {
                    document.getElementById('wrong_pass_alert2').style.color = 'green';
                    document.getElementById('wrong_pass_alert2').innerHTML =
                            '🗹 Password Matched';
                    document.getElementById('create2').disabled = false;
                    document.getElementById('create2').style.opacity = (1);
                }
            }
// function validate_password() {

//     var pass = document.getElementById('pass').value;
//     var confirm_pass = document.getElementById('confirm_pass').value;
//     if (pass != confirm_pass) {
//         document.getElementById('wrong_pass_alert').style.color = 'red';
//         document.getElementById('wrong_pass_alert').innerHTML
//         = '☒ Use same password!';
//         document.getElementById('create').disabled = true;
//         document.getElementById('create').style.opacity = (0.4);
//     } else {
//         document.getElementById('wrong_pass_alert').style.color = 'green';
//         document.getElementById('wrong_pass_alert').innerHTML =
//             '🗹 Password Matched';
//         document.getElementById('create').disabled = false;
//         document.getElementById('create').style.opacity = (1);
//     }
// }
            function wrong_pass_alert2() {
                if (document.getElementById('password2').value != "" &&
                        document.getElementById('confirm_password2').value != ""
                        && document.getElementById("first_name2").value != ""
                        && document.getElementById("last_name2").value != ""
                        && document.getElementById("email2").value != ""
                        && document.getElementById("username2").value != ""
                        && document.getElementById("profile_id2").value != ""
                        && document.getElementById("hire_date2").value != ""
                        && document.getElementById("department_id2").value != ""
                        && document.getElementById("job_id2").value != "") {
                    alert("Your response is submitted");
                } else {
                    alert("Please fill all the fields");
                }
            }
        </script>
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
                                            <option value="<%=rsManager.getString(1)%>" <%= (rsManager.getString(1) == rsProfile.getString(1) ? " selected" : "")%>><%= rsManager.getString(2) + " " + rsManager.getString(3)%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Department <span class="text-danger">*</span></label>
                                        <select class="select" id="department_id2" name="department_id2">
                                            <!-- <option value="">Select Department</option> -->
                                            <%while (rsJob.next()) {%>
                                            <option value="<%= rsJob.getInt(1)%>" <%= (rsJob.getInt(1) == rsProfile.getInt(7) ? " selected" : "")%>><%= rsJob.getString(2)%></option>
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

