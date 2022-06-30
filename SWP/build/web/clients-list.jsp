<%-- 
    Document   : clients-list
    Created on : Jun 19, 2022, 7:01:10 PM
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
        <title>Clients - HRMS admin template</title>

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

        <!-- Datatable JS -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>

        <!-- Select2 JS -->
        <script src="js/select2.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>
        <script src="js/edit.js"></script>

        <!-- Model JS -->
        <script type="text/javascript">
            $(function () {
                $("#edit_client").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id');
                    const myArray = text.split(" ");
                    var id = myArray[0];
                    var first_name = myArray[1];
                    var last_name = myArray[2];
                    var email = myArray[3];
                    var phone_number = myArray[4];
                    var company_id = myArray[5];
                    $(e.currentTarget).find('input[name="client_id"]').val(id);
                    $(e.currentTarget).find('input[name="first_name"]').val(first_name);
                    $(e.currentTarget).find('input[name="last_name"]').val(last_name);
                    $(e.currentTarget).find('input[name="email"]').val(email);
                    $(e.currentTarget).find('input[name="phone_number"]').val(phone_number);
                    document.getElementById('company_id2').value = company_id;

                });
            });
            $(function () {
                $("#delete_client").on("show.bs.modal", function (e) {
                    var id = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="client_id"]').val(id);
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

    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>

            <!-- Page Wrapper -->
            <div class="page-wrapper">

                <!-- Page Content -->
                <div class="content container-fluid">

                    <!-- Page Header -->
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="page-title">Clients</h3>
                                <ul class="breadcrumb">
                                <c:if test="${sessionScope.acc.isManager == true}">
                                    <li class="breadcrumb-item"><a href="manager?do=dashboard">Dashboard</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.isManager == false}">
                                    <li class="breadcrumb-item"><a href="employee?do=dashboard">Dashboard</a></li>
                                    </c:if>
                                <li class="breadcrumb-item active">Clients</li>
                            </ul>
                        </div>
                        <c:if test="${sessionScope.acc.isManager==true}">
                            <div class="col-auto float-right ml-auto">
                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#add_client"><i class="fa fa-plus"></i> Add Client</a>
                                <div class="view-icons">
                                    <!--<a href="clients.html" class="grid-view btn btn-link"><i class="fa fa-th"></i></a>-->
                                    <!--<a href="clients-list.html" class="list-view btn btn-link active"><i class="fa fa-bars"></i></a>-->
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
                <!-- /Page Header -->

                <!-- Search Filter -->
                <form action="client?do=filter" method="post">
                    <div class="row filter-row">
                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating" name="cid">
                                <label class="focus-label">Client ID</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">  
                            <div class="form-group form-focus">
                                <input type="text" class="form-control floating" name="cname">
                                <label class="focus-label">Client Name</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3"> 
                            <div class="form-group form-focus select-focus">
                                <select class="select floating" name="ccompany"> 
                                    <option value="">Select Company</option>
                                    <c:forEach items="${listcpn}" var="cpn">
                                        <option value="${cpn.id}">${cpn.name}</option>
                                    </c:forEach>
                                </select>
                                <label class="focus-label">Company</label>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">  
                            <input type="submit" class="btn btn-success btn-block" value="Search" style="padding: 0px">
                        </div>     
                    </div>
                </form>
                <!-- Search Filter -->

                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped custom-table datatable">
                                <c:if test="${filter == 'no'}">
                                    <h4><a href="client?do=list" style="text-decoration: none; color: grey"> <-- back</a></h4>
                                </c:if>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Client ID</th>
                                        <th>Contact Person</th>
                                        <th>Email</th>
                                        <th>Mobile</th>
                                        <!--<th>Status</th>-->
                                        <c:if test="${sessionScope.acc.isManager==true}">
                                            <th class="text-right">Action</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listcl}" var="cl">
                                        <tr>
                                            <td>
                                                <h2 class="table-avatar">
                                                    <!--<a href="client-profile.html" class="avatar"><img src="img/profiles/avatar-19.jpg" alt=""></a>-->
                                                    <a href="client?do=getclientProfile&client_id=${cl.client_id}">${cl.company_name}</a>
                                                </h2>
                                            </td>
                                            <td>${cl.client_id}</td>
                                            <td>${cl.first_name} ${cl.last_name}</td>
                                            <td>${cl.email}</td>
                                            <c:choose>
                                                <c:when test="${cl.phone_number.equals('')}">
                                                    <td>N/A</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${cl.phone_number}</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <!--                                            <td>
                                                                                            <div class="dropdown action-label">
                                                                                                <a href="#" class="btn btn-white btn-sm btn-rounded dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-dot-circle-o text-success"></i> Active </a>
                                                                                                <div class="dropdown-menu">
                                                                                                    <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-success"></i> Active</a>
                                                                                                    <a class="dropdown-item" href="#"><i class="fa fa-dot-circle-o text-danger"></i> Inactive</a>
                                                                                                </div>
                                                                                            </div>
                                                                                        </td>-->
                                            <c:if test="${sessionScope.acc.isManager==true}">
                                                <td class="text-right">
                                                    <div class="dropdown dropdown-action">
                                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-id="${cl.client_id} ${cl.first_name} ${cl.last_name} ${cl.email} ${cl.phone_number} ${cl.company_id}" data-target="#edit_client"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-id="${cl.client_id}" data-target="#delete_client"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Page Content -->

            <!-- Add Client Modal -->
            <div id="add_client" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add Client</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="client" method="post">
                                <input type="hidden" name="do" value="addClient">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" name="first_name" required pattern="[A-Za-z]{1,12}"
                                                   title="FirstName not contain: Unicode characters, 
                                                   special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                   allow uppercase and lowercase letters, max length: 12">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Last Name <span class="text-danger">*</span></label>
                                            <input class="form-control" type="text" name="last_name" required pattern="[A-Za-z]{1,12}"
                                                   title="FirstName not contain: Unicode characters, 
                                                   special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                   allow uppercase and lowercase letters, max length: 12">
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                                                                <input class="form-control" type="text">
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                            <input class="form-control floating" type="text" name="email" placeholder="e.g: abc@mail.com" required pattern="[a-zA-Z0-9]{1,12}[@][a-z]{1,6}[.][a-z]{1,6}"
                                                   title="email not allow: Unicode characters, 
                                                   special character other than @ and . and spacing characters;  
                                                   allow uppercase, lowercase letters and numeric characters (0-9);
                                                   maximum length of parts of email: 
                                                   username: 20, mail server: 12, domain: 12; 
                                                   max length: 46">
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Password</label>
                                                                                <input class="form-control" type="password">
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Confirm Password</label>
                                                                                <input class="form-control" type="password">
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-md-6">  
                                        <div class="form-group">
                                            <label class="col-form-label">Client ID <span class="text-danger">*</span></label>
                                            <input class="form-control floating" type="text" name="client_id" required pattern="[A-Z0-9]{5}"
                                                   title="Client ID not allow Unicode characters; Can contain both uppercase letters and/or numbers (0-9);
                                                   max length: 5">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Phone </label>
                                            <input class="form-control" type="text" name="phone_number" pattern="[0-9]{10}" title="phone number must be 10-digit number">
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Company Name <span class="text-danger">*</span></label>
                                                                                <input class="form-control" type="text" name="company" required placeholder="Enter Company Name" pattern="[A-Za-z ]{1,25}"
                                                                                       title="Company Name not contain: Unicode characters, 
                                                                                       special character e.g: !@#$%^& etc.. ,
                                                                                       numeric character: 0-9; allow spacing characters; max length: 25">
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Company Name <span class="text-danger">*</span></label>
                                            <select class="select" name="company_id" id="company_id" required="">
                                                <option value="">Select Company</option>
                                                <c:forEach items="${listcpn}" var="cpn">
                                                    <option value="${cpn.id}">${cpn.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="submit-section">
                                    <button class="btn btn-primary submit-btn">add</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Add Client Modal -->

            <!-- Edit Client Modal -->
            <div id="edit_client" class="modal custom-modal fade" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Client</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="client" method="post">
                                <input type="hidden" name="do" value="editClient">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">First Name <span class="text-danger">*</span></label>
                                            <input class="form-control" value="" type="text" name="first_name" required pattern="[A-Za-z]{1,12}"
                                                   title="FirstName not contain: Unicode characters, 
                                                   special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                   allow uppercase and lowercase letters, max length: 12">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Last Name <span class="text-danger">*</span></label>
                                            <input class="form-control" value="" type="text" name="last_name" required pattern="[A-Za-z]{1,12}"
                                                   title="FirstName not contain: Unicode characters, 
                                                   special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  
                                                   allow uppercase and lowercase letters, max length: 12">
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Username <span class="text-danger">*</span></label>
                                                                                <input class="form-control" value="barrycuda" type="text">
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Email <span class="text-danger">*</span></label>
                                            <input class="form-control floating" value="" type="text" name="email" placeholder="e.g: abc@mail.com" required pattern="[a-zA-Z0-9]{1,12}[@][a-z]{1,6}[.][a-z]{1,6}"
                                                   title="email not allow: Unicode characters, 
                                                   special character other than @ and . and spacing characters;  
                                                   allow uppercase, lowercase letters and numeric characters (0-9);
                                                   maximum length of parts of email: 
                                                   username: 20, mail server: 12, domain: 12; 
                                                   max length: 46">
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Password</label>
                                                                                <input class="form-control" value="barrycuda" type="password">
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Confirm Password</label>
                                                                                <input class="form-control" value="barrycuda" type="password">
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-md-6">  
                                        <div class="form-group">
                                            <label class="col-form-label">Client ID <span class="text-danger">*</span></label>
                                            <input class="form-control floating" value="" type="text" name="client_id" readonly="" required pattern="[A-Z0-9]{5}"
                                                   title="Client ID not allow Unicode characters; Can contain both uppercase letters and/or numbers (0-9);
                                                   max length: 5">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Phone </label>
                                            <input class="form-control" value="" type="text" name="phone_number" pattern="[0-9]{10}" title="phone number must be 10-digit number">
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-6">
                                                                            <div class="form-group">
                                                                                <label class="col-form-label">Company Name <span class="text-danger">*</span></label>
                                                                                <input class="form-control" type="text" value="" name="company" required placeholder="Enter Company Name" pattern="[A-Za-z ]{1,25}"
                                                                                       title="Company Name not contain: Unicode characters, 
                                                                                       special character e.g: !@#$%^& etc.. ,
                                                                                       numeric character: 0-9; allow spacing characters; max length: 25">
                                                                            </div>
                                                                        </div>-->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="col-form-label">Company Name <span class="text-danger">*</span></label>
                                            <select class="form-control" name="company_id" id="company_id2" required="">
                                                <option value="">Select Company</option>
                                                <c:forEach items="${listcpn}" var="cpn">
                                                    <option value="${cpn.id}">${cpn.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
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
            <!-- /Edit Client Modal -->

            <!-- Delete Client Modal -->
            <div class="modal custom-modal fade" id="delete_client" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form action="client" do="post">
                                <input type="hidden" name="do" value="deleteClient">
                                <input type="hidden" name="client_id">
                                <div class="form-header">
                                    <h3>Delete Client</h3>
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
            <!-- /Delete Client Modal -->

        </div>
        <!-- /Page Wrapper -->




    </body>
</html>
