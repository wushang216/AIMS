package com.chang.service;

import com.chang.dao.operateArticle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/GetSearchKeyword")
public class getSearchKeyword {
    @RequestMapping(value = "/SearchKeyword",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getSearch(String Key) throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(new operateArticle().GetArticleByName(Key));
    }
}
