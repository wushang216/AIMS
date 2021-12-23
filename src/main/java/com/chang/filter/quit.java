package com.chang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "quit",urlPatterns = {"/view/logIn.jsp","/view/email_login.jsp"})
public class quit implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //这两个是来强转的
        HttpServletRequest req= (HttpServletRequest)request;
        HttpServletResponse resp= (HttpServletResponse) response;
        req.getSession().removeAttribute("ID");
        req.getSession().removeAttribute("identity");
        chain.doFilter(request, response);

    }
}
