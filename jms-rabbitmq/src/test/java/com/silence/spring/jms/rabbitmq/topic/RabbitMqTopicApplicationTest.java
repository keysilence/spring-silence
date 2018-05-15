package com.silence.spring.jms.rabbitmq.topic;

import com.silence.spring.jms.rabbitmq.topic.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Silence on 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqTopicApplication.class)
public class RabbitMqTopicApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    public void send() throws InterruptedException {

        while (true) {
            Thread.sleep(1000);
            sender.send();
        }


    }

}
