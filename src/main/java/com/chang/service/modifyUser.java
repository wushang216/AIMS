package com.chang.service;

import com.chang.dao.operateUser;
import com.chang.entity.user;
import com.chang.entity.userDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/modifyUser")
public class modifyUser {
    @RequestMapping("/modify")
    @ResponseBody
    public void modify(String avatar, String user_id, String user_name, String age, String sex, String email, String address, HttpServletResponse response){
        operateUser operateUser = new operateUser();
        user user = operateUser.GetUser(user_id);
        userDate emailIsExit = operateUser.getEmail(email);
        if (emailIsExit == null && !user.getUser_email().equals(email)){
            userDate userDate = new userDate();
            userDate.setUser_id(user_id);
            userDate.setUser_name(user_name);
            userDate.setAge(Integer.parseInt(age));
            userDate.setAddress(address);
            userDate.setSex(sex);
            userDate.setUser_email(email);
            userDate.setAvatar(avatar);
            operateUser.modify(userDate);
            try {
                response.getWriter().print("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (user.getUser_email().equals(email)){
            try {
                response.getWriter().print("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (emailIsExit != null){
            try {
                response.getWriter().print("-1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
