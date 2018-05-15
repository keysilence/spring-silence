package com.silence.spring.jms.rabbitmq.simple;

import com.silence.spring.jms.rabbitmq.simple.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Silence on 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqApplication.class)
public class RabbitMqApplicationTest {

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
