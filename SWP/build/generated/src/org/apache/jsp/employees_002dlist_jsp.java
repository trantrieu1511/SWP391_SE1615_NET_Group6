package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employees_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=0\">\r\n");
      out.write("        <meta name=\"description\" content=\"Smarthr - Bootstrap Admin Template\">\r\n");
      out.write("        <meta name=\"keywords\" content=\"admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects\">\r\n");
      out.write("        <meta name=\"author\" content=\"Dreamguys - Bootstrap Admin Template\">\r\n");
      out.write("        <meta name=\"robots\" content=\"noindex, nofollow\">\r\n");
      out.write("        <title>Employees - HRMS admin template</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Favicon -->\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/favicon.png\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Fontawesome CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Lineawesome CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/line-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Datatable CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/dataTables.bootstrap4.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Select2 CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/select2.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Datetimepicker CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-datetimepicker.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Main CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- import js -->\r\n");
      out.write("        <script src=\"js/employee-list_js.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- jQuery -->\r\n");
      out.write("        <script src=\"js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap Core JS -->\r\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Slimscroll JS -->\r\n");
      out.write("        <script src=\"js/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Select2 JS -->\r\n");
      out.write("        <script src=\"js/select2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Datetimepicker JS -->\r\n");
      out.write("        <script src=\"js/moment.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap-datetimepicker.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Datatable JS -->\r\n");
      out.write("        <script src=\"js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("        <script src=\"js/dataTables.bootstrap4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom JS -->\r\n");
      out.write("        <script src=\"js/app.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(function () {\r\n");
      out.write("                $(\"#edit_employee\").on(\"show.bs.modal\", function (e) {\r\n");
      out.write("                    var text = $(e.relatedTarget).attr('data-id');\r\n");
      out.write("                    const myArray = text.split(\" \");\r\n");
      out.write("                    var id = myArray[0];\r\n");
      out.write("                    var first_name = myArray[1];\r\n");
      out.write("                    var last_name = myArray[2];\r\n");
      out.write("                    var email = myArray[3];\r\n");
      out.write("                    var phone_number = myArray[4];\r\n");
      out.write("                    var hire_date = myArray[5];\r\n");
      out.write("                    var username = myArray[6];\r\n");
      out.write("                    var password = myArray[7];\r\n");
      out.write("                    var reportto = myArray[8];\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"first_name\"]').val(text);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"last_name\"]').val(last_name);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"email\"]').val(email);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"phone_number\"]').val(phone_number);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"hire_date\"]').val(hire_date);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"profile_id\"]').val(id);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"username\"]').val(username);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"password\"]').val(password);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"ReportsTo\"]').val(reportto);\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("                <script src=\"js/html5shiv.min.js\"></script>\r\n");
      out.write("                <script src=\"js/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!-- Main Wrapper -->\r\n");
      out.write("        <div class=\"main-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "index.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- Page Wrapper -->\r\n");
      out.write("                <div class=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Page Content -->\r\n");
      out.write("                    <div class=\"content container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- Page Header -->\r\n");
      out.write("                        <div class=\"page-header\">\r\n");
      out.write("                            <div class=\"row align-items-center\">\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <h3 class=\"page-title\">Employee</h3>\r\n");
      out.write("                                    <ul class=\"breadcrumb\">\r\n");
      out.write("                                        <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li>\r\n");
      out.write("                                        <li class=\"breadcrumb-item active\">Employee</li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-auto float-right ml-auto\">\r\n");
      out.write("                                    <a href=\"#\" class=\"btn add-btn\" data-toggle=\"modal\" data-target=\"#add_employee\"><i class=\"fa fa-plus\"></i> Add Employee</a>\r\n");
      out.write("                                    <div class=\"view-icons\">\r\n");
      out.write("                                        <a href=\"employees.html\" class=\"grid-view btn btn-link\"><i class=\"fa fa-th\"></i></a>\r\n");
      out.write("                                        <a href=\"employees-list.jsp\" class=\"list-view btn btn-link active\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /Page Header -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- Search Filter -->\r\n");
      out.write("                        <div class=\"row filter-row\">\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\">  \r\n");
      out.write("                                <div class=\"form-group form-focus\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control floating\">\r\n");
      out.write("                                    <label class=\"focus-label\">Employee ID</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\">  \r\n");
      out.write("                                <div class=\"form-group form-focus\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control floating\">\r\n");
      out.write("                                    <label class=\"focus-label\">Employee Name</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\"> \r\n");
      out.write("                                <div class=\"form-group form-focus select-focus\">\r\n");
      out.write("                                    <select class=\"select floating\"> \r\n");
      out.write("                                        <option>Select Designation</option>\r\n");
      out.write("                                        <option>Web Developer</option>\r\n");
      out.write("                                        <option>Web Designer</option>\r\n");
      out.write("                                        <option>Android Developer</option>\r\n");
      out.write("                                        <option>Ios Developer</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                    <label class=\"focus-label\">Designation</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\">  \r\n");
      out.write("                                <a href=\"#\" class=\"btn btn-success btn-block\"> Search </a>  \r\n");
      out.write("                            </div>     \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /Search Filter -->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <div class=\"table-responsive\">\r\n");
      out.write("                                    <table class=\"table table-striped custom-table datatable\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th>Name</th>\r\n");
      out.write("                                                <th>Employee ID</th>\r\n");
      out.write("                                                <th name=\"email\">Email</th>\r\n");
      out.write("                                                <th>Mobile</th>\r\n");
      out.write("                                                <th class=\"text-nowrap\">Join Date</th>\r\n");
      out.write("                                                <th>Role</th>\r\n");
      out.write("                                                <th class=\"text-right no-sort\">Action</th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /Page Content -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Add Employee Modal -->\r\n");
      out.write("                <div id=\"add_employee\" class=\"modal custom-modal fade\" role=\"dialog\">\r\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">\r\n");
      out.write("                        <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-header\">\r\n");
      out.write("                                <h5 class=\"modal-title\">Add Staff</h5>\r\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                    <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <form action=\"ControllerProfile\" method=\"post\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"do\" value=\"addStaff\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">First Name <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"first_name\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Last Name <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"last_name\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Username <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"username\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Email <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"email\" name=\"email\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Password <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"password\" name=\"password\" id=\"password\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Confirm Password <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"password\" name=\"confirm_password\"\r\n");
      out.write("                                                       onchange=\"checkPassword(this)\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">  \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Staff ID <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"profile_id\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Joining Date <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <div><input class=\"form-control\" readonly type=\"date\" name=\"hire_date\" required></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Phone </label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"phone_number\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">ReportsTo</label>\r\n");
      out.write("                                                <select class=\"select\" name=\"ReportsTo\">\r\n");
      out.write("                                                    ");

      out.write("\r\n");
      out.write("                                                    <option value=\"ABCDE\">Tran Trieu</option>\r\n");
      out.write("                                                    <option value=\"ABCDF\">Delta Infotech</option>\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Department <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"select\" name=\"department_id\">\r\n");
      out.write("                                                    <!-- <option value=\"\">Select Department</option> -->\r\n");
      out.write("                                                    <option value=\"1\">Web Development</option>\r\n");
      out.write("                                                    <option value=\"2\">IT Management</option>\r\n");
      out.write("                                                    <option value=\"3\">Marketing</option>\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Designation <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"select\" name=\"job_id\">\r\n");
      out.write("                                                    <!-- <option>Select Designation</option> -->\r\n");
      out.write("                                                    <option value=\"1\">Web Designer</option>\r\n");
      out.write("                                                    <option value=\"2\">Web Developer</option>\r\n");
      out.write("                                                    <option value=\"3\">Android Developer</option>\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <span id=\"wrong_pass_alert\"></span>\r\n");
      out.write("                                    <div class=\"submit-section\">\r\n");
      out.write("                                        <button class=\"btn btn-primary submit-btn\" id=\"create\" onclick=\"wrong_pass_alert()\">Submit</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /Add Employee Modal -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Edit Employee Modal -->\r\n");
      out.write("                <div id=\"edit_employee\" class=\"modal custom-modal fade\" role=\"dialog\">\r\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">\r\n");
      out.write("                        <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-header\">\r\n");
      out.write("                                <h5 class=\"modal-title\">Edit Employee</h5>\r\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                    <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <form>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">First Name <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"first_name\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Last Name</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"last_name\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Username <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"username\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Email <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"email\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Password</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"password\" name=\"password\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Confirm Password</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"password\" name=\"password\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">  \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Employee ID <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input type=\"text\" value=\"\" readonly class=\"form-control floating employee-id\" name=\"profile_id\" id=\"profile_id\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">  \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Joining Date <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <div class=\"cal-icon\"><input class=\"form-control datetimepicker\" type=\"text\" name=\"hire_date\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Phone </label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"9876543210\" type=\"text\" name=\"phone_number\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Report To</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"ReportsTo\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Department <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"select\">\r\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Designation <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"select\">\r\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"submit-section\">\r\n");
      out.write("                                        <button class=\"btn btn-primary submit-btn\">Save</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /Edit Employee Modal -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Delete Employee Modal -->\r\n");
      out.write("                <div class=\"modal custom-modal fade\" id=\"delete_employee\" role=\"dialog\">\r\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("                        <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <div class=\"form-header\">\r\n");
      out.write("                                    <h3>Delete Employee</h3>\r\n");
      out.write("                                    <p>Are you sure want to delete?</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"modal-btn delete-action\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-6\">\r\n");
      out.write("                                            <a href=\"javascript:void(0);\" class=\"btn btn-primary continue-btn\">Delete</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-6\">\r\n");
      out.write("                                            <a href=\"javascript:void(0);\" data-dismiss=\"modal\" class=\"btn btn-primary cancel-btn\">Cancel</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /Delete Employee Modal -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /Main Wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <tr>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.first_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.last_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td class=\"id\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.profile_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.phone_number}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.hire_date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>\r\n");
          out.write("                                                    <div class=\"dropdown\">\r\n");
          out.write("                                                        <a href=\"\" class=\"btn btn-white btn-sm btn-rounded dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">Web Developer </a>\r\n");
          out.write("                                                        <div class=\"dropdown-menu\">\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\">Software Engineer</a>\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\">Software Tester</a>\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\">Frontend Developer</a>\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\">UI/UX Developer</a>\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                </td>\r\n");
          out.write("                                                <td class=\"text-right\">\r\n");
          out.write("                                                    <div class=\"dropdown dropdown-action\">\r\n");
          out.write("                                                        <a href=\"#\" class=\"action-icon dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"material-icons\">more_vert</i></a>\r\n");
          out.write("                                                        <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.profile_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.first_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.last_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.phone_number}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.hire_date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.reportto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.department_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.job_title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" data-target=\"#edit_employee\"> <i class=\"fa fa-pencil m-r-5\"></i> Edit</a>\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#delete_employee\"><i class=\"fa fa-trash-o m-r-5\"></i> Delete</a>\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                </td>\r\n");
          out.write("                                            </tr>\r\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems(new String("list2"));
    _jspx_th_c_forEach_1.setVar("o");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        <option>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems(new String("list3"));
    _jspx_th_c_forEach_2.setVar("o");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        <option>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
