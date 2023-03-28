package com.song.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class messageTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

//    @Test
//    public void Test1(){
//        ValueOperations<String, String> forValue = redisTemplate.opsForValue();
//        String validateCodeInRedis = forValue.get("16600233623");
//        System.out.println(validateCodeInRedis);
//    }
}
