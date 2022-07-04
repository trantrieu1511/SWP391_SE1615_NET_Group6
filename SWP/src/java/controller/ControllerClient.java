/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Clients;
import entity.Company;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOClients;
import model.DAOCompany;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerClient", urlPatterns = {"/client"})
public class ControllerClient extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            String service = request.getParameter("do");
            DAOClients daoCl = new DAOClients();
            DAOCompany daoCpn = new DAOCompany();
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (service.equals("list")) {
                    Object add = request.getParameter("add");
                    Object addFail = request.getParameter("addFail");
                    Object edit = request.getParameter("edit");
                    Object delete = request.getParameter("delete");
                    if (add != null) {
                        String alert = "Successfully added new client!";
                        List<Clients> listCl = daoCl.listAllClients();
                        List<Company> listCpn = daoCpn.listAllCompany();
                        for (Clients c : listCl) {
                            c.setCompany_name(daoCpn.getCompanyByID(c.getCompany_id()).getName());
                        }
                        request.setAttribute("listcl", listCl);
                        request.setAttribute("listcpn", listCpn);
                        request.setAttribute("alert", alert);
                        RequestDispatcher dispatch = request.getRequestDispatcher("clients-list.jsp");
                        dispatch.forward(request, response);
                    } else if (addFail != null) {
                        String alert = "Add new client failed! Client-ID has been used by another Client, please try again!";
                        List<Clients> listCl = daoCl.listAllClients();
                        List<Company> listCpn = daoCpn.listAllCompany();
                        for (Clients c : listCl) {
                            c.setCompany_name(daoCpn.getCompanyByID(c.getCompany_id()).getName());
                        }
                        request.setAttribute("listcl", listCl);
                        request.setAttribute("listcpn", listCpn);
                        request.setAttribute("alert", alert);
                        RequestDispatcher dispatch = request.getRequestDispatcher("clients-list.jsp");
                        dispatch.forward(request, response);
                    } else if (edit != null) {
                        String alert = "Successfully edited client!";
                        List<Clients> listCl = daoCl.listAllClients();
                        List<Company> listCpn = daoCpn.listAllCompany();
                        for (Clients c : listCl) {
                            c.setCompany_name(daoCpn.getCompanyByID(c.getCompany_id()).getName());
                        }
                        request.setAttribute("listcl", listCl);
                        request.setAttribute("listcpn", listCpn);
                        request.setAttribute("alert", alert);
                        RequestDispatcher dispatch = request.getRequestDispatcher("clients-list.jsp");
                        dispatch.forward(request, response);
                    } else if (delete != null) {
                        String alert = "Successfully deleted client!";
                        List<Clients> listCl = daoCl.listAllClients();
                        List<Company> listCpn = daoCpn.listAllCompany();
                        for (Clients c : listCl) {
                            c.setCompany_name(daoCpn.getCompanyByID(c.getCompany_id()).getName());
                        }
                        request.setAttribute("listcl", listCl);
                        request.setAttribute("listcpn", listCpn);
                        request.setAttribute("alert", alert);
                        RequestDispatcher dispatch = request.getRequestDispatcher("clients-list.jsp");
                        dispatch.forward(request, response);
                    } else {
                        String alert = "";
                        List<Clients> listCl = daoCl.listAllClients();
                        List<Company> listCpn = daoCpn.listAllCompany();
                        for (Clients c : listCl) {
                            c.setCompany_name(daoCpn.getCompanyByID(c.getCompany_id()).getName());
                        }
                        request.setAttribute("listcl", listCl);
                        request.setAttribute("listcpn", listCpn);
                        request.setAttribute("alert", alert);
                        RequestDispatcher dispatch = request.getRequestDispatcher("clients-list.jsp");
                        dispatch.forward(request, response);
                    }

                }
                if (service.equals("filter")) {
                    String client_id = request.getParameter("cid").trim();
                    String client_name = request.getParameter("cname").trim();
                    String client_company = request.getParameter("ccompany");
                    String alert = "";
                    List<Company> listCpn = daoCpn.listAllCompany();
                    List<Clients> listSearch = new ArrayList<>();
                    if (client_company.equals("")) {
                        listSearch = daoCl.searchClient1(client_id, client_name);
                        if (listSearch.isEmpty()) {
                            alert = "There are no search result found!";
                        }
                    } else {
                        listSearch = daoCl.searchClient2(client_id, client_name, client_company);
                        if (listSearch.isEmpty()) {
                            alert = "There are no search result found!";
                        }
                    }
                    for (Clients c : listSearch) {
                        c.setCompany_name(daoCpn.getCompanyByID(c.getCompany_id()).getName());
                    }
                    request.setAttribute("listcl", listSearch);
                    request.setAttribute("listcpn", listCpn);
                    request.setAttribute("alert", alert);
                    request.setAttribute("filter", "no");
                    RequestDispatcher dispatch = request.getRequestDispatcher("clients-list.jsp");
                    dispatch.forward(request, response);
                }
                if (service.equals("addClient")) {
                    String client_id = request.getParameter("client_id");
                    String first_name = request.getParameter("first_name").trim();
                    String last_name = request.getParameter("last_name").trim();
                    String company_id_str = request.getParameter("company_id").trim();
                    int company_id = Integer.parseInt(company_id_str);
                    String email = request.getParameter("email").trim();
                    String phone_number = request.getParameter("phone_number").trim();

                    boolean statusAdd = daoCl.addClient(new Clients(client_id,
                            first_name, last_name, email, phone_number, company_id));
                    if (statusAdd) {
                        System.out.println("Successfully added new Client with client_id = " + client_id);
                        response.sendRedirect("client?do=list&add=true");
                    } else {
                        System.out.println("Fail to add new Client with client_id = " + client_id);
                        response.sendRedirect("client?do=list&addFail=true");
                    }
                }
                if (service.equals("editClient")) {
                    String client_id = request.getParameter("client_id");
                    String first_name = request.getParameter("first_name").trim();
                    String last_name = request.getParameter("last_name").trim();
                    String company_id_str = request.getParameter("company_id").trim();
                    int company_id = Integer.parseInt(company_id_str);
                    String email = request.getParameter("email").trim();
                    String phone_number = request.getParameter("phone_number").trim();

                    boolean statusEdit = daoCl.editClient(new Clients(client_id,
                            first_name, last_name, email, phone_number, company_id));
                    if (statusEdit) {
                        System.out.println("Successfully edited Client with client_id = " + client_id);
                    } else {
                        System.out.println("Fail to edit Client with client_id = " + client_id);
                    }
                    response.sendRedirect("client?do=list&edit=true");
                }
                if (service.equals("deleteClient")) {
                    String client_id = request.getParameter("client_id");
                    boolean statusDelete = daoCl.deleteClient(client_id);
                    if (statusDelete) {
                        System.out.println("Successfully deleted Client with client_id = " + client_id);
                    } else {
                        System.out.println("Fail to delete Client with client_id = " + client_id);
                    }
                    response.sendRedirect("client?do=list&delete=true");
                }
                if (service.equals("getclientProfile")) {
                    String client_id = request.getParameter("client_id");
                    List<Clients> listCp = daoCl.getIndividualClientProfile(client_id);
                    request.setAttribute("listcp", listCp);
                    RequestDispatcher dispatch = request.getRequestDispatcher("client-profile.jsp");
                    dispatch.forward(request, response);
                }
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
