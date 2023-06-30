package com.gaoming.mapper;

import com.gaoming.pojo.ShopCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Insert("insert into tb_shopcar values(#{brandName},#{companyName},#{price},#{shopSum},#{customer}) on duplicate key update shop_sum=shop_sum+#{shopSum}")
    @ResultMap("shopcarResultMap")
    void add(ShopCar supp);

    /**
     * 添加数据，商品已存在时只增加数量
     * @param shopcar
     */
    @Insert("insert into tb_shopcar values(null,#{brandName},#{companyName},#{price},#{shopSum},#{customer})")
    @ResultMap("shopcarResultMap")
    void add2(ShopCar shopcar);

    /**
     * 根据用户购买数量修改tb_brand中库存ordered
     * @param shopcar
     */
    @Update("UPDATE tb_brand set ordered = ordered-#{shopSum} WHERE brand_name = #{brandName}")
    void updateOrdered(ShopCar shopcar);


}
