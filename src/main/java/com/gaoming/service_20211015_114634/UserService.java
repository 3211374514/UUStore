package com.gaoming.service_20211015_114634;

import com.gaoming.pojo.User;

public interface UserService {

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);


    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);

}
