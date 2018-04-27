package com.silence.ioc.initializing;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Silence on 2018/4/24.
 */
public class MyInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean！");
    }

}
