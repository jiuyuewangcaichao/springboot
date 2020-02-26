package com.wang.springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RouterController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello....";
    }

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id")int id){
        return "views/level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id")int id){
        return "views/level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id")int id){
        return "views/level3/"+id;
    }

    @RequestMapping("user/add")
    public String add(){ return "user/add"; }

    @RequestMapping("user/update")
    public String update(){ return "user/update"; }

    @RequestMapping("user/login")
    public String login(String username,String password){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);//执行登陆方法 如果没有异常
            return "index";
        }catch (Exception e){
            System.out.println("用户名错误");
            return "views/login";
        }
    }




}
