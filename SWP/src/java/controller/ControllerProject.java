/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.clients;
import entity.profile;
import entity.projects;
import entity.task;
import java.io.IOException;
import java.text.DateFormat;
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
            account acc = (account) session.getAttribute("acc");

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProject daopj = new DAOProject();
                DAOProfile daoPf = new DAOProfile();
                DAOClients daoc = new DAOClients();
                DAOTask daot = new DAOTask();
                DAOJob daoJ = new DAOJob();
                List<projects> list = null;
                if (acc.isIsManager()) {
                    list = daopj.getProject(acc.getProfile_id());
                } else {
                    list = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", list);
                String service = request.getParameter("do");

                if (service.equals("list")) {
                    List<projects> listPj = null;
                    if (acc.isIsManager()) {
                        listPj = daopj.getProject(acc.getProfile_id());
                    } else {
                        listPj = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                    }
                    List<clients> listC = daoc.listAllClients();
                    String alert = "";
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC); 
                    request.setAttribute("alert", alert);
                    request.setAttribute("search", "Project title");
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
                    daopj.addProject(title, client_id, period, Double.parseDouble(rate), manager, desc);
                    String alert = "New project saved!";
                    List<projects> listPj = daopj.getProject(acc.getProfile_id());
                    List<clients> listC = daoc.listAllClients();
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC); 
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("search")) {
                    String title = request.getParameter("title");
                    List<projects> listPj = null;
                    if (acc.isIsManager()) {
                        listPj = daopj.search(title, acc.getProfile_id());
                    } else {
                        listPj = daopj.search(title, daoPf.getByID(acc.getProfile_id()).getReportto());
                    }
                    request.setAttribute("title", title);
                    String alert = "";
                    List<clients> listC = daoc.listAllClients();
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC);
                    request.setAttribute("alert", alert);
                    request.setAttribute("search", title);
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("delete")) {
                    String title = request.getParameter("title");
                    daopj.deleteProject(title);
                    String alert = "Project deleted!";
                    request.setAttribute("alert", alert);
                    List<projects> listPj = daopj.getProject(acc.getProfile_id());                  
                    List<clients> listC = daoc.listAllClients();
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC); 
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("edit")) {
                    String oldTitle = request.getParameter("oldTitle");
                    String title = request.getParameter("title");
                    String client_id = request.getParameter("client");
                    String period = request.getParameter("daterange");
                    String rate = request.getParameter("rate");
                    String manager = request.getParameter("manager");
                    String desc = request.getParameter("description");
                    daopj.updateProject(oldTitle, title, client_id, period, Double.parseDouble(rate), manager, desc);
                    List<projects> listPj = daopj.getProject(acc.getProfile_id());                  
                    List<clients> listC = daoc.listAllClients();
                    String alert = "New information has been saved!";
                    request.setAttribute("alert", alert);
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC); 
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("view")) {
                    String title = request.getParameter("title");
                    projects pj = daopj.getP(title);
                    String sDate = format(pj.getPeriod().split(" ")[0]);
                    String eDate = format(pj.getPeriod().split(" ")[2]);
                    List<task> list0 = daot.listProjectTask(0, title);
                    List<task> list1 = daot.listProjectTask(1, title);
                    List<task> list2 = daot.listProjectTask(2, title);
                    List<task> list3 = daot.listProjectTask(3, title);
                    profile lead = null;
                    if (acc.isIsManager()) {
                        lead = daoPf.getByID(acc.getProfile_id());
                    } else {
                        lead = daoPf.getByID(daoPf.getByID(acc.getProfile_id()).getReportto());
                    }
                    List<profile> listPf = null;
                    if (acc.isIsManager()) {
                        listPf = daoPf.listAllStaff(acc.getProfile_id());
                    } else {
                        listPf = daoPf.listAllStaff(daoPf.getByID(acc.getProfile_id()).getReportto());
                    }
                    for (profile p : listPf) {
                        p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                    }
                    List<clients> listC = daoc.listAllClients();
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
                    daopj.updateProject(oldTitle, title, client_id, period, Double.parseDouble(rate), manager, desc);
                    projects pj = daopj.getP(title);
                    String sDate = format(pj.getPeriod().split(" ")[0]);
                    String eDate = format(pj.getPeriod().split(" ")[2]);
                    List<task> list0 = daot.listProjectTask(0, title);
                    List<task> list1 = daot.listProjectTask(1, title);
                    List<task> list2 = daot.listProjectTask(2, title);
                    List<task> list3 = daot.listProjectTask(3, title);
                    profile lead = daoPf.getByID(acc.getProfile_id());
                    List<profile> listPf = daoPf.listAllStaff(acc.getProfile_id());
                    for (profile p : listPf) {
                        p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                    }
                    List<clients> listC = daoc.listAllClients();
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
