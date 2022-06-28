/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.experience;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOExperience;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerExperience", urlPatterns = {"/experience"})
public class ControllerExperience extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("do");
            DAOExperience daoExp = new DAOExperience();
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("editExperience")) {
                    String profile_id = request.getParameter("profile_id");
                    String role = request.getParameter("role");
                    String cur_role = request.getParameter("cur_role");
                    String start_date = request.getParameter("start_date");
                    String end_date = request.getParameter("end_date");

//                out.print(profile_id);
//                out.print("<br>");
//                out.print(role);
//                out.print("<br>");
//                out.print(start_date);
//                out.print("<br>");
//                out.print(end_date);
//                out.print("<br>");
//                out.print(cur_role);
                    boolean statusEdit = daoExp.editExperience(
                            new experience(profile_id, role, start_date, end_date),
                            cur_role);
                    if (statusEdit) {
                        System.out.println("Successfully edited experience of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile&editExp=true");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id + "&editExp=true");
                        }
                    } else {
                        System.out.println("Fail to edit experience of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                        }
                    }

                }
                if (service.equals("addExperience")) {
                    String profile_id = request.getParameter("profile_id");
                    String role = request.getParameter("role");
                    String start_date = request.getParameter("start_date");
                    String end_date = request.getParameter("end_date");

                    boolean statusAdd = daoExp.addExperience(
                            new experience(profile_id, role, start_date, end_date));
                    if (statusAdd) {
                        System.out.println("Successfully added new experience of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile&addExp=true");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id + "&addExp=true");
                        }
                    } else {
                        System.out.println("Fail to add new experience of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                        }
                    }

                }
                if (service.equals("deleteExperience")) {
                    String profile_id = request.getParameter("profile_id");
                    String role = request.getParameter("role");

                    boolean statusDelete = daoExp.deleteExperience(profile_id, role);
                    if (statusDelete) {
                        System.out.println("Successfully deleted experience of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile&deleteExp=true");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id + "&deleteExp=true");
                        }
                    } else {
                        System.out.println("Fail to delete experience of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                        }
                    }

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
