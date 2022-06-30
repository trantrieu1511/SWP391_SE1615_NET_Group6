/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Profile;
import entity.Projects;
import entity.Schedule;
import entity.Shift;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOProfile;
import model.DAOProject;
import model.DAOSchedule;
import model.DAOShift;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerSchedule", urlPatterns = {"/schedule"})
public class ControllerSchedule extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                DAOProject daoProject = new DAOProject();
                DAOProfile daoProfile = new DAOProfile();
                DAOShift daoShift = new DAOShift();
                DAOSchedule daoSchedule = new DAOSchedule();
                List<Projects> list = null;
                if (acc.isIsManager()) {
                    list = daoProject.getProject(acc.getProfile_id());
                } else {
                    list = daoProject.getProject(daoProfile.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", list);
                String service = request.getParameter("do");

                if (service.equals("list")) {
                    String action = request.getParameter("action");
                    String alert = "";
                    
                    if (action != null && action.equals("edit")) {
                        alert = "All changes saved!";
                    } else if (action != null && action.equals("delete")) {
                        alert = "Schedule has been deleted from database!";
                    } else if (action == null) {
                        alert = "";
                    }
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    List<Schedule> listSch = daoSchedule.listAllScheduleOfStaff();
                    List<String[]> listShiftArray = new ArrayList<String[]>();
                    for (Schedule sch : listSch) {
                        if (sch.getName() != " ") {
                            String[] temp = sch.getName().split(" ");
                            listShiftArray.add(temp);
                        } else {
                            String[] temp = {" "};
                            listShiftArray.add(temp);
                        }
                    }
                    List<boolean[]> listBool = new ArrayList<boolean[]>();
                    for (String[] strTemp : listShiftArray) {
                        boolean[] temp = new boolean[listS.size()];
                        for (int i = 0; i < listS.size(); i++) {
                            for (int j = 0; j < strTemp.length; j++) {
                                if (listS.get(i).getName().equals(strTemp[j])) {
                                    temp[i] = true;
                                }
                            }
                        }
                        listBool.add(temp);
                    }
                    for (int i = 0; i < listPf.size(); i++) {
                        String temp = "";
                        for (int j = 0; j < listBool.get(i).length; j++) {
                            temp += listBool.get(i)[j] + " ";
                        }
                        // Department_name used as shiftStatus(true/false)
                        listPf.get(i).setDepartment_name(temp);
                    }
                    request.setAttribute("listS", listS);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("schedule.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("editSchedule")) {
                    String Profile_id = request.getParameter("profile");
                    String[] shift = request.getParameterValues("shift");
                    String shiftStatus = "";
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    for (int i = 0; i < shift.length; i++) {
                        shiftStatus += shift[i] + " ";
                    }
                    daoSchedule.updateSchedule(Profile_id, shiftStatus);
                    request.setAttribute("alert", "Changes saved!");
                    RequestDispatcher dispath = request.getRequestDispatcher("schedule?do=list&&action=edit");
                    dispath.forward(request, response);
                }

                if (service.equals("deleteSchedule")) {
                    String Profile_id = request.getParameter("profile");
                    daoSchedule.updateSchedule(Profile_id, " ");
                    request.setAttribute("alert", "Schedule deleted!");
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    RequestDispatcher dispath = request.getRequestDispatcher("schedule?do=list&&action=delete");
                    dispath.forward(request, response);
                }

                if (service.equals("search")) {
                    String name = request.getParameter("name");
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.searchStaff3(name, acc.getProfile_id());
                    List<Schedule> listSch = daoSchedule.searchSchedule(name);
                    List<String[]> listShiftArray = new ArrayList<String[]>();
                    for (Schedule sch : listSch) {
                        if (sch.getName() != " ") {
                            String[] temp = sch.getName().split(" ");
                            listShiftArray.add(temp);
                        } else {
                            String[] temp = {" "};
                            listShiftArray.add(temp);
                        }
                    }
                    List<boolean[]> listBool = new ArrayList<boolean[]>();
                    for (String[] strTemp : listShiftArray) {
                        boolean[] temp = new boolean[listS.size()];
                        for (int i = 0; i < listS.size(); i++) {
                            for (int j = 0; j < strTemp.length; j++) {
                                if (listS.get(i).getName().equals(strTemp[j])) {
                                    temp[i] = true;
                                }
                            }
                        }
                        listBool.add(temp);
                    }
                    for (int i = 0; i < listPf.size(); i++) {
                        String temp = "";
                        for (int j = 0; j < listBool.get(i).length; j++) {
                            temp += listBool.get(i)[j] + " ";
                        }
                        // Department_name used as shiftStatus(true/false)
                        listPf.get(i).setDepartment_name(temp);
                    }
                    request.setAttribute("listS", listS);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", "");
                    RequestDispatcher dispath = request.getRequestDispatcher("schedule.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("shift")) {
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", "");
                    RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("addShift")) {
                    String name = request.getParameter("name");
                    String start = request.getParameter("start");
                    String end = request.getParameter("end");
                    daoShift.add(name, start, end);
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", "New shift saved!");
                    RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("editShift")) {
                    String name = request.getParameter("name");
                    String start = request.getParameter("start");
                    String end = request.getParameter("end");
                    String oldName = request.getParameter("oldName");
                    daoShift.edit(name, start, end, oldName);
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    request.setAttribute("alert", "All changes saved!");
                    RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("deleteShift")) {
                    String name = request.getParameter("shift");
                    boolean del = daoShift.delete(name);
                    if (del == true) {
                        List<Shift> listS = daoShift.listShift();
                        List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                        request.setAttribute("list", listS);
                        request.setAttribute("listPf", listPf);
                        request.setAttribute("alert", "Shift deleted from database!");
                        RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                        dispath.forward(request, response);
                    } else {
                        List<Shift> listS = daoShift.listShift();
                        List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                        request.setAttribute("list", listS);
                        request.setAttribute("listPf", listPf);
                        request.setAttribute("alert", "Cannot delete shift in active!");
                        RequestDispatcher dispath = request.getRequestDispatcher("shift-list.jsp");
                        dispath.forward(request, response);
                    }
                }

                if (service.equals("assignShift")) {
                    String Profile_id = request.getParameter("profile");
                    String[] shift = request.getParameterValues("shift");
                    String shiftStatus = "";
                    List<Shift> listS = daoShift.listShift();
                    List<Profile> listPf = daoProfile.listAllStaff(acc.getProfile_id());
                    request.setAttribute("list", listS);
                    request.setAttribute("listPf", listPf);
                    for (int i = 0; i < shift.length; i++) {
                        shiftStatus += shift[i] + " ";
                    }
                    daoSchedule.updateSchedule(Profile_id, shiftStatus);
                    RequestDispatcher dispath = request.getRequestDispatcher("schedule?do=list");
                    dispath.forward(request, response);
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
