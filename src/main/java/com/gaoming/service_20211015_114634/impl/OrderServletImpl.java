package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.BrandMapper;
import com.gaoming.mapper.OrderMapper;
import com.gaoming.pojo.Brand;
import com.gaoming.pojo.BrandNameBean;
import com.gaoming.pojo.Order;
import com.gaoming.service_20211015_114634.OrderService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderServletImpl implements OrderService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<Order> selectAll() {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //4.调用方法
        List<Order> orders = mapper.selectAll();
        //释放资源
        sqlSession.close();

        return orders;
    }



    @Override
    public void add(Order order) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //4.调用方法
        mapper.add(order);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public void update(Order order) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //4.调用方法
        mapper.update(order);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();    }

    @Override
    public void deleteByOrderId(int orderId) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //4.调用方法
        mapper.deleteByOrderId(orderId);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public List<Order> selectByCondition(Order order) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        //处理brand条件，实现模糊表达式
        String s = order.getBrandName();
        if(s != null && s.length() > 0){
            order.setBrandName("%"+s+"%");
        }

        List<Order> orders = mapper.selectByCondition(order);

        sqlSession.close();

        return orders;

    }

    @Override
    public Integer selectOrdered(Order order) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //4.调用方法
        Integer ordered = mapper.selectOrdered(order);
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
        return ordered;
    }




}
