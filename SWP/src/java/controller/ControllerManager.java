/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.attendance;
import entity.departments;
import entity.experience;
import entity.familyInfo;
import entity.jobs;
import entity.profile;
import entity.profileDetail;
import entity.projects;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAccount;
import model.DAOAttendance;
import model.DAODepartment;
import model.DAOExperience;
import model.DAOFamilyInfo;
import model.DAOJob;
import model.DAOProfile;
import model.DAOProfileDetail;
import model.DAOProject;
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("do");
            DAOAttendance daoA = new DAOAttendance();
            DAOProfile daoPf = new DAOProfile();
            DAODepartment daoDp = new DAODepartment();
            DAOJob daoJ = new DAOJob();
            DAOTask daoT = new DAOTask();
            DAOAccount daoAcc = new DAOAccount();
            DAOProfileDetail daopd = new DAOProfileDetail();
            DAOFamilyInfo daof = new DAOFamilyInfo();
            DAOExperience daoexp = new DAOExperience();
            DAOProject daopj = new DAOProject();

            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");
            List<projects> listPj = null;

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (acc.isIsManager()) {
                    listPj = daopj.getProject(acc.getProfile_id());
                } else {
                    listPj = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", listPj);
                //profile user = daoPf.getByID(acc.getProfile_id());
                if (service.equals("attendance")) {
                    List<attendance> list = daoA.listAll(acc.getProfile_id());
                    request.setAttribute("list", list);
                    RequestDispatcher dispath = request.getRequestDispatcher("attendance-manager.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("list")) {
                    List<profile> list = daoPf.listAllStaff(acc.getProfile_id());
                    List<departments> listDp = daoDp.listAllDepartment();
                    List<jobs> listJ = daoJ.listAllJob();
                    for (profile p : list) {
                        p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                    }
                    request.setAttribute("list", list);
                    request.setAttribute("department", listDp);
                    request.setAttribute("job", listJ);
                    RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("filter")) {
                    String eid = request.getParameter("eid");
                    String ename = request.getParameter("ename");
                    String ejob = request.getParameter("ejob");
                    if (eid.equals("") && ename.equals("")) {
                        List<profile> list = daoPf.searchStaffByjob(acc.getProfile_id(), ejob);
                        for (profile p : list) {
                            p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());

                        }
                        request.setAttribute("list", list);
                        List<departments> listDp = daoDp.listAllDepartment();
                        List<jobs> listJ = daoJ.listAllJob();

                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                        dispath.forward(request, response);

                    } else if (eid.equals("") && ejob.equals("")) {
                        List<profile> list = daoPf.searchStaffByname(acc.getProfile_id(), ename);
                        for (profile p : list) {
                            p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                        }
                        request.setAttribute("list", list);
                        List<departments> listDp = daoDp.listAllDepartment();
                        List<jobs> listJ = daoJ.listAllJob();

                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                        dispath.forward(request, response);

                    } else if (ename.equals("") && ejob.equals("")) {
                        List<profile> list = daoPf.searchStaffByid(acc.getProfile_id(), eid);
                        for (profile p : list) {
                            p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                        }
                        request.setAttribute("list", list);
                        List<departments> listDp = daoDp.listAllDepartment();
                        List<jobs> listJ = daoJ.listAllJob();

                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                        dispath.forward(request, response);

                    }
                }

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
                            email, phone_number, hire_date, job_id, department_id,
                            salary, ReportsTo);
                    boolean statusPro = daoPf.addStaff(pro);
                    if (statusPro) {
                        System.out.println("Successfully added new Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to add new Staff with profile_id = " + profile_id);
                    }

                    boolean statusAcc = daoAcc.addAccount(profile_id, username, password);
                    if (statusAcc) {
                        System.out.println("Successfully added new account for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to added new account for Staff with profile_id = " + profile_id);
                    }

                    profileDetail pd = new profileDetail(profile_id, "GETDATE()",
                            "N/A", true, "N/A", "N/A", false, 0, "N/A", "N/A");
                    boolean statusPd = daopd.addProfileDetail(pd);
                    if (statusPd) {
                        System.out.println("Successfully added new profileDetail for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to added new profileDetail for Staff with profile_id = " + profile_id);
                    }

                    familyInfo f = new familyInfo(profile_id, "N/A", "N/A",
                            "GETDATE()", "N/A");
                    boolean statusf = daof.addFamilyInfo(f);
                    if (statusf) {
                        System.out.println("Successfully added new familyInfo for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to added new familyInfo for Staff with profile_id = " + profile_id);
                    }

                    experience exp = new experience(profile_id, "N/A", "GETDATE()",
                            "GETDATE()");
                    boolean statusexp = daoexp.addExperience(exp);
                    if (statusexp) {
                        System.out.println("Successfully added new experience for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to added new experience for Staff with profile_id = " + profile_id);
                    }

                    RequestDispatcher dispath = request.getRequestDispatcher("manager?do=list");
                    dispath.forward(request, response);
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
                    int job_id = Integer.parseInt(request.getParameter("job_id"));
                    String ReportsTo = request.getParameter("ReportsTo");
                    int department_id = Integer.parseInt(request.getParameter("department_id"));
                    double salary = 0;
