package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset='utf-8'>\r\n");
      out.write("        <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n");
      out.write("        <title>Snippet - BBBootstrap</title>\r\n");
      out.write("        <link\r\n");
      out.write("            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'\r\n");
      out.write("            rel='stylesheet'>\r\n");
      out.write("        <link\r\n");
      out.write("            href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css'\r\n");
      out.write("            rel='stylesheet'>\r\n");
      out.write("        <script type='text/javascript'\r\n");
      out.write("        src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>\r\n");
      out.write("        <style>\r\n");
      out.write("            .placeicon {\r\n");
      out.write("                font-family: fontawesome\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .custom-control-label::before {\r\n");
      out.write("                background-color: #dee2e6;\r\n");
      out.write("                border: #dee2e6\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body oncontextmenu='return false' class='snippet-body bg-info'>\r\n");
      out.write("        <link rel=\"stylesheet\"\r\n");
      out.write("              href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css\">\r\n");
      out.write("        <div>\r\n");
      out.write("            <!-- Container containing all contents -->\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row justify-content-center\">\r\n");
      out.write("                    <div class=\"col-12 col-md-9 col-lg-7 col-xl-6 mt-5\">\r\n");
      out.write("                        <!-- White Container -->\r\n");
      out.write("                        <div class=\"container bg-white rounded mt-2 mb-2 px-0\">\r\n");
      out.write("                            <!-- Main Heading -->\r\n");
      out.write("                            <div class=\"row justify-content-center align-items-center pt-3\">\r\n");
      out.write("                                <h1>\r\n");
      out.write("                                    <strong>Reset Password</strong>\r\n");
      out.write("                                </h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"pt-3 pb-3\">\r\n");
      out.write("                                <form class=\"form-horizontal\" action=\"newPassword\" method=\"POST\">\r\n");
      out.write("                                    <!-- User Name Input -->\r\n");
      out.write("                                    <div class=\"form-group row justify-content-center px-3\">\r\n");
      out.write("                                        <div class=\"col-9 px-0\">\r\n");
      out.write("                                            <input type=\"text\" name=\"password\" placeholder=\"&#xf084; &nbsp; New Password\"\r\n");
      out.write("                                                   class=\"form-control border-info placeicon\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!-- Password Input -->\r\n");
      out.write("                                    <div class=\"form-group row justify-content-center px-3\">\r\n");
      out.write("                                        <div class=\"col-9 px-0\">\r\n");
      out.write("                                            <input type=\"password\" name=\"confPassword\"\r\n");
      out.write("                                                   placeholder=\"&#xf084; &nbsp; Confirm New Password\"\r\n");
      out.write("                                                   class=\"form-control border-info placeicon\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <p class=\"alert-danger\">\r\n");
      out.write("                                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alert}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                    <!-- Log in Button -->\r\n");
      out.write("                                    <div class=\"form-group row justify-content-center\">\r\n");
      out.write("                                        <div class=\"col-3 px-3 mt-3\">\r\n");
      out.write("                                            <input type=\"submit\" value=\"Reset\"\r\n");
      out.write("                                                   class=\"btn btn-block btn-info\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- Alternative Login -->\r\n");
      out.write("                            <div class=\"mx-0 px-0 bg-light\">\r\n");
      out.write("\r\n");
      out.write("                                <!-- Horizontal Line -->\r\n");
      out.write("                                <div class=\"px-4 pt-5\">\r\n");
      out.write("                                    <hr>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <!-- Register Now -->\r\n");
      out.write("                                <div class=\"pt-2\">\r\n");
      out.write("                                    <div class=\"row justify-content-center\">\r\n");
      out.write("                                        <h5>\r\n");
      out.write("                                            Don't have an Account?<span><a href=\"#\"\r\n");
      out.write("                                                                           class=\"text-danger\"> Register Now!</a></span>\r\n");
      out.write("                                        </h5>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div\r\n");
      out.write("                                        class=\"row justify-content-center align-items-center pt-4 pb-5\">\r\n");
      out.write("                                        <div class=\"col-4\">\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script type='text/javascript'\r\n");
      out.write("        src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>\r\n");
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
}
