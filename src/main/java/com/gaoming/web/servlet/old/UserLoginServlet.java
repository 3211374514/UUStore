package com.gaoming.web.servlet.old;

import com.gaoming.pojo.Customer;
import com.gaoming.service_20211015_114634.CustomerService;
import com.gaoming.service_20211015_114634.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet{
    private CustomerService customerService = new CustomerServiceImpl();
//http://localhost:8080/brand-case/userLoginServlet?username=1234&password=1234&remember=0
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.获取用户名 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取remember数值
        String remember = request.getParameter("remember");

        //2.调用service查询
        Customer customer = customerService.login(username, password);

        //3.判断
        if (customer != null){
            //登陆成功

            //判断用户是否需要记住我
            if("1".equals(remember)){
                //勾选了记住我
                //1.创建cookie
                Cookie c_username = new Cookie("c_username",username);
                Cookie c_password = new Cookie("p_assword",password);
                //2.设置Cookie存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                //3.发送
                response.addCookie(c_username);
                response.addCookie(c_password);

        }
            //获取session
            request.getSession().setAttribute("customer",customer);
            System.out.println(customer);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/mainpage.html");//测试用，后面需要换
        }
        else {
            //登陆失败
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/userlogin.jsp").forward(request,response);//顾客登录页面，也需要改
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}
