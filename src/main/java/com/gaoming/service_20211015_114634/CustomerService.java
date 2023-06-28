package com.gaoming.service_20211015_114634;

import com.gaoming.pojo.Customer;

public interface CustomerService {

        /**
        * 根据用户名和密码查询
        * @param username
        * @param password
        * @return
        */
        Customer login(String username, String password);

        /**
         * 用户注册
         * @param customer
         * @return
         */
        boolean register(Customer customer);

        /**
         * 修改密码
         * @param username
         * @param password
         * @param repassword
         * @return
         */
        boolean update(String username,String password, String repassword);



}
