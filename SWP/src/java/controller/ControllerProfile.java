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
        try {
            String service = request.getParameter("do");

            DAOProfile daoPf = new DAOProfile();
            DAOProfileDetail daoPd = new DAOProfileDetail();
            DAOFamilyInfo daoF = new DAOFamilyInfo();
            DAOExperience daoExp = new DAOExperience();
            DAOJob daoJ = new DAOJob();
            DAODepartment daoDp = new DAODepartment();
            DAOAccount daoAcc = new DAOAccount();

            HttpSession session = request.getSession();

            account acc = (account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("getmyProfile")) {
                    List<profile> listPf = daoPf.getProfile(acc.getProfile_id());
                    List<profileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                    List<familyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                    List<experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                    List<account> listAcc = daoAcc.getAccountwithList(acc.getProfile_id());
                    for (profile p : listPf) {
                        p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                        p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                    }
                    request.setAttribute("listp", listPf);
                    request.setAttribute("listpd", listPd);
                    request.setAttribute("listf", listF);
                    request.setAttribute("listexp", listExp);
                    request.setAttribute("listacc", listAcc);

                    RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                    dispatch.forward(request, response);
                }
                if (service.equals("getothersProfile")) {
                    String profile_id = request.getParameter("profile_id");
                    List<profile> listPf = daoPf.getProfile(profile_id);
                    List<profileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                    List<familyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                    List<experience> listExp = daoExp.listIndividualExperience(profile_id);
                    List<account> listAcc = daoAcc.getAccountwithList(profile_id);
                    for (profile p : listPf) {
                        p.setJob_title(daoJ.getJobById(p.getJob_id()).getTitle());
                        p.setDepartment_name(daoDp.getDepartmentByID(p.getDepartment_id()).getName());
                    }
                    request.setAttribute("listp", listPf);
                    request.setAttribute("listpd", listPd);
                    request.setAttribute("listf", listF);
                    request.setAttribute("listexp", listExp);
                    request.setAttribute("listacc", listAcc);

                    RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                    dispatch.forward(request, response);
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
