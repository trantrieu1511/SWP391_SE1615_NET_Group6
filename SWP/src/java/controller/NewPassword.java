package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAccount;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password").trim();
        String confPassword = request.getParameter("confPassword").trim();
        RequestDispatcher dispatcher = null;
        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            String email = ((String) session.getAttribute("email")).trim();
            DAOAccount da = new DAOAccount();
            String pid = da.getProfileId(email).trim();
            if (da.GetNewPassword(newPassword, pid)) {
                request.setAttribute("alert", "resetSuccess");
                dispatcher = request.getRequestDispatcher("newPassword.jsp");
            } else {
                request.setAttribute("alert", "resetFailed");
                dispatcher = request.getRequestDispatcher("newPassword.jsp");
            }
            dispatcher.forward(request, response);
        }else{
            request.setAttribute("alert", "password notmatch");
            dispatcher = request.getRequestDispatcher("newPassword.jsp");
            dispatcher.forward(request, response);
        }
    }

}
