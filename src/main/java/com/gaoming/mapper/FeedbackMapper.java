package com.gaoming.mapper;

import org.apache.ibatis.annotations.Insert;
import com.gaoming.pojo.Feedback;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {
    /**
     * 添加用户
     * @param contact
     * @param information
     */
    @Insert("insert into tb_feedback values(null,#{contact},#{information})")
    void add(@Param("contact") String contact , @Param("information") String information);
}
