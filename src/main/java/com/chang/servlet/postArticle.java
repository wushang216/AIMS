package com.chang.servlet;

import com.chang.dao.operateArticle;
import com.chang.entity.articleDate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "postArticle", value = "/postArticle")
public class postArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String label = "";
        articleDate articleDate = new articleDate();
        operateArticle operateArticle = new operateArticle();
        String[] labels = request.getParameterValues("label");
        for (String L :labels) {
            label  = label.concat(L);
        }
        articleDate.setArticle(request.getParameter("article"));
        articleDate.setArticle_name(request.getParameter("article_name"));
        articleDate.setArticle_label(label);
        int i;
        //判断该文章是否已经存在与数据库 若存在下方判断为真
        if (request.getParameter("article_id") == null){
            long time = new Date(System.currentTimeMillis()).getTime();
            articleDate.setArticle_id(String.valueOf(time).substring(2,11));
            articleDate.setUser_id((String) request.getSession().getAttribute("ID"));
            i = operateArticle.postArticle(articleDate);
            if (i == 1){
                response.sendRedirect("view/readArticle.jsp?article="+articleDate.getArticle_id()+"&success=true");
            }else {
                response.sendRedirect("view/write.jsp?success=false");
            }
        }else {
            articleDate.setArticle_id(request.getParameter("article_id"));
            System.out.println(request.getParameter("article_id"));
            i = operateArticle.rewrite(articleDate);
            if (i == 1){
                response.sendRedirect("view/readArticle.jsp?article="+articleDate.getArticle_id()+"&success=true");
            }
        }
    }
}
