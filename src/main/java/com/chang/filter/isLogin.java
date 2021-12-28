package com.chang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "isLogin",urlPatterns = {"/view/home.jsp"
        ,"/view/management.jsp"
        ,"/view/MasterPage.jsp"
        ,"/view/readArticle.jsp"
        ,"/view/setUp.jsp"
        ,"/view/MyInfo.jsp"
        ,"/view/write.jsp"})
public class isLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //这两个是来强转的
        HttpServletRequest req= (HttpServletRequest)request;
        HttpServletResponse resp= (HttpServletResponse) response;
        ////获取用户请求的URL
        //String request_url = req.getRequestURI();
        //得到web应用程序上下文路径
        String ctsPath = req.getContextPath();
        ////去除上下文路径，得到剩余部分的路径
        //String uri = request_url.substring(ctsPath.length());
        if (req.getSession().getAttribute("ID") == null){
            resp.setHeader("refresh","6;url="+ctsPath+"/view/logIn.jsp");
        }
        chain.doFilter(request, response);
    }
}
