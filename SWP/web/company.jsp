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
                                    <h3 class="page-title">Company</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Company</li>
                                    </ul>
                                </div>
                                <div class="col-auto float-right ml-auto">
                                    <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_account"><i class="fa fa-plus"></i> Add Company</a>
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
                                    <label class="focus-label">Company Name</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="lname">
                                    <label class="focus-label">Website</label>
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
                                            <th>Company Name</th>
                                            <th>Email</th>
                                            <th>Hot line</th>
                                            <th>Website</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listC}" var="c">
                                        <tr>
                                            <td>${c.id}</td>
                                            <td>${c.name}</td>
                                            <td>${c.email}</td>
                                            <td>${c.phone}</td>
                                            <td>${c.url}</td>
                                            <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item" data-toggle="modal" data-target="#delete_account" data-id="${c.id}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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
                            <h5 class="modal-title">Add Company</h5>
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
                                            <label>Company Name</label>
                                            <input class="form-control" type="text" name="acname">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Profile Usesr</label>
                                            <select class="select" name="acuser">
                                                <c:forEach items="${listP}" var="p">
                                                    <option>${p.profile_id}-${p.last_name} ${p.first_name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Company Address</label>
                                            <input class="form-control" type="text" name="acaddress">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Country</label>
                                            <input class="form-control" type="text" name="acountry">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Province</label>
                                            <input class="form-control" type="text" name="apro">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>City</label>
                                            <input type="text" class="form-control" name="acity">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Postal Code</label>
                                            <input type="text" class="form-control" name="apcode">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="text" class="form-control" name="aemail">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Phone number</label>
                                            <input type="text" class="form-control" name="aphone">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Fax</label>
                                            <input type="text" class="form-control" name="afax">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Website</label>
                                            <textarea class="form-control" name="aurl"></textarea>
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

            <!-- Delete Job Modal -->
            <div class="modal custom-modal fade" id="delete_account" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form action="authentication" do="post">
                                <input type="hidden" name="do" value="deletecompany">
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