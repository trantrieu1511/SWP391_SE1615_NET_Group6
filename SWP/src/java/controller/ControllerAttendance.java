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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            DAOAttendance dao = new DAOAttendance();
            String date = info[1];
            String time_in = info[2];
            String time_out = "";
            String production_time = "";
            String employee_id = info[0];
            if (time.contains("in")) {
                time_in = info[2];
                dao.add(date, time_in, time_out, production_time, employee_id);
                attendance temp = dao.getLastest();
                request.setAttribute("att", temp);
                RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                dispath.forward(request, response);
            } else if (time.contains("out")) {
                time_out = info[2];
                attendance temp = dao.getLastest();
                SimpleDateFormat fm = new SimpleDateFormat("hh/mm");
                try {
                    Date t_out = fm.parse(time_out);
                    Date t_in = fm.parse(temp.getTime_in());
                    production_time = fm.format(t_out.getTime() - t_in.getTime());
                    dao.update(temp.getId(), time_out, production_time);
                    attendance list = dao.getLastest();
                    request.setAttribute("list_attendance", list);
                    RequestDispatcher dispath = request.getRequestDispatcher("attendance.jsp");
                    dispath.forward(request, response);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerAttendance</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerAttendance at " + date[0] + " st" + date[1] + " st" + date[2] + "</h1>");
//            out.println("<h1>Servlet ControllerAttendance at " + time + "</h1>");
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
