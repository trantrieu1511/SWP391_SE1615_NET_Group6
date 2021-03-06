<%-- 
    Document   : leaves-employee
    Created on : Jul 12, 2022, 4:59:25 PM
    Author     : DELL
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
        <title>Leaves - HRMS admin template</title>

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

        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Slimscroll JS -->
        <script src="js/jquery.slimscroll.min.js"></script>

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="js/html5shiv.min.js"></script>
                <script src="js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            $(function () {
                $("#edit_leave").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var id = myArray[0];
                    var profile_id = myArray[1];
                    var leave_type = myArray[2];
                    var from = myArray[3];
                    var to = myArray[4];
                    var number_of_days = $(e.relatedTarget).attr('data-number_of_days');
                    var reason = $(e.relatedTarget).attr('data-reason');
                    var new_fromDate = from.split("/").reverse().join("-");
                    var new_toDate = to.split("/").reverse().join("-");

                    $(e.currentTarget).find('input[name="profile_id"]').val(profile_id);
                    $(e.currentTarget).find('input[name="id"]').val(id);
//                    $(e.currentTarget).find('input[name="leave_type"]').val(leave_type);
                    $(e.currentTarget).find('input[name="from"]').val(new_fromDate);
                    $(e.currentTarget).find('input[name="to"]').val(new_toDate);
//                    if (from == to) {
                    document.getElementById('number_of_days_select2').value = number_of_days;
//                    $(e.currentTarget).find('select[name="number_of_days_select2"]').val(number_of_days)
//                    } else {
                    document.getElementById('number_of_days2').value = number_of_days;
//                    $(e.currentTarget).find('input[name="number_of_days2"]').val(number_of_days);
//                    }
                    var myselect = document.getElementById('number_of_days_select2');
                    if (from != to) {
                        document.getElementById('number_of_days2').type = "text";
                        myselect.setAttribute("hidden", "hidden");
                        myselect.removeAttribute("required");
                        $('select[id="number_of_days_select2"]').prop("disabled", true);
                    } else {
                        document.getElementById("number_of_days2").type = "hidden";
                        myselect.removeAttribute("hidden");
                        myselect.setAttribute("required", "");
                        $('select[id="number_of_days_select2"]').prop("disabled", false);
                    }
                    $('#reason').text(reason);
                    document.getElementById('leave_type').value = leave_type;
                });
            });

            $(function () {
                $("#add_leave").on("show.bs.modal", function (e) {
                    var profile_id = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="profile_id"]').val(profile_id);
                });
            });

            $(function () {
                $("#delete_leave").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var id = myArray[0];
                    var profile_id = myArray[1];
                    $(e.currentTarget).find('input[name="id"]').val(id);
                    $(e.currentTarget).find('input[name="profile_id"]').val(profile_id);
                });
            });

            $(document).ready(function () {
                var x;
                $("#btn1").click(function () {
                    x = $("p").detach();
                });
                $("#btn2").click(function () {
                    $("body").prepend(x);
                });
            });

//            $(document).ready(function () {
            function checkDay2(to_date) {
                var from_date = document.getElementById('from').value;
                var mySelect = document.getElementById('div_select');
                var myText = document.getElementById('div_input');
                var prepend = document.getElementById('prepend');
                var cacheDom; //storing the value in dom
                if (to_date.value != from_date) {
                    cacheDom = $('#number_of_days_select').detach();
//                    mySelect.remove();
//                        alert('khac');
                } else {
                    $('#prepend').prepend(cacheDom); // appending it back
//                        alert('giong');
                }
            }
//            });

            function checkDay() {
                var to_date = document.getElementById('to').value;
                var from_date = document.getElementById('from').value;
                // JavaScript program to illustrate
                // calculation of no. of days between two date

                // To set two dates to two variables
                var date1 = new Date(from_date);
                var date2 = new Date(to_date);

// To calculate the time difference of two dates
                var Difference_In_Time = date2.getTime() - date1.getTime();

// To calculate the no. of days between two dates
                var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);
                if (Difference_In_Days < 0)
                    Difference_In_Days = 0;

