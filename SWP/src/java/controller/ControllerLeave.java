/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Leave;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOLeave;
import model.DAOLeaveType;
import model.DAOProfile;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerLeave", urlPatterns = {"/leave"})
public class ControllerLeave extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            DAOLeave daoLeave = new DAOLeave();
            DAOLeaveType daoLeaveType = new DAOLeaveType();
            DAOProfile daoPf = new DAOProfile();

            String service = request.getParameter("do");
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("checkLeave")) {
                    if (acc.isIsAdmin()) {
                        List<Leave> listLeave = daoLeave.listAllMyLeave(acc.getProfile_id());
                    }
                    if (acc.isIsManager()) {
                        
                    }
                    RequestDispatcher dispath = request.getRequestDispatcher("leaves.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("myLeave")) {
                    List<Leave> listLeave = daoLeave.listAllMyLeave(acc.getProfile_id());
                    if (acc.isIsManager()) {
                        for (Leave leave : listLeave) {
                            leave.setReportto_name("null");
                            leave.setLeave_name(daoLeaveType.getLeaveTypeByID(Integer.toString(leave.getLeave_type())).getName());
                        }
                    } else {
                        for (Leave leave : listLeave) {
                            leave.setReportto_name(daoPf.getByID(leave.getReportto()).getFirst_name() + " "
                                    + daoPf.getByID(leave.getReportto()).getLast_name());
                            leave.setLeave_name(daoLeaveType.getLeaveTypeByID(Integer.toString(leave.getLeave_type())).getName());
                        }
                    }
                    request.setAttribute("myLeaveList", listLeave);
                    RequestDispatcher dispath = request.getRequestDispatcher("leaves-employee.jsp");
                    dispath.forward(request, response);
                }
                if (service.equals("addLeave")) {
                    
                    response.sendRedirect("leave?do=myLeave");
                }
                if (service.equals("editLeave")) {

                    response.sendRedirect("leave?do=myLeave");
                }
                if (service.equals("deleteLeave")) {

                    response.sendRedirect("leave?do=myLeave");
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
