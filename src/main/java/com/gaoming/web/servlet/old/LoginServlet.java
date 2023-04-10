package com.gaoming.web.servlet.old;

import com.gaoming.pojo.User;
import com.gaoming.service_20211015_114634.UserService;
import com.gaoming.service_20211015_114634.impl.UserServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServletImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取用户名 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取remember数值
        String remember = request.getParameter("remember");

        //2.调用service查询
        User user = userService.login(username, password);

        //3.判断
        if(user != null){
            //登陆成功

            //判断用户是否需要记住我
            if("1".equals(remember)){
                //勾选了记住我
                //1.创建cookie
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                //2.设置Cookie存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                //3.发送
                response.addCookie(c_username);
                response.addCookie(c_password);



            }

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
            request.getRequestDispatcher("/login.jsp").forward(request,response );
//            String contextPath = request.getContextPath();
//            response.sendRedirect(contextPath+"/login.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
