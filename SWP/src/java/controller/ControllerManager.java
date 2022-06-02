/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.attendance;
import entity.profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAttendance;
import model.DAODepartment;
import model.DAOJob;
import model.DAOProfile;

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
            DAOAttendance dao = new DAOAttendance();
            DAOProfile dao2 = new DAOProfile();
            DAODepartment dao3 = new DAODepartment();
            DAOJob dao4 = new DAOJob();
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");
            String user_name = acc.getUser();
            profile user = dao2.getByUser(user_name);

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
                String department_id = request.getParameter("department_id");
                double salary = 0;

                profile pro = new profile(profile_id, first_name, last_name,
                        email, phone_number, hire_date, job_id, salary,
                        ReportsTo, job_id, username, password);
                int state = dao2.addStaff(pro);
                if (state > 0) {
                    System.out.println("Added new Staff with employee_id = "
                            + profile_id);
                } else {
                    System.out.println("Add failed!");
                }
                response.sendRedirect("ControllerProfile");
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
                String job_title = request.getParameter("job_id");
                String ReportsTo = request.getParameter("ReportsTo");
                String department_name = request.getParameter("department_id");
                double salary = 0;
                int department_id = dao3.getDepartmentByName(department_name).getId();
                int job_id = dao4.getJobByTitle(job_title).getId();

                profile pro = new profile(profile_id, first_name, last_name,
                        email, phone_number, hire_date, job_id, salary,
                        ReportsTo, department_id, username, password);
                dao2.editStaff(pro, user.getProfile_id());
                response.sendRedirect("manager?do=listAllProfile");
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
