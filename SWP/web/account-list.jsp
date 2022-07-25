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
        <title>Account - HRMS admin template</title>

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
                $("#edit_account").on("show.bs.modal", function (e) {
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
                    var isamin_d = myArray[8];
                    var ismanager_d = myArray[9];
                    var status_d = myArray[10];
                    $(e.currentTarget).find('input[name="eid"]').val(id);
                    $(e.currentTarget).find('input[name="efname"]').val(first_name);
                    $(e.currentTarget).find('input[name="elname"]').val(last_name);
                    $(e.currentTarget).find('input[name="eemail"]').val(email);
                    $(e.currentTarget).find('input[name="epnumber"]').val(phone_number);
                    $(e.currentTarget).find('input[name="ehiredate"]').val(hire_date);
                    $(e.currentTarget).find('input[name="euser"]').val(username);
                    $(e.currentTarget).find('input[name="epass"]').val(password);
                    $(e.currentTarget).find('input[name="eisa"]').val(isamin_d);
                    $(e.currentTarget).find('input[name="eism"]').val(ismanager_d);
                    $(e.currentTarget).find('input[name="estatus"]').val(status_d);
                });
            });
            $(function () {
                $("#add_account").on("show.bs.modal", function (e) {
                    var reportto = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="ReportsTo"]').val(reportto);
                });
            });
            $(function () {
                $("#delete_account").on("show.bs.modal", function (e) {
                    var id = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="aprofile_id"]').val(id);
                });
            });
        </script>

        <c:choose>
            <c:when test="${alert != ''}">
                <script type="text/javascript">
                    alert("${alert}");
                </script>
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>

        <script type="text/javascript">
            $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            })
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
                                    <h3 class="page-title">Account</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Account</li>
                                    </ul>
                                </div>
                                <div class="col-auto float-right ml-auto">
                                    <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_account"><i class="fa fa-plus"></i> Add User</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Search Filter -->
                    <form action="authentication" do="post">
                        <input type="hidden" name="do" value="search">
                        <div class="row filter-row">
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="fname">
                                    <label class="focus-label">First Name</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="lname">
                                    <label class="focus-label">Last Name</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="email">
                                    <label class="focus-label">Email</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="pnum">
                                    <label class="focus-label">Phone Number</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="user">
                                    <label class="focus-label">User Name</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3"> 
                                <div class="form-group form-focus select-focus">
                                    <select class="select floating" name="isa"> 
                                        <option>Select</option>
                                        <option>True</option>
                                        <option>False</option>
                                    </select>
                                    <label class="focus-label">IsAdmin</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3"> 
                                <div class="form-group form-focus select-focus">
                                    <select class="select floating" name="ism"> 
                                        <option>Select</option>
                                        <option>True</option>
                                        <option>False</option>
                                    </select>
                                    <label class="focus-label">IsManager</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3"> 
                                <div class="form-group form-focus select-focus">
                                    <select class="select floating" name="status"> 
                                        <option>Select</option>
                                        <option>True</option>
                                        <option>False</option>
                                    </select>
                                    <label class="focus-label">Status</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <input type="submit" class="btn btn-success btn-block" value="Search" style="padding: 0px">
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <input type="submit" class="btn btn-success btn-block" value="Clear" style="padding: 0px">
                            </div>  
                        </div>
                    </form>
                    <!-- /Search Filter -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped custom-table mb-0 datatable">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Full Name</th>
                                            <th>Email</th>
                                            <th>Phone Number</th>
                                            <th>Hire date</th>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th class="text-center">IsAdmin</th>
                                            <th class="text-center">IsManager</th>
                                            <th class="text-center">Status</th>
                                            <th class="text-right">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listP}" var="p">
                                        <tr>
                                            <td>${p.profile_id}</td>
                                            <td>${p.first_name} ${p.last_name}</td>
                                            <td>${p.email}</td>
                                            <td>${p.phone_number}</td>
                                            <td>${p.hire_date}</td>
                                            <td>${p.user_display}</td>
                                            <td>${p.pass_display}</td>
                                            <td class="text-center">
                                                <div class="dropdown action-label">
                                                    <a class="btn btn-white btn-sm btn-rounded dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
                                                        <i class="fa fa-dot-circle-o text-danger"></i><c:if test="${p.isadmin_d == 1}">True</c:if><c:if test="${p.isadmin_d == 0}">False</c:if>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-info"></i> True</a>
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-success"></i> False</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-center">
                                                    <div class="dropdown action-label">
                                                        <a class="btn btn-white btn-sm btn-rounded dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
                                                                <i class="fa fa-dot-circle-o text-danger"></i><c:if test="${p.ismanager_d == 1}">True</c:if><c:if test="${p.ismanager_d == 0}">False</c:if>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-info"></i> True</a>
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-success"></i> False</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-center">
                                                    <div class="dropdown action-label">
                                                        <a class="btn btn-white btn-sm btn-rounded dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">
                                                                <i class="fa fa-dot-circle-o text-danger"></i><c:if test="${p.status_d == 1}">True</c:if><c:if test="${p.status_d == 0}">False</c:if>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-info"></i> Open</a>
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-success"></i> Closed</a>
                                                            <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-danger"></i> Cancelled</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                                <a href="#" class="dropdown-item" data-toggle="modal" data-id="${p.profile_id} ${p.first_name} ${p.last_name} ${p.email} ${p.phone_number} ${p.hire_date} ${p.user_display} ${p.pass_display} ${p.isadmin_d} ${p.ismanager_d} ${p.status_d}" data-target="#edit_account"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a href="#" class="dropdown-item" data-toggle="modal" data-target="#delete_account" data-id="${p.profile_id}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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

            <!-- Add Job Modal -->
            <div id="add_account" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add User</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="authentication" do="post">
                                <input type="hidden" name="do" value="addaccount">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input class="form-control" type="text" name="fname">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>IsAdmin</label>
                                            <select class="select" name="isAdmin">
                                                <option>-</option>
                                                <option>True</option>
                                                <option>False</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input class="form-control" type="text" name="lname">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>IsManager</label>
                                            <select class="select" name="isManager">
                                                <option>-</option>
                                                <option>True</option>
                                                <option>False</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Phone Number</label>
                                            <input type="text" class="form-control" name="pnumber">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>User</label>
                                            <input class="form-control" type="text" name="auser">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="text" class="form-control" name="email">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input type="password" class="form-control" name="pass">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Note</label>
                                            <textarea class="form-control" name="note"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Status</label>
                                            <select class="select">
                                                <option>Open</option>
                                                <option>Closed</option>
                                                <option>Cancelled</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Hire Date</label>
                                            <input type="text" class="form-control datetimepicker" name="hiredate">
                                        </div>
                                    </div>
                                </div>
                                <div class="submit-section">
                                    <button type="submit" class="btn btn-primary submit-btn">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Add Job Modal -->

            <!-- Edit Job Modal -->
            <div id="edit_account" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit User</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="authentication" do="post">
                                <input type="hidden" name="do" value="editaccount">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>ID</label>
                                            <input class="form-control" type="text" name="eid" disabled="disable">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>IsAdmin</label>
                                            <select class="select" name="eisa">
                                                <option></option>
                                                <option>True</option>
                                                <option>False</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input class="form-control" type="text" name="efname">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>IsManager</label>
                                            <select class="select" name="eism">
                                                <option>-</option>
                                                <option>True</option>
                                                <option>False</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input class="form-control" type="text" name="elname">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>User</label>
                                            <input class="form-control" type="text" name="ejob">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Phone Number</label>
                                            <input type="text" class="form-control" name="epnumber">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input type="password" class="form-control" name="edepartment">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="text" class="form-control" name="eemail">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Status</label>
                                            <select class="select" name="estatus">
                                                <option>Open</option>
                                                <option>Closed</option>
                                                <option>Cancelled</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Note</label>
                                            <textarea class="form-control" name="email"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Hire Date</label>
                                            <input type="text" class="form-control datetimepicker" name="ehiredate">
                                        </div>
                                    </div>
                                </div>
                                <div class="submit-section">
                                    <button type="submit" class="btn btn-primary submit-btn">Save</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Edit Job Modal -->

            <!-- Delete Job Modal -->
            <div class="modal custom-modal fade" id="delete_account" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form action="authentication" do="post">
                                <input type="hidden" name="do" value="delete">
                                <input type="hidden" name="aprofile_id">
                                <div class="form-header">
                                    <h3>Delete User</h3>
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
            <!-- /Delete Job Modal -->

        </div>
        <!-- /Page Wrapper -->

    </div>
    <!-- /Main Wrapper -->

</body>
</html>