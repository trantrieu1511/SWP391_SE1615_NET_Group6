<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        
        <!-- Summernote CSS -->
        <link rel="stylesheet" href="plugins/summernote/dist/summernote-bs4.css">

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

        <!-- Datetimepicker JS -->
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>

        <!-- Task JS -->
        <script src="js/task.js"></script>
        
        <!-- Summernote JS -->
        <script src="plugins/summernote/dist/summernote-bs4.min.js"></script>

        <!-- Custom JS -->
        <script src="js/app.js"></script>
        
        <!-- Model JS -->
        <script type="text/javascript">
            const changeSelected = (e) => {
                const $select = document.querySelector('#clientEdit');
                $select.value = e;
            }
            $(function () {
                $("#edit_project").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id').trim();
                    const myArray = text.split(" ");
                    var title = myArray[0];
                    var client_id = myArray[4];
                    var start_date = myArray[1];
                    var end_date = myArray[2];
                    var rate = myArray[3];       
                    $(e.currentTarget).find('#titleEdit').val(title);
                    $(e.currentTarget).find('#clientEdit option[value="2    "]').attr('selected', 'selected');
                    $(e.currentTarget).find('#start_date2').val(start_date);
                    $(e.currentTarget).find('#end_date2').val(end_date);
                    $(e.currentTarget).find('#rateEdit').val(rate);                  
                });
            });              
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
                                <h3 class="page-title">Project</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Project</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#edit_project" data-id="${pro.title} ${pro.start_date} ${pro.end_date} ${pro.rate} ${pro.client}"><i class="fa fa-plus"></i> Edit Project</a>
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
                                        <h5 class="card-title">${project.title}</h5>
                                        <small class="block text-ellipsis m-b-15"><span class="text-xs">2</span> <span class="text-muted">open tasks, </span><span class="text-xs">5</span> <span class="text-muted">tasks completed</span></small>
                                    </div>
                                    <p>${project.description}</p>                                      
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
                                                        <c:forEach items="${list0}" var="o">
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
                                                        <c:forEach items="${list1}" var="o">
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
                                                        <c:forEach items="${list3}" var="o">
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
                                            <tr>
                                                <td>Cost:</td>
                                                <td class="text-right">${project.rate}</td>
                                            </tr>                                            
                                            <tr>
                                                <td>Created:</td>
                                                <td class="text-right">${project.start_date}</td>
                                            </tr>
                                            <tr>
                                                <td>Deadline:</td>
                                                <td class="text-right">${project.end_date}</td>
                                            </tr>                                           
                                            <tr>
                                                <td>Client:</td>
                                                <td class="text-right"><a href="#">${project.client}</a></td>
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
                                                <span class="message-author">${lead.getFirst_name()} ${lead.getLast_name()}</span>
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
                                        <c:forEach items="${listPf}" var="o">  
                                        <li>
                                            <a href="#">
                                                <span class="message-author">${o.first_name} ${o.last_name}</span>
                                                <div class="clearfix"></div>
                                                <span class="message-content">${p.job_title}</span>
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
                                <form action="project" do="post">
                                    <input type="hidden" name="do" value="edit">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Project Name</label>
                                                <input class="form-control" type="text" id="titleEdit" name="title" onchange="return trim(this)" pattern="[0-9A-Za-z ]{1,35}">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Client</label>
                                                <select class="select" id="clientEdit" name="client">
                                                    <c:forEach items="${listC}" var="o">
                                                    <option value="${o.client_id}">${o.first_name} ${o.last_name} from ${o.company}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Start Date</label>
                                                <div>
                                                    <input placeholder="start" type="text" class="form-control" onfocus="(this.type='date')" onblur="(this.type='text')" name="start_date" id="start_date2" onchange="check2()">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>End Date</label>
                                                <div>
                                                    <input placeholder="end" type="text" class="form-control" onfocus="(this.type='date')" onblur="(this.type='text')" name="end_date" id="end_date2" onchange="check2()">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Rate</label>
                                                <input class="form-control" type="text" name="rate" id="rateEdit" onchange="return trim(this)">
                                            </div>
                                        </div>                                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Add Project Leader</label>
                                                <input class="form-control" type="text" name="manager" value="${sessionScope.acc.profile_id}" readonly>
                                            </div>
                                        </div>                                     
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea rows="4" class="form-control summernote" placeholder="Enter your message here" name="description" required onchange="return trim(this)" pattern="[0-9A-Za-z ]{1,255}"></textarea>
                                    </div>
                                    <span id="alert2"></span>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn" id="create2">Submit</button>
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
        
    </body>
</html>