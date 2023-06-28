package com.gaoming.mapper;

import com.gaoming.pojo.Customer;
import org.apache.ibatis.annotations.*;

public interface CustomerMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_customer where username = #{username} and password = #{password}")
    Customer login(@Param("username") String username, @Param("password")  String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from tb_customer where username = #{username}")
    Customer selectByUsername(String username);

    /**
     * 添加用户
     * @param customer
     */
    @Insert("insert into tb_customer values(null,#{username},#{password})")
    void add(Customer customer);

    /**
     * 修改密码
     * @param username
     * @param password
     * @param repassword
     */
    @Update("update tb_customer set password = #{repassword} where username = #{username} and password = #{password}")
    void update(@Param("username")String username, @Param("password")String password,@Param("repassword") String repassword);
}
