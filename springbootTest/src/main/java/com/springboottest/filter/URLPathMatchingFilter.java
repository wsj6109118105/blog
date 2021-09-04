package com.springboottest.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * user:lufei
 * DATE:2021/9/4
 **/
public class URLPathMatchingFilter extends PathMatchingFilter {
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //放行OPTIONS请求
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())){
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            System.out.println("存在OPTIONS请求");
            return true;
        }

        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            System.out.println("需要登录");
            return false;
        }else {
            System.out.println("登录成功");
            return true;
        }

    }
}
