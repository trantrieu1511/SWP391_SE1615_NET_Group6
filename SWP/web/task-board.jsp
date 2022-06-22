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
        <title>Task Board - HRMS admin template</title>

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
        
        <!-- jQuery -->
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.ui.touch-punch.min.js"></script>

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

        <!-- Custom JS -->
        <script src="js/app.js"></script>

        <!-- Model JS -->
        <script type="text/javascript">
          $(function () {
                $("#add_task_model").on("show.bs.modal", function (e) {
                    var pj = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="project"]').val(pj);
                });
            });  
            $(function(){
                $('input[type="text"]').change(function(){
                    this.value = $.trim(this.value);
                });
            })
        </script>

        <c:if test="${sessionScope.acc == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        
        <c:if test="${alert != ''}">
        <script lang="Javascript">
            alert("${alert}");
        </script>
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
                        <div class="row">
                            <div class="col-sm-12">
                                <h3 class="page-title">${title}</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Task Board</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <div class="row board-view-header">
                        <div class="col-4">
                            
                        </div>
                        <div class="col-8 text-right">
                            <a href="project-view.jsp" class="btn btn-white float-right" title="View Board"><i class="fa fa-link"></i></a>
                        </div>
                    </div>

                    <div class="kanban-board card mb-0">
                        <div class="card-body">
                            <div class="kanban-cont">
                                <div class="kanban-list kanban-danger">
                                    <div class="kanban-header">
                                        <span class="status-title">Pending</span>
                                    </div>
                                    <div class="kanban-wrap">
                                        <c:forEach items="${list0}" var="o">
                                        <div class="card panel">
                                            <div class="kanban-box">
                                                <div class="task-board-header">
                                                    <span class="status-title">${o.name}</span>
                                                    <c:if test="${sessionScope.acc.isManager == true}">
                                                    <div class="dropdown kanban-task-action">
                                                        <a href="" data-toggle="dropdown">
                                                            <i class="fa fa-angle-down"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_task_modal">Edit</a>
                                                            <a class="dropdown-item" href="#">Delete</a>
                                                        </div>
                                                    </div>
                                                    </c:if>
                                                </div>
                                                <div class="task-board-body">                                            
                                                    <div class="kanban-footer">
                                                        <span class="task-info-cont">
                                                            <span class="task-date"><i class="fa fa-clock-o"></i> ${o.deadline}</span>
                                                            <span class="task-priority badge bg-inverse-danger"></span>
                                                        </span>
                                                        <c:if test="${sessionScope.acc.isManager == true}">
                                                        <span class="task-users">
                                                            ${o.assigned}
                                                        </span>
                                                        </c:if>
                                                        <c:if test="${sessionScope.acc.isManager == false}">
                                                            <a href="task?do=updateStatus&&name=${o.name}&&status=1">Accept</a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </div>
                                    <c:if test="${sessionScope.acc.isManager == true}">
                                    <div class="add-new-task">
                                        <a href="javascript:void(0);" data-toggle="modal" data-target="#add_task_modal" data-id="${o.project}">Add New Task</a>
                                    </div>
                                     </c:if>
                                </div>
                                <div class="kanban-list kanban-info">
                                    <div class="kanban-header">
                                        <span class="status-title">Progress</span>                                        
                                    </div>
                                    <div class="kanban-wrap">
                                        <c:forEach items="${list1}" var="o">
                                        <div class="card panel">
                                            <div class="kanban-box">
                                                <div class="task-board-header">
                                                    <span class="status-title">${o.name}</span>
                                                    <c:if test="${sessionScope.acc.isManager == true}">
                                                    <div class="dropdown kanban-task-action">
                                                        <a href="" data-toggle="dropdown">
                                                            <i class="fa fa-angle-down"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_task_modal">Edit</a>
                                                            <a class="dropdown-item" href="#">Delete</a>
                                                        </div>
                                                    </div>
                                                    </c:if>
                                                </div>
                                                <div class="task-board-body">                                            
                                                    <div class="kanban-footer">
                                                        <span class="task-info-cont">
                                                            <span class="task-date"><i class="fa fa-clock-o"></i> ${o.deadline}</span>
                                                            <span class="task-priority badge bg-inverse-danger"></span>
                                                        </span>
                                                        <c:if test="${sessionScope.acc.isManager == true}">
                                                        <span class="task-users">
                                                            ${o.assigned}
                                                        </span>
                                                        </c:if>
                                                        <c:if test="${sessionScope.acc.isManager == false}">
                                                            <a href="task?do=updateStatus&&status=2">Done</a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </div>
                                </div>                               
                                <div class="kanban-list kanban-primary">
                                    <div class="kanban-header">
                                        <span class="status-title">Review</span>                                      
                                    </div>
                                    <div class="kanban-wrap">
                                        <c:forEach items="${list2}" var="o">
                                        <div class="card panel">
                                            <div class="kanban-box">
                                                <div class="task-board-header">
                                                    <span class="status-title">${o.name}</span>
                                                    <c:if test="${sessionScope.acc.isManager == true}">
                                                    <div class="dropdown kanban-task-action">
                                                        <a href="" data-toggle="dropdown">
                                                            <i class="fa fa-angle-down"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_task_modal">Edit</a>
                                                            <a class="dropdown-item" href="#">Delete</a>
                                                        </div>
                                                    </div>
                                                    </c:if>
                                                </div>
                                                <div class="task-board-body">                                            
                                                    <div class="kanban-footer">
                                                        <span class="task-info-cont">
                                                            <span class="task-date"><i class="fa fa-clock-o"></i> ${o.deadline}</span>
                                                            <span class="task-priority badge bg-inverse-danger"></span>
                                                        </span>
                                                        <c:if test="${sessionScope.acc.isManager == true}">
                                                        <span class="task-users">
                                                            ${o.assigned}
                                                        </span>
                                                        <a href="task?do=updateStatus&&status=3">Accept</a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </div>                                   
                                </div>
                                <div class="kanban-list kanban-success">
                                    <div class="kanban-header">
                                        <span class="status-title">Completed</span>                              
                                    </div>
                                    <div class="kanban-wrap">
                                        <c:forEach items="${list3}" var="o">
                                        <div class="card panel">
                                            <div class="kanban-box">
                                                <div class="task-board-header">
                                                    <span class="status-title">${o.name}</span>
                                                    <div class="dropdown kanban-task-action">
                                                        <a href="" data-toggle="dropdown">
                                                            <i class="fa fa-angle-down"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_task_modal">Edit</a>
                                                            <a class="dropdown-item" href="#">Delete</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="task-board-body">                                            
                                                    <div class="kanban-footer">
                                                        <span class="task-info-cont">
                                                            <span class="task-date"><i class="fa fa-clock-o"></i> ${o.deadline}</span>
                                                            <span class="task-priority badge bg-inverse-danger"></span>
                                                        </span>
                                                        <span class="task-users">
                                                            ${o.assigned}
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </div>                                
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /Page Content -->

                <!-- Add Task Modal -->
                <div id="add_task_modal" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Add Task</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form action="task" do="post">
                                    <input type="hidden" name="do" value="newTask">
                                    <div class="form-group">
                                        <label>Project<span class="text-danger">*</span></label>
                                        <input type="text" value="${title}" readonly class="form-control" name="project" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Task Name<span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" name="name" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Task Priority<span class="text-danger">*</span></label>
                                        <select class="form-control select" name="priority" required>
                                            <option>Select</option>
                                            <option value="0">High</option>
                                            <option value="1">Normal</option>
                                            <option value="2">Low</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Due Date<span class="text-danger">*</span></label>
                                        <input type="text" class="form-control datetimepicker" onkeydown="event.preventDefault()" name="deadline" required> 
                                    </div>
                                    <div class="form-group">
                                        <label>Assigned<span class="text-danger">*</span></label>
                                        <select class="select floating" name="assigned" required 
                                            <option> </option>
                                            <c:forEach items="${listPf}" var="o">
                                            <option value="${o.profile_id}">${o.first_name} ${o.last_name}</option>
                                            </c:forEach>
                                        </select>  
                                    </div>
                                    <div class="submit-section text-center">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Add Task Modal -->

                <!-- Edit Task Modal -->
                <div id="edit_task_modal" class="modal custom-modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Edit Task</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label>Task Name</label>
                                        <input type="text" class="form-control" value="Website Redesign">
                                    </div>
                                    <div class="form-group">
                                        <label>Task Priority</label>
                                        <select class="form-control select">
                                            <option>Select</option>
                                            <option selected>High</option>
                                            <option>Normal</option>
                                            <option>Low</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Due Date</label>
                                        <div class="cal-icon">
                                            <input class="form-control datetimepicker" type="text" value="20/08/2019">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Task Followers</label>
                                        <input type="text" class="form-control" placeholder="Search to add">
                                        <div class="task-follower-list">
                                            <span data-toggle="tooltip" title="John Doe">
                                                <img src="img/profiles/avatar-02.jpg" class="avatar" alt="John Doe" width="20" height="20">
                                                <i class="fa fa-times"></i>
                                            </span>
                                            <span data-toggle="tooltip" title="Richard Miles">
                                                <img src="img/profiles/avatar-09.jpg" class="avatar" alt="Richard Miles" width="20" height="20">
                                                <i class="fa fa-times"></i>
                                            </span>
                                            <span data-toggle="tooltip" title="John Smith">
                                                <img src="img/profiles/avatar-10.jpg" class="avatar" alt="John Smith" width="20" height="20">
                                                <i class="fa fa-times"></i>
                                            </span>
                                            <span data-toggle="tooltip" title="Mike Litorus">
                                                <img src="img/profiles/avatar-05.jpg" class="avatar" alt="Mike Litorus" width="20" height="20">
                                                <i class="fa fa-times"></i>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="submit-section text-center">
                                        <button class="btn btn-primary submit-btn">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Edit Task Modal -->

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->

    </body>
</html>