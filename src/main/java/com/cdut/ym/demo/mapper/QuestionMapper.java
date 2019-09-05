package com.cdut.ym.demo.mapper;

import com.cdut.ym.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    List<Question> list(@Param(value = "offset")Integer  offest, @Param(value = "size")Integer size);
    @Select("select count(1) from question")
    Integer count();
}

