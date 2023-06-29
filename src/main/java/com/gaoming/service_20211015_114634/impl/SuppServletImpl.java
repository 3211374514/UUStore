package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.OrderMapper;
import com.gaoming.mapper.SuppMapper;
import com.gaoming.pojo.Brand;
import com.gaoming.pojo.Order;
import com.gaoming.pojo.Supp;
import com.gaoming.service_20211015_114634.SuppService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SuppServletImpl implements SuppService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();




    @Override
    public List<Supp> selectAll( ) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        SuppMapper mapper = sqlSession.getMapper(SuppMapper.class);

        //4.调用方法
        List<Supp> supps = mapper.selectAll();
        //释放资源
        sqlSession.close();

        return supps;
    }

    @Override
    public void add(Supp supp) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        SuppMapper mapper = sqlSession.getMapper(SuppMapper.class);
        //4.调用方法
        mapper.add(supp);
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();




    }

    @Override
    public List<Supp> selectByCondition(Supp supp) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取suppMapper
        SuppMapper mapper = sqlSession.getMapper(SuppMapper.class);

        //修改模糊条件
        if(supp.getCompanyName()!=null && supp.getCompanyName().length()>0){
            supp.setCompanyName("%"+supp.getCompanyName()+"%");
        }
        if (supp.getAddress()!=null && supp.getAddress().length()>0){
            supp.setAddress("%"+supp.getAddress()+"%");
        }
        //4.调用方法
        List<Supp> supps = mapper.selectByCondition(supp);
        //5.释放资源
        sqlSession.close();
        return supps;
    }





}
