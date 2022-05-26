/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.attendance;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOAttendance;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerAttendance", urlPatterns = {"/attendance"})
public class ControllerAttendance extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String time = request.getParameter("time");
            String[] info = time.split(" ");
            String button = "in";
            if (info[2].equals("in")) {
                button = "out";
            }

            DAOAttendance dao = new DAOAttendance();
            String date = "";
            String time_in = "";
            String time_out = "";
            String production_time = "";
            String employee_id = "";
            if (time.contains("in")) {
                date = info[0];
                time_in = info[1];
                dao.add(date, time_in, time_out, production_time, employee_id);
                attendance temp = dao.getLastest();
                request.setAttribute("button", button);
                request.setAttribute("att", temp);
                RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                dispath.forward(request, response);
            } else if (time.contains("out")) {
                time_out = info[1];
                attendance temp = dao.getLastest();
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
                dao.update(temp.getId(), time_out, production_time);
                attendance list = dao.getLastest();
                request.setAttribute("button", button);
                request.setAttribute("list_attendance", list);
                RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                dispath.forward(request, response);
            }
//            response.sendRedirect("attendance.jsp");
//           
//            
//            RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
//            dispath.forward(request, response);
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerAttendance</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerAttendance at " + info[0] + "</h1>");
//            out.println("<h1>Servlet ControllerAttendance at " + info[1] + "</h1>");
//            out.println("<h1>Servlet ControllerAttendance at " + info[2] + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
