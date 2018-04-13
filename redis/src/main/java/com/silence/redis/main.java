package com.silence.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Silence on 2018/4/13.
 */
public class main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisUtil redisUtil = (RedisUtil) applicationContext.getBean("redisClient");
        redisUtil.set("name", "susan");

    }

}
