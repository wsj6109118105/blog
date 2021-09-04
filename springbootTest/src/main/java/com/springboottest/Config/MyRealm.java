package com.springboottest.Config;

import com.springboottest.Service.UserService;
import com.springboottest.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * user:lufei
 * DATE:2021/9/3
 **/
public class MyRealm extends AuthenticatingRealm {
    @Autowired
    UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(token.getPrincipal()==null){
            return null;
        }
        String username = (String) token.getPrincipal();
        User user = userService.getByName(username);
        System.out.println(user);
        if(user==null){
            return null;
        }else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            return simpleAuthenticationInfo;
        }
    }
}
