package com.chang.service;

import com.chang.entity.createVCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/VCode")
public class GetVCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建对象
        createVCode vCode = new createVCode();
        //获取图片对象
        BufferedImage bi = vCode.getImage();
        //获取文本内容
        String text = vCode.getText();
        req.getSession().setAttribute("VCode",text);
        System.out.println(text);
        vCode.output(bi, resp.getOutputStream());
    }
}

