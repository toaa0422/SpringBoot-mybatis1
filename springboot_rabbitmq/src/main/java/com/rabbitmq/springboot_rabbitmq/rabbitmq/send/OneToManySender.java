package com.rabbitmq.springboot_rabbitmq.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName OneToManySender
 * @Author Smith
 * @Date 2019/1/25 14:10
 * @Description TODO
 * @Version 4.1
 */
@Component
public class OneToManySender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(int i){
        String context = "oneToMany Spring Boot queue + " + " *********** " + i;
        System.out.println("Sender2 : " + context);
        this.rabbitmqTemplate.convertAndSend("oneToMany", context);
    }
}
