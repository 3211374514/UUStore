package com.gaoming.mapper;

import com.gaoming.pojo.ShopCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopCarMapper {

    /**
     * 查询数据
     * @return
     */
    @Select("SELECT * FROM tb_shopcar")
    @ResultMap("shopcarResultMap")
    List<ShopCar> selectAll();


    /**
     * 添加数据
     * @param supp
     */
    @Insert("insert into tb_shopcar values(null,#{brandName},#{companyName},#{price},#{shopSum},#{customer})")
    void add(ShopCar supp);



}
