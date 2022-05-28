package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=0\">\n");
      out.write("        <meta name=\"description\" content=\"Smarthr - Bootstrap Admin Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects\">\n");
      out.write("        <meta name=\"author\" content=\"Dreamguys - Bootstrap Admin Template\">\n");
      out.write("        <meta name=\"robots\" content=\"noindex, nofollow\">\n");
      out.write("        <title>Login - HRMS admin template</title>\n");
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
      out.write("        <!-- Main CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("                <script src=\"assets/js/html5shiv.min.js\"></script>\n");
      out.write("                <script src=\"assets/js/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body class=\"account-page\">\n");
      out.write("\n");
      out.write("        <!-- Main Wrapper -->\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("            <div class=\"account-content\">\n");
      out.write("                <a href=\"job-list.html\" class=\"btn btn-primary apply-btn\">Apply Job</a>\n");
      out.write("                <div class=\"container\">\n");
      out.write("\n");
      out.write("                    <!-- Account Logo -->\n");
      out.write("                    <div class=\"account-logo\">\n");
      out.write("                        <a href=\"index.html\"><img src=\"img/logo2.png\" alt=\"Dreamguy's Technologies\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /Account Logo -->\n");
      out.write("\n");
      out.write("                    <div class=\"account-box\">\n");
      out.write("                        <div class=\"account-wrapper\">\n");
      out.write("                            <h3 class=\"account-title\">Login</h3>\n");
      out.write("                            <p class=\"account-subtitle\">Access to our dashboard</p>\n");
      out.write("                            <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            <!-- Account Form -->\n");
      out.write("                            <form action=\"login\" method=\"post\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Email Address</label>\n");
      out.write("                                    <input class=\"form-control\" type=\"text\" name=\"user\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col\">\n");
      out.write("                                            <label>Password</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-auto\">\n");
      out.write("                                            <a class=\"text-muted\" href=\"forgot-password.html\">\n");
      out.write("                                                Forgot password?\n");
      out.write("                                            </a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <input class=\"form-control\" type=\"password\" name=\"pass\">\n");
      out.write("                                </div>\n");
      out.write("                                <div>\n");
      out.write("                                    <label><input type=\"checkbox\" value=\"Re\"> Remember Me</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group text-center\">\n");
      out.write("                                    <button class=\"btn btn-primary account-btn\" type=\"submit\" value=\"login\">Login</button>\n");
      out.write("                                </div>\n");
      out.write("                                <!--div class=\"account-footer\">\n");
      out.write("                                        <p>Don't have an account yet? <a href=\"register.html\">Register</a></p>\n");
      out.write("                                </div-->\n");
      out.write("                            </form>\n");
      out.write("                            <!-- /Account Form -->\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /Main Wrapper -->\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"js/jquery-3.5.1.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core JS -->\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Custom JS -->\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
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
}
