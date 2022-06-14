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

        <!-- Bean -->
        <jsp:useBean id="profile" class="model.DAOProfile" scope="request"></jsp:useBean>
        <jsp:useBean id="job" class="model.DAOJob" scope="request"></jsp:useBean>
        <jsp:useBean id="task" class="model.DAOTask" scope="request"></jsp:useBean>
        <jsp:useBean id="project" class="model.DAOProject" scope="request"></jsp:useBean>
        <jsp:useBean id="clients" class="model.DAOClients" scope="request"></jsp:useBean>
        
        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        
    </head>
    <body>
        <!-- Main Wrapper -->
        <div class="main-wrapper">
            
            <div><jsp:include page="menu.jsp"></jsp:include></div>
            
            <!-- Page Wrapper -->
            <div class="page-wrapper">

                <!-- Page Content -->
                <div class="content container-fluid">

                    <!-- Page Header -->
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="page-title">Project</h3>
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
                                    <c:if test="${profile.getByID(sessionScope.acc.profile_id).getReportto() == null}">
                                    <div class="project-title">
                                        <h5 class="card-title">${project.getProject(sessionScope.acc.profile_id).getTitle()}</h5>
                                        <small class="block text-ellipsis m-b-15"><span class="text-xs">2</span> <span class="text-muted">open tasks, </span><span class="text-xs">5</span> <span class="text-muted">tasks completed</span></small>
                                    </div>
                                    <p>${project.getProject(sessionScope.acc.profile_id).getDescription()}</p>     
                                    </c:if>
                                    <c:if test="${profile.getByID(sessionScope.acc.profile_id).getReportto() != null}">
                                    <div class="project-title">
                                        <h5 class="card-title">${project.getProject(profile.getByID(sessionScope.acc.profile_id).getReportto()).getTitle()}</h5>
                                        <small class="block text-ellipsis m-b-15"><span class="text-xs">2</span> <span class="text-muted">open tasks, </span><span class="text-xs">5</span> <span class="text-muted">tasks completed</span></small>
                                    </div>
                                    <p>${project.getProject(profile.getByID(sessionScope.acc.profile_id).getReportto()).getDescription()}</p>   
                                    </c:if>
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
                                                        <c:forEach items="${task.list(0)}" var="o">
                                                        <li class="task">
                                                            <div class="task-container">                                                            
                                                                <span class="task-label" contenteditable="false">${o.name}</span>                                                   
                                                            </div>
                                                        </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="pending_tasks">
                                        <div class="task-wrapper">
                                            <div class="task-list-container">
                                                <div class="task-list-body">
                                                    <ul id="task-list">
                                                        <c:forEach items="${task.list(1)}" var="o">
                                                        <li class="task">
                                                            <div class="task-container">                                                            
                                                                <span class="task-label" contenteditable="false">${o.name}</span>                                                   
                                                            </div>
                                                        </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="completed_tasks">
                                        <div class="task-wrapper">
                                            <div class="task-list-container">
                                                <div class="task-list-body">
                                                    <ul id="task-list">
                                                        <c:forEach items="${task.list(3)}" var="o">
                                                        <li class="task">
                                                            <div class="task-container">                                                            
                                                                <span class="task-label" contenteditable="false">${o.name}</span>                                                   
                                                            </div>
                                                        </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-xl-3">
                            <div class="card">
                                <div class="card-body">
                                    <h6 class="card-title m-b-15">Project details</h6>
                                    <table class="table table-striped table-border">
                                        <tbody>
                                            <c:if test="${profile.getByID(sessionScope.acc.profile_id).getReportto() != null}">
                                            <tr>
                                                <td>Cost:</td>
                                                <td class="text-right">${project.getProject(profile.getByID(sessionScope.acc.profile_id).getReportto()).getRate()}</td>
                                            </tr>                                            
                                            <tr>
                                                <td>Created:</td>
                                                <td class="text-right">${project.getProject(profile.getByID(sessionScope.acc.profile_id).getReportto()).getStart_date()}</td>
                                            </tr>
                                            <tr>
                                                <td>Deadline:</td>
                                                <td class="text-right">${project.getProject(profile.getByID(sessionScope.acc.profile_id).getReportto()).getEnd_date()}</td>
                                            </tr>                                           
                                            <tr>
                                                <td>Client:</td>
                                                <td class="text-right"><a href="#">${project.getProject(profile.getByID(sessionScope.acc.profile_id).getReportto()).getClient()}</a></td>
                                            </tr>
                                            <tr>
                                                <td>Status:</td>
                                                <td class="text-right">Working</td>
                                            </tr>
                                            </c:if>
                                            <c:if test="${profile.getByID(sessionScope.acc.profile_id).getReportto() == null}">
                                            <tr>
                                                <td>Cost:</td>
                                                <td class="text-right">${project.getProject(sessionScope.acc.profile_id).getRate()}</td>
                                            </tr>                                            
                                            <tr>
                                                <td>Created:</td>
                                                <td class="text-right">${project.getProject(sessionScope.acc.profile_id).getStart_date()}</td>
                                            </tr>
                                            <tr>
                                                <td>Deadline:</td>
                                                <td class="text-right">${project.getProject(sessionScope.acc.profile_id).getEnd_date()}</td>
                                            </tr>                                           
                                            <tr>
                                                <td>Client:</td>
                                                <td class="text-right"><a href="#">${project.getProject(sessionScope.acc.profile_id).getClient()}</a></td>
                                            </tr>
                                            <tr>
                                                <td>Status:</td>
                                                <td class="text-right">Working</td>
                                            </tr> 
                                            </c:if>
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
                                                <span class="message-author">${profile.getByID(sessionScope.acc.profile_id).getFirst_name()} ${profile.getByID(sessionScope.acc.profile_id).getLast_name()}</span>
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
                                        <c:forEach items="${profile.listAllStaff(sessionScope.acc.profile_id)}" var="o">  
                                        <li>
                                            <a href="#">
                                                <span class="message-author">${o.first_name} ${o.last_name}</span>
                                                <div class="clearfix"></div>
                                                <span class="message-content">${job.getJobById(o.job_id).getTitle()}</span>
                                            </a>
                                        </li>                                   
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->  
                
                <!-- Create Project Modal -->
                <div id="create_project" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Create Project</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="manager" do="post">
                                    <input type="hidden" name="do" value="createProject">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Project Title</label>
                                                <input class="form-control" type="text" name="title">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Client</label>
                                                <select class="select" name="client">
                                                <c:forEach items="${clients.listAllClients()}" var="o">
                                                    <option value="${o.client_id}">${o.company}</option>
                                                </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Start Date</label>
                                                <div class="cal-icon">
                                                    <input class="form-control datetimepicker" type="text" name="start_date">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>End Date</label>
                                                <div class="cal-icon">
                                                    <input class="form-control datetimepicker" type="text" name="end_date">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Rate</label>
                                                <input placeholder="$50" class="form-control" type="text" name="rate">
                                            </div>
                                        </div>                                  
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Project Leader</label>
                                                <input class="form-control" type="text" name="leader" value="${sessionScope.acc.profile_id}" readonly>
                                            </div>
                                        </div>                                       
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea rows="4" class="form-control summernote" placeholder="Enter your message here" name="desc"></textarea>
                                    </div>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Create Project Modal -->

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