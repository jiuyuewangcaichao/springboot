package com.wang.springboot.config;

import com.wang.springboot.controller.UserController;
import com.wang.springboot.pojo.User;
import com.wang.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import static java.awt.SystemColor.info;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserController userController;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权。。。。。");
//        SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
//        Subject subject = SecurityUtils.getSubject();
//        User current =(User) subject.getPrincipal();
//        info.addStringPermission(current.getRealName());
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证。。。。");
        //获取当前的用户
//        Subject subject = SecurityUtils.getSubject();
        //封装

        UsernamePasswordToken userToken=(UsernamePasswordToken)token;
        String userName =userToken.getUsername();
        User user=userController.getUserName(userName);
        if (user ==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassWord(),"");
    }
}
