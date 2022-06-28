/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.FamilyInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOFamilyInfo;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerFamilyInfo", urlPatterns = {"/familyInfo"})
public class ControllerFamilyInfo extends HttpServlet {

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
            DAOFamilyInfo daoF = new DAOFamilyInfo();
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("editFamilyInfo")) {
                    String profile_id = request.getParameter("profile_id");
                    String name = request.getParameter("name");
                    String cur_name = request.getParameter("cur_name");
                    String relationship = request.getParameter("relationship");
                    String dob = request.getParameter("dob");
                    String phone = request.getParameter("phone");

//                out.print(profile_id);
//                out.print("<br>");
//                out.print(name);
//                out.print("<br>");
//                out.print(relationship);
//                out.print("<br>");
//                out.print(dob);
//                out.print("<br>");
//                out.print(phone);
                    boolean statusEdit = daoF.editFamilyInfo(new FamilyInfo(profile_id, name, relationship, dob, phone),
                            cur_name);
                    if (statusEdit) {
                        System.out.println("Successfully edited familyInfo (name = " + name + ") of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile&editF=true");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id + "&editF=true");
                        }
                    } else {
                        System.out.println("Fail to edit familyInfo (name = " + name + ") of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                        }
                    }

                }
                if (service.equals("addFamilyInfo")) {
                    String profile_id = request.getParameter("profile_id");
                    String name = request.getParameter("name");
                    String relationship = request.getParameter("relationship");
                    String dob = request.getParameter("dob");
                    String phone = request.getParameter("phone");

                    boolean statusAdd = daoF.addFamilyInfo(new FamilyInfo(profile_id, name, relationship, dob, phone));
                    if (statusAdd) {
                        System.out.println("Successfully added new familyInfo (name = " + name + ") of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile&addF=true");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id + "&addF=true");
                        }
                    } else {
                        System.out.println("Fail to add new familyInfo (name = " + name + ") of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                        }
                    }

                }
                if (service.equals("deleteFamilyInfo")) {
                    String name = request.getParameter("name");
                    String profile_id = request.getParameter("profile_id");
                    boolean statusDelete = daoF.deleteFamilyInfo(profile_id, name);
                    if (statusDelete) {
                        System.out.println("Successfully deleted familyInfo (name = " + name + ") of profile_id = " + profile_id);
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile&deleteF=true");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id + "&deleteF=true");
                        }
                    } else {
                        System.out.println("Fail to delete familyInfo (name = " + name + ") of profile_id = " + profile_id);
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
