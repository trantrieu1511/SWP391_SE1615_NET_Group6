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
import java.util.ArrayList;
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
                    Object editFail = request.getParameter("editFail");
                    Object add = request.getParameter("add");
                    Object delete = request.getParameter("delete");
                    Object deleteFail = request.getParameter("deleteFail");
                    Object SalaryIsNA = request.getParameter("SalaryIsNA");
                    String alert = "";
                    if (edit != null) { //edit
                        alert = "Successfully edited employee salary!";
                    } else if (editFail != null) { //edit
                        alert = "Fail to edit employee salary! Employee hasn't had a salary to edit yet.";
                    } else if (add != null) { //add
                        alert = "Successfully added new salary!";
                    } else if (delete != null) { //delete
                        alert = "Delete salary successfully!";
                    } else if (deleteFail != null) { //delete fail
                        alert = "Fail to delete employee salary! Employee hasn't had a salary to delete yet.";
                    } else if (SalaryIsNA != null) { //Salary isn't available
                        alert = "Employee hasn't had a salary yet! You have to add employee's salary first to generate their payslip!";
                    }
                    List<Salary> list = daoSalary.listAllStaffAndManagerProfile();
                    List<Salary> listNeedSalary = daoSalary.listStaffNeedSalary();
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
                    request.setAttribute("needsalary", listNeedSalary);
                    request.setAttribute("department", listDp);
                    request.setAttribute("job", listJ);
                    RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                    dispath.forward(request, response);
                }
                if (service.equals("filter")) {
                    String ename = request.getParameter("ename").trim();
                    String erole = request.getParameter("erole").trim();
                    String from = request.getParameter("from").trim();
                    String to = request.getParameter("to").trim();
                    String alert = "";
                    List<Salary> listSearch = new ArrayList<>();
                    if (!erole.equals("") && !ename.equals("") && from.equals("") && to.equals("")) { //role + name
                        listSearch = daoSalary.searchEmployeeSalaryWithoutCreateDate(erole, ename);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && ename.equals("") && !from.equals("") && !to.equals("")) { //from + to
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate4(from, to);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (!erole.equals("") && !ename.equals("") && !from.equals("") && to.equals("")) { //role + name + from
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate3(erole, ename, from);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && !ename.equals("") && !from.equals("") && !to.equals("")) { //name + from + to
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate2(ename, from, to);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (!erole.equals("") && ename.equals("") && !from.equals("") && !to.equals("")) { //role + from + to
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate5(erole, from, to);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (!erole.equals("") && ename.equals("") && !from.equals("") && to.equals("")) { //role + from
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate6(erole, from);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && !ename.equals("") && !from.equals("") && to.equals("")) { //name + from
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate7(ename, from);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && ename.equals("") && !from.equals("") && to.equals("")) { //from only
                        listSearch = daoSalary.searchEmployeeSalaryWithFromOnly(from);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && !ename.equals("") && from.equals("") && to.equals("")) { //name only
                        listSearch = daoSalary.searchEmployeeSalaryWithNameOnly(ename);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (!erole.equals("") && ename.equals("") && from.equals("") && to.equals("")) { //role only
                        listSearch = daoSalary.searchEmployeeSalaryWithRoleOnly(erole);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (!erole.equals("") && !ename.equals("") && !from.equals("") && !to.equals("")) { //role + name + from + to
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate(erole, ename, from, to);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && ename.equals("") && from.equals("") && to.equals("")) { //enter nothing
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate(erole, ename, from, to);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else if (erole.equals("") && ename.equals("") && from.equals("") && to.equals("")) { //enter nothing
                        listSearch = daoSalary.searchEmployeeSalaryWithCreateDate(erole, ename, from, to);
                        if (listSearch.isEmpty()) {
                            alert = "There are no result found!";
                        }
                    } else {
                        alert = "Please enter From Date to commit search!";
                    }
                    List<Salary> listNeedSalary = daoSalary.listStaffNeedSalary();
                    List<Departments> listDp = daoDepartment.listAllDepartment();
                    List<Jobs> listJ = daoJob.listAllJob();
                    if (!listSearch.isEmpty()) {
                        for (Profile p : listSearch) {
                            p.setJob_title(daoJob.getJobById(p.getJob_id()).getTitle());
                            p.setDepartment_name(daoDepartment.getDepartmentByID(p.getDepartment_id()).getName());
                            Account accStaff = daoAccount.getAccount(p.getProfile_id());
                            if (accStaff != null) {
                                p.setUser_display(daoAccount.getAccount(p.getProfile_id()).getUser());
                                p.setPass_display(daoAccount.getAccount(p.getProfile_id()).getPass());
                            }
                        }
                    }
                    request.setAttribute("filter", "no");
                    request.setAttribute("alert", alert);
                    request.setAttribute("profile", listSearch);
                    request.setAttribute("needsalary", listNeedSalary);
                    request.setAttribute("department", listDp);
                    request.setAttribute("job", listJ);
                    RequestDispatcher dispath = request.getRequestDispatcher("salary.jsp");
                    dispath.forward(request, response);
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
                    boolean statusAdd = daoSalary.addEmployeeSalary(
                            new Salary(profile_id, basic_salary, DA, HRA,
                                    conveyance, allowance, medical_allowance,
                                    TDS, ESI, PF, leave, loan, professional_tax,
                                    create_date));
                    if (statusAdd) {
                        System.out.println("Successfully added new Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&add=true");
                    } else {
                        System.out.println("Fail to add new Salary for profile_id = " + profile_id);
                    }
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

                    int statusEdit = daoSalary.editEmployeeSalary(
                            new Salary(profile_id, basic_salary, DA, HRA,
                                    conveyance, allowance, medical_allowance,
                                    TDS, ESI, PF, leave, loan, professional_tax)
                    );
                    if (statusEdit > 0) {
                        System.out.println("Successfully edited Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&edit=true");
                    } else {
                        System.out.println("Fail to edit new Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&editFail=true");
                    }
                }

                if (service.equals("deleteSalary")) {
                    String profile_id = request.getParameter("profile_id");

                    int statusDelete = daoSalary.deleteEmployeeSalary(profile_id);
                    if (statusDelete > 0) {
                        System.out.println("Successfully deleted Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&delete=true");
                    } else {
                        System.out.println("Fail to delete Salary for profile_id = " + profile_id);
                        response.sendRedirect("salary?do=list&deleteFail=true");
                    }
                }

                if (service.equals("payslip")) {
                    String profile_id = request.getParameter("profile_id");
                    Salary salary = daoSalary.getIndividualSalaryAndProfileInPayslip(profile_id);
                    List<Departments> listDp = daoDepartment.listAllDepartment();
                    List<Jobs> listJ = daoJob.listAllJob();

                    salary.setJob_title(daoJob.getJobById(salary.getJob_id()).getTitle());
                    salary.setDepartment_name(daoDepartment.getDepartmentByID(salary.getDepartment_id()).getName());
                    Account accStaff = daoAccount.getAccount(salary.getProfile_id());
                    if (accStaff != null) {
                        salary.setUser_display(daoAccount.getAccount(salary.getProfile_id()).getUser());
                        salary.setPass_display(daoAccount.getAccount(salary.getProfile_id()).getPass());
                    }

                    request.setAttribute("department", listDp);
                    request.setAttribute("job", listJ);
                    request.setAttribute("s", salary);
                    RequestDispatcher dispatch = request.getRequestDispatcher("salary-view.jsp");
                    dispatch.forward(request, response);
                }
                if (service.equals("getmyPayslip")) {
                    Salary salary = daoSalary.getIndividualSalaryAndProfileInPayslip(acc.getProfile_id());
                    List<Departments> listDp = daoDepartment.listAllDepartment();
                    List<Jobs> listJ = daoJob.listAllJob();

                    salary.setJob_title(daoJob.getJobById(salary.getJob_id()).getTitle());
                    salary.setDepartment_name(daoDepartment.getDepartmentByID(salary.getDepartment_id()).getName());
                    Account accStaff = daoAccount.getAccount(salary.getProfile_id());
                    if (accStaff != null) {
                        salary.setUser_display(daoAccount.getAccount(salary.getProfile_id()).getUser());
                        salary.setPass_display(daoAccount.getAccount(salary.getProfile_id()).getPass());
                    }

                    request.setAttribute("department", listDp);
                    request.setAttribute("job", listJ);
                    request.setAttribute("s", salary);
                    RequestDispatcher dispatch = request.getRequestDispatcher("salary-view.jsp");
                    dispatch.forward(request, response);
                }
                if (service.equals("toPDF")) {
                    
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
