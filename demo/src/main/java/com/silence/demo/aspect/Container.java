package com.silence.demo.aspect;

import com.silence.demo.aspect.bussiness.impl.Man;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Silence on 2018/4/25.
 */
public class Container {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aspect.xml");
        Man man = (Man) applicationContext.getBean("man");
        man.say();

    }

}