//                    int department_id = daoDp.getDepartmentByName(department_name).getId();
//                    int job_id = daoJob.getJobByTitle(job_title).getId();
//
                    boolean statusPro = daoPf.editStaff(new profile(profile_id,
                            first_name, last_name, email, phone_number, hire_date,
                            job_id, department_id, salary, ReportsTo));
                    if (statusPro) {
                        System.out.println("Successfully edited Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to edit new Staff with profile_id = " + profile_id);
                    }

                    boolean statusAcc = daoAcc.editAccount(profile_id, username, password);
                    if (statusAcc) {
                        System.out.println("Successfully edited new account for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to edit new account for Staff with profile_id = " + profile_id);
                    }

                    RequestDispatcher dispath = request.getRequestDispatcher("manager?do=list");
                    dispath.forward(request, response);
                }

                if (service.equals("deleteStaff")) {
                    String profile_id = request.getParameter("profile_id");
                    boolean statusAcc = daoAcc.deleteAccount(profile_id);
                    if (statusAcc) {
                        System.out.println("Successfully deleted account for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete new account for Staff with profile_id = " + profile_id);
                    }
                    boolean statusPd = daopd.deleteProfileDetail(profile_id);
                    if (statusPd) {
                        System.out.println("Successfully deleted profileDetail for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete new profileDetail for Staff with profile_id = " + profile_id);
                    }
                    boolean statusf = daof.deleteFamilyInfo(profile_id);
                    if (statusf) {
                        System.out.println("Successfully deleted familyInfo for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete new familyInfo for Staff with profile_id = " + profile_id);
                    }
                    boolean statusexp = daoexp.deleteExperience(profile_id);
                    if (statusexp) {
                        System.out.println("Successfully deleted experience for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete new experience for Staff with profile_id = " + profile_id);
                    }
                    boolean statusPro = daoPf.deleteProfile(profile_id);
                    if (statusAcc) {
                        System.out.println("Successfully deleted Profile for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete Profile for Staff with profile_id = " + profile_id);
                    }

                    RequestDispatcher dispath = request.getRequestDispatcher("manager?do=list");
                    dispath.forward(request, response);
                }

                if (service.equals("addTask")) {
                    String name = request.getParameter("name");
                    int priority = Integer.parseInt(request.getParameter("priority"));
                    String deadline = request.getParameter("deadline");
                    int status = 0;
                    String assigned = request.getParameter("assigned");
                    daoT.add(name, priority, deadline, status, assigned);
                    response.sendRedirect("task-board.jsp");
                }

                if (service.equals("createProject")) {
                    String title = request.getParameter("title");
                    String client = request.getParameter("client");
                    String start_date = request.getParameter("start_date");
                    String end_date = request.getParameter("end_date");
                    double rate = Double.parseDouble(request.getParameter("rate"));
                    String manager = request.getParameter("leader");
                    String desc = request.getParameter("desc");
                    Date start = new SimpleDateFormat("dd/MM/yyyy").parse(start_date);
                    Date end = new SimpleDateFormat("dd/MM/yyyy").parse(end_date);
                    java.sql.Date startDate = new java.sql.Date(start.getTime());
                    java.sql.Date endDate = new java.sql.Date(end.getTime());
                    daopj.addProject(title, client, startDate, endDate, rate, manager, desc);
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Servlet ControllerEmployee</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>" + title + client + start_date + end_date + rate + manager + "</h1>");
//                    out.println("</body>");
//                    out.println("</html>");
                    response.sendRedirect("project-view.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
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
