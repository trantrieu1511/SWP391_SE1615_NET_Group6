/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Clients;
import entity.Profile;
import entity.Projects;
import entity.Schedule;
import entity.Shift;
import entity.Task;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAttendance;
import model.DAOClients;
import model.DAODepartment;
import model.DAOFamilyInfo;
import model.DAOJob;
import model.DAOProfile;
import model.DAOProfileDetail;
import model.DAOProject;
import model.DAOSalary;
import model.DAOSchedule;
import model.DAOShift;
import model.DAOTask;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerDashboard", urlPatterns = {"/dashboard"})
public class ControllerDashboard extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProject daoProject = new DAOProject();
                DAOProfile daoProfile = new DAOProfile();
                DAOAttendance daoAttendance = new DAOAttendance();
                DAODepartment daoDepartment = new DAODepartment();
                DAOJob daoJob = new DAOJob();
                DAOProfileDetail daoPD = new DAOProfileDetail();
                DAOFamilyInfo daoFam = new DAOFamilyInfo();
                DAOSalary daoSalary = new DAOSalary();
                DAOTask daoTask = new DAOTask();
                DAOClients daoClient = new DAOClients();
                DAOShift daoShift = new DAOShift();
                DAOSchedule daoSch = new DAOSchedule();
                String service = request.getParameter("do");

                if (service.equals("manager")) {
                    Profile employee = daoProfile.getByID(acc.getProfile_id());
                    List<Projects> listProject = daoProject.listProject();
                    List<Clients> listClient = daoClient.listAllClients();
                    List<Task> listTask = daoTask.listTaskAssignedTo(acc.getProfile_id());
                    List<Profile> listProfile = daoProfile.listAllStaff(acc.getProfile_id());
                    List<String[]> listPT = new ArrayList<>();
                    for (Projects p : listProject) {
                        String[] temp = new String[4];
                        temp[0] = p.getTitle();
                        temp[1] = Integer.toString(daoTask.listProjectTask(0, p.getTitle()).size());
                        temp[2] = Integer.toString(daoTask.listProjectTask(3, p.getTitle()).size());
                        temp[3] = Integer.toString(p.getStatus());
                        listPT.add(temp);
                    }
                    request.setAttribute("name", employee.getFirst_name() + " " + employee.getLast_name());
                    request.setAttribute("totalPj", listProject.size());
                    request.setAttribute("totalClient", listClient.size());
                    request.setAttribute("totalTask", listTask.size());
                    request.setAttribute("totalEmp", listProfile.size());
                    request.setAttribute("listClient", listClient);
                    request.setAttribute("listPT", listPT);
                    RequestDispatcher dispath = request.getRequestDispatcher("manager-dashboard.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("employee")) {
                    Profile employee = daoProfile.getByID(acc.getProfile_id());
                    SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMM yyyy");
                    String today = formatter.format(new Date());
                    List<Task> listTask = daoTask.listTaskAssignedTo(acc.getProfile_id());
                    List<Task> pending = new ArrayList<>();
                    List<Task> progress = new ArrayList<>();
                    listTask.stream().filter((t) -> (t.getStatus() == 0)).forEachOrdered((t) -> {
                        pending.add(t);
                    });
                    listTask.stream().filter((t) -> (t.getStatus() == 1)).forEachOrdered((t) -> {
                        progress.add(t);
                    });
                    List<Shift> listShift = daoShift.listShift();
                    Schedule sch = daoSch.getStaffSchedule(acc.getProfile_id());
                    for(Shift s : listShift) {
                        if (!sch.getName().contains(s.getName())) {
                            listShift.remove(s);
                        }
                    }                  
                    List<Projects> listProject = daoProject.listProject();
                    request.setAttribute("name", employee.getFirst_name() + " " + employee.getLast_name());
                    request.setAttribute("date", today);
                    request.setAttribute("totalTask", listTask.size());
                    request.setAttribute("pendingTask", pending.size());
                    request.setAttribute("totalPj", listProject.size());
                    request.setAttribute("schedule", listShift);
                    request.setAttribute("list0", pending);
                    request.setAttribute("list1", progress);
                    RequestDispatcher dispath = request.getRequestDispatcher("employee-dashboard.jsp");
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
