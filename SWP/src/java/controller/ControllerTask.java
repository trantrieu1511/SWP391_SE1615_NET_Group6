/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Profile;
import entity.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOProfile;
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
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProfile daoProfile = new DAOProfile();
                DAOTask daoTask = new DAOTask();
                String service = request.getParameter("do");

                if (service.equals("view")) {
                    String title = request.getParameter("title");
                    List<Task> list0 = new ArrayList<>();
                    List<Task> list1 = new ArrayList<>();
                    List<Task> list2 = new ArrayList<>();
                    List<Task> list3 = new ArrayList<>();
                    List<Profile> listPf = null;
                    if (acc.isIsManager()) {
                        listPf = daoProfile.listAllStaff(acc.getProfile_id());
                        list0 = daoTask.listProjectTask(0, title);
                        list1 = daoTask.listProjectTask(1, title);
                        list2 = daoTask.listProjectTask(2, title);
                        list3 = daoTask.listProjectTask(3, title);
                    } else {
                        listPf = daoProfile.listAllStaff(daoProfile.getByID(acc.getProfile_id()).getReportto());
                        list0 = daoTask.listTaskAssignedTo(acc.getProfile_id(), 0);
                        list1 = daoTask.listTaskAssignedTo(acc.getProfile_id(), 1);
                        list2 = daoTask.listTaskAssignedTo(acc.getProfile_id(), 2);
                        list3 = daoTask.listTaskAssignedTo(acc.getProfile_id(), 3);
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
                    daoTask.addTask(name, priority, deadline, 0, assigned, project);

                    List<Task> list0 = daoTask.listProjectTask(0, project);
                    List<Task> list1 = daoTask.listProjectTask(1, project);
                    List<Task> list2 = daoTask.listProjectTask(2, project);
                    List<Task> list3 = daoTask.listProjectTask(3, project);
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
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
                    int id = Integer.parseInt(request.getParameter("id"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    daoTask.updateStatus(status, id);
                    String project = daoTask.getTaskById(id).getProject();

                    List<Task> list0 = daoTask.listProjectTask(0, project);
                    List<Task> list1 = daoTask.listProjectTask(1, project);
                    List<Task> list2 = daoTask.listProjectTask(2, project);
                    List<Task> list3 = daoTask.listProjectTask(3, project);
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
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

                if (service.equals("editTask")) {
                    String project = request.getParameter("project");
                    int id = Integer.parseInt(request.getParameter("idTask")); 
                    String name = request.getParameter("nameEdit");
                    int priority = Integer.parseInt(request.getParameter("priorityEdit"));
                    String deadline = request.getParameter("deadlineEdit");
                    String assigned = request.getParameter("assignedEdit");
                    daoTask.editTask(id, name, priority, deadline, assigned);
                    
                    List<Task> list0 = daoTask.listProjectTask(0, project);
                    List<Task> list1 = daoTask.listProjectTask(1, project);
                    List<Task> list2 = daoTask.listProjectTask(2, project);
                    List<Task> list3 = daoTask.listProjectTask(3, project);
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    String alert = "New task information saved!!";

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
                
                if (service.equals("deleteTask")) {
                    String id = request.getParameter("id");
                    String project = daoTask.getTaskById(Integer.parseInt(id)).getProject();
                    boolean del = daoTask.deleteTask(Integer.parseInt(id));
                    String alert = "";
                    if (del) {
                       alert = "Task deleted from database!"; 
                    } else {
                        alert = "Delete fail";
                    }
                    
                    List<Task> list0 = daoTask.listProjectTask(0, project);
                    List<Task> list1 = daoTask.listProjectTask(1, project);
                    List<Task> list2 = daoTask.listProjectTask(2, project);
                    List<Task> list3 = daoTask.listProjectTask(3, project);
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());

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
