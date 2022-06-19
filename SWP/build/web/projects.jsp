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
        <title>Projects - HRMS admin template</title>

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

        <!-- Summernote JS -->
        <script src="plugins/summernote/dist/summernote-bs4.min.js"></script>

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
            $(function () {
                $("#delete_project").on("show.bs.modal", function (e) {
                    var title = $(e.relatedTarget).attr('data-id');
                    $(e.currentTarget).find('input[name="title"]').val(title);
                });
            });        
        </script>
        
        <c:if test="${alert != ''}">
        <script lang="Javascript">
            alert("${alert}");
        </script>
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
                                <h3 class="page-title">Projects</h3>
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Projects</li>
                                </ul>
                            </div>
                            <div class="col-auto float-right ml-auto">
                                <c:if test="${sessionScope.acc.isManager == true}">
                                <a href="#" class="btn add-btn" data-toggle="modal" data-target="#create_project"><i class="fa fa-plus"></i> Create Project</a>                           
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <!-- /Page Header -->

                    <!-- Search Filter -->
                    <form action="project" do="post">
                        <input type="hidden" name="do" value="search">
                        <div class="row filter-row">
                            <div class="col-sm-6 col-md-3">  
                                <div class="form-group form-focus">
                                    <input type="text" class="form-control floating" name="title" onchange="return trim(this)" pattern="[0-9A-Za-z ]{1,35}">
                                    <label class="focus-label">Project Title</label>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">                      
                            </div>
                            <div class="col-sm-6 col-md-3">                                
                            </div>
                            <div class="col-sm-6 col-md-3">  
                                <button class="btn btn-success btn-block"> Search </button>  
                            </div>     
                        </div>
                    </form>
                    <!-- Search Filter -->

                    <div class="row">
                        <c:forEach items="${list}" var="o">
                        <div class="col-lg-4 col-sm-6 col-md-4 col-xl-3">
                            <div class="card">
                                <div class="card-body">
                                    <c:if test="${sessionScope.acc.isManager == true}">
                                    <div class="dropdown dropdown-action profile-action">
                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                        <div class="dropdown-menu dropdown-menu-right"> 
                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit_project" data-id="${o.title} ${o.start_date} ${o.end_date} ${o.rate} ${o.client}"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_project" data-id="${o.title}"><i class="fa fa-trash-o m-r-5"></i> Delete</a>                         
                                        </div>
                                    </div>
                                    </c:if>
                                    <h4 class="project-title"><a href="project?do=view&title=${o.title}">${o.title}</a></h4>
                                    <p class="text-muted">${o.description}
                                    </p>
                                    <div class="pro-deadline m-b-15">
                                        <div class="sub-title">
                                            Deadline:
                                        </div>
                                        <div class="text-muted">
                                            ${o.end_date}
                                        </div>
                                    </div>
                                    <div class="project-members m-b-15">
                                        <div>Project Leader :</div>
                                        <div class="text-muted">
                                            ${o.manager}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
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
                                <form action="project" do="post">
                                    <input type="hidden" name="do" value="create">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Project Name
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <input class="form-control" type="text" name="title" required onchange="return trim(this)" pattern="[0-9A-Za-z ]{1,35}">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>Client
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <select class="select" name="client" required onchange="return trim(this)">
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
                                                <label>Start Date
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div>
                                                    <input type="date" name="start_date" id="start_date" required onchange="check()">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label>End Date<span class="text-danger">*</span></label>
                                                <div>
                                                    <input type="date" name="end_date" id="end_date" required onchange="check()">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Rate<span class="text-danger">*</span></label>
                                                <input class="form-control" type="number" name="rate" required onchange="return trim(this)">
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
                                        <textarea rows="4" class="form-control summernote" placeholder="Enter your message here" name="description" required onchange="return trim(this)" pattern="[0-9A-Za-z ]{1,255}"></textarea>
                                    </div>
                                    <span id="alert"></span>
                                    <div class="submit-section">
                                        <button class="btn btn-primary submit-btn" id="create">Submit</button>
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

                <!-- Delete Project Modal -->
                <div class="modal custom-modal fade" id="delete_project" role="dialog">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form action="project" do="post">
                                    <input type="hidden" name="do" value="delete">
                                    <input type="hidden" name="title">
                                    <div class="form-header">
                                        <h3>Delete Project</h3>
                                        <p>Are you sure want to delete?</p>
                                    </div>
                                    <div class="modal-btn delete-action">
                                        <div class="row">
                                            <div class="col-6">
                                                <input type="submit" value="Delete" href="" class="btn btn-primary continue-btn" style="padding: 10px 75px;">
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
                <!-- /Delete Project Modal -->               

            </div>
            <!-- /Page Wrapper -->

        </div>
        <!-- /Main Wrapper -->
        
    </body>
</html>