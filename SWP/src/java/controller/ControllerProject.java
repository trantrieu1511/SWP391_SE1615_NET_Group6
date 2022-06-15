/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.clients;
import entity.projects;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOClients;
import model.DAOProfile;
import model.DAOProject;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerProject", urlPatterns = {"/project"})
public class ControllerProject extends HttpServlet {

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
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProject daopj = new DAOProject();
                DAOProfile daoPf = new DAOProfile();
                DAOClients daoc = new DAOClients();
                List<projects> list = null;
                if (acc.isIsManager()) {
                    list = daopj.getProject(acc.getProfile_id());
                } else {
                    list = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", list);
                String service = request.getParameter("do");

                if (service.equals("list")) {
                    List<projects> listPj = null;
                    if (acc.isIsManager()) {
                        listPj = daopj.getProject(acc.getProfile_id());
                    } else {
                        listPj = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                    }
                    List<clients> listC = daoc.listAllClients();
                    request.setAttribute("list", listPj);
                    request.setAttribute("listC", listC);
                    RequestDispatcher dispath = request.getRequestDispatcher("projects.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("create")) {
                    String title = request.getParameter("title");
                    String client_id = request.getParameter("client");
                    String start_date = request.getParameter("start_date");
                    String end_date = request.getParameter("end_date");
                    String rate = request.getParameter("rate");
                    String manager = request.getParameter("manager");
                    String desc = request.getParameter("description");
                    try {
                        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
                        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(end_date);
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");  
                        String sdate = dateFormat.format(start);
                        String edate = dateFormat.format(end);
                        daopj.addProject(title, client_id, sdate, edate, Double.parseDouble(rate), manager, desc);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    RequestDispatcher dispath = request.getRequestDispatcher("project?do=list");
                    dispath.forward(request, response);
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Servlet ControllerEmployee</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>" + title + client_id + start_date + end_date + manager + desc + "</h1>");
//                    out.println("</body>");
//                    out.println("</html>");
                }
                
                if (service.equals("delete")) {
                    String title = request.getParameter("title");
                    daopj.deleteProject(title);
                    RequestDispatcher dispath = request.getRequestDispatcher("project?do=list");
                    dispath.forward(request, response);
                }
                
                if (service.equals("edit")) {
                    String title = request.getParameter("title");
                    String client_id = request.getParameter("client");
                    String start_date = request.getParameter("start_date");
                    String end_date = request.getParameter("end_date");
                    String rate = request.getParameter("rate");
                    String manager = request.getParameter("manager");
                    String desc = request.getParameter("description");
                    try {
                        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
                        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(end_date);
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");  
                        String sdate = dateFormat.format(start);
                        String edate = dateFormat.format(end);
                        daopj.updateProject(title, client_id, sdate, edate, Double.parseDouble(rate), manager, desc);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    RequestDispatcher dispath = request.getRequestDispatcher("project?do=list");
                    dispath.forward(request, response);
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
