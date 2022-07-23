/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Jobs;
import entity.Profile;
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
import model.DAOJob;
import model.DAOProfile;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerJob", urlPatterns = {"/job"})
public class ControllerJob extends HttpServlet {

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
            if (service.equals("login")) {
                String username = request.getParameter("user");
                String password = request.getParameter("pass");
                DAOAccount dao = new DAOAccount();
                Account a = dao.login(username, password);
                if (a == null) {
                    request.setAttribute("mess", "Wrong username or password");
                    RequestDispatcher dispath = request.getRequestDispatcher("login.jsp");
                    dispath.forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", a);
                    response.sendRedirect("home");
                }
            }
            
            if (service.equals("list")) {
                DAOJob j = new DAOJob();
                List<Jobs> listJ = j.listAllJob();
                String alert = "";

                request.setAttribute("listJ", listJ);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("job-list.jsp").forward(request, response);
            }
            
            if (service.equals("add")){
                int id = Integer.getInteger(request.getParameter("id"));
                String title = request.getParameter("title");
                double min = Double.parseDouble(request.getParameter("min"));
                double max = Double.parseDouble(request.getParameter("max"));
                DAOJob j = new DAOJob();
                
                if(j.addJob(id, title, min, max)){
                    System.out.println("Add successfully job: " + title);
                }else{
                    System.out.println("Add fail job: " + title);
                }
                
                request.getRequestDispatcher("job?do=list").forward(request, response);
            }
            
            if (service.equals("edit")){
                int id = Integer.getInteger(request.getParameter("eid"));
                String title = request.getParameter("etitle");
                double min = Double.parseDouble(request.getParameter("emin"));
                double max = Double.parseDouble(request.getParameter("emax"));
                DAOJob j = new DAOJob();
                
                if(j.editJob(id, title, min, max)){
                    System.out.println("Save successfully job_id: " + id);
                }else{
                    System.out.println("Save fail job_id: " + id);
                }
                
                request.getRequestDispatcher("job?do=list").forward(request, response);
            }
            
            if (service.equals("delete")){
                
            }
        }catch(Exception ex) {
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