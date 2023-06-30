package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.FeedbackMapper;
import com.gaoming.pojo.Feedback;
import com.gaoming.service_20211015_114634.FeedbackService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class FeedbackServletImpl implements FeedbackService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public void Onsend(String contact, String information) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取customerMapper
        FeedbackMapper mapper = sqlSession.getMapper(FeedbackMapper.class);


        //4.调用方法
        mapper.add(contact,information);
        sqlSession.commit();
        sqlSession.close();
    }
}
