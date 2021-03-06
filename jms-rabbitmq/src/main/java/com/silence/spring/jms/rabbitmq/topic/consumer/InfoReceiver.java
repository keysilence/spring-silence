package com.silence.spring.jms.rabbitmq.topic.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Silence on 2018/5/14.
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}", type = ExchangeTypes.TOPIC),
                key = "*.info.#"))
public class InfoReceiver {

    @RabbitHandler
    public void receive(String msg) {

        System.out.println(msg);

    }

}
