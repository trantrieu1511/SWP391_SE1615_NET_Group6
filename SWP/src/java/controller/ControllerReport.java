/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Attendance;
import entity.Departments;
import entity.FamilyInfo;
import entity.Profile;
import entity.ProfileDetail;
import entity.Projects;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAttendance;
import model.DAODepartment;
import model.DAOFamilyInfo;
import model.DAOJob;
import model.DAOProfile;
import model.DAOProfileDetail;
import model.DAOProject;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerReport", urlPatterns = {"/report"})
public class ControllerReport extends HttpServlet {

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
                DAOAttendance daoAttendance = new DAOAttendance();
                DAODepartment daoDepartment = new DAODepartment();
                DAOJob daoJob = new DAOJob();
                DAOProfileDetail daoPD =  new DAOProfileDetail();
                DAOFamilyInfo daoFam = new DAOFamilyInfo();
                List<Projects> list = null;
                if (acc.isIsManager()) {
                    list = daoProject.listProject(acc.getProfile_id());
                } else {
                    list = daoProject.listProject(daoProfile.getByID(acc.getProfile_id()).getReportto());
                }
                request.setAttribute("project", list);
                String service = request.getParameter("do");

                if (service.equals("daily")) {
                    List<Profile> listProfile = daoProfile.listAllStaff(acc.getProfile_id());
                    int totalEmployee = listProfile.size();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    List<Attendance> listAttendance = daoAttendance.todayAttendance(formatter.format(date));
                    int present = listAttendance.size();
                    int absent = totalEmployee - present;
                    List<String[]> listStr = new ArrayList<>();
                    listProfile.stream().map((p) -> {
                        String[] temp = new String[10];
                        temp[0] = p.getProfile_id();
                        temp[1] = p.getFirst_name() + " " + p.getLast_name();
                        temp[2] = formatter.format(date);
                        temp[3] = daoDepartment.getDepartmentByID(p.getDepartment_id()).getName();
                        String status;
                        if (listAttendance.contains(p.getProfile_id())) {
                            status = "Present";
                        } else {
                            status = "Absent";
                        }
                        temp[4] = status;
                        return temp;
                    }).forEachOrdered((temp) -> {
                        listStr.add(temp);
                    });
                    List<Departments> listDepartment = daoDepartment.listAllDepartment();
                    request.setAttribute("present", present);
                    request.setAttribute("absent", absent);
                    request.setAttribute("totalEmployee", totalEmployee);
                    request.setAttribute("list", listStr);
                    request.setAttribute("listDepartment", listDepartment);
                    request.setAttribute("filter", "no");
                    request.setAttribute("nameFilter", "Employee");
                    request.setAttribute("departmentFilter", "select a department");
                    RequestDispatcher dispath = request.getRequestDispatcher("daily-report.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("searchDailyReport")) {
                    String name = request.getParameter("name");
                    String department = request.getParameter("department");
                    List<Profile> listProfile = new ArrayList<>();
                    if (department != null) {
                        listProfile = daoProfile.searchStaff4(name, Integer.parseInt(department), acc.getProfile_id());
                    } else {
                        listProfile = daoProfile.searchStaff3(name, acc.getProfile_id());
                    }
                    int totalEmployee = listProfile.size();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    List<Attendance> listAttendance = daoAttendance.todayAttendance(formatter.format(date));
                    int present = listAttendance.size();
                    int absent = totalEmployee - present;
                    List<String[]> listStr = new ArrayList<>();
                    listProfile.stream().map((p) -> {
                        String[] temp = new String[10];
                        temp[0] = p.getProfile_id();
                        temp[1] = p.getFirst_name() + " " + p.getLast_name();
                        temp[2] = formatter.format(date);
                        temp[3] = daoDepartment.getDepartmentByID(p.getDepartment_id()).getName();
                        String status;
                        if (listAttendance.contains(p.getProfile_id())) {
                            status = "Present";
                        } else {
                            status = "Absent";
                        }
                        temp[4] = status;
                        return temp;
                    }).forEachOrdered((temp) -> {
                        listStr.add(temp);
                    });
                    List<Departments> listDepartment = daoDepartment.listAllDepartment();
                    request.setAttribute("present", present);
                    request.setAttribute("absent", absent);
                    request.setAttribute("totalEmployee", totalEmployee);
                    request.setAttribute("list", listStr);
                    request.setAttribute("listDepartment", listDepartment);
                    request.setAttribute("filter", "yes");
                    request.setAttribute("nameFilter", name);
                    if (department != null) {
                        request.setAttribute("departmentFilter", department);
                    } else {
                        request.setAttribute("departmentFilter", "select a department");
                    }
                    RequestDispatcher dispath = request.getRequestDispatcher("daily-report.jsp");
                    dispath.forward(request, response);
                }
                
                if (service.equals("employee")) {
                    List<Profile> listProfile = daoProfile.listAllStaff(acc.getProfile_id());
                    List<ProfileDetail> listPD = daoPD.listProfileDetail(acc.getProfile_id());
                    List<FamilyInfo> listFam = daoFam.listFamilyInfo(acc.getProfile_id());
                    List<String[]> empReport = new ArrayList<>();
                    for(int i = 0; i < listPD.size(); i++) {
                        String temp[] = new String[12];
                        temp[0] = listProfile.get(i).getFirst_name() + " " + listProfile.get(i).getLast_name();
                        temp[1] = listProfile.get(i).getEmail();
                        temp[2] = daoDepartment.getDepartmentByID(listProfile.get(i).getDepartment_id()).getName();
                        temp[3] = daoJob.getJobById(listProfile.get(i).getJob_id()).getTitle();
                        temp[4] = listProfile.get(i).getHire_date();  
                        temp[5] = listPD.get(i).getDob();
                        if(listPD.get(i).isIsMarried()){
                            temp[6] = "Married";
                        } else {
                            temp[6] = "Single";
                        }
                        if(listPD.get(i).isGender()) {
                            temp[7] = "Male";
                        } else {
                            temp[7] = "Female";
                        }
                        temp[8] = "";
                        temp[9] = listPD.get(i).getAddress();
                        temp[10] = listProfile.get(i).getPhone_number();
                        for (FamilyInfo f : listFam) {
                            if(f.getProfile_id().equals(listProfile.get(i).getProfile_id())) {
                                temp[11] = f.getPhone() + "\n";
                            }
                        }
                        empReport.add(temp);
                    }
                    
                    request.setAttribute("employee", empReport);
                    RequestDispatcher dispath = request.getRequestDispatcher("employee-report.jsp");
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
