/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Departments;
import entity.Jobs;
import entity.Profile;
import entity.Salary;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import model.DAOJob;
import model.DAOProfile;
import model.DAOSalary;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerSalary", urlPatterns = {"/salary"})
public class ControllerSalary extends HttpServlet {

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

            DAOProfile daoProfile = new DAOProfile();
            DAODepartment daoDepartment = new DAODepartment();
            DAOJob daoJob = new DAOJob();
            DAOAccount daoAccount = new DAOAccount();
            DAOSalary daoSalary = new DAOSalary();

            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            // check session for user logged in
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("list")) {
                    Object edit = request.getParameter("edit");
                    Object add = request.getParameter("add");
                    Object delete = request.getParameter("delete");
                    Object deleteFail = request.getParameter("deleteFail");
                    if (edit != null) { //edit
                        String alert = "Successfully edited employee salary!";
                        List<Salary> list = daoSalary.listAllStaffAndManagerProfile();
                        List<Departments> listDp = daoDepartment.listAllDepartment();
                        List<Jobs> listJ = daoJob.listAllJob();
                        for (Profile p : list) {
                            p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDepartment.getDepartmentByID(p.getDepartment_id()).getName());
                            Account accStaff = daoAccount.getAccount(p.getProfile_id());
                            if (accStaff != null) {
                                p.setUser_display(daoAccount.getAccount(p.getProfile_id()).getUser());
                                p.setPass_display(daoAccount.getAccount(p.getProfile_id()).getPass());
                            }
                        }
                        request.setAttribute("filter", "yes");
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", list);
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                        dispath.forward(request, response);
                    } else if (add != null) { //add
                        String alert = "Successfully added new salary!";
                        List<Salary> list = daoSalary.listAllStaffAndManagerProfile();
                        List<Departments> listDp = daoDepartment.listAllDepartment();
                        List<Jobs> listJ = daoJob.listAllJob();
                        for (Profile p : list) {
                            p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDepartment.getDepartmentByID(p.getDepartment_id()).getName());
                            Account accStaff = daoAccount.getAccount(p.getProfile_id());
                            if (accStaff != null) {
                                p.setUser_display(daoAccount.getAccount(p.getProfile_id()).getUser());
                                p.setPass_display(daoAccount.getAccount(p.getProfile_id()).getPass());
                            }
                        }
                        request.setAttribute("filter", "yes");
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", list);
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                        dispath.forward(request, response);
                    } else if (delete != null) { //delete
                        String alert = "Delete salary successfully!";
                        List<Salary> list = daoSalary.listAllStaffAndManagerProfile();
                        List<Departments> listDp = daoDepartment.listAllDepartment();
                        List<Jobs> listJ = daoJob.listAllJob();
                        for (Profile p : list) {
                            p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDepartment.getDepartmentByID(p.getDepartment_id()).getName());
                            Account accStaff = daoAccount.getAccount(p.getProfile_id());
                            if (accStaff != null) {
                                p.setUser_display(daoAccount.getAccount(p.getProfile_id()).getUser());
                                p.setPass_display(daoAccount.getAccount(p.getProfile_id()).getPass());
                            }
                        }
                        request.setAttribute("filter", "yes");
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", list);
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                        dispath.forward(request, response);
                    } else if (deleteFail != null) { //delete fail
                        String alert = "Fail to delete employee salary! Employee hasn't had a salary yet";
                        List<Salary> list = daoSalary.listAllStaffAndManagerProfile();
                        List<Departments> listDp = daoDepartment.listAllDepartment();
                        List<Jobs> listJ = daoJob.listAllJob();
                        for (Profile p : list) {
                            p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDepartment.getDepartmentByID(p.getDepartment_id()).getName());
                            Account accStaff = daoAccount.getAccount(p.getProfile_id());
                            if (accStaff != null) {
                                p.setUser_display(daoAccount.getAccount(p.getProfile_id()).getUser());
                                p.setPass_display(daoAccount.getAccount(p.getProfile_id()).getPass());
                            }
                        }
                        request.setAttribute("filter", "yes");
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", list);
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                        dispath.forward(request, response);
                    } else {
                        String alert = "";
                        List<Salary> list = daoSalary.listAllStaffAndManagerProfile();
                        List<Departments> listDp = daoDepartment.listAllDepartment();
                        List<Jobs> listJ = daoJob.listAllJob();
                        for (Profile p : list) {
                            p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDepartment.getDepartmentByID(p.getDepartment_id()).getName());
                            Account accStaff = daoAccount.getAccount(p.getProfile_id());
                            if (accStaff != null) {
                                p.setUser_display(daoAccount.getAccount(p.getProfile_id()).getUser());
                                p.setPass_display(daoAccount.getAccount(p.getProfile_id()).getPass());
                            }
                        }
                        request.setAttribute("filter", "yes");
                        request.setAttribute("alert", alert);
                        request.setAttribute("profile", list);
                        request.setAttribute("department", listDp);
                        request.setAttribute("job", listJ);
                        RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                        dispath.forward(request, response);
                    }

                }
                if (service.equals("filter")) {

                }

                if (service.equals("addSalary")) {
                    String profile_id = request.getParameter("profile_id");
                    double basic_salary = Double.parseDouble(request.getParameter("basic_salary").trim());
                    double DA = Double.parseDouble(request.getParameter("DA").trim());
                    double HRA = Double.parseDouble(request.getParameter("HRA").trim());
                    double conveyance = Double.parseDouble(request.getParameter("conveyance").trim());
                    double allowance = Double.parseDouble(request.getParameter("allowance").trim());
                    double medical_allowance = Double.parseDouble(request.getParameter("medical_allowance").trim());
                    double TDS = Double.parseDouble(request.getParameter("TDS").trim());
                    double ESI = Double.parseDouble(request.getParameter("ESI").trim());
                    double PF = Double.parseDouble(request.getParameter("PF").trim());
                    double leave = Double.parseDouble(request.getParameter("leave").trim());
                    double loan = Double.parseDouble(request.getParameter("loan").trim());
                    double professional_tax = Double.parseDouble(request.getParameter("professional_tax").trim());
                    String create_date = "";
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDateTime now = LocalDateTime.now();
                    create_date = dtf.format(now);

//                    out.print(profile_id);
//                    out.print("<br>");
//                    out.print(basic_salary);
//                    out.print("<br>");
//                    out.print(DA);
//                    out.print("<br>");
//                    out.print(HRA);
//                    out.print("<br>");
//                    out.print(conveyance);
//                    out.print("<br>");
//                    out.print(allowance);
//                    out.print("<br>");
//                    out.print(medical_allowance);
//                    out.print("<br>");
//                    out.print(TDS);
//                    out.print("<br>");
//                    out.print(ESI);
//                    out.print("<br>");
//                    out.print(PF);
//                    out.print("<br>");
//                    out.print(leave);
//                    out.print("<br>");
//                    out.print(loan);
//                    out.print("<br>");
//                    out.print(professional_tax);
//                    out.print("<br>");
//                    out.print(create_date);
                    boolean statusAdd = daoSalary.addEmployeeSalary(
                            new Salary(profile_id, basic_salary, DA, HRA,
                                    conveyance, allowance, medical_allowance,
                                    TDS, ESI, PF, leave, loan, professional_tax,
                                    create_date));
                    if (statusAdd) {
                        System.out.println("Successfully added new Salary for profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to add new Salary for profile_id = " + profile_id);
                    }
                    response.sendRedirect("salary?do=list&add=true");
                }
                if (service.equals("editSalary")) {
                    String profile_id = request.getParameter("profile_id");
                    double basic_salary = Double.parseDouble(request.getParameter("basic_salary").trim());
                    double DA = Double.parseDouble(request.getParameter("DA").trim());
                    double HRA = Double.parseDouble(request.getParameter("HRA").trim());
                    double conveyance = Double.parseDouble(request.getParameter("conveyance").trim());
                    double allowance = Double.parseDouble(request.getParameter("allowance").trim());
                    double medical_allowance = Double.parseDouble(request.getParameter("medical_allowance").trim());
                    double TDS = Double.parseDouble(request.getParameter("TDS").trim());
                    double ESI = Double.parseDouble(request.getParameter("ESI").trim());
                    double PF = Double.parseDouble(request.getParameter("PF").trim());
                    double leave = Double.parseDouble(request.getParameter("leave").trim());
                    double loan = Double.parseDouble(request.getParameter("loan").trim());
                    double professional_tax = Double.parseDouble(request.getParameter("professional_tax").trim());

                    boolean statusEdit = daoSalary.editEmployeeSalary(
                            new Salary(profile_id, basic_salary, DA, HRA,
                                    conveyance, allowance, medical_allowance,
                                    TDS, ESI, PF, leave, loan, professional_tax)
                    );
                    if (statusEdit) {
                        System.out.println("Successfully edited Salary for profile_id = " + profile_id);
                    } else {
                        System.out.println("Fail to edit new Salary for profile_id = " + profile_id);
                    }
                    response.sendRedirect("salary?do=list&edit=true");
                }
                if (service.equals("deleteSalary")) {
                    String profile_id = request.getParameter("profile_id");

                    boolean statusDelete = daoSalary.deleteEmployeeSalary(profile_id);
                    if (statusDelete) {
                        System.out.println("Successfully deleted Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&delete=true");
                    } else {
                        System.out.println("Fail to delete Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&deleteFail=true");
                    }
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
