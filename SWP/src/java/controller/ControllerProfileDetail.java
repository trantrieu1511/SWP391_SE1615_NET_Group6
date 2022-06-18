/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.profileDetail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            String service = request.getParameter("do");

            DAOProfileDetail daoPd = new DAOProfileDetail();
            DAOFamilyInfo daoF = new DAOFamilyInfo();
            DAOExperience daoExp = new DAOExperience();

            if (service.equals("editProfileInfo")) {
                String profile_id = request.getParameter("profile_id");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");
                String country = request.getParameter("country");
                
                out.print(profile_id);
                out.print("<br>");
                out.print(dob);
                out.print("<br>");
                out.print(gender);
                out.print("<br>");
                out.print(address);
                out.print("<br>");
                
//                profileDetail pd = new profileDetail();
            }
            if (service.equals("editPersonalInfo")) {
                
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
