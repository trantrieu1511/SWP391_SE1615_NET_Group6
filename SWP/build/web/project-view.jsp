<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
        <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>Project View - HRMS admin template</title>

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

        <!-- Datetimepicker CSS -->
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="js/html5shiv.min.js"></script>
                <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">
            
            <div><jsp:include page="index.jsp"></jsp:include></div>
            
            <!-- Page Wrapper -->
            <div class="page-wrapper">

                <!-- Page Content -->
                <div class="content container-fluid">

                    <!-- Page Header -->
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="page-title">Hospital Admin</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Project</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#edit_project"><i class="fa fa-plus"></i> Edit Project</a>
                                <a href="task-board.jsp" class="btn btn-white float-right m-r-10" data-toggle="tooltip" title="Task Board"><i class="fa fa-bars"></i></a>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <div class="row">
                        <div class="col-lg-8 col-xl-9">
                            <div class="card">
                                <div class="card-body">
                                    <div class="project-title">
                                        <h5 class="card-title">Hospital Administration</h5>
                                        <small class="block text-ellipsis m-b-15"><span class="text-xs">2</span> <span class="text-muted">open tasks, </span><span class="text-xs">5</span> <span class="text-muted">tasks completed</span></small>
                                    </div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel elit neque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum sollicitudin libero vitae est consectetur, a molestie tortor consectetur. Aenean tincidunt interdum ipsum, id pellentesque diam suscipit ut. Vivamus massa mi, fermentum eget neque eget, imperdiet tristique lectus. Proin at purus ut sem pellentesque tempor sit amet ut lectus. Sed orci augue, placerat et pretium ac, hendrerit in felis. Integer scelerisque libero non metus commodo, et hendrerit diam aliquet. Proin tincidunt porttitor ligula, a tincidunt orci pellentesque nec. Ut ultricies maximus nulla id consequat. Fusce eu consequat mi, eu euismod ligula. Aliquam porttitor neque id massa porttitor, a pretium velit vehicula. Morbi volutpat tincidunt urna, vel ullamcorper ligula fermentum at. </p>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel elit neque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum sollicitudin libero vitae est consectetur, a molestie tortor consectetur. Aenean tincidunt interdum ipsum, id pellentesque diam suscipit ut. Vivamus massa mi, fermentum eget neque eget, imperdiet tristique lectus. Proin at purus ut sem pellentesque tempor sit amet ut lectus. Sed orci augue, placerat et pretium ac, hendrerit in felis. Integer scelerisque libero non metus commodo, et hendrerit diam aliquet. Proin tincidunt porttitor ligula, a tincidunt orci pellentesque nec. Ut ultricies maximus nulla id consequat. Fusce eu consequat mi, eu euismod ligula. Aliquam porttitor neque id massa porttitor, a pretium velit vehicula. Morbi volutpat tincidunt urna, vel ullamcorper ligula fermentum at. </p>
                                </div>
                            </div>
                            <div class="project-task">
                                <ul class="nav nav-tabs nav-tabs-top nav-justified mb-0">
                                    <li class="nav-item"><a class="nav-link active" href="#all_tasks" data-toggle="tab" aria-expanded="true">All Tasks</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#pending_tasks" data-toggle="tab" aria-expanded="false">Pending Tasks</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#completed_tasks" data-toggle="tab" aria-expanded="false">Completed Tasks</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane show active" id="all_tasks">
                                        <div class="task-wrapper">
                                            <div class="task-list-container">
                                                <div class="task-list-body">
                                                    <ul id="task-list">
                                                        <li class="task">
                                                            <div class="task-container">
                                                                <span class="task-action-btn task-check">
                                                                    <span class="action-circle large complete-btn" title="Mark Complete">
                                                                        <i class="material-icons">check</i>
                                                                    </span>
                                                                </span>
                                                                <span class="task-label" contenteditable="true">Patient appointment booking</span>
                                                                <span class="task-action-btn task-btn-right">
                                                                    <span class="action-circle large" title="Assign">
                                                                        <i class="material-icons">person_add</i>
                                                                    </span>
                                                                    <span class="action-circle large delete-btn" title="Delete Task">
                                                                        <i class="material-icons">delete</i>
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </li>
                                                        <li class="task">
                                                            <div class="task-container">
                                                                <span class="task-action-btn task-check">
                                                                    <span class="action-circle large complete-btn" title="Mark Complete">
                                                                        <i class="material-icons">check</i>
                                                                    </span>
                                                                </span>
                                                                <span class="task-label" contenteditable="true">Appointment booking with payment gateway</span>
                                                                <span class="task-action-btn task-btn-right">
                                                                    <span class="action-circle large" title="Assign">
                                                                        <i class="material-icons">person_add</i>
                                                                    </span>
                                                                    <span class="action-circle large delete-btn" title="Delete Task">
                                                                        <i class="material-icons">delete</i>
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </li>
                                                        <li class="completed task">
                                                            <div class="task-container">
                                                                <span class="task-action-btn task-check">
                                                                    <span class="action-circle large complete-btn" title="Mark Complete">
                                                                        <i class="material-icons">check</i>
                                                                    </span>
                                                                </span>
                                                                <span class="task-label">Doctor available module</span>
                                                                <span class="task-action-btn task-btn-right">
                                                                    <span class="action-circle large" title="Assign">
                                                                        <i class="material-icons">person_add</i>
                                                                    </span>
                                                                    <span class="action-circle large delete-btn" title="Delete Task">
                                                                        <i class="material-icons">delete</i>
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </li>
                                                        <li class="task">
                                                            <div class="task-container">
                                                                <span class="task-action-btn task-check">
                                                                    <span class="action-circle large complete-btn" title="Mark Complete">
                                                                        <i class="material-icons">check</i>
                                                                    </span>
                                                                </span>
                                                                <span class="task-label" contenteditable="true">Patient and Doctor video conferencing</span>
                                                                <span class="task-action-btn task-btn-right">
                                                                    <span class="action-circle large" title="Assign">
                                                                        <i class="material-icons">person_add</i>
                                                                    </span>
                                                                    <span class="action-circle large delete-btn" title="Delete Task">
                                                                        <i class="material-icons">delete</i>
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </li>
                                                        <li class="task">
                                                            <div class="task-container">
                                                                <span class="task-action-btn task-check">
                                                                    <span class="action-circle large complete-btn" title="Mark Complete">
                                                                        <i class="material-icons">check</i>
                                                                    </span>
                                                                </span>
                                                                <span class="task-label" contenteditable="true">Private chat module</span>
                                                                <span class="task-action-btn task-btn-right">
                                                                    <span class="action-circle large" title="Assign">
                                                                        <i class="material-icons">person_add</i>
                                                                    </span>
                                                                    <span class="action-circle large delete-btn" title="Delete Task">
                                                                        <i class="material-icons">delete</i>
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </li>
                                                        <li class="task">
                                                            <div class="task-container">
                                                                <span class="task-action-btn task-check">
                                                                    <span class="action-circle large complete-btn" title="Mark Complete">
                                                                        <i class="material-icons">check</i>
                                                                    </span>
                                                                </span>
                                                                <span class="task-label" contenteditable="true">Patient Profile add</span>
                                                                <span class="task-action-btn task-btn-right">
                                                                    <span class="action-circle large" title="Assign">
                                                                        <i class="material-icons">person_add</i>
                                                                    </span>
                                                                    <span class="action-circle large delete-btn" title="Delete Task">
                                                                        <i class="material-icons">delete</i>
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="task-list-footer">
                                                    <div class="new-task-wrapper">
                                                        <textarea  id="new-task" placeholder="Enter new task here. . ."></textarea>
                                                        <span class="error-message hidden">You need to enter a task first</span>
                                                        <span class="add-new-task-btn btn" id="add-task">Add Task</span>
                                                        <span class="btn" id="close-task-panel">Close</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="pending_tasks"></div>
                                    <div class="tab-pane" id="completed_tasks"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-xl-3">
                            <div class="card">
                                <div class="card-body">
                                    <h6 class="card-title m-b-15">Project details</h6>
                                    <table class="table table-striped table-border">
                                        <tbody>
                                            <tr>
                                                <td>Cost:</td>
                                                <td class="text-right">$1200</td>
                                            </tr>
                                            <tr>
                                                <td>Total Hours:</td>
                                                <td class="text-right">100 Hours</td>
                                            </tr>
                                            <tr>
                                                <td>Created:</td>
                                                <td class="text-right">25 Feb, 2019</td>
                                            </tr>
                                            <tr>
                                                <td>Deadline:</td>
                                                <td class="text-right">12 Jun, 2019</td>
                                            </tr>                                           
                                            <tr>
                                                <td>Client:</td>
                                                <td class="text-right"><a href="#">Barry Cuda</a></td>
                                            </tr>
                                            <tr>
                                                <td>Status:</td>
                                                <td class="text-right">Working</td>
                                            </tr>
                                        </tbody>
                                    </table>                                    
                                </div>
                            </div>
                            <div class="card project-user">
                                <div class="card-body">
                                    <h6 class="card-title m-b-20">Assigned Leader</h6>
                                    <ul class="list-box">
                                        <li>
                                            <a href="#">
                                                <span class="message-author">Wilmer Deluna</span>
                                                <div class="clearfix"></div>
                                                <span class="message-content">Team Leader</span>
                                            </a>
                                        </li>                                        
                                    </ul>
                                </div>
                            </div>
                            <div class="card project-user">
                                <div class="card-body">
                                    <h6 class="card-title m-b-20">
                                        Assigned member                                         
                                    </h6>
                                    <ul class="list-box">
                                        <li>
                                            <a href="#">
                                                <span class="message-author">John Doe</span>
                                                <div class="clearfix"></div>
                                                <span class="message-content">Web Designer</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">                                                                                                                                                   
                                                <span class="message-author">Richard Miles</span>
                                                <div class="clearfix"></div>
                                                <span class="message-content">Web Developer</span>                                                 
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->  

                <!-- Edit Project Modal -->
                <div id="edit_project" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Project</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Project Name</label>
                                                <input class="form-control" value="Project Management" type="text">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Client</label>
                                                <select class="select">
                                                    <option>Global Technologies</option>
                                                    <option>Delta Infotech</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Start Date</label>
                                                <div class="cal-icon">
                                                    <input class="form-control datetimepicker" type="text">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>End Date</label>
                                                <div class="cal-icon">
                                                    <input class="form-control datetimepicker" type="text">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Rate</label>
                                                <input placeholder="$50" class="form-control" value="$5000" type="text">
                                            </div>
                                        </div>                                                                          
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea rows="4" class="form-control" placeholder="Enter your message here"></textarea>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Save</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Project Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

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

        <!-- Task JS -->
        <script src="js/task.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>

    </body>
</html>