package com.gaoming.service_20211015_114634;

import com.gaoming.pojo.Brand;
import com.gaoming.pojo.PageBean;

import java.util.List;

public interface BrandService {

    //查询所有
    List<Brand> selectAll();
    //PageBean<Brand> selectAll();

    //mainpage查询所有
    PageBean<Brand> selectAll2(Brand brand);

    //添加数据
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds( int[] ids);


    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);



    /**
     * 修改数据
     * @param brand
     */
    void update(Brand brand);


    /**
     * 查找品牌是否已经存在
     * @param brandName
     */
    List<Brand> selectByBrandName(String brandName);


}
