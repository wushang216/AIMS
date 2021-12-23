package com.chang.service;

import com.chang.dao.operateUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/freeze")
public class freeze {
    @RequestMapping(value = "/unsealed",method = RequestMethod.GET)
    @ResponseBody
    public void unsealed(@Param("id") String user_id, HttpServletRequest request){
        System.out.println(user_id+"封印");
        String id = request.getParameter("id");
        operateUser operateDao = new operateUser();
        operateDao.sealUser(id);
    }
    @RequestMapping(value = "/sealed",method = RequestMethod.GET)
    @ResponseBody
    public void sealed(@Param("user_id") String user_id, HttpServletRequest request){

        System.out.println(user_id+"解封");
        String id = request.getParameter("id");
        operateUser operateDao = new operateUser();
        operateDao.unSealUser(id);
    }
}
