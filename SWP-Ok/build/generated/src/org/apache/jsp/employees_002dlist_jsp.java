package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class employees_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_redirect_url_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
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
      out.write("        <script src=\"js/edit.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Model JS -->\r\n");
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
      out.write("                    var depart_id = myArray[9];\r\n");
      out.write("                    var job_id = myArray[10];\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"profile_id\"]').val(id);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"first_name\"]').val(first_name);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"last_name\"]').val(last_name);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"email\"]').val(email);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"phone_number\"]').val(phone_number);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"hire_date\"]').val(hire_date);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"username\"]').val(username);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"password\"]').val(password);\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"ReportsTo\"]').val(reportto);\r\n");
      out.write("                    document.getElementById('department_id2').value = depart_id;\r\n");
      out.write("                    document.getElementById('job_id2').value = job_id;\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("            $(function () {\r\n");
      out.write("                $(\"#add_employee\").on(\"show.bs.modal\", function (e) {\r\n");
      out.write("                    var reportto = $(e.relatedTarget).attr('data-id');\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"ReportsTo\"]').val(reportto);\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("            $(function () {\r\n");
      out.write("                $(\"#delete_employee\").on(\"show.bs.modal\", function (e) {\r\n");
      out.write("                    var id = $(e.relatedTarget).attr('data-id');\r\n");
      out.write("                    $(e.currentTarget).find('input[name=\"profile_id\"]').val(id);\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(function () {\r\n");
      out.write("                $('input[type=\"text\"]').change(function () {\r\n");
      out.write("                    this.value = $.trim(this.value);\r\n");
      out.write("                });\r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body onpageshow=\"checkPasswordonpageshow()\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Main Wrapper -->\r\n");
      out.write("        <div class=\"main-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
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
      out.write("                                    <h3 class=\"page-title\">Manage Staff</h3>\r\n");
      out.write("                                    <ul class=\"breadcrumb\">\r\n");
      out.write("                                        <li class=\"breadcrumb-item\"><a href=\"manager?do=dashboard\">Dashboard</a></li>\r\n");
      out.write("                                        <li class=\"breadcrumb-item active\">Staff</li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-auto float-right ml-auto\">\r\n");
      out.write("                                    <a href=\"#\" class=\"btn add-btn\" data-toggle=\"modal\" data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.profile_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" data-target=\"#add_employee\"><i class=\"fa fa-plus\"></i> Add Staff</a>\r\n");
      out.write("                                <div class=\"view-icons\">\r\n");
      out.write("                                    <!--                                        <a href=\"employees.html\" class=\"grid-view btn btn-link\"><i class=\"fa fa-th\"></i></a>\r\n");
      out.write("                                                                            <a href=\"employees-list.jsp\" class=\"list-view btn btn-link active\"><i class=\"fa fa-bars\"></i></a>-->\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /Page Header -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <!-- Search Filter -->\r\n");
      out.write("                    <form action=\"manager?do=filter\" method=\"post\">\r\n");
      out.write("                        <div class=\"row filter-row\">\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\">  \r\n");
      out.write("                                <div class=\"form-group form-focus\">\r\n");
      out.write("                                    <input type=\"text\" name=\"eid\" id=\"eid\" class=\"form-control floating\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                    <label class=\"focus-label\">Staff ID</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\">\r\n");
      out.write("                                <div class=\"form-group form-focus\">\r\n");
      out.write("                                    <input type=\"text\" name=\"ename\" id=\"ename\" class=\"form-control floating\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                    <label class=\"focus-label\">Staff Name</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\"> \r\n");
      out.write("                                <div class=\"form-group form-focus select-focus\">\r\n");
      out.write("                                    <select name=\"ejob\" id=\"ejob\" class=\"select floating\">\r\n");
      out.write("                                        <option value=\"\">Select Designation</option>\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                    <label class=\"focus-label\">Designation</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-3\">  \r\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-success btn-block\" value=\"Search\" style=\"padding: 0px\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>         \r\n");
      out.write("                    <!-- /Search Filter -->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-12\">\r\n");
      out.write("                            <div class=\"table-responsive\">\r\n");
      out.write("                                <table class=\"table table-striped custom-table datatable\" id=\"table\">  \r\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th>Name</th>\r\n");
      out.write("                                            <th>Employee ID</th>\r\n");
      out.write("                                            <th name=\"email\">Email</th>\r\n");
      out.write("                                            <th>Mobile</th>\r\n");
      out.write("                                            <th class=\"text-nowrap\">Join Date</th>\r\n");
      out.write("                                            <th>Role</th>\r\n");
      out.write("                                            <th class=\"text-right no-sort\">Action</th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>                                   \r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </tbody>                                  \r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <!--                    <script type=\"text/javascript\">\r\n");
      out.write("                                            function filter1() {\r\n");
      out.write("                                                var input, filter, table, tr, td, i, txtValue;\r\n");
      out.write("                                                input = document.getElementById(\"EID\");\r\n");
      out.write("                                                table = document.getElementById(\"table\");\r\n");
      out.write("                                                tr = table.getElementsByTagName(\"tr\");\r\n");
      out.write("                                                filter = input.value.toUpperCase();\r\n");
      out.write("                    \r\n");
      out.write("                                                for (i = 0; i < tr.length; i++) {\r\n");
      out.write("                                                    td = tr[i].getElementsByTagName(\"td\")[1];\r\n");
      out.write("                                                    if (td) {\r\n");
      out.write("                                                        txtValue = td.textContent || td.innerText;\r\n");
      out.write("                                                        if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n");
      out.write("                                                            tr[i].style.display = \"\";\r\n");
      out.write("                                                        } else {\r\n");
      out.write("                                                            tr[i].style.display = \"none\";\r\n");
      out.write("                                                        }\r\n");
      out.write("                                                    }\r\n");
      out.write("                    \r\n");
      out.write("                                                }\r\n");
      out.write("                                            }\r\n");
      out.write("                                            function filter2() {\r\n");
      out.write("                                                var input, filter, table, tr, td, i, txtValue;\r\n");
      out.write("                                                input = document.getElementById(\"EName\");\r\n");
      out.write("                                                table = document.getElementById(\"table\");\r\n");
      out.write("                                                tr = table.getElementsByTagName(\"tr\");\r\n");
      out.write("                                                filter = input.value.toUpperCase();\r\n");
      out.write("                    \r\n");
      out.write("                                                for (i = 0; i < tr.length; i++) {\r\n");
      out.write("                                                    td = tr[i].getElementsByTagName(\"td\")[0];\r\n");
      out.write("                                                    if (td) {\r\n");
      out.write("                                                        txtValue = td.textContent || td.innerText;\r\n");
      out.write("                                                        if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n");
      out.write("                                                            tr[i].style.display = \"\";\r\n");
      out.write("                                                        } else {\r\n");
      out.write("                                                            tr[i].style.display = \"none\";\r\n");
      out.write("                                                        }\r\n");
      out.write("                                                    }\r\n");
      out.write("                    \r\n");
      out.write("                                                }\r\n");
      out.write("                                            }\r\n");
      out.write("                                            function filter3() {\r\n");
      out.write("                                                var input, filter, table, tr, td, i, txtValue;\r\n");
      out.write("                                                input = document.getElementById(\"EJob\");\r\n");
      out.write("                                                table = document.getElementById(\"table\");\r\n");
      out.write("                                                tr = table.getElementsByTagName(\"tr\");\r\n");
      out.write("                                                filter = input.value.toUpperCase();\r\n");
      out.write("                    \r\n");
      out.write("                                                for (i = 0; i < tr.length; i++) {\r\n");
      out.write("                                                    td = tr[i].getElementsByTagName(\"td\")[5];\r\n");
      out.write("                    //                                if (input.value.equals(\"All Designation\")) {\r\n");
      out.write("                    //                                        tr[i].style.display = \"\";\r\n");
      out.write("                    //                                } else\r\n");
      out.write("                                                    if (td) {\r\n");
      out.write("                                                        txtValue = td.textContent || td.innerText;\r\n");
      out.write("                                                        if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n");
      out.write("                                                            tr[i].style.display = \"\";\r\n");
      out.write("                                                        } else {\r\n");
      out.write("                                                            tr[i].style.display = \"none\";\r\n");
      out.write("                                                        }\r\n");
      out.write("                                                    }\r\n");
      out.write("                                                }\r\n");
      out.write("                                            }\r\n");
      out.write("                                        </script> -->\r\n");
      out.write("\r\n");
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
      out.write("                                <form action=\"manager\" method=\"post\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"do\" value=\"addStaff\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">First Name <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"first_name\" id=\"first_name\" required pattern=\"[A-Za-z]{1,12}\"\r\n");
      out.write("                                                       title=\"FirstName not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  \r\n");
      out.write("                                                       allow uppercase and lowercase letters, max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Last Name <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"last_name\" id=\"last_name\" required pattern=\"[A-Za-z]{1,12}\"\r\n");
      out.write("                                                       title=\"LastName not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  \r\n");
      out.write("                                                       allow uppercase and lowercase letters, max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Username <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"username\" id=\"username\" required pattern=\"[a-zA-Z0-9]{1,12}\"\r\n");
      out.write("                                                       title=\"Username not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Email <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"email\" id=\"email\" placeholder=\"e.g: abc@mail.com\" required pattern=\"[a-zA-Z0-9]{1,12}[@][a-z]{1,6}[.][a-z]{1,6}\"\r\n");
      out.write("                                                       title=\"email not allow: Unicode characters, \r\n");
      out.write("                                                       special character other than @ and . and spacing characters;  \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9);\r\n");
      out.write("                                                       maximum length of parts of email: \r\n");
      out.write("                                                       username: 20, mail server: 12, domain: 12; \r\n");
      out.write("                                                       max length: 46\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Password <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"password\" name=\"password\" id=\"password\" \r\n");
      out.write("                                                       onkeyup=\"checkconfirmPassword(this)\" required pattern=\"[a-zA-Z0-9]{1,12}\"\r\n");
      out.write("                                                       title=\"Password not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <span id=\"wrong_pass_alert\"></span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Confirm Password <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"password\" name=\"confirm_password\" id=\"confirm_password\"\r\n");
      out.write("                                                       onkeyup=\"checkPassword(this)\" required pattern=\"[a-zA-Z0-9]{1,12}\"\r\n");
      out.write("                                                       title=\"Confirm Password not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">  \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Staff ID <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"profile_id\" id=\"profile_id\" required pattern=\"[A-Z]{5}\"\r\n");
      out.write("                                                       title=\"Staff ID not allow Unicode characters, must be 5 character with uppercase\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Joining Date <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <div class=\"cal-icon\"><input class=\"form-control datetimepicker\" type=\"text\" name=\"hire_date\" placeholder=\"pick a joining date\" onkeydown=\"event.preventDefault()\" id=\"hire_date\" required pattern=\"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Phone </label>\r\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"phone_number\" id=\"phone_number\" title=\"phone number must be 10-digit number\" pattern=\"[0-9]{10}\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <!--                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                                                                    <div class=\"form-group\">\r\n");
      out.write("                                                                                        <label class=\"col-form-label\">ReportsTo <span class=\"text-danger\">*</span></label>-->\r\n");
      out.write("                                        <input class=\"form-control\" readonly type=\"hidden\" value=\"\" name=\"ReportsTo\" id=\"ReportsTo\" pattern=\"[A-Z]{5}\">\r\n");
      out.write("                                        <!--                                            </div>\r\n");
      out.write("                                                                                </div>-->\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Department <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"select\" name=\"department_id\" id=\"department_id\" required=\"\">\r\n");
      out.write("                                                    <option value=\"\">Select Department</option>\r\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Designation <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"select\" name=\"job_id\" id=\"job_id\" required=\"\">\r\n");
      out.write("                                                    <option value=\"\">Select Designation</option>\r\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"submit-section\">\r\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-primary submit-btn\" id=\"create\" value=\"submit\">\r\n");
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
      out.write("                                <h5 class=\"modal-title\">Edit Staff</h5>\r\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                    <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <form action=\"manager\" do=\"post\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"do\" value=\"editStaff\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">First Name <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"first_name\" id=\"first_name2\" required pattern=\"[A-Za-z]{1,12}\"\r\n");
      out.write("                                                       title=\"FirstName not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  \r\n");
      out.write("                                                       allow uppercase and lowercase letters, max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Last Name</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"last_name\" id=\"last_name2\" required pattern=\"[A-Za-z]{1,12}\"\r\n");
      out.write("                                                       title=\"LastName not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.., spacing and numeric characters (0-9);  \r\n");
      out.write("                                                       allow uppercase and lowercase letters, max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Username <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"username\" id=\"username2\" required pattern=\"[a-zA-Z0-9]{1,12}\"\r\n");
      out.write("                                                       title=\"Username not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Email <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"email\" name=\"email\" id=\"email2\" placeholder=\"e.g: abc@mail.com\" required\r\n");
      out.write("                                                       title=\"email not allow: Unicode characters, \r\n");
      out.write("                                                       special character other than @ and . and spacing characters;  \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9);\r\n");
      out.write("                                                       maximum length of parts of email: \r\n");
      out.write("                                                       username: 12, mail server: 6, domain: 6; \r\n");
      out.write("                                                       max length: 26\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Password</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"password\" name=\"password\" id=\"password2\" \r\n");
      out.write("                                                       onkeyup=\"checkConfirmPassword2(this)\" required pattern=\"[a-zA-Z0-9]{1,12}\"\r\n");
      out.write("                                                       title=\"Password not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <span id=\"wrong_pass_alert2\"></span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Confirm Password</label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"password\" name=\"password\" id=\"confirm_password2\" \r\n");
      out.write("                                                       onkeyup=\"checkPassword2(this)\" required pattern=\"[a-zA-Z0-9]{1,12}\"\r\n");
      out.write("                                                       title=\"Confirm Password not contain: Unicode characters, \r\n");
      out.write("                                                       special character e.g: !@#$%^&,. etc.. and spacing characters; \r\n");
      out.write("                                                       allow uppercase, lowercase letters and numeric characters (0-9), max length: 12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">  \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Employee ID <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <input type=\"text\" value=\"\" readonly class=\"form-control floating employee-id\" name=\"profile_id\" id=\"profile_id2\" \r\n");
      out.write("                                                       required pattern=\"[A-Z]{5}\" title=\"Staff ID not allow Unicode characters and must be 5 character with uppercase\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">  \r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Joining Date <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <div class=\"cal-icon\"><input class=\"form-control datetimepicker\" type=\"text\" placeholder=\"pick a joining date\" onkeydown=\"event.preventDefault()\" name=\"hire_date\" id=\"hire_date2\" required pattern=\"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label class=\"col-form-label\">Phone </label>\r\n");
      out.write("                                                <input class=\"form-control\" value=\"\" type=\"text\" name=\"phone_number\" id=\"phone_number2\" title=\"phone number must be 10 digit number\" pattern=\"[0-9]{10}\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <!--                                        <div class=\"col-sm-6\">\r\n");
      out.write("                                                                                    <div class=\"form-group\">\r\n");
      out.write("                                                                                        <label class=\"col-form-label\">Report To <span class=\"text-danger\">*</span></label>-->\r\n");
      out.write("                                        <input class=\"form-control\" value=\"\" type=\"hidden\" name=\"ReportsTo\" id=\"ReportsTo2\" required=\"\" pattern=\"[A-Z]{5}\">\r\n");
      out.write("                                        <!--                                            </div>\r\n");
      out.write("                                                                                </div>-->\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Department <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"form-control\" name=\"department_id\" id=\"department_id2\" required=\"\">\r\n");
      out.write("                                                    <option value=\"\">Select Department</option>\r\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <label>Designation <span class=\"text-danger\">*</span></label>\r\n");
      out.write("                                                <select class=\"form-control\" name=\"job_id\" id=\"job_id2\" required=\"\">\r\n");
      out.write("                                                    <option value=\"\">Select Designation</option>\r\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"submit-section\">\r\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-primary submit-btn\" id=\"create2\" value=\"submit\">\r\n");
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
      out.write("                                <form action=\"manager\" do=\"post\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"do\" value=\"deleteStaff\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"profile_id\">\r\n");
      out.write("                                    <div class=\"form-header\">\r\n");
      out.write("                                        <h3>Delete Staff</h3>\r\n");
      out.write("                                        <p>Are you sure want to delete?</p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"modal-btn delete-action\">\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-6\">\r\n");
      out.write("                                                <input type=\"submit\" value=\"Delete\" href=\"\" class=\"btn btn-primary continue-btn\" style=\"padding: 10px 75px;\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-6\">\r\n");
      out.write("                                                <a href=\"javascript:void(0);\" data-dismiss=\"modal\" class=\"btn btn-primary cancel-btn\">Cancel</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alert != ''}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <script type=\"text/javascript\">\r\n");
        out.write("                    alert(\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alert}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\");\r\n");
        out.write("                </script>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_redirect_0.setUrl("login.jsp");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${job}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("j");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ejob == j.id ? \" selected\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filter == 'no'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <h4><a href=\"manager?do=list\" style=\"text-decoration: none; color: grey\"> <-- back</a></h4>\r\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
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
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("o");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <tr>\r\n");
          out.write("                                                <td>\r\n");
          out.write("                                                    <h2 class=\"table-avatar\">\r\n");
          out.write("                                                        <!--<a href=\"profile.html\" class=\"avatar\"><img alt=\"\" src=\"assets/img/user.jpg\"></a>-->\r\n");
          out.write("                                                        <a href=\"profile?do=getothersProfile&profile_id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.profile_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.first_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.last_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.department_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span></a>\r\n");
          out.write("                                                    </h2>\r\n");
          out.write("\r\n");
          out.write("                                                </td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.profile_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                ");
          if (_jspx_meth_c_choose_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.hire_date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.job_title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
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
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.user_display}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pass_display}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.reportto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.department_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.job_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" data-target=\"#edit_employee\"> <i class=\"fa fa-pencil m-r-5\"></i> Edit</a>\r\n");
          out.write("                                                            <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#delete_employee\" data-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.profile_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"fa fa-trash-o m-r-5\"></i> Delete</a>\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                </td>\r\n");
          out.write("                                            </tr>\r\n");
          out.write("                                        ");
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

  private boolean _jspx_meth_c_choose_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                    ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("                                                    ");
        if (_jspx_meth_c_otherwise_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.phone_number.equals('')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td>N/A</td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
    if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                        <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.phone_number}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</td>\r\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
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
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${department}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("o");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${job}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_3.setVar("o");
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent(null);
    _jspx_th_c_forEach_4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${department}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_4.setVar("o");
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_5.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_5.setParent(null);
    _jspx_th_c_forEach_5.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${job}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_5.setVar("o");
    int[] _jspx_push_body_count_c_forEach_5 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_5 = _jspx_th_c_forEach_5.doStartTag();
      if (_jspx_eval_c_forEach_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_5.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_5);
    }
    return false;
  }
}
