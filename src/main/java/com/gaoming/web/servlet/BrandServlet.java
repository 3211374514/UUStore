package com.gaoming.web.servlet;


import com.alibaba.fastjson.JSON;
import com.gaoming.pojo.Brand;
import com.gaoming.pojo.PageBean;
import com.gaoming.service_20211015_114634.BrandService;
import com.gaoming.service_20211015_114634.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    /**
     * 读取全部数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @return
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands = brandService.selectAll();

        System.out.println(brands);



        //2.转为JSON
        String jsonString = JSON.toJSONString(brands);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    public void selectAll2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取查询条件对象
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //2.转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);


        //2.调用service查询
        //PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        PageBean<Brand> pageBean1 = brandService.selectAll2(brand);
        System.out.println(brand);

        //2.转为JSON
        String jsonString = JSON.toJSONString(pageBean1);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //2.转为Brand对象
        Brand brand = JSON.parseObject(params,Brand.class);
        Integer ordered = brand.getOrdered();
        if(ordered <= 0){
            brand.setOrdered(0);
            brand.setStatus(0);
        }else{
            brand.setStatus(1);
        }
        //调用add
        brandService.add(brand);
        //成功表示
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //2.转为int[]对象
        int[] ids = JSON.parseObject(params, int[].class);
        //调用deleteByIds方法
        brandService.deleteByIds(ids);
        //成功表示
        response.getWriter().write("success");
    }

    /**
     * 分页查找
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据 当前页码 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");


        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);



        //2.调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);


        //2.转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据 当前页码 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");


        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        //获取查询条件对象
        //1.接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //2.转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);


        //2.调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        System.out.println(currentPage);
        System.out.println(pageSize);
        System.out.println(brand);

        //2.转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 获取输入流，接收品牌数据json字符串
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将json字符串转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        Integer id = brand.getId();
        String brandName = brand.getBrandName();
        String companyName = brand.getCompanyName();
        String description = brand.getDescription();
        Integer ordered = brand.getOrdered();
        Integer status = brand.getStatus();
        Float price = brand.getPrice();
        String image = brand.getImage();


        Brand b = new Brand();
        b.setId(id);
        b.setBrandName(brandName);
        b.setCompanyName(companyName);
        b.setDescription(description);
        b.setPrice(price);
        b.setImage(image);
        //b.setStatus(status);
        if(ordered <= 0){
            b.setOrdered(0);
            b.setStatus(0);
        }else{
            b.setOrdered(ordered);
            b.setStatus(1);
        }
        //2. 调用service更新
        brandService.update(b);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }











}



