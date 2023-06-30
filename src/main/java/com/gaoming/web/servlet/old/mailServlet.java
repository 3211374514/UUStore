package com.gaoming.web.servlet.old;
import com.gaoming.service_20211015_114634.UserService;
import com.gaoming.service_20211015_114634.impl.UserServletImpl;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Properties;
@WebServlet("/mailServlet")
public class mailServlet extends HttpServlet {
    private UserService userService = new UserServletImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/change.jsp").forward(request,response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        System.out.println(mail);
        try {
            this.main(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.doGet(request,response);

    }
    public static void main(String to) throws Exception {
        String txt="请点击此处继续修改密码\nhttp://localhost:8080/brand-case/user login.jsp";
        String from = "3089802115@qq.com";// 发件人的电子邮件
        String host = "smtp.qq.com";// 邮件服务器，每个邮箱公司不同
        String use = "3089802115@qq.com";// 使用的邮箱账号
        System.out.println("sss");
        String pas = "pitegijpccicdegc";// 使用的邮箱授权码，需要在个人邮箱设置中打开
        Properties properties = System.getProperties();// 获取系统属性对象
        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.put("mail.smtp.auth", "true");// 开启邮件服务器验证
        Session mailSession = Session.getDefaultInstance(properties);// 获取默认的Session对象。
        MimeMessage message = new MimeMessage(mailSession);   // 创建一个默认的MimeMessage对象。
        message.setFrom(new InternetAddress(from));   // 设置 From: 头部的header字段
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));   // 设置 To: 头部的header字段
        message.setSubject("youyou杂货铺");   // 设置 Subject: header字段
        message.setText(txt);   // 现在设置的实际消息
        Transport transport = mailSession.getTransport("smtp");   // 开始验证
        transport.connect(host, use, pas);//链接邮件服务器
        transport.sendMessage(message, message.getAllRecipients());//发送邮件
        transport.close();//关闭链接
    }
}