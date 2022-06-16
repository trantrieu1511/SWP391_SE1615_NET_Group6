/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.experience;
import entity.familyInfo;
import entity.profile;
import entity.profileDetail;
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
import model.DAOAccount;
import model.DAODepartment;
import model.DAOExperience;
import model.DAOFamilyInfo;
import model.DAOJob;
import model.DAOProfile;
import model.DAOProfileDetail;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerProfile", urlPatterns = {"/profile"})
public class ControllerProfile extends HttpServlet {

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
            
            DAOProfile daop = new DAOProfile();
            DAOProfileDetail daopd = new DAOProfileDetail();
            DAOFamilyInfo daof = new DAOFamilyInfo();
            DAOExperience daoexp = new DAOExperience();
            DAOJob daoj = new DAOJob();
            DAODepartment daoDp = new DAODepartment();
            DAOAccount daoacc = new DAOAccount();
            
            HttpSession session = request.getSession();
            
            account acc = (account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("getmyProfile")) {
                    List<profile> listp = daop.getProfile(acc.getProfile_id());
                    List<profileDetail> listpd = daopd.getIndividualProfileDetail(acc.getProfile_id());
                    List<familyInfo> listf = daof.getIndividualFamilyInfo(acc.getProfile_id());
                    List<experience> listexp = daoexp.listIndividualExperience(acc.getProfile_id());
                    List<account> listacc = daoacc.getAccountwithList(acc.getProfile_id());
                    for (profile p : listp) {
                        p.setJob_title(daoj.getJobById(p.getJob_id()).getTitle());
                        p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                    }
                    request.setAttribute("listp", listp);
                    request.setAttribute("listpd", listpd);
                    request.setAttribute("listf", listf);
                    request.setAttribute("listexp", listexp);
                    request.setAttribute("listacc", listacc);

                    RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                    dispatch.forward(request, response);
                }
                if(service.equals("getothersProfile")){
                    String profile_id = request.getParameter("profile_id");
                    List<profile> listp = daop.getProfile(profile_id);
                    List<profileDetail> listpd = daopd.getIndividualProfileDetail(profile_id);
                    List<familyInfo> listf = daof.getIndividualFamilyInfo(profile_id);
                    List<experience> listexp = daoexp.listIndividualExperience(profile_id);
                    List<account> listacc = daoacc.getAccountwithList(profile_id);
                    for (profile p : listp) {
                        p.setJob_title(daoj.getJobById(p.getJob_id()).getTitle());
                        p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                    }
                    request.setAttribute("listp", listp);
                    request.setAttribute("listpd", listpd);
                    request.setAttribute("listf", listf);
                    request.setAttribute("listexp", listexp);
                    request.setAttribute("listacc", listacc);

                    RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                    dispatch.forward(request, response);
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
