<%@page import="java.util.List"%>
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
        <title>Employees - HRMS admin template</title>

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

        <!-- import js -->
        <script src="js/employee-list_js.js"></script>

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
        <script src="js/edit.js"></script>

        <!-- Model JS -->
        <script type="text/javascript">
            $(function () {
                $("#edit_employee").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var id = myArray[0];
                    var first_name = myArray[1];
                    var last_name = myArray[2];
                    var email = myArray[3];
                    var phone_number = myArray[4];
                    var hire_date = myArray[5];
                    var username = myArray[6];
                    var password = myArray[7];
                    var reportto = myArray[8];
                    var depart_id = myArray[9];
                    var job_id = myArray[10];
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
                    $(e.currentTarget).find('input[name="first_name"]').val(first_name);
                    $(e.currentTarget).find('input[name="last_name"]').val(last_name);
                    $(e.currentTarget).find('input[name="email"]').val(email);
                    $(e.currentTarget).find('input[name="phone_number"]').val(phone_number);
                    $(e.currentTarget).find('input[name="hire_date"]').val(hire_date);
                    $(e.currentTarget).find('input[name="username"]').val(username);
                    $(e.currentTarget).find('input[name="password"]').val(password);
                    $(e.currentTarget).find('input[name="ReportsTo"]').val(reportto);
                    document.getElementById('department_id2').value = depart_id;
                    document.getElementById('job_id2').value = job_id;
                });
            });
            $(function () {
                $("#add_employee").on("show.bs.modal", function (e) {
                    var reportto = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="ReportsTo"]').val(reportto);
                });
            });
            $(function () {
                $("#delete_employee").on("show.bs.modal", function (e) {
                    var id = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
                });
            });
            function checkPassword(checkpassword) {
                var password = document.getElementById('password').value;
                if ((checkpassword.value && password) != "") {
                    if (checkpassword.value != password) {
                        document.getElementById('wrong_pass_alert').style.color = 'red';
                        document.getElementById('wrong_pass_alert').innerHTML
                                = '☒ Use same password! Confirm password does not match';
                        document.getElementById('create').disabled = true;
                        document.getElementById('create').style.opacity = (0.4);
                    } else {
                        document.getElementById('wrong_pass_alert').style.color = 'green';
                        document.getElementById('wrong_pass_alert').innerHTML =
                                '🗹 Password Matched';
                        document.getElementById('create').disabled = false;
                        document.getElementById('create').style.opacity = (1);
                    }

                } else {
                    document.getElementById('wrong_pass_alert').innerHTML
                            = '';
                    document.getElementById('create').disabled = false;
                    document.getElementById('create').style.opacity = (1);
                }
            }
            function checkconfirmPassword(checkpassword) {
                var confirm_password = document.getElementById('confirm_password').value;
                if ((checkpassword.value && confirm_password) != "") {
                    if (checkpassword.value != confirm_password) {
                        document.getElementById('wrong_pass_alert').style.color = 'red';
                        document.getElementById('wrong_pass_alert').innerHTML
                                = '☒ Use same password! Confirm password does not match';
                        document.getElementById('create').disabled = true;
                        document.getElementById('create').style.opacity = (0.4);
                    } else {
                        document.getElementById('wrong_pass_alert').style.color = 'green';
                        document.getElementById('wrong_pass_alert').innerHTML =
                                '🗹 Password Matched';
                        document.getElementById('create').disabled = false;
                        document.getElementById('create').style.opacity = (1);
                    }

                } else {
                    document.getElementById('wrong_pass_alert').innerHTML
                            = '';
                    document.getElementById('create').disabled = false;
                    document.getElementById('create').style.opacity = (1);
                }
            }

            function checkPassword2(checkpassword) {
                var password = document.getElementById('password2').value;
                if ((checkpassword.value && password) != "") {
                    if (checkpassword.value != password) {
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
                } else {
                    document.getElementById('wrong_pass_alert').innerHTML
                            = '';
                    document.getElementById('create').disabled = false;
                    document.getElementById('create').style.opacity = (1);
                }

            }
            function checkPasswordonpageshow() {
                var password = document.getElementById('password2').value;
                var confirm_password = document.getElementById('confirm_password2').value;
//                if ((password && confirm_password) != "") {
                    if (confirm_password != password) {
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
//                } else {
//                    document.getElementById('wrong_pass_alert').innerHTML
//                            = '';
//                    document.getElementById('create').disabled = false;
//                    document.getElementById('create').style.opacity = (1);
//                }

            }

            function checkConfirmPassword2(checkpassword) {
                var confirm_password = document.getElementById('confirm_password2').value;
                if ((checkpassword.value && confirm_password) != "") {
                    if (checkpassword.value != confirm_password) {
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
                } else {
                    document.getElementById('wrong_pass_alert').innerHTML
                            = '';
                    document.getElementById('create').disabled = false;
                    document.getElementById('create').style.opacity = (1);
                }

            }
            // alert
            <c:if test="${alert != ''}">
            window.onload = function () {
                alert("${alert}");
            }
            </c:if>
            $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            })
            function clearFunc() {
                document.getElementById('ejob').value = "";
                document.getElementById('ename').value = "";
                document.getElementById('eid').value = "";
            }
        </script>

        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

    </head>

    <body onpageshow="checkPasswordonpageshow()">

        <!-- Main Wrapper -->
        <div class="main-wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <!-- Page Wrapper -->
                <div class="page-wrapper">

                    <!-- Page Content -->
                    <div class="content container-fluid">

                        <!-- Page Header -->
                        <div class="page-header">
                            <div class="row align-items-center">
                                <div class="col">
                                    <h3 class="page-title">Manage Staff</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="manager?do=dashboard">Dashboard</a></li>
                                        <li class="breadcrumb-item active"><a href="manager?do=list">Staff</a></li>
                                    </ul>
                                </div>
                                <div class="col-auto float-right ml-auto">
                                    <a href="#" class="btn add-btn" data-toggle="modal" data-id="${sessionScope.acc.profile_id}" data-target="#add_employee"><i class="fa fa-plus"></i> Add Staff</a>
                                <div class="view-icons">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->


                    <!-- Search Filter -->
                    <form action="manager?do=filter" method="post">
                        <div class="row filter-row">
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" name="eid" id="eid" class="form-control floating" value="${eid}">
                                    <label class="focus-label">Staff ID</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <div class="form-group form-focus">
                                    <input type="text" name="ename" id="ename" class="form-control floating" value="${ename}">
                                    <label class="focus-label">Staff Name</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3"> 
                                <div class="form-group form-focus select-focus">
                                    <select name="ejob" id="ejob" class="form-control">
                                        <option value="">Select Designation</option>
                                        <c:forEach items="${job}" var="j">
                                            <option value="${j.id}" ${ejob == j.id ? " selected": ""}>${j.title}</option>
                                        </c:forEach>
                                    </select>
                                    <label class="focus-label">Designation</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-2">  
                                <input type="submit" class="btn btn-success btn-block" value="Search" style="padding: 0px">
                            </div>
                            <div class="col-sm-6 col-md-1">
                                <a class="btn btn-success btn-block" onclick="clearFunc()">Clear</a>
                            </div>
                        </div>
                    </form>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable" id="table">  
                                    <%--<c:if test="${filter == 'no'}">--%>
                                    <!--<h4><a href="manager?do=list" style="text-decoration: none; color: grey"> <-- back</a></h4>-->
                                    <%--</c:if>--%>
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Employee ID</th>
                                            <th name="email">Email</th>
                                            <th>Mobile</th>
                                            <th class="text-nowrap">Join Date</th>
                                            <th>Role</th>
                                            <th class="text-right no-sort">Action</th>
                                        </tr>
                                    </thead>                                   
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
                                            <tr>
                                                <td>
                                                    <h2 class="table-avatar">
                                                        <a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-18.jpg"></a>
                                                        <a href="profile?do=getothersProfile&profile_id=${o.profile_id}">${o.first_name} ${o.last_name} <span>${o.department_name}</span></a>
                                                    </h2>

                                                </td>
                                                <td>${o.profile_id}</td>
                                                <td>${o.email}</td>
                                                <c:choose>
                                                    <c:when test="${o.phone_number.equals('')}">
                                                        <td>N/A</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>${o.phone_number}</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td>${o.hire_date}</td>
                                                <td>${o.job_title}</td>
                                                <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-id="${o.profile_id} ${o.first_name} ${o.last_name} ${o.email} ${o.phone_number} ${o.hire_date} ${o.user_display} ${o.pass_display} ${o.reportto} ${o.department_id} ${o.job_id}" data-target="#edit_employee"> <i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_employee" data-id="${o.profile_id}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>                                  
                                </table>
                            </div>
                        </div>
                    </div>


                    <!--                    <script type="text/javascript">
                                            function filter1() {
                                                var input, filter, table, tr, td, i, txtValue;
                                                input = document.getElementById("EID");
                                                table = document.getElementById("table");
                                                tr = table.getElementsByTagName("tr");
                                                filter = input.value.toUpperCase();
                    
                                                for (i = 0; i < tr.length; i++) {
                                                    td = tr[i].getElementsByTagName("td")[1];
                                                    if (td) {
                                                        txtValue = td.textContent || td.innerText;
                                                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                                            tr[i].style.display = "";
                                                        } else {
                                                            tr[i].style.display = "none";
                                                        }
                                                    }
                    
                                                }
                                            }
                                            function filter2() {
                                                var input, filter, table, tr, td, i, txtValue;
                                                input = document.getElementById("EName");
                                                table = document.getElementById("table");
                                                tr = table.getElementsByTagName("tr");
                                                filter = input.value.toUpperCase();
                    
                                                for (i = 0; i < tr.length; i++) {
                                                    td = tr[i].getElementsByTagName("td")[0];
                                                    if (td) {
                                                        txtValue = td.textContent || td.innerText;
                                                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                                            tr[i].style.display = "";
                                                        } else {
                                                            tr[i].style.display = "none";
                                                        }
                                                    }
                    
                                                }
                                            }
                                            function filter3() {
                                                var input, filter, table, tr, td, i, txtValue;
                                                input = document.getElementById("EJob");
                                                table = document.getElementById("table");
                                                tr = table.getElementsByTagName("tr");
                                                filter = input.value.toUpperCase();
                    
                                                for (i = 0; i < tr.length; i++) {
                                                    td = tr[i].getElementsByTagName("td")[5];
                    //                                if (input.value.equals("All Designation")) {
                    //                                        tr[i].style.display = "";
                    //                                } else
                                                    if (td) {
                                                        txtValue = td.textContent || td.innerText;
                                                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                                            tr[i].style.display = "";
                                                        } else {
                                                            tr[i].style.display = "none";
                                                        }
                                                    }
                                                }
                                            }
                                        </script> -->

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
                                <form action="manager" method="post">
                                    <input type="hidden" name="do" value="addStaff">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" name="first_name" id="first_name" required pattern="[A-Za-z]{1,12}"
                                                       title="FirstName not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                       allow uppercase and lowercase letters, max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Last Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" name="last_name" id="last_name" required pattern="[A-Za-z]{1,12}"
                                                       title="LastName not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                       allow uppercase and lowercase letters, max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" name="username" id="username" required pattern="[a-zA-Z0-9]{1,12}"
                                                       title="Username not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" name="email" id="email" placeholder="e.g: abc@mail.com" required pattern="[a-zA-Z0-9]{1,12}[@][a-z]{1,6}[.][a-z]{1,6}"
                                                       title="email not allow: Unicode characters, 
                                                       special character other than @ and . and spacing characters;  
                                                       allow uppercase, lowercase letters and numeric characters (0-9);
                                                       maximum length of parts of email: 
                                                       username: 20, mail server: 12, domain: 12; 
                                                       max length: 46">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Password <span class="text-danger">*</span></label>
                                                <input class="form-control" type="password" name="password" id="password" 
                                                       onkeyup="checkconfirmPassword(this)" required pattern="[a-zA-Z0-9]{1,12}"
                                                       title="Password not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12">
                                            </div>
                                            <span id="wrong_pass_alert"></span>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Confirm Password <span class="text-danger">*</span></label>
                                                <input class="form-control" type="password" name="confirm_password" id="confirm_password"
                                                       onkeyup="checkPassword(this)" required pattern="[a-zA-Z0-9]{1,12}"
                                                       title="Confirm Password not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12">
                                            </div>
                                        </div>
                                        <!--                                        <div class="col-sm-6">  
                                                                                    <div class="form-group">
                                                                                        <label class="col-form-label">Staff ID <span class="text-danger">*</span></label>
                                                                                        <input type="text" class="form-control" name="profile_id" id="profile_id" required pattern="[A-Z]{5}"
                                                                                               title="Staff ID not allow Unicode characters, must be 5 character with uppercase">
                                                                                    </div>
                                                                                </div>-->
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Joining Date <span class="text-danger">*</span></label>
                                                <div class="cal-icon"><input class="form-control datetimepicker" type="text" name="hire_date" placeholder="pick a joining date" onkeydown="event.preventDefault()" id="hire_date" required pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Phone </label>
                                                <input class="form-control" type="text" name="phone_number" id="phone_number" title="phone number must be 10-digit number" pattern="[0-9]{10}">
                                            </div>
                                        </div>
                                        <!--                                        <div class="col-sm-6">
                                                                                    <div class="form-group">
                                                                                        <label class="col-form-label">ReportsTo <span class="text-danger">*</span></label>-->
                                        <input class="form-control" readonly type="hidden" value="" name="ReportsTo" id="ReportsTo" pattern="[A-Z]{5}">
                                        <!--                                            </div>
                                                                                </div>-->
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Department <span class="text-danger">*</span></label>
                                                <select class="select" name="department_id" id="department_id" required="">
                                                    <option value="">Select Department</option>
                                                    <c:forEach items="${department}" var="o">
                                                        <option value="${o.id}">${o.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Designation <span class="text-danger">*</span></label>
                                                <select class="select" name="job_id" id="job_id" required="">
                                                    <option value="">Select Designation</option>
                                                    <c:forEach items="${job}" var="o">
                                                        <option value="${o.id}">${o.title}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="submit-section">
                                        <input type="submit" class="btn btn-primary submit-btn" id="create" value="submit">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Add Employee Modal -->

                <!-- Edit Employee Modal -->
                <c:forEach items="${}" var="o">
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
                                <form action="manager" do="post">
                                    <input type="hidden" name="do" value="editStaff">
                                    <div class="row">
                                        <div class="col-sm-6">  
                                            <div class="form-group">
                                                <label class="col-form-label">Employee ID <span class="text-danger">*</span></label>
                                                <input type="text" value="" readonly class="form-control floating employee-id" name="profile_id" id="profile_id2" 
                                                       required pattern="[A-Z]{5}" title="Staff ID not allow Unicode characters and must be 5 character with uppercase">
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                                <input class="form-control" value="" type="text" name="first_name" id="first_name2" required pattern="[A-Za-z]{1,12}"
                                                       title="FirstName not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                       allow uppercase and lowercase letters, max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Last Name</label>
                                                <input class="form-control" value="" type="text" name="last_name" id="last_name2" required pattern="[A-Za-z]{1,12}"
                                                       title="LastName not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                       allow uppercase and lowercase letters, max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                                <input class="form-control" value="" type="text" name="username" id="username2" required pattern="[a-zA-Z0-9]{1,12}"
                                                       title="Username not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                                <input class="form-control" value="" type="email" name="email" id="email2" placeholder="e.g: abc@mail.com" required
                                                       title="email not allow: Unicode characters, 
                                                       special character other than @ and . and spacing characters;  
                                                       allow uppercase, lowercase letters and numeric characters (0-9);
                                                       maximum length of parts of email: 
                                                       username: 12, mail server: 6, domain: 6; 
                                                       max length: 26">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Password</label>
                                                <input class="form-control" value="" type="password" name="password" id="password2" 
                                                       onkeyup="checkConfirmPassword2(this)" required pattern="[a-zA-Z0-9]{1,12}"
                                                       title="Password not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12">
                                            </div>
                                            <span id="wrong_pass_alert2"></span>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Confirm Password</label>
                                                <input class="form-control" value="" type="password" name="password" id="confirm_password2" 
                                                       onkeyup="checkPassword2(this)" required pattern="[a-zA-Z0-9]{1,12}"
                                                       title="Confirm Password not contain: Unicode characters, 
                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; 
                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">  
                                            <div class="form-group">
                                                <label class="col-form-label">Joining Date <span class="text-danger">*</span></label>
                                                <div class="cal-icon"><input class="form-control datetimepicker" type="text" placeholder="pick a joining date" onkeydown="event.preventDefault()" name="hire_date" id="hire_date2" required pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"></div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-form-label">Phone </label>
                                                <input class="form-control" value="" type="text" name="phone_number" id="phone_number2" title="phone number must be 10 digit number" pattern="[0-9]{10}">
                                            </div>
                                        </div>
                                        <!--                                        <div class="col-sm-6">
                                                                                    <div class="form-group">
                                                                                        <label class="col-form-label">Report To <span class="text-danger">*</span></label>-->
                                        <input class="form-control" value="" type="hidden" name="ReportsTo" id="ReportsTo2" required="" pattern="[A-Z]{5}">
                                        <!--                                            </div>
                                                                                </div>-->
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Department <span class="text-danger">*</span></label>
                                                <select class="form-control" name="department_id" id="department_id2" required="">
                                                    <option value="">Select Department</option>
                                                    <c:forEach items="${department}" var="o">
                                                        <option value="${o.id}">${o.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Designation <span class="text-danger">*</span></label>
                                                <select class="form-control" name="job_id" id="job_id2" required="">
                                                    <option value="">Select Designation</option>
                                                    <c:forEach items="${job}" var="o">
                                                        <option value="${o.id}">${o.title}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="submit-section">
                                        <input type="submit" class="btn btn-primary submit-btn" id="create2" value="submit">
                                    </div>
                                </form>
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
                                <form action="manager" do="post">
                                    <input type="hidden" name="do" value="deleteStaff">
                                    <input type="hidden" name="profile_id">
                                    <div class="form-header">
                                        <h3>Delete Staff</h3>
                                        <p>Are you sure want to delete?</p>
                                    </div>
                                    <div class="modal-btn delete-action">
                                        <div class="row">
                                            <div class="col-6">
                                                <input type="submit" value="Delete" class="btn btn-primary continue-btn" style="padding: 10px 75px;">
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
                <!-- /Delete Employee Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

    </body>
</html>