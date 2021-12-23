package com.chang.service;

import com.chang.dao.operateArticle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/check")
public class check {
    @RequestMapping("/check_article")
    @ResponseBody
    public void check_article(HttpServletRequest request){
        String id = request.getParameter("article");
        String pass = request.getParameter("pass");
        operateArticle operateArticle = new operateArticle();
        int audit = operateArticle.Audit(id, pass);
        System.out.println(audit);
    }
}
