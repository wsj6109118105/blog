package com.springboottest.Controller;

import com.springboottest.Result.Result;
import com.springboottest.Service.UserService;
import com.springboottest.pojo.User;
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

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
