package com.example.emailback.service;

import com.example.emailback.entity.User;
import com.example.emailback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    //登录
    public User selectByName(String userName){
        return userMapper.getUserByName(userName);
    }

    //注册
    public int insert(User user){
        return userMapper.addUser(user);
    }

    //修改密码
    public int update(User passwd){
        return userMapper.updatePasswd(passwd);
    }

}
