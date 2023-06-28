package com.gaoming.web.servlet;

import com.alibaba.fastjson.JSON;
import com.gaoming.pojo.Customer;
import com.gaoming.service_20211015_114634.CustomerService;
import com.gaoming.service_20211015_114634.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/change/*")
public class ChangeServlet extends BaseServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    /**
     * 修改密码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
////http://localhost:8080/brand-case/change/update?username=111&password=111&repassword=1234
     public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String repassword = request.getParameter("repassword");
         String contextPath = request.getContextPath();
            //3. 调用service修改
            if (customerService.update(username,password,repassword)) {
                response.sendRedirect(contextPath+"/userlogin.jsp");
            }else {
                request.setAttribute("reset_msg","用户名或密码错误");
                response.sendRedirect(contextPath+"/change.jsp");
            }
     }
}
