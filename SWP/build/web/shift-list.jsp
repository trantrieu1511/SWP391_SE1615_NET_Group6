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
        <title>Shift List - HRMS admin template</title>

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

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

        <script type="text/javascript">
            $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            })
            function checkTime() {
                var a = document.getElementById('start').value + ':00';
                var b = document.getElementById('end').value + ':00';
                if (a > b) {
                    document.getElementById('alert').style.color = 'red';
                    document.getElementById('alert').innerHTML = '☒ Invalid time range';
                    document.getElementById('create').disabled = true;
                    document.getElementById('create').style.opacity = (0.4);
                } else {
                    document.getElementById('alert').style.color = 'green';
                    document.getElementById('alert').innerHTML = '🗹 Valid time range';
                    document.getElementById('create').disabled = false;
                    document.getElementById('create').style.opacity = (1);
                }
            }
            function checkTime2() {
                var a = document.getElementById('start2').value + ':00';
                var b = document.getElementById('end2').value + ':00';
                if (a > b) {
                    document.getElementById('alert2').style.color = 'red';
                    document.getElementById('alert2').innerHTML = '☒ Invalid time range';
                    document.getElementById('create2').disabled = true;
                    document.getElementById('create2').style.opacity = (0.4);
                } else {
                    document.getElementById('alert2').style.color = 'green';
                    document.getElementById('alert2').innerHTML = '🗹 Valid time range';
                    document.getElementById('create2').disabled = false;
                    document.getElementById('create2').style.opacity = (1);
                }
            }
            $(function () {
                $("#edit_shift").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="name"]').val(text);
                    $(e.currentTarget).find('input[name="oldName"]').val(text);
                });
            });
            $(function () {
                $("#edit_shift").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var start = myArray[0];
                    var end = myArray[1];
                    $(e.currentTarget).find('input[name="start"]').val(start);
                    $(e.currentTarget).find('input[name="end"]').val(end);
                });
            });
            $(function () {
                $("#delete_shift").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="name"]').val(text);
                });
            });
            $(function () {
                $("#add_schedule").on("show.bs.modal", function (e) {                   
                    $("#profile").select2({
                        width: '100%',
                        placeholder: "Select an option",
                        allowClear: false
                    });
                });
            });
        </script>

        <c:if test="${alert != ''}">
            <script lang="Javascript">
            alert("${alert}");
            </script>
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
                                    <h3 class="page-title">Shift List</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="#">Employees</a></li>
                                        <li class="breadcrumb-item active">Shift List</li>
                                    </ul>
                                </div>
                                <div class="col-auto float-right ml-auto">
                                    <a href="#" class="btn add-btn m-r-5" data-toggle="modal" data-target="#add_shift">Add Shifts</a>
                                    <a href="#" class="btn add-btn m-r-5" data-toggle="modal" data-target="#add_schedule"> Assign Shifts</a>
                                </div>
                            </div>
                        </div>
                        <!-- /Page Header -->

                        <!-- Content Starts -->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="table-responsive">
                                    <table class="table table-striped custom-table datatable">
                                        <thead>
                                            <tr>
                                                <th>Shift Name</th>                                           
                                                <th>Start Time</th>
                                                <th>End Time</th>
                                                <th class="text-right no-sort">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="o">
                                            <tr>
                                                <td>${o.name}</td>
                                                <td>${o.start_time}</td>
                                                <td>${o.end_time}</td>
                                                <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_shift" data-id="${o.name}" data-time="${o.start_time} ${o.end_time}"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_employee" data-id="${o.name}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                    <!-- /Content End -->

                </div>
                <!-- /Page Content -->

            </div>
            <!-- /Page Wrapper -->

            <!-- Add Shift Modal -->
            <div id="add_shift" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add Shift</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="schedule" do="post">
                                <input type="hidden" name="do" value="addShift">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Shift Name<span class="text-danger">*</span></label>
                                            <div>
                                                <input class="form-control" name="name" pattern="[0-9A-Za-z ]{1,15}" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Start Time<span class="text-danger">*</span></label>
                                            <div>
                                                <input class="form-control" type="time" name="start" id="start" required onchange="checkTime()">
                                            </div>									
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>End Time<span class="text-danger">*</span></label>
                                            <div>
                                                <input class="form-control" type="time" name="end" id="end" required onchange="checkTime()">
                                            </div>									
                                        </div>
                                    </div>
                                </div>
                                <span id="alert"></span>
                                <div class="submit-section">
                                    <button id="create" class="btn btn-primary submit-btn">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Add Shift Modal -->

            <!-- Edit Shift Modal -->
            <div id="edit_shift" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Shift</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="schedule" do="post">
                                <input type="hidden" name="do" value="editShift">
                                <input type="hidden" name="oldName">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="col-form-label">Shift Name<span class="text-danger">*</span></label>
                                            <div>
                                                <input class="form-control" name="name" pattern="[0-9A-Za-z ]{1,15}" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Start Time<span class="text-danger">*</span></label>
                                            <div>
                                                <input class="form-control" type="time" name="start" id="start2" required onchange="checkTime()">
                                            </div>									
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>End Time<span class="text-danger">*</span></label>
                                            <div>
                                                <input class="form-control" type="time" name="end" id="end2" required onchange="checkTime()">
                                            </div>									
                                        </div>
                                    </div>
                                </div>
                                <span id="alert2"></span>
                                <div class="submit-section">
                                    <button id="create2" class="btn btn-primary submit-btn">Submit</button>
                                </div>                              
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Edit Shift Modal -->

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
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Employee Name <span class="text-danger">*</span></label>
                                            <select class="select" id="profile">
                                            <c:forEach items="${listPf}" var="o">
                                                <option>${o.first_name} ${o.last_name}</option>
                                            </c:forEach>  
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Shifts <span class="text-danger">*</span></label>
                                            <select class="select">
                                            <c:forEach items="${list}" var="o">
                                                <option>${o.name}</option>
                                            </c:forEach>  
                                            </select>
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

            <!-- Delete Shift Modal -->
            <div class="modal custom-modal fade" id="delete_employee" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form action="schedule" do="post">
                                <input type="hidden" name="do" value="deleteShift">
                                <input type="hidden" name="name">
                                <div class="form-header">
                                    <h3>Delete Shift</h3>
                                    <p>Are you sure want to delete?</p>
                                </div>
                                <div class="modal-btn delete-action">
                                    <div class="row">
                                        <div class="col-6">
                                            <a href="#;" name="name" class="btn btn-primary continue-btn">Delete</a>
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
        <!-- /Main Wrapper -->       

    </body>
</html>