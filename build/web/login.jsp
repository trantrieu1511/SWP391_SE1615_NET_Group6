<%-- 
    Document   : login
    Created on : Jun 2, 2022, 4:35:43 PM
    Author     : DELL
--%>

<%@page import="entity.Profile"%>
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
        <title>Login - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="assets/js/html5shiv.min.js"></script>
                <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <script>
            function checkLogin() {
                if (document.getElementById('username').value != "" &&
                        document.getElementById('password').value != "") {

                } else {
                    alert("Please fill all the fields!");
                }
            }

        </script>

    </head>
    <body class="account-page">

        <!-- Main Wrapper -->
        <div class="main-wrapper">
            <div class="account-content">
                <a href="job-list.html" class="btn btn-primary apply-btn">Apply Job</a>
                <div class="container">

                    <!-- Account Logo -->
                    <div class="account-logo">
                        <a href="index.html"><img src="assets/img/logo2.png" alt="Dreamguy's Technologies"></a>
                    </div>
                    <!-- /Account Logo -->

                    <div class="account-box">
                        <div class="account-wrapper">
                            <h3 class="account-title">Login</h3>
                            <p class="account-subtitle">Access to our dashboard</p>
                            <p class="alert-danger">
                                <%
                                    Profile pro = (Profile) session.getAttribute("acc");
                                    if (pro == null) {
                                        Object loginfail = session.getAttribute("status");
                                        if (loginfail!=null) {
//                                        String message = session.getAttribute("mess").toString();
                                            out.print("Username or password isn't correct! Please check again!");
                                        }
                                    }
                                %>
                            </p>
                            <!-- Account Form -->
                            <form action="ControllerProfile?do=login" method="post">
                                <div class="form-group">
                                    <label>Email Address</label>
                                    <input class="form-control" type="text" id="username" name="username" required="">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col">
                                            <label>Password</label>
                                        </div>
                                        <div class="col-auto">
                                            <a class="text-muted" href="forgot-password.jsp">
                                                Forgot password?
                                            </a>
                                        </div>
                                    </div>
                                    <input class="form-control" type="password" id="password" name="password" required="">
                                </div>
                                <div class="form-group text-center">
                                    <input class="btn btn-primary account-btn" type="submit" onclick="checkLogin()" id="submit" value="login" >
                                </div>
                                <!--div class="account-footer">
                                        <p>Don't have an account yet? <a href="register.html">Register</a></p>
                                </div-->
                            </form>
                            <!-- /Account Form -->

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Main Wrapper -->

        <!-- jQuery -->
        <script src="assets/js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- Custom JS -->
        <script src="assets/js/app.js"></script>

    </body>
</html>
