package com.gaoming.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.gaoming.pojo.Feedback;
import com.gaoming.service_20211015_114634.FeedbackService;
import com.gaoming.service_20211015_114634.impl.FeedbackServletImpl;

@WebServlet("/feedback/*")
public class feedbackServlet extends BaseServlet{
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String contact = request.getParameter("contact");
        String information1 = request.getParameter("information");
        String information = new String(information1.getBytes("iso-8859-1"),"utf-8");
        //由于<textarea>保存数据格式为iso-8859-1，而数据库保存数据格式为utf-8，需要加一个转换
        FeedbackService feedbackservice = new FeedbackServletImpl();
        feedbackservice.Onsend(contact,information);
        String contextPath = request.getContextPath();
        request.setAttribute("feed_msg","反馈成功");
        response.sendRedirect(contextPath+"/mainpage.html");

    }
}
