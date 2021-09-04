package com.springboottest.Controller;

import com.springboottest.Result.Result;
import com.springboottest.Service.UserService;
import com.springboottest.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * user:lufei
 * DATE:2021/8/16
 **/
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        UsernamePasswordToken token = new UsernamePasswordToken(requestUser.getUsername(),requestUser.getPassword());
        Subject subject = SecurityUtils.getSubject();
        System.out.println(token);
        try {
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            System.out.println("密码错误");
            return new Result(400);
        }catch (UnknownAccountException use){
            System.out.println("账号不存在");
            return new Result(400);
        }catch (AuthenticationException ae){
            System.out.println("状态不正常");
            return new Result(400);
        }
        System.out.println(subject.getSession());
        if(subject.isAuthenticated()){
            System.out.println("认证成功");
            return new Result(200);
        }else {
            token.clear();
            return new Result(400);
        }



        /*User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            return new Result(400);
        } else {
            return new Result(200);
        }*/
    }
}
