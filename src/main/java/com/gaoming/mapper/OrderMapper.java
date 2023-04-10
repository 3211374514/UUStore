package com.gaoming.mapper;

import com.gaoming.pojo.Brand;
import com.gaoming.pojo.BrandNameBean;
import com.gaoming.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    /**
     * 查询数据
     * @return
     */
    @Select("SELECT * FROM tb_brand,tb_order WHERE tb_brand.brand_name = tb_order.brand_name;")
    @ResultMap("orderResultMap")
    List<Order> selectAll();




    /**
     * 添加数据
     * @param order
     */
    @Insert("insert into tb_order values(NOW(),#{brandName},#{orderSum},#{orderPeople},#{userName},#{beiZhu},null)")
    void add(Order order);

    /**
     * 修改数据
     * @param order
     */
    @Update("update tb_order set brand_name=#{brandName},orderSum=#{orderSum},orderPeople=#{orderPeople},beiZhu=#{beiZhu} where orderId =#{orderId}")
    @ResultMap("orderResultMap")
    void update(Order order);


    /**
     * 删除数据
     * @param orderId
     */
    @Delete("delete from tb_order where orderId = #{orderId}")
    void deleteByOrderId(int orderId);


    /**
     * 根据条件查找数据
     * @param order
     * @return
     */


    List<Order> selectByCondition(@Param("order") Order order);

    /**
     * 查找商品剩余库存
     * @param order
     * @return
     */
    @Select("select ordered from tb_brand where brand_name = #{brandName}")
    Integer selectOrdered(Order order);


    //List<Order> selectBrandNameByCondition(@Param("order") Order order);




}
