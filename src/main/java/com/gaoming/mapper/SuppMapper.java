package com.gaoming.mapper;

import com.gaoming.pojo.Brand;
import com.gaoming.pojo.Order;
import com.gaoming.pojo.Supp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SuppMapper {

    /**
     * 查询数据
     * @return
     */
    @Select("SELECT * FROM tb_supp")
    @ResultMap("suppResultMap")
    List<Supp> selectAll();


    /**
     * 添加数据
     * @param supp
     */
    @Insert("insert into tb_supp values(#{companyName},#{phone},#{province},#{city},#{address},null,#{zip},#{beiZhu})")
    void add(Supp supp);



}
