package com.silence.spring.jms.rabbitmq.topic.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Silence on 2018/5/14.
 * key *只能匹配一个单词；#可以匹配多个单词（或者零个）
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.debug}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}", type = ExchangeTypes.TOPIC),
                key = "*.debug.#"))
public class DebugReceiver {

    @RabbitHandler
    public void receive(String msg) {

        System.out.println(msg);

    }

}
