/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Attendance;
import entity.Leave;
import entity.LeaveType;
import entity.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import model.DAOAttendance;
import model.DAOJob;
import model.DAOLeave;
import model.DAOLeaveType;
import model.DAOProfile;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerLeave", urlPatterns = {"/leave"})
public class ControllerLeave extends HttpServlet {

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
            DAOLeave daoLeave = new DAOLeave();
            DAOLeaveType daoLeaveType = new DAOLeaveType();
            DAOProfile daoPf = new DAOProfile();
            DAOJob daoJob = new DAOJob();
            DAOAttendance daoAttendance = new DAOAttendance();

            String service = request.getParameter("do");
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                String alert = "";
                if (service.equals("checkLeave")) {
                    List<Profile> listProfile = new ArrayList<>();
                    int totalEmployee = listProfile.size();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    List<Attendance> listAttendance = new ArrayList<>(); //get today's attendance
                    int present = 0;
                    int pending_request = 0;//count the pending request
                    List<Leave> listLeave = new ArrayList<>();
                    if (acc.isIsAdmin()) {
                        listLeave = daoLeave.listAllCheckLeaveAdmin();
                        for (Leave leave : listLeave) {
                            leave.setLeave_name(daoLeaveType.getLeaveTypeByID(Integer.toString(leave.getLeave_type())).getName());
                            leave.setFirst_name(daoPf.getByID(leave.getProfile_id()).getFirst_name());
                            leave.setLast_name(daoPf.getByID(leave.getProfile_id()).getLast_name());
                            leave.setJob_title(daoJob.getJobById(leave.getJob_id()).getTitle());
                            if (leave.getStatus() == 1) {
                                pending_request += 1;
                            }
                        }

                    }
                    if (acc.isIsManager()) {
                        listProfile = daoPf.listAllStaff(acc.getProfile_id());
                        totalEmployee = listProfile.size();
                        listAttendance = daoAttendance.todayAttendance(formatter.format(date));
                        present = listAttendance.size();
                        listLeave = daoLeave.listAllCheckLeaveManager(acc.getProfile_id());
                        for (Leave leave : listLeave) {
                            leave.setLeave_name(daoLeaveType.getLeaveTypeByID(Integer.toString(leave.getLeave_type())).getName());
                            leave.setFirst_name(daoPf.getByID(leave.getProfile_id()).getFirst_name());
                            leave.setLast_name(daoPf.getByID(leave.getProfile_id()).getLast_name());
                            leave.setJob_title(daoJob.getJobById(leave.getJob_id()).getTitle());
                            if (leave.getStatus() == 1) {
                                pending_request += 1;
                            }
                        }
                    }
                    request.setAttribute("checkLeaveList", listLeave);
                    request.setAttribute("pending_request", pending_request);
                    request.setAttribute("present", present);
                    request.setAttribute("totalEmployee", totalEmployee);
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("leaves.jsp");
                    dispath.forward(request, response);
                }

