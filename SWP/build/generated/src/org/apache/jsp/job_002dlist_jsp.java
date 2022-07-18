package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class job_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=0\">\n");
      out.write("        <meta name=\"description\" content=\"Smarthr - Bootstrap Admin Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects\">\n");
      out.write("        <meta name=\"author\" content=\"Dreamguys - Bootstrap Admin Template\">\n");
      out.write("        <meta name=\"robots\" content=\"noindex, nofollow\">\n");
      out.write("        <title>Account - HRMS admin template</title>\n");
      out.write("\n");
      out.write("        <!-- Favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/favicon.png\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Fontawesome CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Lineawesome CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/line-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Datatable CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/dataTables.bootstrap4.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Select2 CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/select2.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Datetimepicker CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-datetimepicker.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Main CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <!-- import js -->\n");
      out.write("        <script src=\"js/employee-list_js.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"js/jquery-3.5.1.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core JS -->\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Slimscroll JS -->\n");
      out.write("        <script src=\"js/jquery.slimscroll.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Select2 JS -->\n");
      out.write("        <script src=\"js/select2.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Datetimepicker JS -->\n");
      out.write("        <script src=\"js/moment.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-datetimepicker.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Datatable JS -->\n");
      out.write("        <script src=\"js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"js/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Custom JS -->\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
      out.write("        <script src=\"js/edit.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Model JS -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#edit_account\").on(\"show.bs.modal\", function (e) {\n");
      out.write("                    var text = $(e.relatedTarget).attr('data-id');\n");
      out.write("                    const myArray = text.split(\" \");\n");
      out.write("                    var id = myArray[0];\n");
      out.write("                    var first_name = myArray[1];\n");
      out.write("                    var last_name = myArray[2];\n");
      out.write("                    var email = myArray[3];\n");
      out.write("                    var phone_number = myArray[4];\n");
      out.write("                    var hire_date = myArray[5];\n");
      out.write("                    var username = myArray[6];\n");
      out.write("                    var password = myArray[7];\n");
      out.write("                    var isamin_d = myArray[8];\n");
      out.write("                    var ismanager_d = myArray[9];\n");
      out.write("                    var status_d = myArray[10];\n");
      out.write("                    $(e.currentTarget).find('input[name=\"eid\"]').val(id);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"efname\"]').val(first_name);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"elname\"]').val(last_name);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"eemail\"]').val(email);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"epnumber\"]').val(phone_number);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"ehiredate\"]').val(hire_date);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"euser\"]').val(username);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"epass\"]').val(password);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"eisa\"]').val(isamin_d);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"eism\"]').val(ismanager_d);\n");
      out.write("                    $(e.currentTarget).find('input[name=\"estatus\"]').val(status_d);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#add_account\").on(\"show.bs.modal\", function (e) {\n");
      out.write("                    var reportto = $(e.relatedTarget).attr('data-id');\n");
      out.write("                    $(e.currentTarget).find('input[name=\"ReportsTo\"]').val(reportto);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#delete_account\").on(\"show.bs.modal\", function (e) {\n");
      out.write("                    var id = $(e.relatedTarget).attr('data-id');\n");
      out.write("                    $(e.currentTarget).find('input[name=\"aprofile_id\"]').val(id);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function () {\n");
      out.write("                $('input[type=\"text\"]').change(function () {\n");
      out.write("                    this.value = $.trim(this.value);\n");
      out.write("                });\n");
      out.write("            })\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onpageshow=\"checkPasswordonpageshow()\">\n");
      out.write("\n");
      out.write("        <!-- Main Wrapper -->\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Page Wrapper -->\n");
      out.write("                <div class=\"page-wrapper\">\n");
      out.write("\n");
      out.write("                    <!-- Page Content -->\n");
      out.write("                    <div class=\"content container-fluid\">\n");
      out.write("                        <!-- Page Header -->\n");
      out.write("                        <div class=\"page-header\">\n");
      out.write("                            <div class=\"row align-items-center\">\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h3 class=\"page-title\">Job</h3>\n");
      out.write("                                    <ul class=\"breadcrumb\">\n");
      out.write("                                        <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li>\n");
      out.write("                                        <li class=\"breadcrumb-item active\">Job</li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-auto float-right ml-auto\">\n");
      out.write("                                    <a href=\"#\" class=\"btn add-btn\" data-toggle=\"modal\" data-target=\"#add_account\"><i class=\"fa fa-plus\"></i> Add Job</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /Page Header -->\n");
      out.write("\n");
      out.write("                        <!-- Search Filter -->\n");
      out.write("                        <form action=\"authentication?do=search\" method=\"post\">\n");
      out.write("                            <div class=\"row filter-row\">\n");
      out.write("                                <div class=\"col-sm-6 col-md-3\">  \n");
      out.write("                                    <div class=\"form-group form-focus\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control floating\" name=\"fname\">\n");
      out.write("                                        <label class=\"focus-label\">Min Salary</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-6 col-md-3\">  \n");
      out.write("                                    <div class=\"form-group form-focus\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control floating\" name=\"lname\">\n");
      out.write("                                        <label class=\"focus-label\">Max Salary</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-6 col-md-3\">  \n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-success btn-block\" value=\"Search\" style=\"padding: 0px\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-6 col-md-3\">  \n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-success btn-block\" value=\"Clear\" style=\"padding: 0px\">\n");
      out.write("                                </div>  \n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                        <!-- /Search Filter -->\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped custom-table mb-0 datatable\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>JOB-ID</th>\n");
      out.write("                                                <th>JOB-TITLE</th>\n");
      out.write("                                                <th>MIN_SALARY</th>\n");
      out.write("                                                <th>MAX_SALARY</th>\n");
      out.write("                                                <th class=\"text-right\">Actions</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /Page Content -->\n");
      out.write("\n");
      out.write("                <!-- Add Job Modal -->\n");
      out.write("                <div id=\"add_account\" class=\"modal custom-modal fade\" role=\"dialog\">\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">\n");
      out.write("                        <div class=\"modal-content\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\">Add Job</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\n");
      out.write("                                <form action=\"authentication\" do=\"post\">\n");
      out.write("                                    <input type=\"hidden\" name=\"do\" value=\"addaccount\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>ID</label>\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"id\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Title</label>\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"fname\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Min Salary</label>\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"lname\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Max Salary</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"pnumber\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"submit-section\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary submit-btn\">Submit</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /Add Job Modal -->\n");
      out.write("\n");
      out.write("                <!-- Edit Job Modal -->\n");
      out.write("                <div id=\"edit_account\" class=\"modal custom-modal fade\" role=\"dialog\">\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <div class=\"modal-content\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\">Edit Job</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\n");
      out.write("                                <form action=\"authentication\" do=\"post\">\n");
      out.write("                                    <input type=\"hidden\" name=\"do\" value=\"addaccount\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>ID</label>\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"id\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Title</label>\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"fname\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Min Salary</label>\n");
      out.write("                                                <input class=\"form-control\" type=\"text\" name=\"lname\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Max Salary</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"pnumber\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"submit-section\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary submit-btn\">Save</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /Edit Job Modal -->\n");
      out.write("\n");
      out.write("            <!-- Delete Job Modal -->\n");
      out.write("            <div class=\"modal custom-modal fade\" id=\"delete_account\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog modal-dialog-centered\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form action=\"authentication\" do=\"post\">\n");
      out.write("                                <input type=\"hidden\" name=\"do\" value=\"delete\">\n");
      out.write("                                <input type=\"hidden\" name=\"aprofile_id\">\n");
      out.write("                                <div class=\"form-header\">\n");
      out.write("                                    <h3>Delete Job</h3>\n");
      out.write("                                    <p>Are you sure want to delete?</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-btn delete-action\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-6\">\n");
      out.write("                                            <input type=\"submit\" value=\"Delete\" href=\"\" class=\"btn btn-primary continue-btn\" style=\"padding: 10px 75px;\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-6\">\n");
      out.write("                                            <a href=\"javascript:void(0);\" data-dismiss=\"modal\" class=\"btn btn-primary cancel-btn\">Cancel</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>       \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /Delete Job Modal -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /Page Wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /Main Wrapper -->\n");
      out.write("\n");
      out.write("</body>\n");
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
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
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
        out.write("\n");
        out.write("                <script type=\"text/javascript\">\n");
        out.write("                    alert(\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alert}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\");\n");
        out.write("                </script>\n");
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
        out.write("\n");
        out.write("\n");
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
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
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
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listJ}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("j");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <tr>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.min}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.max}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                <td class=\"text-right\">\n");
          out.write("                                                    <div class=\"dropdown dropdown-action\">\n");
          out.write("                                                        <a href=\"#\" class=\"action-icon dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"material-icons\">more_vert</i></a>\n");
          out.write("                                                        <div class=\"dropdown-menu dropdown-menu-right\">\n");
          out.write("                                                            <a href=\"#\" class=\"dropdown-item\" data-toggle=\"modal\" data-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.min}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.max}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" data-target=\"#edit_account\"><i class=\"fa fa-pencil m-r-5\"></i> Edit</a>\n");
          out.write("                                                            <a href=\"#\" class=\"dropdown-item\" data-toggle=\"modal\" data-target=\"#delete_account\" data-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"fa fa-trash-o m-r-5\"></i> Delete</a>\n");
          out.write("                                                        </div>\n");
          out.write("                                                    </div>\n");
          out.write("                                                </td>\n");
          out.write("                                            </tr>\n");
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
}
