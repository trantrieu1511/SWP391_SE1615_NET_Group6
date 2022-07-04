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
                    String alert = "";
                    if (editPf != null) {
                        alert = "profile information edited successfully!";
                    } else if (editPs != null) {
                        alert = "personal information edited successfully!";
                    } else if (addExp != null) {
                        alert = "add new experience successfully!";
                    } else if (editExp != null) {
                        alert = "edit experience successfully!";
                    } else if (deleteExp != null) {
                        alert = "delete experience successfully!";
                    } else if (addF != null) {
                        alert = "add new familyInfo successfully!";
                    } else if (editF != null) {
                        alert = "edit familyInfo successfully!";
                    } else if (deleteF != null) {
                        alert = "delete familyInfo successfully!";

                    }
                    ProfileDetail pd = daoPd.getIndividualProfileDetail(acc.getProfile_id());
                    Profile profile = daoPf.getByID(acc.getProfile_id());

                    List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(acc.getProfile_id());
                    List<Experience> listExp = daoExp.listIndividualExperience(acc.getProfile_id());
                    Account account = daoAcc.getAccount(acc.getProfile_id());
                    profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                    profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                    request.setAttribute("alert", alert);

                    request.setAttribute("pd", pd);
                    request.setAttribute("p", profile);

                    request.setAttribute("listf", listF);
                    request.setAttribute("listexp", listExp);
                    request.setAttribute("acc", account);

                    RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                    dispatch.forward(request, response);
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
                    String alert = "";
                    if (editPf != null) {
                        alert = "profile information edited successfully!";
                    } else if (editPs != null) {
                        alert = "personal information edited successfully!";
                    } else if (addExp != null) {
                        alert = "add new experience successfully!";
                    } else if (editExp != null) {
                        alert = "edit experience successfully!";
                    } else if (deleteExp != null) {
                        alert = "delete experience successfully!";
                    } else if (addF != null) {
                        alert = "add new familyInfo successfully!";
                    } else if (editF != null) {
                        alert = "edit familyInfo successfully!";
                    } else if (deleteF != null) {
                        alert = "delete familyInfo successfully!";
                    }
                    String profile_id = request.getParameter("profile_id");

                    ProfileDetail pd = daoPd.getIndividualProfileDetail(profile_id);
                    Profile profile = daoPf.getByID(profile_id);

                    List<FamilyInfo> listF = daoF.getIndividualFamilyInfo(profile_id);
                    List<Experience> listExp = daoExp.listIndividualExperience(profile_id);
                    Account account = daoAcc.getAccount(profile_id);
                    profile.setJob_title(daoJ.getJobById(profile.getJob_id()).getTitle());
                    profile.setDepartment_name(daoDp.getDepartmentByID(profile.getDepartment_id()).getName());
                    request.setAttribute("alert", alert);

                    request.setAttribute("pd", pd);
                    request.setAttribute("p", profile);

                    request.setAttribute("listf", listF);
                    request.setAttribute("listexp", listExp);
                    request.setAttribute("acc", account);

                    RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
                    dispatch.forward(request, response);
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
