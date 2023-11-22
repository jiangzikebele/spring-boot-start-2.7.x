package com.example.util;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 新增或更新键值对
    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 新增或更新键值对,转String再存储
    public void setStringValue(String key, Object value) {
        value = JSON.toJSONString(value);
        redisTemplate.opsForValue().set(key, value);
    }

    // 新增或更新键值对，并设置过期时间（秒）
    public void setValueWithExpiration(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    // 获取键对应的值
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 获取键对应的值,class
    public <T> T getClassValue(String key, Class<T> clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value != null && value instanceof String) {
            value = JSON.parseObject((String) value, clazz);
            return clazz.cast(value);
        }
        return null;
    }

    // 获取键对应的值,List-class
    public <T> List<T> getListValue(String key, Class<T> clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value != null && value instanceof String) {
            return JSON.parseArray((String) value, clazz);
        }
        return null;
    }

    // 删除指定键
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    // 设置键的过期时间（秒）
    public boolean setExpiration(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    // 获取键的剩余过期时间（秒）
    public long getExpiration(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
}
