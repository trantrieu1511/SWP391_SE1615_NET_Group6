/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.profile;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAODepartment;
import model.DAOJob;
import model.DAOProfile;
import model.DAOTask;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerManager", urlPatterns = {"/manager"})
public class ControllerManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("do");
            DAOProfile daoPf = new DAOProfile();
            DAODepartment daoDp = new DAODepartment();
            DAOJob daoJob = new DAOJob();
            DAOTask daoT = new DAOTask();
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                String user_name = acc.getUser();
                profile user = daoPf.getByUser(user_name);

                if (service.equals("dashboard")) {
                    request.getSession(false);
                    RequestDispatcher dispath = request.getRequestDispatcher("manager-dashboard.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("addStaff")) {
                    String profile_id = request.getParameter("profile_id");
                    String first_name = request.getParameter("first_name");
                    String last_name = request.getParameter("last_name");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String email = request.getParameter("email");
                    String phone_number = request.getParameter("phone_number");
                    String hire_date = request.getParameter("hire_date");
                    int job_id = Integer.parseInt(request.getParameter("job_id"));
                    String ReportsTo = request.getParameter("ReportsTo");
                    int department_id = Integer.parseInt(request.getParameter("department_id"));
                    double salary = 0;

                    profile pro = new profile(profile_id, first_name, last_name,
                            email, phone_number, hire_date, job_id, salary,
                            ReportsTo, department_id, username, password);
                    daoPf.addStaff(pro);
                    response.sendRedirect("employees-list.jsp");
                }

                if (service.equals("editStaff")) {
                    String profile_id = request.getParameter("profile_id");
                    String first_name = request.getParameter("first_name");
                    String last_name = request.getParameter("last_name");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String email = request.getParameter("email");
                    String phone_number = request.getParameter("phone_number");
                    String hire_date = request.getParameter("hire_date");
                    String job_title = request.getParameter("job_title");
                    String ReportsTo = request.getParameter("ReportsTo");
                    String department_name = request.getParameter("department_name");
                    double salary = 0;
                    int department_id = daoDp.getDepartmentByName(department_name).getId();
                    int job_id = daoJob.getJobByTitle(job_title).getId();

                    daoPf.editStaff(profile_id, first_name, last_name, email,
                            phone_number, hire_date, job_id, salary, ReportsTo,
                            department_id, username, password);
                    response.sendRedirect("employees-list.jsp");
                }

                if (service.equals("deleteStaff")) {
                    String profile_id = request.getParameter("profile_id");
                    daoPf.deleteProfile(profile_id);
                    response.sendRedirect("employees-list.jsp");
                }
                
                if (service.equals("addTask")) {
                    String name = request.getParameter("name");
                    int priority = Integer.parseInt(request.getParameter("priority"));
                    String deadline = request.getParameter("deadline");                   
                    int status = 0;
                    String assigned = request.getParameter("assigned");
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Servlet ControllerEmployee</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>Servlet ControllerEmployee at " + deadline + "</h1>");
//                    out.println("</body>");
//                    out.println("</html>");
                    daoT.add(name, priority, deadline, status, assigned);
                    response.sendRedirect("task-board.jsp");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
