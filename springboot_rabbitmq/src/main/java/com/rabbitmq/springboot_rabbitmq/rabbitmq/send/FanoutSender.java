package com.rabbitmq.springboot_rabbitmq.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FanoutSender
 * @Author Smith
 * @Date 2019/1/25 16:09
 * @Description TODO
 * @Version 4.1
 */
@Configuration
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

}
