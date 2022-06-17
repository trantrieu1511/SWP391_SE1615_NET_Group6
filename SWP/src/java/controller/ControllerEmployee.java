/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.account;
import entity.attendance;
import entity.profile;
import entity.projects;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAttendance;
import model.DAOProfile;
import model.DAOProject;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerEmployee", urlPatterns = {"/employee"})
public class ControllerEmployee extends HttpServlet {

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
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat hf = new SimpleDateFormat("hh:mm");
            String service = request.getParameter("do");
            DAOAttendance dao = new DAOAttendance();
            DAOProject daopj = new DAOProject();
            DAOProfile daoPf = new DAOProfile();
            HttpSession session = request.getSession();
            account acc = (account) session.getAttribute("acc");

            String date = "";
            String time_in = "";
            String time_out = "";
            String production_time = "";
            String employee_id = "";
            String button = "in";
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                List<projects> listPj = null;
                if (acc.isIsManager()) {
                    listPj = daopj.getProject(acc.getProfile_id());
                } else {
                    listPj = daopj.getProject(daoPf.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", listPj);
                
                employee_id = acc.getProfile_id();;

                if(service.equals("dashboard")){
                    response.sendRedirect("employee-dashboard.jsp");
                }
                
                if (service.equals("attendance")) {
                    List<attendance> list = dao.listAllAttendanceofAnEmployee(employee_id);
                    attendance temp = dao.getLastest(employee_id);
                    if (temp != null) {
                        if (temp.getTime_out().equals("")) {
                            button = "out";
                        }
                    }
                    request.getSession(false);
                    request.setAttribute("list_attendance", list);
                    request.setAttribute("button", button);
                    RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("searchAttendance")) {
                    String date_search = request.getParameter("date");
                    List<attendance> list = dao.search(date_search, employee_id);
                    request.setAttribute("list", list);
                }

                if (service.equals("punchin")) {
                    date = df.format(new java.util.Date());
                    time_in = hf.format(new java.util.Date());
                    button = "out";

                    dao.add(date, time_in, time_out, production_time, employee_id);
                    attendance temp = dao.getLastest(acc.getProfile_id());

                    List<attendance> list = dao.listAllAttendanceofAnEmployee(employee_id);
                    request.setAttribute("list_attendance", list);
                    request.setAttribute("button", button);
                    request.setAttribute("att", temp);
                    RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("punchout")) {
                    time_out = hf.format(new java.util.Date());
                    attendance temp = dao.getLastest(employee_id);

                    int t_out_hr = Integer.parseInt(time_out.split(":")[0]);
                    int t_out_min = Integer.parseInt(time_out.split(":")[1]);
                    int t_in_hr = Integer.parseInt(temp.getTime_in().split(":")[0]);
                    int t_in_min = Integer.parseInt(temp.getTime_in().split(":")[1]);
                    int proc_hr = (Math.abs(t_in_hr - t_out_hr) * 60 + Math.abs(t_in_min - t_out_min)) / 60;
                    int proc_min = (Math.abs(t_in_hr - t_out_hr) * 60 + Math.abs(t_in_min - t_out_min)) % 60;

                    String proc_time_hr = "";
                    if (proc_hr < 10) {
                        proc_time_hr = "0" + Integer.toString(proc_hr);
                    } else {
                        proc_time_hr = Integer.toString(proc_hr);
                    }
                    String proc_time_min = "";
                    if (proc_min < 10) {
                        proc_time_min = "0" + Integer.toString(proc_min);
                    } else {
                        proc_time_hr = Integer.toString(proc_min);
                    }

                    production_time = proc_time_hr + ":" + proc_time_min;
                    dao.update(temp.getId(), time_out, production_time, employee_id);
                    List<attendance> list = dao.listAllAttendanceofAnEmployee(employee_id);
                    request.setAttribute("button", button);
                    request.setAttribute("list_attendance", list);
                    RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                    dispath.forward(request, response);
                }
                /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerEmployee</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerEmployee at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
