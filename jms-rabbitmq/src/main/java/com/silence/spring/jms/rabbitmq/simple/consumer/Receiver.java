package com.silence.spring.jms.rabbitmq.simple.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Silence on 2018/5/14.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "hello-queue")
    public void receive(String msg) {

        System.out.println(msg);

    }

}
