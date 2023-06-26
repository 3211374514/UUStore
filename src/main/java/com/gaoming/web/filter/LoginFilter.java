package com.gaoming.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        //判断资源是否和登录注册相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/userLoginServlet","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        //判断
        String url = req.getRequestURL().toString();

        for(String u :urls){
            if(url.contains(u)){
                chain.doFilter(request, response);

                return;
            }
        }


        //1.判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2.判断user是否为null
        if(user != null){
            //登陆过了，放行
            //放行
            chain.doFilter(request, response);
        }else {
            //没有登录
            req.setAttribute("login_msg","您尚未登陆！");

            req.getRequestDispatcher("/login.jsp").forward(request,response);

        }



    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
