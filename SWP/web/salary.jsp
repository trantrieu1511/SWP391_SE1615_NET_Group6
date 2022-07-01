<%-- 
    Document   : salary
    Created on : Jun 30, 2022, 1:12:14 PM
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
        <title>Salary - HRMS admin template</title>

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

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="js/html5shiv.min.js"></script>
                <script src="js/respond.min.js"></script>
        <![endif]-->
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
                $("#edit_salary").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var id = $(e.relatedTarget).attr('profile-id');
                    var basic_salary = myArray[0];
                    var DA = myArray[1];
                    var HRA = myArray[2];
                    var conveyance = myArray[3];
                    var allowance = myArray[4];
                    var medical_allowance = myArray[5];
                    var TDS = myArray[6];
                    var ESI = myArray[7];
                    var PF = myArray[8];
                    var leave = myArray[9];
                    var loan = myArray[10];
                    var professional_tax = myArray[11];
                    document.getElementById('profile_id').value = id;
                    $(e.currentTarget).find('input[name="basic_salary"]').val(basic_salary);
                    $(e.currentTarget).find('input[name="DA"]').val(DA);
                    $(e.currentTarget).find('input[name="HRA"]').val(HRA);
                    $(e.currentTarget).find('input[name="conveyance"]').val(conveyance);
                    $(e.currentTarget).find('input[name="allowance"]').val(allowance);
                    $(e.currentTarget).find('input[name="medical_allowance"]').val(medical_allowance);
                    $(e.currentTarget).find('input[name="TDS"]').val(TDS);
                    $(e.currentTarget).find('input[name="ESI"]').val(ESI);
                    $(e.currentTarget).find('input[name="PF"]').val(PF);
                    $(e.currentTarget).find('input[name="leave"]').val(leave);
                    $(e.currentTarget).find('input[name="loan"]').val(loan);
                    $(e.currentTarget).find('input[name="professional_tax"]').val(professional_tax);
                });
            });

            $(function () {
                $("#delete_salary").on("show.bs.modal", function (e) {
                    var id = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="profile_id"]').val(id);
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
                                    <h3 class="page-title">Employee Salary</h3>
                                    <ul class="breadcrumb">
                                        <!--<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>-->
                                        <li class="breadcrumb-item active">Salary</li>
                                    </ul>
                                </div>
                                <div class="col-auto float-right ml-auto">
                                    <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_salary"><i class="fa fa-plus"></i> Add Salary</a>
                                </div>
                            </div>
                        </div>
                        <!-- /Page Header -->

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
                                        <option value=""> -- Select -- </option>
                                        <option value="">Employee</option>
                                        <option value="1">Manager</option>
                                    </select>
                                    <label class="focus-label">Role</label>
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
                                    <table class="table table-striped custom-table datatable">
                                        <thead>
                                            <tr>
                                                <th>Employee</th>
                                                <th>Employee ID</th>
                                                <th>Email</th>
                                                <th>Join Date</th>
                                                <th>Role</th>
                                                <th>Designation</th>
                                                <th>Salary</th>
                                                <th>Payslip</th>
                                                <th class="text-right">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${profile}" var="p">
                                            <tr>
                                                <td>
                                                    <h2 class="table-avatar">
                                                        <!--<a href="profile.html" class="avatar"><img alt="" src="img/profiles/avatar-02.jpg"></a>-->
                                                        <a href="profile?do=getothersProfile&profile_id=${p.profile_id}">${p.first_name} ${p.last_name}<span>${p.department_name}</span></a>
                                                    </h2>
                                                </td>
                                                <td>${p.profile_id}</td>
                                                <td>${p.email}</td>
                                                <td>${p.hire_date}</td>
                                                <c:choose>
                                                    <c:when test="${p.reportto!=null}">
                                                        <td>Staff</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>Manager</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td>${p.job_title}</td>
                                                <td>${p.net_salary}</td>
                                                <td><a class="btn btn-sm btn-primary" href="salary-view.jsp">Generate Slip</a></td>
                                                <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" profile-id="${p.profile_id}" data-id="${p.basic_salary} ${p.DA} ${p.HRA} ${p.conveyance} ${p.allowance} ${p.medical_allowance} ${p.TDS} ${p.ESI} ${p.PF} ${p.leave} ${p.loan} ${p.professional_tax}" data-target="#edit_salary"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-id="${p.profile_id}" data-target="#delete_salary"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
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

                <!-- Add Salary Modal -->
                <div id="add_salary" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Staff Salary</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="salary" method="post">
                                    <input type="hidden" name="do" value="addSalary">
                                    <div class="row"> 
                                        <div class="col-sm-6"> 
                                            <div class="form-group">
                                                <label>Select Staff</label>
                                                <select class="select" name="profile_id"> 
                                                    <c:forEach items="${profile}" var="p">
                                                        <option value="${p.profile_id}">${p.first_name} ${p.last_name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <!--                                        <div class="col-sm-6"> 
                                                                                    <label>Net Salary</label>
                                                                                    <input class="form-control" type="text">
                                                                                </div>-->
                                    </div>
                                    <div class="row"> 
                                        <div class="col-sm-6"> 
                                            <h4 class="text-primary">Earnings</h4>
                                            <div class="form-group">
                                                <label>Basic</label>
                                                <input class="form-control" type="text" name="basic_salary">
                                            </div>
                                            <div class="form-group">
                                                <label>DA(40%)</label>
                                                <input class="form-control" type="text" name="DA">
                                            </div>
                                            <div class="form-group">
                                                <label>HRA(15%)</label>
                                                <input class="form-control" type="text" name="HRA">
                                            </div>
                                            <div class="form-group">
                                                <label>Conveyance</label>
                                                <input class="form-control" type="text" name="conveyance">
                                            </div>
                                            <div class="form-group">
                                                <label>Allowance</label>
                                                <input class="form-control" type="text" name="allowance">
                                            </div>
                                            <div class="form-group">
                                                <label>Medical  Allowance</label>
                                                <input class="form-control" type="text" name="medical_allowance">
                                            </div>
                                            <!--                                            <div class="form-group">
                                                                                            <label>Others</label>
                                                                                            <input class="form-control" type="text">
                                                                                        </div>
                                                                                        <div class="add-more">
                                                                                            <a href="#"><i class="fa fa-plus-circle"></i> Add More</a>
                                                                                        </div>-->
                                        </div>
                                        <div class="col-sm-6">  
                                            <h4 class="text-primary">Deductions</h4>
                                            <div class="form-group">
                                                <label>TDS</label>
                                                <input class="form-control" type="text" name="TDS">
                                            </div> 
                                            <div class="form-group">
                                                <label>ESI</label>
                                                <input class="form-control" type="text" name="ESI">
                                            </div>
                                            <div class="form-group">
                                                <label>PF</label>
                                                <input class="form-control" type="text" name="PF">
                                            </div>
                                            <div class="form-group">
                                                <label>Leave</label>
                                                <input class="form-control" type="text" name="leave">
                                            </div>
                                            <div class="form-group">
                                                <label>Loan</label>
                                                <input class="form-control" type="text" name="loan">
                                            </div>
                                            <div class="form-group">
                                                <label>Prof. Tax</label>
                                                <input class="form-control" type="text" name="professional_tax">
                                            </div>
                                            <!--                                            <div class="form-group">
                                                                                            <label>Labour Welfare</label>
                                                                                            <input class="form-control" type="text">
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <label>Others</label>
                                                                                            <input class="form-control" type="text">
                                                                                        </div>
                                                                                        <div class="add-more">
                                                                                            <a href="#"><i class="fa fa-plus-circle"></i> Add More</a>
                                                                                        </div>-->
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
                <!-- /Add Salary Modal -->

                <!-- Edit Salary Modal -->
                <div id="edit_salary" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-md" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Staff Salary</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="salary" method="post">
                                    <input type="hidden" name="do" value="editSalary">
                                    <div class="row"> 
                                        <div class="col-sm-6"> 
                                            <div class="form-group">
                                                <label>Select Staff</label>
                                                <select class="form-control" name="profile_id" id="profile_id"> 
                                                    <c:forEach items="${profile}" var="p">
                                                        <option value="${p.profile_id}">${p.first_name} ${p.last_name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <!--                                        <div class="col-sm-6"> 
                                                                                    <label>Net Salary</label>
                                                                                    <input class="form-control" type="text" value="$4000">
                                                                                </div>-->
                                    </div>
                                    <div class="row"> 
                                        <div class="col-sm-6"> 
                                            <h4 class="text-primary">Earnings</h4>
                                            <div class="form-group">
                                                <label>Basic</label>
                                                <input class="form-control" type="text" name="basic_salary">
                                            </div>
                                            <div class="form-group">
                                                <label>DA(40%)</label>
                                                <input class="form-control" type="text" name="DA">
                                            </div>
                                            <div class="form-group">
                                                <label>HRA(15%)</label>
                                                <input class="form-control" type="text" name="HRA">
                                            </div>
                                            <div class="form-group">
                                                <label>Conveyance</label>
                                                <input class="form-control" type="text" name="conveyance">
                                            </div>
                                            <div class="form-group">
                                                <label>Allowance</label>
                                                <input class="form-control" type="text" name="allowance">
                                            </div>
                                            <div class="form-group">
                                                <label>Medical  Allowance</label>
                                                <input class="form-control" type="text" name="medical_allowance">
                                            </div>
                                            <!--                                            <div class="form-group">
                                                                                            <label>Others</label>
                                                                                            <input class="form-control" type="text">
                                                                                        </div>  -->
                                        </div>
                                        <div class="col-sm-6">  
                                            <h4 class="text-primary">Deductions</h4>
                                            <div class="form-group">
                                                <label>TDS</label>
                                                <input class="form-control" type="text" name="TDS">
                                            </div> 
                                            <div class="form-group">
                                                <label>ESI</label>
                                                <input class="form-control" type="text" name="ESI">
                                            </div>
                                            <div class="form-group">
                                                <label>PF</label>
                                                <input class="form-control" type="text" name="PF">
                                            </div>
                                            <div class="form-group">
                                                <label>Leave</label>
                                                <input class="form-control" type="text" name="leave">
                                            </div>
                                            <div class="form-group">
                                                <label>Loan</label>
                                                <input class="form-control" type="text" name="loan">
                                            </div>
                                            <div class="form-group">
                                                <label>Prof. Tax</label>
                                                <input class="form-control" type="text" name="professional_tax">
                                            </div>
                                            <!--                                            <div class="form-group">
                                                                                            <label>Labour Welfare</label>
                                                                                            <input class="form-control" type="text" value="$10">
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <label>Fund</label>
                                                                                            <input class="form-control" type="text" value="$40">
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <label>Others</label>
                                                                                            <input class="form-control" type="text" value="$15">
                                                                                        </div>-->
                                        </div>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Save</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Salary Modal -->

                <!-- Delete Salary Modal -->
                <div class="modal custom-modal fade" id="delete_salary" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form action="salary" method="post">
                                    <input type="hidden" name="do" value="deleteSalary">
                                    <input type="hidden" name="profile_id">
                                    <div class="form-header">
                                        <h3>Delete Salary</h3>
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
                <!-- /Delete Salary Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->


    </body>
</html>