//To display the final no. of days (result)
//                document.write("Total number of days between dates <br>"
//                        + date1 + "<br> and <br>"
//                        + date2 + " is: <br> "
//                        + Difference_In_Days);
                document.getElementById('number_of_days').value = Difference_In_Days;
                var myselect = document.getElementById('number_of_days_select');
                if (to_date != from_date) {
                    document.getElementById('number_of_days').type = "text";
                    myselect.setAttribute("hidden", "hidden");
                    myselect.removeAttribute("required");
                } else {
                    document.getElementById("number_of_days").type = "hidden";
                    myselect.removeAttribute("hidden");
                    myselect.setAttribute("required", "");
                }
            }

            function checkDayEdit() {
                var to_date = document.getElementById('to2').value;
                var from_date = document.getElementById('from2').value;
                // JavaScript program to illustrate
                // calculation of no. of days between two date

                // To set two dates to two variables
                var date1 = new Date(from_date);
                var date2 = new Date(to_date);

// To calculate the time difference of two dates
                var Difference_In_Time = date2.getTime() - date1.getTime();

// To calculate the no. of days between two dates
                var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);
                if (Difference_In_Days < 0)
                    Difference_In_Days = 0;

//To display the final no. of days (result)
//                document.write("Total number of days between dates <br>"
//                        + date1 + "<br> and <br>"
//                        + date2 + " is: <br> "
//                        + Difference_In_Days);
                document.getElementById('number_of_days2').value = Difference_In_Days;
                var myselect = document.getElementById('number_of_days_select2');
                if (to_date != from_date) {
                    document.getElementById('number_of_days2').type = "text";
                    myselect.setAttribute("hidden", "hidden");
                    myselect.removeAttribute("required");
                    $('select[id="number_of_days_select2"]').prop("disabled", true);
                } else {
                    document.getElementById("number_of_days2").type = "hidden";
                    myselect.removeAttribute("hidden");
                    myselect.setAttribute("required", "");
                    $('select[id="number_of_days_select2"]').prop("disabled", false);
                }
            }

//            function recheckDayEdit() {
//                var to_date = document.getElementById('to3').value;
//                var from_date = document.getElementById('from3').value;
//                
//                var myselect = document.getElementById('number_of_days_select2');
//                if (to_date != from_date) {
//                    myselect.removeAttribute("required");
//                    $('select[id="number_of_days_select2"]').prop("disabled", true);
//                } else {
//                    myselect.setAttribute("required", "");
//                    $('select[id="number_of_days_select2"]').prop("disabled", false);
//                }
//            }


//            $("#document").ready(function () {
//                var to_date = $('#to2');
//                var from_date = $('#from2');
//                var myselect = document.getElementById('number_of_days_select2');
//                if (from_date != to_date) {
////                    $('input[id="number_of_days2"]').prop("readonly", false);
//                    myselect.removeAttribute("required");
//                    $('select[id="number_of_days_select2"]').prop("disabled", true);
//                } else {
////                    $('input[id="number_of_days2"]').prop("readonly", true);
//                    myselect.setAttribute("required", "");
//                    $('select[id="number_of_days_select2"]').prop("disabled", false);
//                }
//            });

