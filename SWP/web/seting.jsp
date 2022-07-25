
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>Settings - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Lineawesome CSS -->
        <link rel="stylesheet" href="css/line-awesome.min.css">

        <!-- Select2 CSS -->
        <link rel="stylesheet" href="css/select2.min.css">

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

        <!-- Custom JS -->
        <script src="js/app.js"></script>

        <script type="text/javascript">
            $(function () {
                $('input[type="text"]').change(function () {
                    this.value = $.trim(this.value);
                });
            });
            <c:if test="${alert != ''}">
            window.onload = function () {
                alert("${alert}");
            }
            </c:if>
            <c:if test="${sessionScope.acc.isAdmin == false && sessionScope.acc.isManager == false}">
            $("#document").ready(function (){
                $('input[type="text"]').prop("readonly",true);
                $('input[type="email"]').prop("readonly",true);
            });
            </c:if>
            <c:if test="${sessionScope.acc.isAdmin == true || sessionScope.acc.isManager == true}">
            $("#document").ready(function (){
                $('input[type="text"]').prop("readonly",false);
                $('input[type="email"]').prop("readonly",false);
            });
            </c:if>
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
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Company Name <span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" value="${myComp.name}" name="cname">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Contact Person</label>
                                            <input class="form-control " value="${myComp.lname_d} ${myComp.fname_d}" type="text" name="pname">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input class="form-control " value="${myComp.address}" type="text" name="caddress">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-6 col-lg-3">
                                        <div class="form-group">
                                            <label>Country</label>
                                            <input class="form-control " value="${myComp.country}" type="text" name="country">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-6 col-lg-3">
                                        <div class="form-group">
                                            <label>Province</label>
                                            <input class="form-control" value="${myComp.province}" type="text" name="prov">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-6 col-lg-3">
                                        <div class="form-group">
                                            <label>City</label>
                                            <input class="form-control " value="${myComp.city}" type="text" name="city">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-6 col-lg-3">
                                        <div class="form-group">
                                            <label>Postal Code</label>
                                            <input class="form-control" value="${myComp.postal_code}" type="text" name="pcode">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input class="form-control" value="${myComp.email}" type="email" name="cemail">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Phone Number</label>
                                            <input class="form-control" value="${myComp.phone}" type="text" name="cphone">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Mobile Number</label>
                                            <input class="form-control" value="${myComp.pphone_d}" type="text" name="pphone">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Fax</label>
                                            <input class="form-control" value="${myComp.fax}" type="text" name="fax">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label>Website Url</label>
                                            <input class="form-control" value="${myComp.url}" type="text" name="url">
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${sessionScope.acc.isAdmin == true || sessionScope.acc.isManager == true}">
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn" type="submit">Save</button>
                                    </div>
                                </c:if>
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