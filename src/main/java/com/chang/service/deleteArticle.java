package com.chang.service;

import com.chang.dao.operateArticle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/delete")
public class deleteArticle {
    @RequestMapping(value ="/delete" ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public void delete(HttpServletRequest request){
        operateArticle operateArticle = new operateArticle();
        operateArticle.deleteArticle(request.getParameter("article_id"));
        System.out.println("成功");
    }
}
