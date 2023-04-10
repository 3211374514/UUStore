package com.gaoming.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.gaoming.pojo.Brand;
import com.gaoming.service_20211015_114634.BrandService;
import com.gaoming.service_20211015_114634.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //2.转为Brand对象
        Brand brand = JSON.parseObject(params,Brand.class);
        //调用add
        brandService.add(brand);
        //成功表示
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
