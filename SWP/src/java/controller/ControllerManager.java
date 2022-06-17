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
import java.text.ParseException;
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
        try {
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

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                List<projects> listPj = null;
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
                        p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                    }
                    request.setAttribute("filter", "yes");
                    request.setAttribute("list", list);
                    request.setAttribute("department", listDp);
                    request.setAttribute("job", listJ);
                    RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("dashboard")) {
                    request.getSession(false);
                    RequestDispatcher dispath = request.getRequestDispatcher("manager-dashboard.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("filter")) {
                    String eid = request.getParameter("eid");
                    String ename = request.getParameter("ename");
                    String ejob = request.getParameter("ejob");
                    List<profile> list = null;
                    List<departments> listDp = daoDp.listAllDepartment();
                    List<jobs> listJ = daoJ.listAllJob();

                    if (ejob.equals("")) {
                        list = daoPf.searchStaff1(eid, ename);
                        for (profile p : list) {
                            p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                        }

                        request.setAttribute("list", list);
                        request.setAttribute("filter", "no");
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                        dispath.forward(request, response);
                    } else {
                        list = daoPf.searchStaff2(eid, ename, ejob);
                        for (profile p : list) {
                            p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                        }

                        request.setAttribute("list", list);
                        request.setAttribute("filter", "no");
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("employees-list.jsp");
                        dispath.forward(request, response);
                    }

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
                        System.out.println("Successfully deleted Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete new account for Staff with profile_id = " + profile_id);
                    }

                    boolean statusPro = daoPf.deleteProfile(profile_id);
                    if (statusAcc) {
                        System.out.println("Successfully deleted account for Staff with profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to delete account for Staff with profile_id = " + profile_id);
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
                    String project = request.getParameter("project");
                    daoT.add(name, priority, deadline, status, assigned, project);
                    response.sendRedirect("task-board.jsp");
                }

                if (service.equals("searchAttendance")) {
                    String name = request.getParameter("name");
                    String date = request.getParameter("date");
                    List<attendance> list = daoA.search(name, date);
                    request.setAttribute("list", list);
                    RequestDispatcher dispath = request.getRequestDispatcher("attendance-manager.jsp");
                    dispath.forward(request, response);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error404.jsp");
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
