package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.UserMapper;
import com.gaoming.pojo.User;
import com.gaoming.service_20211015_114634.UserService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServletImpl implements UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用方法
        User user = mapper.login(username, password);
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();

        return user;
    }

    @Override
    public boolean register(User user) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用方法
        User u = mapper.selectByUsername(user.getUsername());
        //5.判断
        if(u == null){
            //用户不存在
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;


    }


}
