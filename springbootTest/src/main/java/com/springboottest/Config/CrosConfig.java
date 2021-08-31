package com.springboottest.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * user:lufei
 * DATE:2021/8/16
 **/
@Configuration
@EnableWebMvc
public class CrosConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                //这里：是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                //跨域允许时间
                .allowedHeaders("*")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + "d:/2021/springboot+vue/img/");
    }
}
