package com.rabbitmq.springboot_rabbitmq.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName TopicReceiver1
 * @Author Smith
 * @Date 2019/1/25 16:01
 * @Description TODO
 * @Version 4.1
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver1  : " + message);
    }

}
