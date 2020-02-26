package com.wang.springboot.service;

import com.wang.springboot.mapper.UserMapper;
import com.wang.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public User query(String userName){
        return userMapper.queryUser(userName);
    }
}
