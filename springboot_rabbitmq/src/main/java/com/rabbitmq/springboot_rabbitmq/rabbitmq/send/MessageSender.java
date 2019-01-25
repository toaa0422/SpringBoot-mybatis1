package com.rabbitmq.springboot_rabbitmq.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MessageSender
 * @Author Smith
 * @Date 2019/1/25 13:48
 * @Description Sender Message
 * @Version 4.1
 */
@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void send(){
        String context = "hello " + format.format(new Date());
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

}
