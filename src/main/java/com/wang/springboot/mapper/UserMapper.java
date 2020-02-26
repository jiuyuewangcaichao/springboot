package com.wang.springboot.mapper;

import com.wang.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {
    User Sel(int id);

    User queryUser(String userName);
}
