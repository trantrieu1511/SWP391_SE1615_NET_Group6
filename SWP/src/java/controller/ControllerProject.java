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
import entity.Task;
import java.io.IOException;
import java.text.DateFormat;
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
import model.DAOClients;
import model.DAOJob;
import model.DAOProfile;
import model.DAOProject;
import model.DAOTask;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerProject", urlPatterns = {"/project"})
public class ControllerProject extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public String format(String date) throws Exception {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        String formatted = dateFormat.format(date1);
        return formatted;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProject daoProject = new DAOProject();
                DAOProfile daoProfile = new DAOProfile();
                DAOClients daoClients = new DAOClients();
                DAOTask daoTask = new DAOTask();
                DAOJob daoJob = new DAOJob();
                String service = request.getParameter("do");

                if (service.equals("list")) {
                    List<Projects> listPj = daoProject.listProject();
                    List<Clients> listC = daoClients.listAllClients();
                    String alert = "";
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC);
                    request.setAttribute("alert", alert);
                    request.setAttribute("search", "");
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("create")) {
                    String title = request.getParameter("title");
                    String client_id = request.getParameter("client");
                    String period = request.getParameter("daterange");
                    String rate = request.getParameter("rate");
                    String manager = request.getParameter("manager");
                    String desc = request.getParameter("description");
                    daoProject.addProject(title, client_id, period, Double.parseDouble(rate), manager, desc);
                    String alert = "New project saved!";
                    List<Projects> listPj = daoProject.listProject();
                    List<Clients> listC = daoClients.listAllClients();
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC);
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("search")) {
                    String title = request.getParameter("title");
                    List<Projects> listPj = null;
                    if (acc.isIsManager()) {
                        listPj = daoProject.search(title);
                    } else {
                        listPj = daoProject.search(title);
                    }
                    request.setAttribute("title", title);
                    String alert = "";
                    List<Clients> listC = daoClients.listAllClients();
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC);
                    request.setAttribute("alert", alert);
                    request.setAttribute("search", title);
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("delete")) {
                    String title = request.getParameter("title");
                    boolean del = daoProject.deleteProject(title);
                    if (del == true) {
                        String alert = "Project deleted!";
                        request.setAttribute("alert", alert);
                        List<Projects> listPj = daoProject.listProject();
                        List<Clients> listC = daoClients.listAllClients();
                        request.setAttribute("list", listPj);
                        request.setAttribute("listC", listC);
                        RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                        dispath.forward(request, response);
                    } else {
                        String alert = "Cannot delete project having tasks!";
                        request.setAttribute("alert", alert);
                        List<Projects> listPj = daoProject.listProject();
                        List<Clients> listC = daoClients.listAllClients();
                        request.setAttribute("list", listPj);
                        request.setAttribute("listC", listC);
                        RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                        dispath.forward(request, response);
                    }
                }

                if (service.equals("edit")) {
                    String oldTitle = request.getParameter("oldTitle");
                    String title = request.getParameter("title");
                    String client_id = request.getParameter("client");
                    String period = request.getParameter("daterange");
                    String rate = request.getParameter("rate");
                    String manager = request.getParameter("manager");
                    String desc = request.getParameter("description");
                    String status = request.getParameter("status");
                    boolean edit = daoProject.updateProject(oldTitle, title, client_id, period, Double.parseDouble(rate), manager, desc, Integer.parseInt(status));
                    List<Projects> listPj = daoProject.listProject();
                    List<Clients> listC = daoClients.listAllClients();
                    String alert;
                    if (edit == false) {
                        alert = "Cannot edit project having tasks!";
                    } else {
                        alert = "New information has been saved!";
                    }
                    request.setAttribute("alert", alert);
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC);
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("view")) {
                    String title = request.getParameter("title");
                    Projects pj = daoProject.getProject(title);
                    String sDate = format(pj.getPeriod().split(" ")[0]);
                    String eDate = format(pj.getPeriod().split(" ")[2]);
                    List<Task> list0 = daoTask.listProjectTask(0, title);
                    List<Task> list1 = daoTask.listProjectTask(1, title);
                    List<Task> list2 = daoTask.listProjectTask(2, title);
                    List<Task> list3 = daoTask.listProjectTask(3, title);
                    Profile lead = null;
                    if (acc.isIsManager()) {
                        lead = daoProfile.getByID(acc.getProfile_id());
                    } else {
                        lead = daoProfile.getByID(daoProfile.getByID(acc.getProfile_id()).getReportto());
                    }
                    List<Profile> listPf = null;
                    if (acc.isIsManager()) {
                        listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    } else {
                        listPf = daoProfile.listAllStaff(daoProfile.getByID(acc.getProfile_id()).getReportto());
                    }
                    for (Profile p : listPf) {
                        p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                    }
                    List<Clients> listC = daoClients.listAllClients();
                    request.setAttribute("project", pj);
                    request.setAttribute("start", sDate);
                    request.setAttribute("end", eDate);
                    request.setAttribute("list0", list0);
                    request.setAttribute("list1", list1);
                    request.setAttribute("list2", list2);
                    request.setAttribute("list3", list3);
                    request.setAttribute("lead", lead);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("listC", listC);
                    RequestDispatcher dispath = request.getRequestDispatcher("project-view.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("editFromView")) {
                    String oldTitle = request.getParameter("oldTitle");
                    String title = request.getParameter("title");
                    String client_id = request.getParameter("client");
                    String period = request.getParameter("daterange");
                    String rate = request.getParameter("rate");
                    String manager = request.getParameter("manager");
                    String desc = request.getParameter("description");
                    String status = request.getParameter("status");
                    daoProject.updateProject(oldTitle, title, client_id, period, Double.parseDouble(rate), manager, desc, Integer.parseInt(status));
                    Projects pj = daoProject.getProject(title);
                    String sDate = format(pj.getPeriod().split(" ")[0]);
                    String eDate = format(pj.getPeriod().split(" ")[2]);
                    List<Task> list0 = daoTask.listProjectTask(0, title);
                    List<Task> list1 = daoTask.listProjectTask(1, title);
                    List<Task> list2 = daoTask.listProjectTask(2, title);
                    List<Task> list3 = daoTask.listProjectTask(3, title);
                    Profile lead = daoProfile.getByID(acc.getProfile_id());
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    for (Profile p : listPf) {
                        p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                    }
                    List<Clients> listC = daoClients.listAllClients();
                    request.setAttribute("project", pj);
                    request.setAttribute("start", sDate);
                    request.setAttribute("end", eDate);
                    request.setAttribute("list0", list0);
                    request.setAttribute("list1", list1);
                    request.setAttribute("list2", list2);
                    request.setAttribute("list3", list3);
                    request.setAttribute("lead", lead);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("listC", listC);
                    RequestDispatcher dispath = request.getRequestDispatcher("project-view.jsp");
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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
