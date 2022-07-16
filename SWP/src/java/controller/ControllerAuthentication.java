/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Profile;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAccount;
import model.DAOProfile;

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
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", a);
                    response.sendRedirect("home");
                }
            }

            if (service.equals("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("login.jsp");
            }

            if (service.equals("list")) {
                DAOProfile dp = new DAOProfile();
                List<Profile> listP = dp.getADandMN();
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
                DAOProfile dp = new DAOProfile();
                List<Profile> listP = dp.searchADandMN(fname, lname, email, pnumber, user, Isa, Ism, Status);

                request.setAttribute("listP", listP);
                request.getRequestDispatcher("account-list.jsp").forward(request, response);
            }
            if (service.equals("addaccount")) {
                String pid = request.getParameter("id").trim();
                String user = request.getParameter("user").trim();
                String pass = request.getParameter("pass").trim();
                String isA = request.getParameter("isAdmin").trim();
                String isM = request.getParameter("isManager").trim();
                String fname = request.getParameter("fname").trim();
                String lname = request.getParameter("lname").trim();
                String date = request.getParameter("hiredate").trim();
                String email = request.getParameter("email").trim();
                String phone = request.getParameter("pnumber").trim();
                DAOAccount da = new DAOAccount();
                DAOProfile dp = new DAOProfile();
                int isAA = 0;
                int isMM = 0;
                int status = 1;
                if (isA == "True") {
                    isAA = 1;
                }
                if (isM == "True") {
                    isMM = 1;
                }
                Profile pro = new Profile(pid, fname, lname, email, phone, date, 0, 0, "NULL");
                if (dp.addManager(pro)) {
                    da.addAMAccount(pid, user, pass, isAA, isMM);
                }
                request.getRequestDispatcher("authentication?do=list").forward(request, response);
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
