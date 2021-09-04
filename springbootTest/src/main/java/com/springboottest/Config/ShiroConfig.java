package com.springboottest.Config;

import com.springboottest.filter.URLPathMatchingFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * user:lufei
 * DATE:2021/9/3
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainMap = new LinkedHashMap<>();
        Map<String, Filter> customizedFilter = new HashMap<>();
        customizedFilter.put("url",getUrlPathMatchingFilter());
        filterChainMap.put("/login","anon");
        filterChainMap.put("/index","anon");
        filterChainMap.put("/article/**","anon");
        //filterChainMap.put("/articledetails/**","anon");
        filterChainMap.put("/file/**","anon");
        filterChainMap.put("/**","url");
        shiroFilterFactoryBean.setFilters(customizedFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        return shiroFilterFactoryBean;
    }
    @Bean("securityManager")
    public SecurityManager securityManager(MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }
    @Bean("myRealm")
    public MyRealm getMyRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    public URLPathMatchingFilter getUrlPathMatchingFilter(){
        return new URLPathMatchingFilter();
    }
}
