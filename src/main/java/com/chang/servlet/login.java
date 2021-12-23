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

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String VCode = req.getParameter("VCode");
        String VCode_verify = (String) req.getSession().getAttribute("VCode");
        if (VCode.equals(VCode_verify)){
            operateUser operateUser = new operateUser();
            userDate userDate = operateUser.Login(account);
            if (userDate == null){
                req.getSession().setAttribute("error","0");
                resp.sendRedirect("view/logIn.jsp");
            }else if (userDate.getUser_password().equals(password)){
                if (userDate.seal.getTime() > new Date().getTime()){
                    resp.sendRedirect("view/logIn.jsp?sealed=true");
                    return;
                }
                req.getSession().setAttribute("ID",account);
                req.getSession().setAttribute("identity", userDate.getIdentity());
                resp.sendRedirect("view/MasterPage.jsp?n=1");
            }else {
                req.getSession().setAttribute("error","-1");
                resp.sendRedirect("view/logIn.jsp");
            }
        }else {
            req.getSession().setAttribute("VCode_error","false");
            resp.sendRedirect("view/logIn.jsp");
        }
    }
}
