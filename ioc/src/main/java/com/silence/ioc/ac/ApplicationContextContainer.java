package com.silence.ioc.ac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Silence on 2018/4/23.
 */
public class ApplicationContextContainer {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContextTest applicationContextTest = (ApplicationContextTest) applicationContext.getBean("ac");
        applicationContextTest.getMessage();

    }

}
