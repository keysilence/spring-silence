package com.silence.ioc.ac;

import com.silence.ioc.initializing.MyInitializingBean;

/**
 * Created by Silence on 2018/4/23.
 */
public class ApplicationContextTest extends MyInitializingBean {

    public void getMessage() {
        System.out.println("Hello Application Context！");
    }

    public void init() {
        System.out.println("Init Method！");
    }

    public void destroy() {
        System.out.println("Destroy Method！");
    }

}
