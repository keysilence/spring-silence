package com.silence.spring.jms.rabbitmq.simple.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Silence on 2018/5/14.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    public void send() {

        String msg = "hello";
        this.rabbitMqTemplate.convertAndSend("hello-queue", msg);

    }

}
