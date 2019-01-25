package com.rabbitmq.springboot_rabbitmq.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessageReceive
 * @Author Smith
 * @Date 2019/1/25 13:53
 * @Description receive message
 * @Version 4.1
 */
@Component
@RabbitListener(queues = "hello")
public class MessageReceive {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
