package com.gaoming.web.servlet;


import com.alibaba.fastjson.JSON;
import com.gaoming.pojo.*;
import com.gaoming.service_20211015_114634.BrandService;
import com.gaoming.service_20211015_114634.OrderService;
import com.gaoming.service_20211015_114634.impl.BrandServiceImpl;
import com.gaoming.service_20211015_114634.impl.OrderServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServletImpl();

    //
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.调用service查询

        List<Order> orders = orderService.selectAll();

        System.out.println(orders);



        //2.转为JSON
        String jsonString = JSON.toJSONString(orders);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }



    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        //BufferedReader br = request.getReader();
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.接受session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        //2.转为Brand对象
        Order order = JSON.parseObject(params, Order.class);
        order.setUserName(user.getUsername());
        System.out.println(order);
        //调用add
        orderService.add(order);
        //成功表示
        response.getWriter().write("success");
    }



    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 获取输入流，接收品牌数据json字符串
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将json字符串转为brand对象
        Order order = JSON.parseObject(params, Order.class);


        //2. 调用service更新
        orderService.update(order);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }


    public void verifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.接受session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        //2.转为Order对象
        Order order = JSON.parseObject(params, Order.class);
        System.out.println(order);
        System.out.println(user.getUsername());
        System.out.println(order.getUserName());
        //order.setUserName(user.getUsername());
        if(user.getUsername().equals(order.getUserName())){
            //成功表示
            response.getWriter().write("success");
        }
        else {
            response.getWriter().write("erro");
        }

    }

    public void deleteByOrderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.转为Order对象
        Order order = JSON.parseObject(params, Order.class);

        //调用deleteByOrderId
        orderService.deleteByOrderId(order.getOrderId());
        //成功表示
        response.getWriter().write("success");
    }


    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.转为Brand对象
        Order order = JSON.parseObject(params, Order.class);

        System.out.println(order);
        //调用
       //List<Order> orders1 = orderService.selectBrandNameByCondition(order);
        //System.out.println(brandName);
        //System.out.println("这是一个句子");
        List<Order> orders = orderService.selectByCondition(order);
        //System.out.println(orders);

        //成功表示
        //response.getWriter().write("success");


        //2.转为JSON
        String jsonString = JSON.toJSONString(orders);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    /**
     * 查找商品剩余库存
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectOrdered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.转为Brand对象
        Order order = JSON.parseObject(params, Order.class);

        //调用add
        Integer ordered = orderService.selectOrdered(order);
        System.out.println(ordered);
        System.out.println(order.getOrderSum());

        if(ordered >= order.getOrderSum()){
            //成功表示
            response.getWriter().write("success");
        }else{
            response.getWriter().write("erro");
        }

    }






}



