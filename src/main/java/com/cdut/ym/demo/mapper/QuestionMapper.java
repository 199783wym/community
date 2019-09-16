package com.cdut.ym.demo.mapper;

import com.cdut.ym.demo.dto.QuestionDTO;
import com.cdut.ym.demo.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/11 10:07
 * @Version 1.0
 */
@Mapper
public interface QuestionMapper {
    @Insert("Insert into question (title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
    @Select("Select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset")Integer  offset, @Param(value = "size")Integer size);
    @Select("select count(1) from question")
    Integer count();

    @Select("Select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId")Integer userId,@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId")Integer userId);

    @Select("Select * from question where id =#{id}")
    Question getById(@Param("id") Integer id);

    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id=#{id}")
    void update(Question question);
}

