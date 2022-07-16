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
        <link rel="stylesheet" href="css/daterangepicker.css">

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
        <script src="js/daterangepicker.min.js"></script>
        
        <!-- Custom JS -->
        <script src="js/app.js"></script>
        <script src="js/edit.js"></script>
        
        <!-- Model JS -->
        <script type="text/javascript">
            const changeSelected = (e) => {
                const $select = document.querySelector('#clientEdit');
                $select.value = e;
            }
            $(function () {
                $("#edit_project").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('name-id').trim();                    
                    $(e.currentTarget).find('#oldTitle').val(text);
                    $(e.currentTarget).find('#titleEdit').val(text);                                  
                });
            }); 
            $(function () {
                $("#edit_project").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('desc-id').trim();                    
                    $(e.currentTarget).find('#desc').val(text);                                  
                });
            }); 
            $(function () {
                $("#edit_project").on("show.bs.modal", function (e) {
                    var text = $(e.relatedTarget).attr('data-id').trim();
                    const myArray = text.split(" ");
                    var client_id = myArray[4];
                    var status = myArray[5];
                    var period1 = myArray[0]; 
                    var period2 = myArray[1];
                    var period3 = myArray[2];
                    var rate = myArray[3];  
                    $("#clientEdit").val(client_id);
                    $("#clientEdit").select2({
                        width: '100%',
                        placeholder: "Select an option",
                        allowClear: false
                    });
                    $("#statusEdit").val(status);
                    $("#statusEdit").select2({
                        width: '100%',
                        placeholder: "Select an option",
                        allowClear: false
                    });
                    $(e.currentTarget).find('#daterange').val(period1 + ' ' + period2 + ' ' + period3);
                    $(e.currentTarget).find('#rateEdit').val(rate);
                });
            });
            $(function () {
                $('input[name="daterange"]').daterangepicker({
                    opens: 'left'
                }, function (start, end, label) {
                    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
                });
            });
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
                                <h3 class="page-title">Project</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Project</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#edit_project" data-id="${project.period} ${project.rate} ${project.client} ${project.status}" name-id="${project.title}" desc-id=" ${project.description}"><i class="fa fa-plus"></i> Edit Project</a>
                                <a href="task?do=view&&title=${project.title}" class="btn btn-white float-right m-r-10" data-toggle="tooltip" title="Task Board"><i class="fa fa-bars"></i></a>
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
                                                        <c:forEach items="${listTask}" var="o">
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
                                                <td class="text-right">${start}</td>
                                            </tr>
                                            <tr>
                                                <td>Deadline:</td>
                                                <td class="text-right">${end}</td>
                                            </tr>                                           
                                            <tr>
                                                <td>Client:</td>
                                                <td class="text-right"><a href="#">${project.client}</a></td>
                                            </tr>
                                            <tr>
                                                <td>Status:</td>                                               
                                                <td class="text-right">
                                                    <c:if test="${project.status == 0}">Pending</c:if>
                                                    <c:if test="${project.status == 1}">Doing</c:if>
                                                    <c:if test="${project.status == 2}">Done</c:if>
                                                </td>
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
                                    <input type="hidden" name="do" value="editFromView">
                                    <input type="hidden" name="oldTitle" id="oldTitle">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Project Name<span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" id="titleEdit" name="title" onchange="return trim(this)" pattern="[0-9A-Za-z ]{1,35}">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Client<span class="text-danger">*</span></label>
                                                <select class="select" id="clientEdit" name="client">
                                                    <c:forEach items="${listC}" var="o">
                                                    <option value="${o.client_id}">${o.first_name} ${o.last_name} from ${o.company_name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Period
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div>
                                                    <input type="text" class="form-control" name="daterange" id="daterange" onkeydown="event.preventDefault()" required>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Rate<span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" name="rate" id="rateEdit" onchange="return trim(this)">
                                            </div>
                                        </div>                                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Add Project Leader<span class="text-danger">*</span></label>
                                                <input class="form-control" type="text" name="manager" value="${sessionScope.acc.profile_id}" readonly>
                                            </div>
                                        </div>                                     
                                    </div>
                                    <div class="form-group">
                                        <label>Description<span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" name="description" id="desc" required pattern="[0-9A-Za-z ]{1,255}">
                                    </div>
                                    <div class="form-group">
                                        <label>Status<span class="text-danger">*</span></label>
                                        <select class="select" id="statusEdit" name="status">
                                            <option value="0">Pending</option>
                                            <option value="1">Doing</option>
                                            <option value="2">Done</option>
                                        </select>
                                    </div>
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