package com.rabbitmq.springboot_rabbitmq.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName OneToManyReceive1
 * @Author Smith
 * @Date 2019/1/25 14:12
 * @Description TODO
 * @Version 4.1
 */
@Component
@RabbitListener(queues = "oneToMany")
public class OneToManyReceive1 {

    @RabbitHandler
    public void process(String context){
        System.out.println("oneToMany 1 : " + context);
    }

}
