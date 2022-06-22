/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.profile;
import entity.projects;
import entity.task;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOProfile;
import model.DAOProject;
import model.DAOTask;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerTask", urlPatterns = {"/task"})
public class ControllerTask extends HttpServlet {

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
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProject daopj = new DAOProject();
                DAOProfile daoPf = new DAOProfile();
                DAOTask daot = new DAOTask();
                String service = request.getParameter("do");
                
                if (service.equals("view")) {
                    String title = request.getParameter("title");
                    List<task> list0 = daot.listProjectTask(0, title);
                    List<task> list1 = daot.listProjectTask(1, title);
                    List<task> list2 = daot.listProjectTask(2, title);
                    List<task> list3 = daot.listProjectTask(3, title);
                    List<profile> listPf = null;
                    if (acc.isIsManager()) {
                        listPf = daoPf.listAllStaff(acc.getProfile_id());
                    } else {
                        listPf = daoPf.listAllStaff(daoPf.getByID(acc.getProfile_id()).getReportto());
                    }                   
                    request.setAttribute("list0", list0);
                    request.setAttribute("list1", list1);
                    request.setAttribute("list2", list2);
                    request.setAttribute("list3", list3);
                    request.setAttribute("title", title);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", "");
                    RequestDispatcher dispath = request.getRequestDispatcher("task-board.jsp");
                    dispath.forward(request, response);
                }
                
                if (service.equals("newTask")) {
                    String project = request.getParameter("project");
                    String name = request.getParameter("name");
                    int priority = Integer.parseInt(request.getParameter("priority"));
                    String deadline = request.getParameter("deadline");
                    String assigned = request.getParameter("assigned");                  
                    daot.add(name, priority, deadline, 0, assigned, project);
                                
                    List<task> list0 = daot.listProjectTask(0, project);
                    List<task> list1 = daot.listProjectTask(1, project);
                    List<task> list2 = daot.listProjectTask(2, project);
                    List<task> list3 = daot.listProjectTask(3, project);
                    List<profile> listPf = daoPf.listAllStaff(acc.getProfile_id());
                    String alert = "New task saved!!";
                                      
                    request.setAttribute("list0", list0);
                    request.setAttribute("list1", list1);
                    request.setAttribute("list2", list2);
                    request.setAttribute("list3", list3);
                    request.setAttribute("title", project);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("task-board.jsp");
                    dispath.forward(request, response);  
                }
                
                if (service.equals("updateStatus")) {
                    String name = request.getParameter("name");
                    int status = Integer.parseInt(request.getParameter("status"));
                    daot.updateStatus(status, name);
                    String project = daot.getByName(name).getProject();
                    
                    List<task> list0 = daot.listProjectTask(0, project);
                    List<task> list1 = daot.listProjectTask(1, project);
                    List<task> list2 = daot.listProjectTask(2, project);
                    List<task> list3 = daot.listProjectTask(3, project);
                    List<profile> listPf = daoPf.listAllStaff(acc.getProfile_id());
                    String alert = "Task status updated!";
                                      
                    request.setAttribute("list0", list0);
                    request.setAttribute("list1", list1);
                    request.setAttribute("list2", list2);
                    request.setAttribute("list3", list3);
                    request.setAttribute("title", project);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("task-board.jsp");
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
