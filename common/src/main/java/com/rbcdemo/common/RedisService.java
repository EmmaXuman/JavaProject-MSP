package com.rbcdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;

import java.util.concurrent.TimeUnit;

public interface RedisService<K,V> {

    V get(String key);

    V getAndSet(K var1, V var2);

    void set(K var1, V var2);

    void set(K var1, V var2, long var3, TimeUnit var5);

    Long increment(K var1);

    Long increment(K var1, long var2);

    Double increment(K var1, double var2);

    Long decrement(K var1);

    Long decrement(K var1, long var2);
}
