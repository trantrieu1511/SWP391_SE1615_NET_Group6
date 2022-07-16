<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate;" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat"%>
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
        <title>Shift & Schedule - HRMS admin template</title>

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
            $(function () {
                $("#add_schedule").on("show.bs.modal", function (e) {                   
                    $("#profile").select2({
                        width: '100%',
                        placeholder: "Select an option",
                        allowClear: false
                    });
                    $('input[type=checkbox]').on('change', function (e) {
                        if ($('input[type=checkbox]:checked').length > 3) {
                            $(this).prop('checked', false);
                        }
                    });
                });
            });  
            $(function () {
                $("#edit_schedule").on("show.bs.modal", function (e) {   
                    var text = $(e.relatedTarget).attr('data-id');
                    $("#profile_edit").val(text);
                    $("#profile_edit").select2({
                        width: '100%',
                        placeholder: "Select an option",
                        allowClear: false
                    });
                    $('input[type=checkbox]').on('change', function (e) {
                        if ($('input[type=checkbox]:checked').length > 3) {
                            $(this).prop('checked', false);
                        }
                    });
                });
            }); 
            $(function(){
                $('#add_schedule').on('hidden.bs.modal', function(){
                    $(this).find('form')[0].reset();
                });
            })
            $(function(){
                $('#edit_schedule').on('hidden.bs.modal', function(){
                    $(this).find('form')[0].reset();
                });
            });
            $(function () {
                $("#delete_schedule").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="profile"]').val(text);
                });
            });
            <c:if test="${alert != ''}">
            window.onload = function () {
                alert("${alert}");
            }
            </c:if>
        </script>
        
        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
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
                                <h3 class="page-title">Daily Scheduling</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="employees.html">Employees</a></li>
                                    <li class="breadcrumb-item active">Shift Scheduling</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <a href="schedule?do=shift" class="btn add-btn m-r-5">Shifts</a>
                                <a href="#" class="btn add-btn m-r-5" data-toggle="modal" data-target="#add_schedule"> Assign Shifts</a>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Content Starts -->
                    
                    <!-- Search Filter -->
                    <form action="schedule" do="post">
                        <input type="hidden" name="do" value="search">
                        <div class="row filter-row">
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="name" pattern="[0-9A-Za-z ]{1,35}" value="${name}">                                  
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3"> 
                            </div>
                            <div class="col-sm-6 col-md-2">                             
                            </div>
                            <div class="col-sm-6 col-md-2">                             
                            </div>
                            <div class="col-sm-6 col-md-2">  
                                <button class="btn btn-success btn-block"> Search </button>  
                            </div>     
                        </div>
                    </form>
                    <!-- Search Filter -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table datatable table-nowrap mb-0">
                                    <thead>
                                        <tr>
                                            <th>Employee</th>
                                            <c:forEach items="${listS}" var="o">
                                            <th>${o.name}</th>
                                            </c:forEach> 
                                            <th class="text-right no-sort">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listPf}" var="o">
                                        <tr>                                           
                                            <td>                                          
                                                <h2><a href="profile.html">${o.first_name} ${o.last_name}</a></h2>                                           
                                            </td>     
                                            <c:forEach items="${o.department_name.split(' ')}" var="p">
                                                <c:if test="${p == 'true'}">
                                                    <td><i class="fa fa-check text-success"></i></td>
                                                </c:if>
                                                <c:if test="${p == 'false'}">
                                                    <td><i class="fa fa-close text-danger"></i></td>
                                                </c:if>
                                            </c:forEach>  
                                                    <td class="text-right">
                                                        <div class="dropdown dropdown-action">
                                                            <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_schedule" data-id="${o.profile_id}"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_schedule" data-id="${o.profile_id}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                            <form action="schedule" do="post">
                                <input type="hidden" name="do" value="editSchedule">
                                <div class="row">                                    
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Employee Name <span class="text-danger">*</span></label>
                                            <select name="profile" id="profile">
                                                <option value="" disabled selected hidden></option>
                                            <c:forEach items="${listPf}" var="o">                                               
                                                <option value="${o.profile_id}">${o.first_name} ${o.last_name}</option>
                                            </c:forEach>  
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Shifts <span class="text-danger">*</span></label>                                           
                                        <c:forEach items="${listS}" var="o">    
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="${o.name}" name="shift">
                                                <label class="form-check-label">
                                                    ${o.name}
                                                </label>
                                            </div>
                                        </c:forEach>  
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

            <!-- Edit Schedule Modal -->
            <div id="edit_schedule" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Schedule</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="schedule" do="post" id="form_edit">
                                <input type="hidden" name="do" value="editSchedule">
                                <div class="row">                                    
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Employee Name <span class="text-danger">*</span></label>
                                            <select class="select" name="profile" id="profile_edit">
                                                <option value="" disabled selected hidden></option>
                                            <c:forEach items="${listPf}" var="o">                                               
                                                <option value="${o.profile_id}">${o.first_name} ${o.last_name}</option>
                                            </c:forEach>  
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-form-label">Shifts <span class="text-danger">*</span></label>                                           
                                        <c:forEach items="${listS}" var="o">    
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="${o.name}" name="shift">
                                                <label class="form-check-label">
                                                    ${o.name}
                                                </label>
                                            </div>
                                        </c:forEach>  
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
            <!-- /Edit Schedule Modal -->
            
            <!-- Delete Shift Modal -->
            <div class="modal custom-modal fade" id="delete_schedule" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form action="schedule" do="post">
                                <input type="hidden" name="do" value="deleteSchedule">
                                <input type="hidden" name="profile">
                                <div class="form-header">
                                    <h3>Delete Shift</h3>
                                    <p>Are you sure want to delete?</p>
                                </div>
                                <div class="modal-btn delete-action">
                                    <div class="row">
                                        <div class="col-6">
                                            <input type="submit" value="Delete" href="" class="btn btn-primary continue-btn" style="padding: 10px 75px;">
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
            <!-- /Delete Shift Modal -->
            
        </div>
        <!-- /Main Wrapper -->

    </body>
</html>