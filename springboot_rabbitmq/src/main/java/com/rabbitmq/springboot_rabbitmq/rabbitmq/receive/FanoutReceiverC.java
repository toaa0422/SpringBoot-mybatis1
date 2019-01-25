package com.rabbitmq.springboot_rabbitmq.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutReceiverA
 * @Author Smith
 * @Date 2019/1/25 16:10
 * @Description TODO
 * @Version 4.1
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver C: " + message);
    }
}
