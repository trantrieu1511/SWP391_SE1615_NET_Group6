/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.profile;
import entity.projects;
import entity.shift;
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
import model.DAOShift;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerSchedule", urlPatterns = {"/schedule"})
public class ControllerSchedule extends HttpServlet {

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
                DAOShift daos = new DAOShift();
                List<projects> list = null;
                if (acc.isIsManager()) {
                    list = daopj.getProject(acc.getProfile_id());
                } else {
                    list = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", list);
                String service = request.getParameter("do");

                if (service.equals("list")) {
                    RequestDispatcher dispath = request.getRequestDispatcher("schedule.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("shift")) {
                    List<shift> listS = daos.listShift();
                    List<profile> listPf = daoPf.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", "");
                    RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("addShift")) {
                    String name = request.getParameter("name");
                    String start = request.getParameter("start");
                    String end = request.getParameter("end");
                    daos.add(name, start, end);
                    List<shift> listS = daos.listShift();
                    request.setAttribute("list", listS);
                    request.setAttribute("alert", "New shift saved!");
                    RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("editShift")) {
                    String name = request.getParameter("name");
                    String start = request.getParameter("start");
                    String end = request.getParameter("end");
                    String oldName = request.getParameter("oldName");
                    daos.edit(name, start, end, oldName);
                    List<shift> listS = daos.listShift();
                    request.setAttribute("list", listS);
                    request.setAttribute("alert", "All changes saved!");
                    RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("deleteShift")) {
                    String name = request.getParameter("name");
                    boolean del = daos.delete(name);
                    if (del == true) {
                        List<shift> listS = daos.listShift();
                        request.setAttribute("list", listS);
                        request.setAttribute("alert", "Shift deleted from database!");
                        RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                        dispath.forward(request, response);
                    } else {
                        List<shift> listS = daos.listShift();
                        request.setAttribute("list", listS);
                        request.setAttribute("alert", "Cannot delete shift in active!");
                        RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                        dispath.forward(request, response);
                    }
                }
                
                if (service.equals("assignShift")) {
                    
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
