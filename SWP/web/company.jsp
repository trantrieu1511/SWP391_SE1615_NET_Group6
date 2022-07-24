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
                        <div class="row">
                            <div class="col-md-8 offset-md-2">

                                <!-- Page Header -->
                                <div class="page-header">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h3 class="page-title">Company Settings</h3>
                                        </div>
                                    </div>
                                </div>
                                <!-- /Page Header -->

                                <form action="authentication?do=editcompany" method="post">
                                <c:forEach items="listC" var="c">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Company Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" value="${c.name}" name="cname">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Contact Person</label>
                                                <input class="form-control " value="${c.lname_d} ${c.fname_d}" type="text" name="pname">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input class="form-control " value="${c.address}" type="text" name="caddress">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-3">
                                            <div class="form-group">
                                                <label>Country</label>
                                                <select class="form-control select">
                                                    <option>USA</option>
                                                    <option>United Kingdom</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-3">
                                            <div class="form-group">
                                                <label>City</label>
                                                <input class="form-control" value="${c.city}" type="text" name="city">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-3">
                                            <div class="form-group">
                                                <label>State/Province</label>
                                                <select class="form-control select">
                                                    <option>California</option>
                                                    <option>Alaska</option>
                                                    <option>Alabama</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-3">
                                            <div class="form-group">
                                                <label>Postal Code</label>
                                                <input class="form-control" value="${c.postal_code}" type="text" name="pcode">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input class="form-control" value="${c.email}" type="email" name="cemail">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Phone Number</label>
                                                <input class="form-control" value="${c.phone}" type="text" name="cphone">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Mobile Number</label>
                                                <input class="form-control" value="${c.pphone_d}" type="text" name="pphone">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Fax</label>
                                                <input class="form-control" value="${c.fax}" type="text" name="fax">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label>Website Url</label>
                                                <input class="form-control" value="${c.url}" type="text" name="url">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn" type="submit">Save</button>
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

    </body>
</html>