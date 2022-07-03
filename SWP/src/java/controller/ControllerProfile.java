/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Experience;
import entity.FamilyInfo;
import entity.Profile;
import entity.ProfileDetail;
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

            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("getmyProfile")) {
                    Object editPf = request.getParameter("editPf");
                    Object editPs = request.getParameter("editPs");
                    Object addExp = request.getParameter("addExp");
                    Object editExp = request.getParameter("editExp");
                    Object deleteExp = request.getParameter("deleteExp");
                    Object addF = request.getParameter("addF");
                    Object editF = request.getParameter("editF");
                    Object deleteF = request.getParameter("deleteF");
                    if (editPf != null) {
                        String alert = "profile information edited successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (editPs != null) {
                        String alert = "personal information edited successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (addExp != null) {
                        String alert = "add new experience successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (editExp != null) {
                        String alert = "edit experience successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (deleteExp != null) {
                        String alert = "delete experience successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (addF != null) {
                        String alert = "add new familyInfo successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (editF != null) {
                        String alert = "edit familyInfo successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (deleteF != null) {
                        String alert = "delete familyInfo successfully!";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else {
                        String alert = "";
                        Profile profile = daoPf.getByID(acc.getProfile_id());
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                        List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                        Account account = daoAcc.getAccount(acc.getProfile_id());
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    }
                }
                if (service.equals("getothersProfile")) {
                    Object editPf = request.getParameter("editPf");
                    Object editPs = request.getParameter("editPs");
                    Object addExp = request.getParameter("addExp");
                    Object editExp = request.getParameter("editExp");
                    Object deleteExp = request.getParameter("deleteExp");
                    Object addF = request.getParameter("addF");
                    Object editF = request.getParameter("editF");
                    Object deleteF = request.getParameter("deleteF");
                    if (editPf != null) {
                        String alert = "profile information edited successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (editPs != null) {
                        String alert = "personal information edited successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (addExp != null) {
                        String alert = "add new experience successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (editExp != null) {
                        String alert = "edit experience successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (deleteExp != null) {
                        String alert = "delete experience successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (addF != null) {
                        String alert = "add new familyInfo successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (editF != null) {
                        String alert = "edit familyInfo successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else if (deleteF != null) {
                        String alert = "delete familyInfo successfully!";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    } else {
                        String alert = "";
                        String profile_id = request.getParameter("profile_id");
                        Profile profile = daoPf.getByID(profile_id);
                        List<ProfileDetail> listPd = daoPd.getIndividualProfileDetail(profile_id);
                        List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                        List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                        Account account = daoAcc.getAccount(profile_id);
                        profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                        profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", profile);
                        request.setAttribute("listpd", listPd);
                        request.setAttribute("listf", listF);
                        request.setAttribute("listexp", listExp);
                        request.setAttribute("acc", account);

                        RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                        dispatch.forward(request, response);
                    }

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
