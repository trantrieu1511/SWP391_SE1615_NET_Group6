/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
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
                request.setAttribute("list", listS);
                RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                dispath.forward(request, response);
            }
            
            if (service.equals("addShift")) {
                String name = request.getParameter("name");
                String start = request.getParameter("start");
                String end = request.getParameter("end");
                daos.add(name, start, end);
                RequestDispatcher dispath = request.getRequestDispatcher("schedule?do=shift");
                dispath.forward(request, response);
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
