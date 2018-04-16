package com.silence.mongo;

import com.silence.mongo.dao.TestDao;
import com.silence.mongo.model.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Silence on 2018/4/16.
 */
public class main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mongo.xml");
        TestDao testDao = (TestDao) applicationContext.getBean("testDao");
        try {
            Test test = new Test();
            test.setName("silence");
            testDao.add(test);
            System.out.println(test);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
