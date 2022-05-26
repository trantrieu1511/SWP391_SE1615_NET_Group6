package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;

public final class attendance_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat hf = new SimpleDateFormat("hh:mm");
    String date = df.format(new java.util.Date());
    String hour = hf.format(new java.util.Date());
    String str = date + " " + hour;

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
      out.write("        <title>Attendance - HRMS admin template</title>\n");
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
      out.write("        <!-- Select2 CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/select2.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Datetimepicker CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-datetimepicker.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Main Stylesheet -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("                <script src=\"js/html5shiv.min.js\"></script>\n");
      out.write("                <script src=\"js/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Main Wrapper -->\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "index.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Page Wrapper -->\n");
      out.write("                <div class=\"page-wrapper\">\n");
      out.write("                    <div class=\"content container-fluid\">\n");
      out.write("\n");
      out.write("                        <!-- Page Header -->\n");
      out.write("                        <div class=\"page-header\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-12\">\n");
      out.write("                                    <h3 class=\"page-title\">Attendance</h3>\n");
      out.write("                                    <ul class=\"breadcrumb\">\n");
      out.write("                                        <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li>\n");
      out.write("                                        <li class=\"breadcrumb-item active\">Attendance</li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /Page Header -->\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <div class=\"card punch-status\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5 class=\"card-title\">Timesheet <small class=\"text-muted\">");
      out.print(date);
      out.write("</small></h5>\n");
      out.write("                                    <div class=\"punch-det\">\n");
      out.write("                                        <h6 id=\"punch-det-text\" name=\"text\"></h6>\n");
      out.write("                                        <p id=\"inat\"></p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"punch-info\"onload=\"initClock()\">\n");
      out.write("                                        <div class=\"punch-hours\">\n");
      out.write("                                            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "clock.jsp", out, false);
      out.write("                                       \n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"punch-btn-section\">\n");
      out.write("                                        <a href=\"#\" button id=\"in\" onclick=\"punch(this.id)\" type=\"button\" class=\"btn btn-primary punch-btn\" name=\"punch\">Punch In</button></a>\n");
      out.write("                                        <script type=\"text/javascript\">\n");
      out.write("                                            function punch(id)\n");
      out.write("                                            {\n");
      out.write("                                                if (id == \"out\") {\n");
      out.write("                                                    document.getElementById(id).href = \"attendance?time=");
      out.print(str);
      out.write(" out\";\n");
      out.write("                                                    var today = new Date();\n");
      out.write("                                                    var time = today.getHours() + \":\" + today.getMinutes() + \":\" + today.getSeconds();\n");
      out.write("                                                    document.getElementById(id).innerHTML = \"Punch In\";\n");
      out.write("                                                    document.getElementById(id).id = \"in\";\n");
      out.write("                                                    document.getElementById(\"punch-det-text\").innerHTML = \"Punch Out At\";\n");
      out.write("                                                    document.getElementById(\"inat\").innerHTML = time;\n");
      out.write("                                                } else {\n");
      out.write("                                                    document.getElementById(id).href = \"attendance?time=");
      out.print(str);
      out.write(" in\";\n");
      out.write("                                                    var today = new Date();\n");
      out.write("                                                    var time = today.getHours() + \":\" + today.getMinutes() + \":\" + today.getSeconds();\n");
      out.write("                                                    document.getElementById(id).innerHTML = \"Punch Out\";\n");
      out.write("                                                    document.getElementById(id).id = \"out\";\n");
      out.write("                                                    document.getElementById(\"punch-det-text\").innerHTML = \"Punch In At\";\n");
      out.write("                                                    document.getElementById(\"inat\").innerHTML = time;\n");
      out.write("                                                }\n");
      out.write("                                            }\n");
      out.write("                                        </script>\n");
      out.write("                                    </div>                                  \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!--                        <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"card att-statistics\">\n");
      out.write("                                                        <div class=\"card-body\">\n");
      out.write("                                                            <h5 class=\"card-title\">Statistics</h5>\n");
      out.write("                                                            <div class=\"stats-list\">\n");
      out.write("                                                                <div class=\"stats-info\">\n");
      out.write("                                                                    <p>Today <strong>3.45 <small>/ 8 hrs</small></strong></p>\n");
      out.write("                                                                    <div class=\"progress\">\n");
      out.write("                                                                        <div class=\"progress-bar bg-primary\" role=\"progressbar\" style=\"width: 31%\" aria-valuenow=\"31\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"stats-info\">\n");
      out.write("                                                                    <p>This Week <strong>28 <small>/ 40 hrs</small></strong></p>\n");
      out.write("                                                                    <div class=\"progress\">\n");
      out.write("                                                                        <div class=\"progress-bar bg-warning\" role=\"progressbar\" style=\"width: 31%\" aria-valuenow=\"31\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"stats-info\">\n");
      out.write("                                                                    <p>This Month <strong>90 <small>/ 160 hrs</small></strong></p>\n");
      out.write("                                                                    <div class=\"progress\">\n");
      out.write("                                                                        <div class=\"progress-bar bg-success\" role=\"progressbar\" style=\"width: 62%\" aria-valuenow=\"62\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"stats-info\">\n");
      out.write("                                                                    <p>Remaining <strong>90 <small>/ 160 hrs</small></strong></p>\n");
      out.write("                                                                    <div class=\"progress\">\n");
      out.write("                                                                        <div class=\"progress-bar bg-danger\" role=\"progressbar\" style=\"width: 62%\" aria-valuenow=\"62\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"stats-info\">\n");
      out.write("                                                                    <p>Overtime <strong>4</strong></p>\n");
      out.write("                                                                    <div class=\"progress\">\n");
      out.write("                                                                        <div class=\"progress-bar bg-info\" role=\"progressbar\" style=\"width: 22%\" aria-valuenow=\"22\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>-->\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"card recent-activity\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h5 class=\"card-title\">Today Activity</h5>\n");
      out.write("                                    <ul class=\"res-activity-list\">\n");
      out.write("                                        <li>\n");
      out.write("                                            <p class=\"mb-0\">Punch In at</p>\n");
      out.write("                                            <p class=\"res-activity-time\">\n");
      out.write("                                                <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                                10.00 AM.\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <p class=\"mb-0\">Punch Out at</p>\n");
      out.write("                                            <p class=\"res-activity-time\">\n");
      out.write("                                                <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                                11.00 AM.\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <p class=\"mb-0\">Punch In at</p>\n");
      out.write("                                            <p class=\"res-activity-time\">\n");
      out.write("                                                <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                                11.15 AM.\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <p class=\"mb-0\">Punch Out at</p>\n");
      out.write("                                            <p class=\"res-activity-time\">\n");
      out.write("                                                <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                                1.30 PM.\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <p class=\"mb-0\">Punch In at</p>\n");
      out.write("                                            <p class=\"res-activity-time\">\n");
      out.write("                                                <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                                2.00 PM.\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <p class=\"mb-0\">Punch Out at</p>\n");
      out.write("                                            <p class=\"res-activity-time\">\n");
      out.write("                                                <i class=\"fa fa-clock-o\"></i>\n");
      out.write("                                                7.30 PM.\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Search Filter -->\n");
      out.write("                    <div class=\"row filter-row\">\n");
      out.write("                        <div class=\"col-sm-3\">  \n");
      out.write("                            <div class=\"form-group form-focus\">\n");
      out.write("                                <div class=\"cal-icon\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control floating datetimepicker\">\n");
      out.write("                                </div>\n");
      out.write("                                <label class=\"focus-label\">Date</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-3\"> \n");
      out.write("                            <div class=\"form-group form-focus select-focus\">\n");
      out.write("                                <select class=\"select floating\"> \n");
      out.write("                                    <option>-</option>\n");
      out.write("                                    <option>Jan</option>\n");
      out.write("                                    <option>Feb</option>\n");
      out.write("                                    <option>Mar</option>\n");
      out.write("                                    <option>Apr</option>\n");
      out.write("                                    <option>May</option>\n");
      out.write("                                    <option>Jun</option>\n");
      out.write("                                    <option>Jul</option>\n");
      out.write("                                    <option>Aug</option>\n");
      out.write("                                    <option>Sep</option>\n");
      out.write("                                    <option>Oct</option>\n");
      out.write("                                    <option>Nov</option>\n");
      out.write("                                    <option>Dec</option>\n");
      out.write("                                </select>\n");
      out.write("                                <label class=\"focus-label\">Select Month</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-3\"> \n");
      out.write("                            <div class=\"form-group form-focus select-focus\">\n");
      out.write("                                <select class=\"select floating\"> \n");
      out.write("                                    <option>-</option>\n");
      out.write("                                    <option>2019</option>\n");
      out.write("                                    <option>2018</option>\n");
      out.write("                                    <option>2017</option>\n");
      out.write("                                    <option>2016</option>\n");
      out.write("                                    <option>2015</option>\n");
      out.write("                                </select>\n");
      out.write("                                <label class=\"focus-label\">Select Year</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-3\">  \n");
      out.write("                            <a href=\"#\" class=\"btn btn-success btn-block\"> Search </a>  \n");
      out.write("                        </div>     \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /Search Filter -->\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"table-responsive\">\n");
      out.write("                                <table class=\"table table-striped custom-table mb-0\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>#</th>\n");
      out.write("                                            <th>Date </th>\n");
      out.write("                                            <th>Punch In</th>\n");
      out.write("                                            <th>Punch Out</th>\n");
      out.write("                                            <th>Production</th>                                            \n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
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
      out.write("            </div>\n");
      out.write("            <!-- Page Wrapper -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /Main Wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Select2 JS -->\n");
      out.write("        <script src=\"js/select2.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Datetimepicker JS -->\n");
      out.write("        <script src=\"js/moment.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-datetimepicker.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
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
          out.write("\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.time_in}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.time_out}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.production_time}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    ");
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
