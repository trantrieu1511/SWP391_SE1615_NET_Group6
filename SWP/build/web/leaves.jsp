<%-- 
    Document   : leaves
    Created on : Jul 12, 2022, 4:58:12 PM
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
                    var leave_name = $(e.relatedTarget).attr('data-leave_name');
                    var from = myArray[2];
                    var to = myArray[3];
                    var number_of_days = myArray[4];
                    var annual_leave = myArray[5];
                    var reason = $(e.relatedTarget).attr('data-reason');

                    $(e.currentTarget).find('input[name="profile_id"]').val(profile_id);
                    $(e.currentTarget).find('input[name="leave_name"]').val(leave_name);
                    $(e.currentTarget).find('input[name="from"]').val(from);
                    $(e.currentTarget).find('input[name="to"]').val(to);
                    $(e.currentTarget).find('input[name="number_of_days"]').val(number_of_days);
                    $(e.currentTarget).find('input[name="remaining_leave"]').val(annual_leave);
                    $('#reason').val(reason);
                });
            });
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

            }
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
                                    <h3 class="page-title">Leaves</h3>
                                    <ul class="breadcrumb">
                                        <!--<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>-->
                                        <li class="breadcrumb-item active">Leaves</li>
                                    </ul>
                                </div>
                                <!--                            <div class="col-auto float-right ml-auto">
                                                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_leave"><i class="fa fa-plus"></i> Add Leave</a>
                                                            </div>-->
                            </div>
                        </div>
                        <!-- /Page Header -->

                        <!-- Leave Statistics -->
                        <div class="row">
                        <c:if test="${sessionScope.acc.isManager==true}">
                            <div class="col-md-3">
                                <div class="stats-info">
                                    <h6>Today Presents</h6>
                                    <h4>${present} / ${totalEmployee}</h4>
                                </div>
                            </div>
                        </c:if>

                        <!--                        <div class="col-md-3">
                                                    <div class="stats-info">
                                                        <h6>Planned Leaves</h6>
                                                        <h4>8 <span>Today</span></h4>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="stats-info">
                                                        <h6>Unplanned Leaves</h6>
                                                        <h4>0 <span>Today</span></h4>
                                                    </div>
                                                </div>-->
                        <div class="col-md-3">
                            <div class="stats-info">
                                <h6>Pending Requests</h6>
                                <h4>${pending_request}</h4>
                            </div>
                        </div>
                    </div>
                    <!-- /Leave Statistics -->

                    <!-- Search Filter -->
                    <div class="row filter-row">
                        <div class="col-sm-6 col-md-3 col-lg-3 col-xl-2 col-12">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating">
                                <label class="focus-label">Employee Name</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3 col-lg-3 col-xl-2 col-12">  
                            <div class="form-group form-focus select-focus">
                                <select class="select floating"> 
                                    <option> -- Select -- </option>
                                    <option>Casual Leave</option>
                                    <option>Medical Leave</option>
                                    <option>Loss of Pay</option>
                                </select>
                                <label class="focus-label">Leave Type</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3 col-lg-3 col-xl-2 col-12"> 
                            <div class="form-group form-focus select-focus">
                                <select class="select floating"> 
                                    <option> -- Select -- </option>
                                    <option> Pending </option>
                                    <option> Approved </option>
                                    <option> Rejected </option>
                                </select>
                                <label class="focus-label">Leave Status</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3 col-lg-3 col-xl-2 col-12">  
                            <div class="form-group form-focus">
                                <div class="cal-icon">
                                    <input class="form-control floating datetimepicker" type="text">
                                </div>
                                <label class="focus-label">From</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3 col-lg-3 col-xl-2 col-12">  
                            <div class="form-group form-focus">
                                <div class="cal-icon">
                                    <input class="form-control floating datetimepicker" type="text">
                                </div>
                                <label class="focus-label">To</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3 col-lg-3 col-xl-2 col-12">  
                            <a href="#" class="btn btn-success btn-block"> Search </a>  
                        </div>     
                    </div>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table mb-0 datatable">
                                    <thead>
                                        <tr>
                                            <th>Employee</th>
                                            <th>Leave Type</th>
                                            <th>From</th>
                                            <th>To</th>
                                            <th>No of Days</th>
                                            <th>Reason</th>
                                            <th class="text-center">Status</th>
                                            <th class="text-right">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${checkLeaveList}" var="leave">
                                            <tr>
                                                <td>
                                                    <h2 class="table-avatar">
                                                        <!--<a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-09.jpg"></a>-->
                                                        <a href="profile?do=getothersProfile&profile_id=${leave.profile_id}">${leave.first_name} ${leave.last_name} <span>${leave.job_title}</span></a>
                                                    </h2>
                                                </td>
                                                <td>${leave.leave_name}</td>
                                                <td>${leave.from}</td>
                                                <td>${leave.to}</td>
                                                <td>${leave.number_of_days}</td>
                                                <td>${leave.reason}</td>
                                                <td class="text-center">
                                                    <div class="dropdown action-label">
                                                        <c:if test="${leave.status==1}">
                                                            <a class="btn btn-white btn-sm btn-rounded dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
                                                                <i class="fa fa-dot-circle-o text-info"></i> Pending
                                                            </a>
                                                        </c:if>
                                                        <c:if test="${leave.status==2}">
                                                            <a class="btn btn-white btn-sm btn-rounded dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
                                                                <i class="fa fa-dot-circle-o text-success"></i> Approved
                                                            </a>
                                                        </c:if>
                                                        <c:if test="${leave.status==3}">
                                                            <a class="btn btn-white btn-sm btn-rounded dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
                                                                <i class="fa fa-dot-circle-o text-danger"></i> Declined
                                                            </a>
                                                        </c:if>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-info"></i> Pending</a>
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#approve_leave"><i class="fa fa-dot-circle-o text-success"></i> Approved</a>
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-danger"></i> Declined</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-reason="${leave.reason}" data-leave_name="${leave.leave_name}" data-id="${leave.id} ${leave.profile_id} ${leave.from} ${leave.to} ${leave.number_of_days} ${leave.annual_leave}" data-toggle="modal" data-target="#edit_leave"><i class="fa fa-pencil m-r-5"></i> Detail</a>
                                                            <!--<a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_approve"><i class="fa fa-trash-o m-r-5"></i> Delete</a>-->
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
                                <form>
                                    <div class="form-group">
                                        <label>Leave Type <span class="text-danger">*</span></label>
                                        <select class="select">
                                            <option>Select Leave Type</option>
                                            <option>Casual Leave 12 Days</option>
                                            <option>Medical Leave</option>
                                            <option>Loss of Pay</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>From <span class="text-danger">*</span></label>
                                        <div class="cal-icon">
                                            <input class="form-control datetimepicker" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>To <span class="text-danger">*</span></label>
                                        <div class="cal-icon">
                                            <input class="form-control datetimepicker" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Number of days <span class="text-danger">*</span></label>
                                        <input class="form-control" readonly type="text">
                                    </div>
                                    <div class="form-group">
                                        <label>Remaining Leaves <span class="text-danger">*</span></label>
                                        <input class="form-control" readonly value="12" type="text">
                                    </div>
                                    <div class="form-group">
                                        <label>Leave Reason <span class="text-danger">*</span></label>
                                        <textarea rows="4" class="form-control"></textarea>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
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
                                <h5 class="modal-title">Leave detail</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <!--                                    <div class="form-group">
                                                                            <label>Leave Type <span class="text-danger">*</span></label>
                                                                            <select class="select">
                                                                                <option>Select Leave Type</option>
                                                                                <option>Casual Leave 12 Days</option>
                                                                            </select>
                                                                        </div>-->
                                    <!--                                    <div class="form-group">
                                                                            <label>Profile_id <span class="text-danger">*</span></label>
                                                                            <div class="">
                                                                                <input class="form-control" readonly="" name="profile_id" value="" type="text">
                                                                            </div>
                                                                        </div>-->
                                    <div class="form-group">
                                        <label>Leave Type </label>
                                        <div class="">
                                            <input class="form-control" onkeydown="event.preventDefault()" name="leave_name" value="" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>From </label>
                                        <div class="cal-icon">
                                            <input class="form-control datetimepicker" readonly="" name="from" value="" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>To </label>
                                        <div class="cal-icon">
                                            <input class="form-control datetimepicker" readonly="" name="to" value="" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Number of days </label>
                                        <input class="form-control" readonly name="number_of_days" type="text" value="">
                                    </div>
                                    <div class="form-group">
                                        <label>Remaining Leaves </label>
                                        <input class="form-control" readonly name="remaining_leave" value="" type="text">
                                    </div>
                                    <div class="form-group">
                                        <label>Leave Reason </label>
                                        <textarea rows="4" class="form-control" name="reason" onkeydown="event.preventDefault()" id="reason">Going to hospital</textarea>
                                    </div>
                                    <div class="submit-section">
                                        <!--<button class="btn btn-primary submit-btn">Save</button>-->
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Leave Modal -->

                <!-- Approve Leave Modal -->
                <div class="modal custom-modal fade" id="approve_leave" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="form-header">
                                    <h3>Leave Approve</h3>
                                    <p>Are you sure want to approve for this leave?</p>
                                </div>
                                <div class="modal-btn delete-action">
                                    <div class="row">
                                        <div class="col-6">
                                            <a href="javascript:void(0);" class="btn btn-primary continue-btn">Approve</a>
                                        </div>
                                        <div class="col-6">
                                            <a href="javascript:void(0);" data-dismiss="modal" class="btn btn-primary cancel-btn">Decline</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Approve Leave Modal -->

                <!-- Delete Leave Modal -->
                <div class="modal custom-modal fade" id="delete_approve" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="form-header">
                                    <h3>Delete Leave</h3>
                                    <p>Are you sure want to delete this leave?</p>
                                </div>
                                <div class="modal-btn delete-action">
                                    <div class="row">
                                        <div class="col-6">
                                            <a href="javascript:void(0);" class="btn btn-primary continue-btn">Delete</a>
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
                <!-- /Delete Leave Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->


    </body>
</html>
