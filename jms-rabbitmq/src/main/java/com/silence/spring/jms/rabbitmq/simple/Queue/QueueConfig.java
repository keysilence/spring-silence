package com.silence.spring.jms.rabbitmq.simple.Queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Silence on 2018/5/14.
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue queue() {

        return new Queue("hello-queue");

    }

}
