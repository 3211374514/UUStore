package com.gaoming.web.servlet;


import com.alibaba.fastjson.JSON;
import com.gaoming.pojo.*;
import com.gaoming.service_20211015_114634.ShopCarService;
import com.gaoming.service_20211015_114634.impl.ShopCarServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/shopcar/*")
public class ShopCarServlet extends BaseServlet{
    private ShopCarService shopcarService = new ShopCarServletImpl();

    //
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码问题
        request.setCharacterEncoding("utf-8");
//        //1. 获取输入流，接收品牌数据json字符串
//        BufferedReader br = request.getReader();
//        String params = br.readLine();
//
//        //将json字符串转为brand对象
//        Brand brand = JSON.parseObject(params, Brand.class);
//
//        System.out.println(brand);
        //1.调用service查询

        List<ShopCar> shopcars = shopcarService.selectAll();

        System.out.println(shopcars);

        //2.转为JSON
        String jsonString = JSON.toJSONString(shopcars);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    //添加数据
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        //BufferedReader br = request.getReader();
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.接受session
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        System.out.println(customer);

        //2.转为Brand对象
        //Supp supp = JSON.parseObject(params, Supp.class);
        ShopCar shopcar = JSON.parseObject(params, ShopCar.class);
        shopcar.setCustomer(customer.getUsername());
        System.out.println(shopcar);
        //调用add
        shopcarService.add(shopcar);
        //成功表示
        response.getWriter().write("success");
    }






}



