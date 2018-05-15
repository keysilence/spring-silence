package com.silence.spring.jms.rabbitmq.fanout.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Silence on 2018/5/14.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @Value("${mq.config.exchange.fanout}")
    private String exchange;

    public void send() {

        String msg = "hello fanout log ";
        //广播消息不需要路由键
        this.rabbitMqTemplate.convertAndSend(exchange, "", msg + "info");
//        this.rabbitMqTemplate.convertAndSend(exchange, "", msg + "error");

    }

}
