package com.silence.ioc.bf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Silence on 2018/4/20.
 */
public class BeanFactoryContainer {

    public static void main(String[] args) throws Exception {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        BeanFactoryTest beanFactoryTest = (BeanFactoryTest) beanFactory.getBean("bf");
        beanFactoryTest.getMessage();

    }

}
