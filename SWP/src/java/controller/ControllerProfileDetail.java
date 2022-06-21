/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.profileDetail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOExperience;
import model.DAOFamilyInfo;
import model.DAOProfileDetail;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerProfileDetail", urlPatterns = {"/profileDetail"})
public class ControllerProfileDetail extends HttpServlet {

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
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");

            String service = request.getParameter("do");

            DAOProfileDetail daoPd = new DAOProfileDetail();
            DAOFamilyInfo daoF = new DAOFamilyInfo();
            DAOExperience daoExp = new DAOExperience();

            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("editProfileInfo")) {
                    String profile_id = request.getParameter("profile_id");
                    String dob = request.getParameter("dob");
                    boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                    String address = request.getParameter("address").trim();
                    if (address.equals("")) {
                        if (acc.getProfile_id().equals(profile_id)) {
                            response.sendRedirect("profile?do=getmyProfile");
                        } else {
                            response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                        }
                        return;
                    }

//                out.print(profile_id);
//                out.print("<br>");
//                out.print(dob);
//                out.print("<br>");
//                out.print(gender);
//                out.print("<br>");
//                out.print(address);
//                out.print("<br>");
                    boolean statusPfi = daoPd.editProfileInfo(
                            new profileDetail(profile_id, dob, address, gender));
                    if (statusPfi) {
                        System.out.println("Successfully edited profileInfo of profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to edit profileInfo of profile_id = " + profile_id);
                    }

                    if (acc.getProfile_id().equals(profile_id)) {
                        response.sendRedirect("profile?do=getmyProfile");
                    } else {
                        response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                    }
                }
                if (service.equals("editPersonalInfo")) {
                    String profile_id = request.getParameter("profile_id");
                    String country = request.getParameter("country").trim();
                    String religion = request.getParameter("religion").trim();
                    boolean isMarried = Boolean.parseBoolean(request.getParameter("isMarried"));
                    int children = Integer.parseInt(request.getParameter("children").trim());
                    String bank_name = request.getParameter("bank_name").trim();
                    String bank_number = request.getParameter("bank_number").trim();
//                out.print(profile_id);
//                out.print("<br>");
//                out.print(country);
//                out.print("<br>");
//                out.print(religion);
//                out.print("<br>");
//                out.print(isMarried);
//                out.print("<br>");
//                out.print(children);
//                out.print("<br>");
//                out.print(bank_name);
//                out.print("<br>");
//                out.print(bank_number);
                    boolean statusPsInfo = daoPd.editPersonalInfo(
                            new profileDetail(profile_id, country, religion,
                                    isMarried, children, bank_name, bank_number));
                    if (statusPsInfo) {
                        System.out.println("Successfully edited personalInfo of profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to edit personalInfo of profile_id = " + profile_id);
                    }

                    if (acc.getProfile_id().equals(profile_id)) {
                        response.sendRedirect("profile?do=getmyProfile");
                    } else {
                        response.sendRedirect("profile?do=getothersProfile&profile_id=" + profile_id);
                    }
                }
            }

        } catch (Exception ex) {
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