//            let toggle = button => {
//                let element = document.getElementById("number_of_days_select");
//                let element2 = document.getElementById("number_of_days");
//
//                let hidden = element.getAttribute("hidden");
//
//                if (hidden) {
//                    element.removeAttribute("hidden");
//                    element2.type = "hidden";
//                    button.innerText = "Hide Select";
//                } else {
//                    element.setAttribute("hidden", "hidden");
//                    element2.type = "text";
//                    button.innerText = "Show Select";
//                }
//            }
            function checkDayOnPageShow() {
                var to_date = document.getElementById('to2').value;
                var from_date = document.getElementById('from2').value;

                var myselect = document.getElementById('number_of_days_select2');
                if (to_date != from_date) {
                    document.getElementById('number_of_days2').type = "text";
                    myselect.setAttribute("hidden", "hidden");
                    myselect.removeAttribute("required");
                } else {
                    document.getElementById("number_of_days2").type = "hidden";
                    myselect.removeAttribute("hidden");
                    myselect.setAttribute("required", "");
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
        </script>

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
                            <div class="row align-items-center">
                                <div class="col">
                                    <h3 class="page-title">My Leaves</h3>
                                    <ul class="breadcrumb">
                                        <!--<li class="breadcrumb-item"><a href="dashboard?do=manager">Dashboard</a></li>-->
                                        <!--<li class="breadcrumb-item"><a href="dashboard?do=employee">Dashboard</a></li>-->
                                        <li class="breadcrumb-item active">My Leaves</li>
                                    </ul>
                                </div>
                            <c:if test="${(12 - medical_leave - other_leave) > 0}">
                                <div class="col-auto float-right ml-auto">
                                    <a href="#" class="btn add-btn" data-toggle="modal" data-id="${sessionScope.acc.profile_id}" data-target="#add_leave"><i class="fa fa-plus"></i> Add Leave</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Leave Statistics -->
                    <div class="row">
                        <div class="col-md-3">
                            <div class="stats-info">
                                <h6>Annual Leave</h6>
                                <h4>12</h4>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="stats-info">
                                <h6>Medical Leave</h6>
                                <h4>${medical_leave}</h4>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="stats-info">
                                <h6>Other Leave</h6>
                                <h4>${other_leave}</h4>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="stats-info">
                                <h6>Remaining Leave</h6>
                                <h4>${12 - medical_leave - other_leave}</h4>
                            </div>
                        </div>
                    </div>
                    <!-- /Leave Statistics -->

                    <div class="row">
                        <div class="col-md-12">

                            <c:if test="${(12 - medical_leave - other_leave) <= 0}">
                                <div class="col-auto float-left ml-auto">
                                    Your leave has exceeded the annual leave amount! Cannot add new leave!
                                </div>
                            </c:if>
                            <div class="table-responsive">
                                <table class="table table-striped custom-table mb-0 datatable">
                                    <thead>
                                        <tr>
                                            <th>Leave Type</th>
                                            <th>From</th>
                                            <th>To</th>
                                            <th>No of Days</th>
                                            <th>Reason</th>
                                            <th class="text-center">Status</th>
                                            <th>Approve by</th>
                                            <th class="text-right">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${myLeaveList}" var="leave">
                                            <tr>
                                                <td>${leave.leave_name}</td>
                                                <td>${leave.from}</td>
                                                <td>${leave.to}</td>
                                                <td>${leave.number_of_days}</td>
                                                <td>${leave.reason}</td>
                                                <td class="text-center">
                                                    <div class="action-label">
                                                        <a class="btn btn-white btn-sm btn-rounded" href="javascript:void(0);">
                                                            <c:if test="${leave.status==1}">
                                                                <i class="fa fa-dot-circle-o text-purple"></i> New
                                                            </c:if>
                                                            <c:if test="${leave.status==2}">
                                                                <i class="fa fa-dot-circle-o text-success"></i> Approved
                                                            </c:if>
                                                            <c:if test="${leave.status==3}">
                                                                <i class="fa fa-dot-circle-o text-danger"></i> Declined
                                                            </c:if>
                                                        </a>
                                                    </div>
                                                </td>
                                                <td>
                                                    <h2 class="table-avatar">
                                                        <c:choose>
                                                            <c:when test="${leave.reportto_name.equals('null')}">
                                                                <a href="" class="avatar avatar-xs"><img src="img/profiles/avatar-05.jpg" alt=""></a>
                                                                Admin
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="" class="avatar avatar-xs"><img src="img/profiles/avatar-21.jpg" alt=""></a>
                                                                <a href="profile?do=getothersProfile&profile_id=${leave.reportto}">${leave.reportto_name}</a>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </h2>
                                                </td>
                                                <td class="text-right">
                                                    <!--<a onclick="recheckDayEdit()">edit</a>-->
                                                    <c:choose>
                                                        <c:when test="${leave.status == 1}">
                                                            <div class="dropdown dropdown-action">
                                                                <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                                <div class="dropdown-menu dropdown-menu-right">
                                                                    <!--<a onclick="recheckDayEdit()">edit</a>-->
                                                                    <a class="dropdown-item" href="#" data-reason="${leave.reason}" data-number_of_days="${leave.number_of_days}" data-id="${leave.id} ${leave.profile_id} ${leave.leave_type} ${leave.from} ${leave.to}" data-toggle="modal" data-target="#edit_leave"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                    <a class="dropdown-item" href="#" data-id="${leave.id} ${leave.profile_id}" data-toggle="modal" data-target="#delete_leave"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->

                <!-- Add Leave Modal -->
                <div id="add_leave" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Leave</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="leave?do=addLeave" method="post">
                                    <input type="hidden" name="profile_id">
                                    <div class="form-group">
                                        <label>Leave Type <span class="text-danger">*</span></label>
                                        <select class="select" name="leave_type" required="">
                                            <option value="">Select Leave Type</option>
                                            <c:forEach items="${listLeaveType}" var="ltype">
                                                <option value="${ltype.id}">${ltype.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <%
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDateTime now = LocalDateTime.now();
                                    %>
                                    <div class="form-group">
                                        <label>From <span class="text-danger">*</span></label>
                                        <div class="">
                                            <input class="form-control" onkeydown="event.preventDefault()" type="date" name="from" id="from" required="" readonly="" value="<%=now.getYear() + "-0" + now.getMonthValue() + "-" + now.getDayOfMonth()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>To <span class="text-danger">*</span></label>
                                        <div class="">
                                            <input class="form-control" onchange="checkDay()" type="date" name="to" id="to" required="">
                                        </div>
                                    </div>
                                    <!--<a class="btn btn-success btn-block" onclick="checkDay()">Compare</a>-->
                                    <!--<span id="prepend"></span>-->
                                    <!--<div class="form-group" id="div_input">-->
                                    <label>Number of days <span class="text-danger">*</span></label>
                                    <input class="form-control" readonly type="text" id="number_of_days">
                                    <!--</div>-->
                                    <!--<div class="form-group" id="div_select_1">-->
                                    <!--<label>Number of days <span class="text-danger">*</span></label>-->
                                    <select class="form-control" name="number_of_days" id="number_of_days_select" hidden required="">
                                        <option value="">Select leave slot</option>
                                        <option value="slot 1">slot 1</option>
                                        <option value="slot 2">slot 2</option>
                                        <option value="slot 3">slot 3</option>
                                        <option value="slot 4">slot 4</option>
                                        <option value="slot 5">slot 5</option>
                                        <option value="slot 6">slot 6</option>
                                        <option value="slot 7">slot 7</option>
                                        <option value="slot 8">slot 8</option>
                                    </select>
                                    <!--</div>-->
                                    <div class="form-group">
                                        <!--<label>Remaining Leaves <span class="text-danger">*</span></label>-->
                                        <!--<input class="form-control" readonly value="12" type="hidden">-->
                                    </div>
                                    <div class="form-group">
                                        <label>Leave Reason <span class="text-danger">*</span></label>
                                        <textarea rows="4" class="form-control" name="reason" required=""></textarea>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                                <!--<button onclick="toggle(this)">Hide Select</button>-->
                                <!--                                <button id='remove'>Remove</button>
                                                                <button id='add'>Add Back</button>-->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Add Leave Modal -->

                <!-- Edit Leave Modal -->
                <div id="edit_leave" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Leave</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="leave" method="post">
                                    <input type="hidden" name="do" value="editLeave">
                                    <input type="hidden" name="profile_id" value="">
                                    <input type="hidden" name="id" value="">
                                    <div class="form-group">
                                        <label>Leave Type <span class="text-danger">*</span></label>
                                        <select class="form-control" name="leave_type" id="leave_type" required="">
                                            <option value="">Select Leave Type</option>
                                            <c:forEach items="${listLeaveType}" var="leaveType">
                                                <option value="${leaveType.id}">${leaveType.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>From <span class="text-danger">*</span></label>
                                        <div class="">
                                            <input class="form-control" name="from" onkeydown="event.preventDefault()" value="" type="date" id="from2" readonly="" required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>To <span class="text-danger">*</span></label>
                                        <div class="">
                                            <input class="form-control" name="to" onkeydown="event.preventDefault()" onchange="checkDayEdit()" value="" type="date" id="to2" required="">
                                        </div>
                                    </div>
                                    <label>Number of days <span class="text-danger">*</span></label>
                                    <input class="form-control" readonly type="text" id="number_of_days2">
                                    <select class="form-control" name="number_of_days" id="number_of_days_select2" hidden required="">
                                        <option value="">Select leave slot</option>
                                        <option value="slot 1">slot 1</option>
                                        <option value="slot 2">slot 2</option>
                                        <option value="slot 3">slot 3</option>
                                        <option value="slot 4">slot 4</option>
                                        <option value="slot 5">slot 5</option>
                                        <option value="slot 6">slot 6</option>
                                        <option value="slot 7">slot 7</option>
                                        <option value="slot 8">slot 8</option>
                                    </select>
                                    <div class="form-group">

                                    </div>
                                    <!--                                    <div class="form-group">
                                                                            <label>Remaining Leaves <span class="text-danger">*</span></label>
                                                                            <input class="form-control" readonly name="remaining_leave" value="" type="text">
                                                                        </div>-->
                                    <div class="form-group">
                                        <label>Leave Reason <span class="text-danger">*</span></label>
                                        <textarea rows="4" class="form-control" name="reason" id="reason" required=""></textarea>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Save</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Leave Modal -->

                <!-- Delete Leave Modal -->
                <div class="modal custom-modal fade" id="delete_leave" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="form-header">
                                    <h3>Delete Leave</h3>
                                    <p>Are you sure want to Cancel this leave?</p>
                                </div>
                                <form action="leave" method="post">
                                    <input type="hidden" name="do" value="deleteLeave">
                                    <input type="hidden" name="id">
                                    <input type="hidden" name="profile_id">
                                    <div class="modal-btn delete-action">
                                        <div class="row">
                                            <div class="col-6">
                                                <input type="submit" class="btn btn-primary continue-btn" value="Delete" style="padding: 10px 75px;">
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
                <!-- /Delete Leave Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->


    </body>
</html>
