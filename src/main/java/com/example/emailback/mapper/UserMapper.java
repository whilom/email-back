package com.example.emailback.mapper;

import com.example.emailback.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据用户名查询用户(登录)
    @Select("select * from user where binary userName = #{userName}")
    public User getUserByName(String userName);

    //添加用户账号、密码(注册)
    @Insert("insert into user (userName,passwd,status,registTime)  values (#{userName}, #{passwd}, #{status}, #{registTime})")
    public int addUser(User user);

    //修改密码
    @Update("update user set passwd = #{passwd} where binary userName = #{userName}")
    public int updatePasswd(User passwd);
}
