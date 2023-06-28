package com.gaoming.service_20211015_114634.impl;

import com.gaoming.mapper.CustomerMapper;
import com.gaoming.pojo.Customer;
import com.gaoming.service_20211015_114634.CustomerService;
import com.gaoming.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CustomerServiceImpl implements CustomerService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public Customer login(String username, String password) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取customerMapper
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //4.调用方法
        Customer customer = mapper.login(username, password);
        //5.释放资源
        sqlSession.close();
        return customer;
    }
    @Override
    public boolean register(Customer customer) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取customerMapper
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //4.调用方法
        Customer c = mapper.selectByUsername(customer.getUsername());
        //5.判断
        if(c == null){
            //用户不存在
            mapper.add(customer);
            sqlSession.commit();
        }
        sqlSession.close();
        return c == null;
    }
    @Override
    public boolean update(String username,String password, String repassword) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取customerMapper
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //4.调用方法
        Customer c = mapper.selectByUsername(username);
        //5.判断
        if(c != null){
            //用户存在
            if(c.getPassword().equals(password)){
                //密码正确
                mapper.update(username,password, repassword);
                sqlSession.commit();
                return true;

            }
        }
        sqlSession.close();
        return false;
    }

}
