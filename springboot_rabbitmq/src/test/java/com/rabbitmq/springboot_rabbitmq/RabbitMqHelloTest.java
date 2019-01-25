package com.rabbitmq.springboot_rabbitmq;

import com.rabbitmq.springboot_rabbitmq.rabbitmq.send.ManyToMany;
import com.rabbitmq.springboot_rabbitmq.rabbitmq.send.MessageSender;
import com.rabbitmq.springboot_rabbitmq.rabbitmq.send.OneToManySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RabbitMqHelloTest
 * @Author Smith
 * @Date 2019/1/25 13:54
 * @Description TODO
 * @Version 4.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private MessageSender messageSender;

    @Test
    public void testMessageSend() throws InterruptedException {
        messageSender.send();
        Thread.sleep(1000);
    }

    @Autowired
    private OneToManySender oneToManySender;

    @Test
    public void oneToMany() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            oneToManySender.send(i);
        }
        Thread.sleep(10000l);
    }

    @Autowired
    private ManyToMany manyToMany;

    @Test
    public void manyToMany() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            oneToManySender.send(i);
            manyToMany.send(i);
        }
        Thread.sleep(10000l);
    }
}
