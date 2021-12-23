package com.chang.servlet;

import com.chang.dao.operateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/enroll")
public class enroll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        operateUser operateUser = new operateUser();
        session.setAttribute("success",operateUser.registration(account,password)+"");
        resp.sendRedirect("view/enroll.jsp");
    }
}
