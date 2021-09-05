package com.springboottest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * user:lufei
 * DATE:2021/9/5
 **/
@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    //设置带过期时间的缓存
    public void set(String key,Object value,long time){
        redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
    }
    //设置缓存
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }
    //根据key获得缓存
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    //根据key删除缓存
    public boolean delete(String key){
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }
    //根据key集合批量删除缓存
    public Long delete(Set<String> keys){
        return redisTemplate.delete(keys);
    }
    //根据正则表达式匹配keys获取缓存
    public Set<String> getKeysByPattern(String pattern){
        return redisTemplate.keys(pattern);
    }
}
