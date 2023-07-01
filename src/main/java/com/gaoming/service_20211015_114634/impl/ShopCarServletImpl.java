package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.OrderMapper;
import com.gaoming.mapper.ShopCarMapper;
import com.gaoming.pojo.ShopCar;
import com.gaoming.service_20211015_114634.ShopCarService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ShopCarServletImpl implements ShopCarService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();




    @Override
    public List<ShopCar> selectAll( ) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);

        //4.调用方法
        List<ShopCar> shopCars = mapper.selectAll();
        //释放资源
        sqlSession.close();

        return shopCars;
    }

    @Override
    public void add(ShopCar shopcar) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
        //4.调用方法
        mapper.add(shopcar);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public void add2(ShopCar shopcar) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
        //4.调用方法
        mapper.add2(shopcar);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public void updateOrdered(ShopCar shopcar) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
        //4.调用方法
        mapper.updateOrdered(shopcar);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByName(String brandName) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
        //4.调用方法
        mapper.deleteByName(brandName);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public List<ShopCar> selectAllByCustomer(String customer) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
        //4.调用方法
        List<ShopCar> shopCars = mapper.selectAllByCustomer(customer);
        //5.释放资源
        sqlSession.close();
        return shopCars;

    }


}
