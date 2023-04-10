package com.gaoming.service_20211015_114634;

import com.gaoming.pojo.Brand;
import com.gaoming.pojo.BrandNameBean;
import com.gaoming.pojo.Order;
import com.gaoming.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    //查询所有
    List<Order> selectAll();


    void add(Order order);

    void update(Order order);

    //删除数据
    void deleteByOrderId(int orderId);

    //根据条件查找数据
    List<Order> selectByCondition(Order order);

    //查找库存
    Integer selectOrdered(Order order);





}
