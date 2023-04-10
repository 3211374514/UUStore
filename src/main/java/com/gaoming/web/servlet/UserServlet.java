package com.gaoming.web.servlet;


import com.gaoming.pojo.User;
import com.gaoming.service_20211015_114634.UserService;
import com.gaoming.service_20211015_114634.impl.UserServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServletImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用service查询
        User user = userService.login(username, password);

        //3.判断
        if(user != null){
            //登陆成功

            //获取session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/brand.html");
        }
        else {
            //登陆失败

            //存储错误信息
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到login.jsp
            //request.getRequestDispatcher("/login.jsp").forward(request,response );
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/login.jsp");

        }


    }




}



