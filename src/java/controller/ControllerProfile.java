/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employees;
import entity.Jobs;
import entity.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOProfile;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerProfile", urlPatterns = {"/ControllerProfile"})
public class ControllerProfile extends HttpServlet {

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
            DAOProfile dao = new DAOProfile();

            String service = request.getParameter("do");
            if (service == null) {
                service = "listAllStaffProfile";
            }
            if (service.equals("listAllStaffProfile")) {
                HttpSession session = request.getSession();
                Profile pro = (Profile) session.getAttribute("acc");
                if (pro == null) {
                    response.sendRedirect("login.jsp");
                } else {
                    String manager_id = pro.getProfile_id();
                    //pre data for jsp
                    Vector<Profile> vectorStaff = dao.listAllStaffProfile(manager_id);
                    Vector<Jobs> vectorJobs = dao.listAllDesignation();
                    ResultSet rsDepartment = dao.getData("select * from departments");
                    ResultSet rsJobs = dao.getData("select * from jobs");
                    ResultSet rsManager = dao.getData("select * from [Profile] where ReportsTo is null");

                    //set data for request
                    request.setAttribute("list", vectorStaff);
                    request.setAttribute("vectorJobs", vectorJobs);
                    request.setAttribute("rsJobs", rsJobs);
                    request.setAttribute("rsDepartment", rsDepartment);
                    request.setAttribute("rsManager", rsManager);

                    //select jsp
                    RequestDispatcher dispatch
                            = request.getRequestDispatcher("employees-list.jsp");
                    //run
                    dispatch.forward(request, response);
                }
            }
            if (service.equals("addStaff")) {
                //get data
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
                int department_id
                        = Integer.parseInt(request.getParameter("department_id"));
                double salary = 0; //default amount of salary
//                String img = request.getParameter("img");
                //display
//                Date hiredate = Date.valueOf(hire_date);
//                out.print(hire_date);
//                out.print(hiredate);
//                out.print(img);

                //commit insert to db
                Profile pro = new Profile(profile_id, first_name, last_name,
                        email, phone_number, hire_date, job_id, salary,
                        ReportsTo, department_id, username, password);
                //state > 0: success; state <= 0: fail
                int state = dao.addStaff(pro);
                if (state > 0) {
                    System.out.println("Added new Staff with employee_id = "
                            + profile_id);
                } else {
                    System.out.println("Add failed!");
                }
                response.sendRedirect("ControllerProfile");
            }
            if (service.equals("editStaff")) {
                String submit = request.getParameter("submit");
                if (submit == null) {  //chua nhan edit
                    //get data from db
                    String profile_id = request.getParameter("profile_id");
                    HttpSession session = request.getSession();
                    Object cur_profile_id = session.getAttribute("profile_id");
                    if (cur_profile_id == null) {
                        session.setAttribute("profile_id", profile_id);
                    } else {
                        session.setAttribute("profile_id", profile_id);
                    }
//                    out.print(profile_id);
                    ResultSet rsProfile = dao.getData("select * from [Profile] where profile_id = '" + profile_id + "'");
                    ResultSet rsJob = dao.getData("select * from jobs");
                    ResultSet rsDepartment = dao.getData("select * from departments");
                    ResultSet rsManager = dao.getData("select * from [Profile] where ReportsTo is null");
                    request.setAttribute("rsProfile", rsProfile);
                    request.setAttribute("rsJob", rsJob);
                    request.setAttribute("rsDepartment", rsDepartment);
                    request.setAttribute("rsManager", rsManager);

                    RequestDispatcher dispatch = request.getRequestDispatcher("editStaff.jsp");
                    dispatch.forward(request, response);
                } else {  //nhan edit
                    //get data
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
                    int department_id
                            = Integer.parseInt(request.getParameter("department_id"));
                    double salary = 0; //default amount of salary
//                    String img = request.getParameter("img");

                    Profile pro = new Profile(profile_id, first_name, last_name,
                            email, phone_number, hire_date, job_id, salary,
                            ReportsTo, department_id, username, password);
                    HttpSession session = request.getSession();
                    String cur_profile_id = session.getAttribute("profile_id").toString();
                    int editStatus = dao.editStaff(pro, cur_profile_id);
                    if (editStatus > 0) {
                        System.out.println("Successfully edited Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Edit failed! An error must have occured!");
                    }
                    response.sendRedirect("ControllerProfile");
                }

            }   
            if (service.equals("login")) {
                //check login
                String getUserName = request.getParameter("username");
                String getpassword = request.getParameter("password");

                // goi DAO de kiem tra tai khoan dang nhap co trong DB hay k
                boolean isValid = dao.checkLogin(getUserName, getpassword);

                //chuyen den cac view tiep theo neu login thanh cong
                if (isValid) {

                    HttpSession session = request.getSession();

                    Profile pro = (Profile) session.getAttribute("acc");
                    if (pro == null) {
                        pro = dao.addProfileInfo(getUserName, getpassword);

                        session.setAttribute("acc", pro);
                    } else {

                        pro = dao.addProfileInfo(getUserName, getpassword);

                        session.setAttribute("acc", pro);
                    }
                    response.sendRedirect("ControllerProfile");
                } // truong hop that bai se quay lai form login
                else {
//                    out.print("Account isn't available!\nYou can try to register\n <a href = \"login.jsp\">return to Login</a>");
                    HttpSession session = request.getSession();
                    Object loginfail = true;
                    session.setAttribute("status", loginfail);
                    response.sendRedirect("login.jsp");
                }
            }
            if (service.equals("deleteStaff")) {
                String profile_id = request.getParameter("profile_id");
//                out.print(profile_id);
                //delete
                int deleteStatus = dao.deleteStaff(profile_id);
                if(deleteStatus>0) System.out.println("Successfully delete Staff with profile_id = "+profile_id);
                else System.out.println("Delete fail!");
                response.sendRedirect("ControllerProfile");
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
