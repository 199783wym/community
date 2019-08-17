package com.cdut.ym.demo.mapper;

import com.cdut.ym.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ym
 * @Date: 2019/7/14 16:57
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified}" +
            ",#{avatarUrl})")
    void insert(User user);
    @Select("select * from  user where token= #{token}")
    User findByToken(@Param("token")String token);
    @Select("select * from  user where id= #{id}")
    User findById(@Param("id")Integer id);
}
