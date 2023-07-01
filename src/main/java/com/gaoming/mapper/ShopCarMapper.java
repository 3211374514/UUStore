package com.gaoming.mapper;

import com.gaoming.pojo.ShopCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopCarMapper {

    /**
     * 查询数据
     * @return
     */
    @Select("SELECT * FROM tb_brand,tb_shopcar WHERE tb_brand.brand_name = tb_shopcar.shop_name;")
    @ResultMap("shopcarResultMap")
    List<ShopCar> selectAll();


    /**
     * 添加数据
     * @param supp
     */

    @Insert("insert into tb_shopcar values(#{brandName},#{companyName},#{price},#{shopSum},#{customer},#{beizhu},NOW(),#{address}) on duplicate key update shop_sum=shop_sum+#{shopSum};")
    @ResultMap("shopcarResultMap")
    void add(ShopCar supp);

    /**
     * 修改备注 地址
     * @param supp
     */
    @Insert("insert into tb_shopcar values(#{brandName},#{companyName},#{price},#{shopSum},#{customer},#{beizhu},NOW(),#{address}) on duplicate key update beizhu = #{beizhu},address = #{address}")
    @ResultMap("shopcarResultMap")
    void add2(ShopCar supp);




    /**
     * 根据用户购买数量修改tb_brand中库存ordered
     * @param shopcar
     */
    @Update("UPDATE tb_brand set ordered = ordered-#{shopSum} WHERE brand_name = #{brandName}")
    void updateOrdered(ShopCar shopcar);


    @Delete("delete from tb_shopcar where shop_name = #{brandName}")
    void deleteByName(String brandName);


}
