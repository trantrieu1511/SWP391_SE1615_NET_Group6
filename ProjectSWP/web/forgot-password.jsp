
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
<<<<<<< Updated upstream:ProjectSWP/web/forgot-password.jsp
        <title>Forgot Password - HRMS admin template</title>
		
		<!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
		
		<!-- Bootstrap CSS -->
=======
        <title>Login - HRMS admin template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

        <!-- Bootstrap CSS -->
>>>>>>> Stashed changes:build/web/login.jsp
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="assets/js/html5shiv.min.js"></script>
                <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="account-page">

        <!-- Main Wrapper -->
        <div class="main-wrapper">
<<<<<<< Updated upstream:ProjectSWP/web/forgot-password.jsp
		
			<div class="account-content">
				<a href="job-list.html" class="btn btn-primary apply-btn">Apply Job</a>
				<div class="container">
				
					<!-- Account Logo -->
					<div class="account-logo">
						<a href="index.html"><img src="img/logo2.png" alt="Dreamguy's Technologies"></a>
					</div>
					<!-- /Account Logo -->
					
					<div class="account-box">
						<div class="account-wrapper">
							<h3 class="account-title">Forgot Password?</h3>
							<p class="account-subtitle">Enter your email to get a password reset link</p>
							
							<!-- Account Form -->
							<form>
								<div class="form-group">
									<label>Email Address</label>
									<input class="form-control" type="text" name="email">
								</div>
								<div class="form-group text-center">
									<button class="btn btn-primary account-btn" type="submit">Reset Password</button>
								</div>
								<div class="account-footer">
									<p>Remember your password? <a href="login.jsp">Login</a></p>
								</div>
							</form>
							<!-- /Account Form -->
							
						</div>
					</div>
				</div>
			</div>
=======
            <div class="account-content">
                <a href="job-list.html" class="btn btn-primary apply-btn">Apply Job</a>
                <div class="container">

                    <!-- Account Logo -->
                    <div class="account-logo">
                        <a href="index.html"><img src="img/logo2.png" alt="Dreamguy's Technologies"></a>
                    </div>
                    <!-- /Account Logo -->

                    <div class="account-box">
                        <div class="account-wrapper">
                            <h3 class="account-title">Login</h3>
                            <p class="account-subtitle">Access to our dashboard</p>
                            <div class="alert-danger" role="alert">
                                ${mess}
                            </div>

                            <!-- Account Form -->
                            <form action="login" method="post">
                                <div class="form-group">
                                    <label>Email Address</label>
                                    <input class="form-control" type="text" name="user">
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
                                    <input class="form-control" type="password" name="pass">
                                </div>
                                <div class="form-group text-center">
                                    <button class="btn btn-primary account-btn" type="submit" value="login">Login</button>
                                </div>
                                <div class="account-footer">
                                    <p>Don't have an account yet? <a href="register.html">Register</a></p>
                                </div>
                            </form>
                            <!-- /Account Form -->

                        </div>
                    </div>
                </div>
            </div>
>>>>>>> Stashed changes:build/web/login.jsp
        </div>
        <!-- /Main Wrapper -->

        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>

        <!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>