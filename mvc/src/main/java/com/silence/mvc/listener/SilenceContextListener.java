package com.silence.mvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Silence on 2018/4/2.
 */
public class SilenceContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        String value = servletContextEvent.getServletContext().getInitParameter("contextKey");
        //contextValue
        System.out.println(value);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
