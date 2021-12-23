package com.chang.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/getArticle")
public class getArticle {
    @RequestMapping("/getArticleList")
    @ResponseBody
    public List getArticleName(){
        List<String> list = new ArrayList<String>();

        return list;
    }
}
