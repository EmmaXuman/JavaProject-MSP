package com.rbcdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

public class RedisServiceImp<K,V> implements RedisService{
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String key) {
       boolean haskey=  redisTemplate.hasKey(key);
       if(!haskey)
        return null;
       else
       {
           ValueOperations operations = redisTemplate.opsForValue();
           String redisList = (String) operations.get(key);
           return redisList;
       }
    }

    @Override
    public Object getAndSet(Object var1, Object var2) {
        return null;
    }

    @Override
    public void set(Object var1, Object var2) {

    }

    @Override
    public void set(Object var1, Object var2, long var3, TimeUnit var5) {

    }

    @Override
    public Long increment(Object var1) {
        return null;
    }

    @Override
    public Long increment(Object var1, long var2) {
        return null;
    }

    @Override
    public Double increment(Object var1, double var2) {
        return null;
    }

    @Override
    public Long decrement(Object var1) {
        return null;
    }

    @Override
    public Long decrement(Object var1, long var2) {
        return null;
    }
}
