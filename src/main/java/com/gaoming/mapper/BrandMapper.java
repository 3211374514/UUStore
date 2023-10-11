package com.gaoming.mapper;

import com.gaoming.pojo.Brand;
import com.gaoming.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    @Select("select * from tb_brand where brand_name = #{brandName}")
    List<Brand> selectByBrandName(String brandName);

    //查询所有

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * mainpage查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll2(Brand brand);

    /**
     * 添加数据
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status},#{price},4,null)")
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);



    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();



    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand")Brand brand);

    /**
     * 根据条件查询总记录数
     * @param brand
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

    /**
     * 修改数据
     * @param brand
     */
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},`description`=#{description},`status`=#{status},`price`=#{price},`image`=#{image} where id =#{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);




}