                if (service.equals("myLeave")) {
                    String add = request.getParameter("add");
                    String edit = request.getParameter("edit");
                    String delete = request.getParameter("delete");

                    if (add != null && add.equals("success")) {
                        alert = "Add new leave successfully!";
                    }
                    if (add != null && add.equals("failed")) {
                        alert = "Add new leave failed!";
                    }
                    if (add != null && add.equals("error")) {
                        alert = "Add new leave failed! From Date must before To Date";
                    }
                    if (edit != null && edit.equals("success")) {
                        alert = "Edit leave successfully!";
                    }
                    if (edit != null && edit.equals("failed")) {
                        alert = "Edit leave failed!";
                    }
                    if (edit != null && edit.equals("error")) {
                        alert = "Edit leave failed! From Date must before To Date";
                    }
                    if (delete != null && delete.equals("success")) {
                        alert = "Delete leave successfully!";
                    }
                    if (delete != null && delete.equals("failed")) {
                        alert = "Delete leave failed!";
                    }
                    List<Leave> listLeave = daoLeave.listAllMyLeave(acc.getProfile_id());
                    List<LeaveType> listLeaveType = daoLeaveType.listAllLeaveType();
                    int medical_leave = 0;
                    int other_leave = 0;
                    if (acc.isIsManager()) {
                        for (Leave leave : listLeave) {
                            leave.setReportto_name("null");
                            leave.setLeave_name(daoLeaveType.getLeaveTypeByID(Integer.toString(leave.getLeave_type())).getName());
                            if (leave.getLeave_name().equals("Medical Leave")) {
                                medical_leave += 1;
                            } else {
                                other_leave += 1;
                            }
                        }
                    } else {
                        for (Leave leave : listLeave) {
                            leave.setReportto_name(daoPf.getByID(leave.getReportto()).getFirst_name() + " "
                                    + daoPf.getByID(leave.getReportto()).getLast_name());
                            leave.setLeave_name(daoLeaveType.getLeaveTypeByID(Integer.toString(leave.getLeave_type())).getName());
                            if (leave.getLeave_name().equals("Medical Leave")) {
                                medical_leave += 1;
                            } else {
                                other_leave += 1;
                            }
                        }
                    }
                    request.setAttribute("myLeaveList", listLeave);
                    request.setAttribute("medical_leave", medical_leave);
                    request.setAttribute("other_leave", other_leave);
                    request.setAttribute("listLeaveType", listLeaveType);
                    request.setAttribute("alert", alert);
                    RequestDispatcher dispath = request.getRequestDispatcher("leaves-employee.jsp");
                    dispath.forward(request, response);
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

                if (service.equals("addLeave")) {
                    String profile_id = request.getParameter("profile_id");
                    int leave_type = Integer.parseInt(request.getParameter("leave_type"));
                    String from = request.getParameter("from");
                    String to = request.getParameter("to");
                    String reason = request.getParameter("reason");
                    String number_of_days = "";
                    boolean addLeave = false;
                    boolean DecrementAL = false;

                    int annual_leave = daoPf.getByID(profile_id).getAnnual_leave(); //remaining leave
                    try {
                        Date f_date = sdf.parse(from);
                        Date t_date = sdf.parse(to);
                        if (f_date.before(t_date)) {
                            from = sdf2.format(f_date);
                            to = sdf2.format(t_date);
                            if (annual_leave > 0) {
                                addLeave = daoLeave.addLeave(new Leave(profile_id,
                                        leave_type, from, to, reason));
                                if (addLeave) {
                                    System.out.println("Add Leave for pf_id = " + profile_id + " successfully!");
                                    DecrementAL = daoLeave.DecrementAnnualLeave(profile_id);
                                    if (DecrementAL) {
                                        System.out.println("Update annual leave for pf_id = " + profile_id + " successfully (-1 annual leave)!");
                                    } else {
                                        System.out.println("Fail to update annual leave!");
                                    }
                                    response.sendRedirect("leave?do=myLeave&add=success");
                                } else {
                                    System.out.println("Fail to add new leave!");
                                    response.sendRedirect("leave?do=myLeave&add=failed");
                                }
                            } else {
                                System.out.println("Cannot add more leave, your leave has extend the required amount of annual leave!");
                                response.sendRedirect("leave?do=myLeave&add=failed");
                            }
                        } else if (f_date.after(t_date)) {
                            System.out.println("Fail to add new leave! From date must before to date!");
                            response.sendRedirect("leave?do=myLeave&add=error");
                        } else {
                            from = sdf2.format(f_date);
                            to = sdf2.format(t_date);
                            number_of_days = request.getParameter("number_of_days");
                            if (annual_leave > 0) {
                                addLeave = daoLeave.addLeave2(new Leave(profile_id,
                                        leave_type, from, to, number_of_days, reason));
                                if (addLeave) {
                                    System.out.println("Add Leave for pf_id = " + profile_id + " successfully!");
                                    DecrementAL = daoLeave.DecrementAnnualLeave(profile_id);
                                    if (DecrementAL) {
                                        System.out.println("Update annual leave for pf_id = " + profile_id + " successfully (-1 annual leave)!");
                                    } else {
                                        System.out.println("Fail to update annual leave!");
                                    }
                                    response.sendRedirect("leave?do=myLeave&add=success");
                                } else {
                                    System.out.println("Fail to add new leave!");
                                    response.sendRedirect("leave?do=myLeave&add=failed");
                                }
                            } else {
                                System.out.println("Cannot add more leave, your leave has extend the required amount of annual leave!");
                                response.sendRedirect("leave?do=myLeave&add=failed");
                            }
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

//                    out.print(profile_id);
//                    out.print("<br>");
//                    out.print(leave_type);
//                    out.print("<br>");
//                    out.print(from);
//                    out.print("<br>");
//                    out.print(to);
//                    out.print("<br>");
//                    out.print(number_of_days);
//                    out.print("<br>");
//                    out.print(number_of_days_select);
//                    out.print("<br>");
//                    out.print(reason);
                }
                if (service.equals("editLeave")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String profile_id = request.getParameter("profile_id");
                    int leave_type = Integer.parseInt(request.getParameter("leave_type"));
                    String from = request.getParameter("from");
                    String to = request.getParameter("to");
                    String reason = request.getParameter("reason");
                    String number_of_days = "";
                    boolean editLeave = false;
                    try {
                        Date f_date = sdf.parse(from);
                        Date t_date = sdf.parse(to);
                        if (f_date.before(t_date)) {
                            from = sdf2.format(f_date);
                            to = sdf2.format(t_date);
                            editLeave = daoLeave.editLeave(new Leave(id, profile_id,
                                    leave_type, from, to, reason));
                            if (editLeave) {
                                System.out.println("Edit Leave for pf_id = " + profile_id + " where id = " + id + " success!");
                                response.sendRedirect("leave?do=myLeave&edit=success");
                            } else {
                                System.out.println("Fail to edit leave!");
                                response.sendRedirect("leave?do=myLeave&edit=failed");
                            }
                        } else if (f_date.after(t_date)) {
                            System.out.println("Fail to edit new leave! From date must before to date!");
                            response.sendRedirect("leave?do=myLeave&edit=error");
                        } else {
                            from = sdf2.format(f_date);
                            to = sdf2.format(t_date);
                            number_of_days = request.getParameter("number_of_days");
                            editLeave = daoLeave.editLeave2(new Leave(id, profile_id,
                                    leave_type, from, to, number_of_days, reason));
                            if (editLeave) {
                                System.out.println("Edit Leave for pf_id = " + profile_id + " where id = " + id + " success!");
                                response.sendRedirect("leave?do=myLeave&edit=success");
                            } else {
                                System.out.println("Fail to edit leave!");
                                response.sendRedirect("leave?do=myLeave&edit=failed");
                            }
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
                if (service.equals("deleteLeave")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String profile_id = request.getParameter("profile_id");

                    boolean deleteLeave = daoLeave.deleteLeave(id);
                    if (deleteLeave) {
                        System.out.println("Delete Leave for pf_id = " + profile_id + " where id = " + id + " success!");
                        boolean DecrementAL = daoLeave.IncrementAnnualLeave(profile_id);
                        if (DecrementAL) {
                            System.out.println("Update annual leave for pf_id = " + profile_id + " successfully (+1 annual leave)!");
                        } else {
                            System.out.println("Fail to update annual leave!");
                        }
                        response.sendRedirect("leave?do=myLeave&delete=success");
                    } else {
                        System.out.println("Fail to delete leave!");
                        response.sendRedirect("leave?do=myLeave&delete=failed");
                    }

                }
                if (service.equals("updateStatus")) {
                    int status = Integer.parseInt(request.getParameter("status"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    String profile_id = request.getParameter("profile_id");

                    boolean updateStatus = daoLeave.updateStatus(id, status);
                    if (updateStatus) {
                        System.out.println("Update status successfully to " + status + " for pf_id = " + profile_id + ", id = " + id);
                    } else {
                        System.out.println("Fail to update status to " + status + " for pf_id = " + profile_id + ", id = " + id);
                    }
                    response.sendRedirect("leave?do=checkLeave");
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
