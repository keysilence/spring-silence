package com.silence.spring.jms.rabbitmq.fanout;

import com.silence.spring.jms.rabbitmq.fanout.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Silence on 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqFanoutApplication.class)
public class RabbitMqFanoutApplicationTest {

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
