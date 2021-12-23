package com.chang.servlet;

import com.chang.dao.operateUser;
import com.chang.entity.user;
import com.chang.entity.userDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/email_login")
public class email_login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String email = req.getParameter("email");
        if (code.equals(req.getSession().getAttribute("VCode").toString())){
            operateUser operateUser = new operateUser();
            userDate userDate = operateUser.getEmail(email);
            if (userDate.seal.getTime() > new Date().getTime()){
                resp.sendRedirect("view/logIn.jsp?sealed=true");
                return;
            }
            req.getSession().setAttribute("ID", userDate.getUser_id());
            req.getSession().setAttribute("identity", userDate.getIdentity());
            req.getSession().removeAttribute("VCode");
            resp.sendRedirect("view/MasterPage.jsp?n=1");
        }else {
            req.getSession().removeAttribute("user");
            resp.sendRedirect("view/email_login.jsp");
        }
    }
}
