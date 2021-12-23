package com.chang.service;

import com.chang.dao.operateUser;
import com.chang.entity.user;
import com.chang.entity.userDate;
import com.chang.utils.sendEmailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/Email")
public class Email {

    @RequestMapping("/logInEmail")
    @ResponseBody
    public void email(String email, HttpServletResponse response, HttpServletRequest request) throws IOException {
        operateUser operateUser = new operateUser();
        userDate userDate = operateUser.getEmail(email);
        if (userDate != null){
            String vCode = getVCode();
            request.getSession().setAttribute("VCode", vCode);
            System.out.println(vCode);
            email(email,userDate.getUser_name(),GetMsg(1,vCode));
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }
    private void email(String to,String name ,String emailMsg) {
        sendEmailUtil sendEmail = new sendEmailUtil();
        sendEmail.sendHtmlMail(to,name,emailMsg);
    }
    public String getVCode(){
        String str = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXVZ";
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            buffer.append(str.charAt(random.nextInt(str.length())));
        }
        return buffer.toString();
    }
    //文件信息
    private String GetMsg(int level,String VCode){
        if (level == 1){
            return "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>" +
                    "<h1 style='align-content: center'>欢迎登录茶纳雅言<h1>" +
                    "这是您的验证码："+VCode+"，您可以通过验证码进行登录"+
                    "</body></html>";
        }
        else return "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>" +
                "<h1 style='align-content: center'>欢迎登录茶纳雅言<h1>" +
                "<h2>您的账户正在修改密码，如果不是您本人操作，请尽快修改密码<h2>"+
                "这是您的验证码："+VCode+"，您可以通过验证码进行密码修改"+
                "</body></html>";
    }
}


