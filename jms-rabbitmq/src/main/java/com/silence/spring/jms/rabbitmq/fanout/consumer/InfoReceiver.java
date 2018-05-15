package com.silence.spring.jms.rabbitmq.fanout.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Silence on 2018/5/14.
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "", autoDelete = "true"),
        exchange = @Exchange(value="${mq.config.exchange.fanout}", type = ExchangeTypes.FANOUT)))
public class InfoReceiver {

    @RabbitHandler
    public void receive(String msg) {

        System.out.println("Receive Info Log:" + msg);

    }

}
