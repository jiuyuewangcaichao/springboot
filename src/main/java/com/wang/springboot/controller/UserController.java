package com.wang.springboot.controller;

import com.wang.springboot.pojo.User;
import com.wang.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable int id){
        System.out.println(userService.Sel(id).toString());
        return userService.Sel(id);
    }

    @RequestMapping("getUserName/{userName}")
    public User getUserName(@PathVariable("userName") String userName){
        System.out.println("----------jingru");
        System.out.println(userService.query(userName).toString());
        return userService.query(userName);
    }

    @RequestMapping("/noauth")
    public  String uthorized(){
        return "为筹权";
    }


}
