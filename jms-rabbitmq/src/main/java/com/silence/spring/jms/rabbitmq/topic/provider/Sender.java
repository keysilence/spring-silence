package com.silence.spring.jms.rabbitmq.topic.provider;

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

    @Value("${mq.config.exchange}")
    private String exchange;

    @Value("${mq.config.queue.debug.routing.key}")
    private String routingKeyDebug;

    @Value("${mq.config.queue.info.routing.key}")
    private String routingKeyInfo;

    @Value("${mq.config.queue.warn.routing.key}")
    private String routingKeyWarn;

    @Value("${mq.config.queue.error.routing.key}")
    private String routingKeyError;

    public void send() {

        String msg = "hello log ";
        this.rabbitMqTemplate.convertAndSend(exchange, routingKeyDebug, msg + "debug");
        this.rabbitMqTemplate.convertAndSend(exchange, routingKeyInfo, msg + "info");
        this.rabbitMqTemplate.convertAndSend(exchange, routingKeyWarn, msg + "warn");
        this.rabbitMqTemplate.convertAndSend(exchange, routingKeyError, msg + "error");

    }

}
