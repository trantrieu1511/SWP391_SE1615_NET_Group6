package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;

public final class attendance_002dmanager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Attendance - HRMS admin template</title>\r\n");
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
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("                <script src=\"assets/js/html5shiv.min.js\"></script>\r\n");
      out.write("                <script src=\"assets/js/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Main Wrapper -->\r\n");
      out.write("        <div class=\"main-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "index.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- Page Wrapper -->\r\n");
      out.write("                <div class=\"page-wrapper\">\r\n");
      out.write("                    <div class=\"content container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- Page Header -->\r\n");
      out.write("                        <div class=\"page-header\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-sm-12\">\r\n");
      out.write("                                    <h3 class=\"page-title\">Attendance</h3>\r\n");
      out.write("                                    <ul class=\"breadcrumb\">\r\n");
      out.write("                                        <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li>\r\n");
      out.write("                                        <li class=\"breadcrumb-item active\">Attendance</li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /Page Header -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- Search Filter -->\r\n");
      out.write("                        <div class=\"row filter-row\">\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-4\">  \r\n");
      out.write("                                <div class=\"form-group form-focus\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control floating\" id=\"myInput\" onkeyup=\"filter()\">\r\n");
      out.write("                                    <label class=\"focus-label\">Employee Name</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-4\"> \r\n");
      out.write("                                <div class=\"form-group form-focus select-focus\">\r\n");
      out.write("                                    <select class=\"select floating\" id=\"month\" onchange=\"filter()\"> \r\n");
      out.write("                                        <option>-</option>\r\n");
      out.write("                                        <option>Jan</option>\r\n");
      out.write("                                        <option>Feb</option>\r\n");
      out.write("                                        <option>Mar</option>\r\n");
      out.write("                                        <option>Apr</option>\r\n");
      out.write("                                        <option>May</option>\r\n");
      out.write("                                        <option>Jun</option>\r\n");
      out.write("                                        <option>Jul</option>\r\n");
      out.write("                                        <option>Aug</option>\r\n");
      out.write("                                        <option>Sep</option>\r\n");
      out.write("                                        <option>Oct</option>\r\n");
      out.write("                                        <option>Nov</option>\r\n");
      out.write("                                        <option>Dec</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                    <label class=\"focus-label\">Select Month</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-md-4\"> \r\n");
      out.write("                                <div class=\"form-group form-focus select-focus\">\r\n");
      out.write("                                    <select class=\"select floating\" id=\"year\" onchange=\"filter()\"> \r\n");
      out.write("                                        <option>-</option>\r\n");
      out.write("                                        <option>2019</option>\r\n");
      out.write("                                        <option>2018</option>\r\n");
      out.write("                                        <option>2017</option>\r\n");
      out.write("                                        <option>2016</option>\r\n");
      out.write("                                        <option>2015</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                    <label class=\"focus-label\">Select Year</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>                          \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /Search Filter -->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-lg-12\">\r\n");
      out.write("                                <div class=\"table-responsive\">\r\n");
      out.write("                                    <table class=\"table table-striped custom-table dataTable\" id=\"table\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th>ID</th>\r\n");
      out.write("                                                <th>Date </th>\r\n");
      out.write("                                                <th>Punch In</th>\r\n");
      out.write("                                                <th>Punch Out</th>\r\n");
      out.write("                                                <th>Production</th>                                            \r\n");
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
      out.write("                    <script type=\"text/javascript\">\r\n");
      out.write("                        function filter() {\r\n");
      out.write("                            var input, filter, table, tr, td, i, txtValue;\r\n");
      out.write("                            input = document.getElementById(\"myInput\");\r\n");
      out.write("                            table = document.getElementById(\"table\");\r\n");
      out.write("                            tr = table.getElementsByTagName(\"tr\");\r\n");
      out.write("                            filter = input.value.toUpperCase();\r\n");
      out.write("\r\n");
      out.write("                            for (i = 0; i < tr.length; i++) {\r\n");
      out.write("                                td = tr[i].getElementsByTagName(\"td\")[0];\r\n");
      out.write("                                if (td) {\r\n");
      out.write("                                    txtValue = td.textContent || td.innerText;\r\n");
      out.write("                                    if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n");
      out.write("                                        tr[i].style.display = \"\";\r\n");
      out.write("                                    } else {\r\n");
      out.write("                                        tr[i].style.display = \"none\";\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    </script> \r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /Page Content -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /Main Wrapper -->\r\n");
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
      out.write("        <!-- Chart JS -->\r\n");
      out.write("<!--        <script src=\"plugins/morris/morris.min.js\"></script>\r\n");
      out.write("        <script src=\"plugins/raphael/raphael.min.js\"></script>\r\n");
      out.write("        <script src=\"js/chart.js\"></script>-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom JS -->\r\n");
      out.write("        <script src=\"js/app.js\"></script>\r\n");
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
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list_attendance}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <tr>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.employee_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.time_in}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.time_out}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.production_time}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
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
}
