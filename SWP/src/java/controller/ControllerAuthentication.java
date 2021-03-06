/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Clients;
import entity.Company;
import entity.Profile;
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
import model.DAOAccount;
import model.DAOClients;
import model.DAOCompany;
import model.DAOProfile;
import model.DAOProfileDetail;

/**
 *
 * @author Khanh
 */
@WebServlet(name = "ControllerAuthentication", urlPatterns = {"/authentication"})
public class ControllerAuthentication extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
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
                    Boolean status = dao.getStatus(username);
                    if (status == true) {
                        session.setAttribute("acc", a);
                        response.sendRedirect("home");
                    } else {
                        request.setAttribute("mess", "Your account is disable. Please contact admin by phone number: 0976.475.638 for more details");
                        RequestDispatcher dispath = request.getRequestDispatcher("login.jsp");
                        dispath.forward(request, response);
                    }
                }
            }

            if (service.equals("logout")) {
                session.invalidate();
                response.sendRedirect("login.jsp");
            }

            if (service.equals("list")) {
                DAOProfile daoPf = new DAOProfile();
                List<Profile> listP = daoPf.getADandMN();
                String alert = "";

                request.setAttribute("listP", listP);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("account-list.jsp").forward(request, response);
            }

            if (service.equals("search")) {
                String fname = request.getParameter("fname").trim();
                String lname = request.getParameter("lname").trim();
                String email = request.getParameter("email").trim();
                String pnumber = request.getParameter("pnum").trim();
                String user = request.getParameter("user").trim();
                String isa = request.getParameter("isa").trim();
                String ism = request.getParameter("ism").trim();
                String status = request.getParameter("status").trim();
                int Isa = 0;
                int Ism = 0;
                int Status = 0;
                if (isa.equals("True")) {
                    Isa = 1;
                }
                if (ism.equals("True")) {
                    Ism = 1;
                }
                if (status.equals("True")) {
                    Status = 1;
                }
                DAOProfile daoPf = new DAOProfile();
                List<Profile> listP = daoPf.searchADandMN(fname, lname, email, pnumber, user, Isa, Ism, Status);

                request.setAttribute("listP", listP);
                request.getRequestDispatcher("account-list.jsp").forward(request, response);
            }
            if (service.equals("addaccount")) {
                String user = request.getParameter("auser").trim();
                String pass = request.getParameter("pass").trim();
                String isA = request.getParameter("isAdmin").trim();
                String isM = request.getParameter("isManager").trim();
                String fname = request.getParameter("fname").trim();
                String lname = request.getParameter("lname").trim();
                String date = request.getParameter("hiredate").trim();
                String email = request.getParameter("email").trim();
                String phone = request.getParameter("pnumber").trim();
                DAOAccount daoAcc = new DAOAccount();
                DAOProfile daoPf = new DAOProfile();
                int isAA = 0;
                int isMM = 0;
                int status = 1;
                if (isA == "True") {
                    isAA = 1;
                }
                if (isM == "True") {
                    isMM = 1;
                }
                Profile pro = new Profile(fname, lname, email, phone, date);
                if (daoPf.addManager(pro)) {
                    String pid = daoPf.getPID(fname);
                    daoAcc.addAMAccount(pid, user, pass, isAA, isMM);
                    System.out.println("Add Successfully user_id = " + pid);

                    request.getRequestDispatcher("authentication?do=list").forward(request, response);
                } else {
                    request.setAttribute("alert", "Add Fail");
                    request.getRequestDispatcher("authentication?do=list").forward(request, response);
                }
            }

            if (service.equals("editaccount")) {
                String pid = request.getParameter("eid").trim();
                String user = request.getParameter("euser").trim();
                String pass = request.getParameter("epass").trim();
                String isA = request.getParameter("eisAdmin").trim();
                String isM = request.getParameter("eisManager").trim();
                String fname = request.getParameter("efname").trim();
                String lname = request.getParameter("elname").trim();
                String date = request.getParameter("ehiredate").trim();
                String email = request.getParameter("eemail").trim();
                String phone = request.getParameter("epnumber").trim();
                String status = request.getParameter("estatus").trim();
                DAOAccount daoAcc = new DAOAccount();
                DAOProfile daoPf = new DAOProfile();
                int isAA = 0;
                int isMM = 0;
                int Status = 1;
                if (isA == "True") {
                    isAA = 1;
                }
                if (isM == "True") {
                    isMM = 1;
                }
                if (status == "True") {
                    Status = 1;
                }
                Profile pro = new Profile(pid, fname, lname, email, phone, date, 0, 0, "NULL");
                if (daoPf.editStaff(pro)) {
                    daoAcc.editAMAccount(pid, user, pass, isAA, isMM, Status);
                    System.out.println("Add Successfully user_id = " + pid);

                    request.getRequestDispatcher("authentication?do=list").forward(request, response);
                } else {
                    request.setAttribute("alert", "Add Fail");
                    request.getRequestDispatcher("authentication?do=list").forward(request, response);
                }
            }

            if (service.equals("delete")) {
                String aid = request.getParameter("aprofile_id");
                DAOAccount daoAcc = new DAOAccount();
                DAOProfile daoPf = new DAOProfile();
                DAOProfileDetail daoPd = new DAOProfileDetail();
                if (daoAcc.deleteAccount(aid)) {
                    if (daoPd.deleteProfileDetail(aid)) {
                        daoPf.deleteProfile(aid);
                        System.out.println("Delete Successfully user_id " + aid);

                        request.getRequestDispatcher("authentication?do=list").forward(request, response);
                    }
                } else {
                    System.out.println("Delete Fail user_id = " + aid);

                    request.getRequestDispatcher("authentication?do=list").forward(request, response);
                }
            }

            if (service.equals("allcompany")) {
                DAOCompany daoCp = new DAOCompany();
                DAOClients daocClient = new DAOClients();
                List<Clients> listClient = daocClient.listAllClients();
                List<Company> listComp = daoCp.listCompany();
                List<String[]> listS = new ArrayList<>();
                for (Company co : listComp) {
                    for (Clients cli : listClient) {
                        if (co.getId() == cli.getCompany_id()) {
                            String temp[] = new String[4];
                            temp[0] = Integer.toString(co.getId());
                            temp[1] = co.getName();
                            temp[2] = cli.getEmail();
                            temp[3] = cli.getPhone_number();
                            listS.add(temp);
                        } 
                    }
                }
                String allId = "";
                    for (String[] str : listS ){
                        allId += str[0];
                    }
                for (Company co : listComp) {
                    if (!allId.contains(Integer.toString(co.getId()))){
                        String temp[] = new String[4];
                            temp[0] = Integer.toString(co.getId());
                            temp[1] = co.getName();
                            temp[2] = "N/A";
                            temp[3] = "N/A";
                            listS.add(temp);
                    }                   
                }

                request.setAttribute("listS", listS);
                request.setAttribute("alert", "");
                request.getRequestDispatcher("company.jsp").forward(request, response);
            }

            if (service.equals("searchcompany")) {
                DAOCompany daoCp = new DAOCompany();
                DAOClients daocClient = new DAOClients();
                String name = request.getParameter("sname");
                String url = request.getParameter("surl");
                List<Company> listComp = daoCp.GetCompany(name);
                List<Clients> listClient = daocClient.listAllClients();
                List<String[]> listS = new ArrayList<>();
                for (Company co : listComp) {
                    for (Clients cli : listClient) {
                        if (co.getId() == cli.getCompany_id()) {
                            String temp[] = new String[4];
                            temp[0] = Integer.toString(co.getId());
                            temp[1] = co.getName();
                            temp[2] = cli.getEmail();
                            temp[3] = cli.getPhone_number();
                            listS.add(temp);
                        } 
                    }
                }
                String allId = "";
                    for (String[] str : listS ){
                        allId += str[0];
                    }
                for (Company co : listComp) {
                    if (!allId.contains(Integer.toString(co.getId()))){
                        String temp[] = new String[4];
                            temp[0] = Integer.toString(co.getId());
                            temp[1] = co.getName();
                            temp[2] = "N/A";
                            temp[3] = "N/A";
                            listS.add(temp);
                    }                   
                }

                request.setAttribute("listS", listS);
                request.setAttribute("alert", "");

                request.getRequestDispatcher("company.jsp").forward(request, response);
            }

            if (service.equals("company")) {
                DAOCompany daoCp = new DAOCompany();
                DAOAccount daoAcc = new DAOAccount();
                List<Account> listA = daoAcc.getADandMNAccount();
                Account admin = new Account();
                for (Account a : listA) {
                    if (a.isIsAdmin()) {
                        admin = a;
                    }
                }
                Company myComp = new Company();
                List<Company> listC = daoCp.MyCompany(admin.getProfile_id());
                for (Company c : listC) {
                    myComp = c;
                }
                request.setAttribute("myComp", myComp);
                request.setAttribute("alert", "");
                RequestDispatcher dispatch = request.getRequestDispatcher("seting.jsp");
                dispatch.forward(request, response);
            }

            if (service.equals("editcompany")) {
                String name = request.getParameter("cname").trim();
                String pnamed = request.getParameter("pname").trim();
                String[] part = pnamed.split(" ");
                String lname = part[0];
                String fname = part[1];
                String address = request.getParameter("caddress").trim();
                String conutry = request.getParameter("country").trim();
                String province = request.getParameter("prov").trim();
                String city = request.getParameter("city").trim();
                int pcode = Integer.parseInt(request.getParameter("pcode").trim());
                String email = request.getParameter("cemail").trim();
                int phone = Integer.parseInt(request.getParameter("cphone").trim());
                String pphone = request.getParameter("pphone").trim();
                int fax = Integer.parseInt(request.getParameter("fax").trim());
                String url = request.getParameter("url").trim();
                DAOCompany daoCP = new DAOCompany();
                Company com = new Company(name, address, conutry, province, city, pcode, email, phone, fax, url);
                DAOProfile daoPf = new DAOProfile();
                Profile pro = new Profile(acc.getProfile_id(), fname, lname, pphone);
                if ((daoCP.editCompany(com, acc.getProfile_id())) == true && (daoPf.editCompanyCEO(pro)) == true) {
                    DAOCompany daoCp = new DAOCompany();
                    DAOAccount daoAcc = new DAOAccount();
                    List<Account> listA = daoAcc.getADandMNAccount();
                    Account admin = new Account();
                    for (Account a : listA) {
                        if (a.isIsAdmin()) {
                            admin = a;
                        }
                    }
                    Company myComp = new Company();
                    List<Company> listC = daoCp.MyCompany(admin.getProfile_id());
                    for (Company c : listC) {
                        myComp = c;
                    }
                    request.setAttribute("myComp", myComp);
                    request.setAttribute("alert", "Save successfully!");
                    RequestDispatcher dispatch = request.getRequestDispatcher("seting.jsp");
                    dispatch.forward(request, response);

                } else {
                    DAOCompany daoCp = new DAOCompany();
                    DAOAccount daoAcc = new DAOAccount();
                    List<Account> listA = daoAcc.getADandMNAccount();
                    Account admin = new Account();
                    for (Account a : listA) {
                        if (a.isIsAdmin()) {
                            admin = a;
                        }
                    }
                    Company myComp = new Company();
                    List<Company> listC = daoCp.MyCompany(admin.getProfile_id());
                    for (Company c : listC) {
                        myComp = c;
                    }
                    request.setAttribute("myComp", myComp);
                    request.setAttribute("alert", "Save fail!");
                    RequestDispatcher dispatch = request.getRequestDispatcher("seting.jsp");
                    dispatch.forward(request, response);

                }
            }

            if (service.equals("addcompany")) {
                String name = request.getParameter("acname").trim();               
                DAOCompany daoCP = new DAOCompany();
                if (daoCP.addCompany(name)) {
                    request.setAttribute("alert", "Add successfully");
                } else {
                    request.setAttribute("alert", "Add fail");
                }
                DAOCompany daoCp = new DAOCompany();
                DAOClients daocClient = new DAOClients();
                List<Clients> listClient = daocClient.listAllClients();
                List<Company> listComp = daoCp.listCompany();
                List<String[]> listS = new ArrayList<>();
                for (Company co : listComp) {
                    for (Clients cli : listClient) {
                        if (co.getId() == cli.getCompany_id()) {
                            String temp[] = new String[4];
                            temp[0] = Integer.toString(co.getId());
                            temp[1] = co.getName();
                            temp[2] = cli.getEmail();
                            temp[3] = cli.getPhone_number();
                            listS.add(temp);
                        }
                    }
                }
                String allId = "";
                    for (String[] str : listS ){
                        allId += str[0];
                    }
                for (Company co : listComp) {
                    if (!allId.contains(Integer.toString(co.getId()))){
                        String temp[] = new String[4];
                            temp[0] = Integer.toString(co.getId());
                            temp[1] = co.getName();
                            temp[2] = "N/A";
                            temp[3] = "N/A";
                            listS.add(temp);
                    }                   
                }

                request.setAttribute("listS", listS);
                request.setAttribute("alert", "");
                request.getRequestDispatcher("company.jsp").forward(request, response);
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
