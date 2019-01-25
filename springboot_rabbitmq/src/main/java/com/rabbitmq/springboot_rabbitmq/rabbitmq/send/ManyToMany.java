package com.rabbitmq.springboot_rabbitmq.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName ManyToMany
 * @Author Smith
 * @Date 2019/1/25 14:41
 * @Description TODO
 * @Version 4.1
 */
@Component
public class ManyToMany {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(int i){
        String context = "ManyToMany Spring Boot queue + " + " *********** " + i;
        System.out.println("Sender3 : " + context);
        this.rabbitmqTemplate.convertAndSend("manyToMany", context);
    }
}
