package com.rbcdemo.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImp<K, V> implements RedisService<K, V> {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public V get(K key) {
        boolean haskey = redisTemplate.hasKey(key);
        if (!haskey)
            return null;
        else {
            ValueOperations operations = redisTemplate.opsForValue();
            Object op= operations.get(key);
            return (V) operations.get(key);
        }
    }

    @Override
    public V getAndSet(K var1, V var2) {
        boolean haskey = redisTemplate.hasKey(var1);
        if (!haskey)
            return null;
        else {
            ValueOperations operations = redisTemplate.opsForValue();
            String redisStr = (String) operations.getAndSet(var1, var2);
            Type type = new TypeToken<V>() {
            }.getType();
            V resvalue = new Gson().fromJson(redisStr, type);
            return resvalue;
        }
    }

    @Override
    public void set(K var1, V var2) {
        boolean haskey = redisTemplate.hasKey(var1);
        if (haskey)
            redisTemplate.delete(var1);
        else {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(var1, var2);
        }
    }

    @Override
    public void set(K var1, V var2, long var3, TimeUnit var5) {
        boolean haskey = redisTemplate.hasKey(var1);
        if (haskey)
            redisTemplate.delete(var1);
        else {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(var1, var2, var3, var5);
        }
    }

    @Override
    public Long increment(K var1) {
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.increment(var1);
    }

    @Override
    public Long increment(K var1, long var2) {
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.increment(var1, var2);
    }

    @Override
    public Double increment(K var1, double var2) {
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.increment(var1, var2);
    }

    @Override
    public Long decrement(K var1) {
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.decrement(var1);
    }

    @Override
    public Long decrement(Object var1, long var2) {
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.decrement(var1, var2);
    }

    @Override
    public boolean delete(K var1) {
        boolean haskey = redisTemplate.hasKey(var1);
        if (!haskey)
            return true;
        return redisTemplate.delete(var1);
    }
}
