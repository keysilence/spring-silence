package com.silence.spring.jms.rabbitmq.direct.provider;

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

    @Value("${mq.config.exchange.direct}")
    private String exchange;

    @Value("${mq.config.queue.info.routing.key}")
    private String routingKeyInfo;

    @Value("${mq.config.queue.info.routing.key}")
    private String routingKeyError;

    public void sendInfo() {

        String msg = "hello direct info";
        this.rabbitMqTemplate.convertAndSend(exchange, routingKeyInfo, msg);

    }

    public void sendError() {

        String msg = "hello direct error";
        this.rabbitMqTemplate.convertAndSend(exchange, routingKeyError, msg);

    }

    public void send() {
        this.sendInfo();
        this.sendError();
    }

}
