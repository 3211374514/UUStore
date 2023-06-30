package com.gaoming.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.gaoming.pojo.Feedback;
import com.gaoming.service_20211015_114634.FeedbackService;
import com.gaoming.service_20211015_114634.impl.FeedbackServletImpl;

@WebServlet("/feedback/*")
public class feedbackServlet extends BaseServlet{
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contact = request.getParameter("contact");
        String information = request.getParameter("information");
        FeedbackService feedbackservice = new FeedbackServletImpl();
        feedbackservice.Onsend(contact,information);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/feedback.html");

    }
}
