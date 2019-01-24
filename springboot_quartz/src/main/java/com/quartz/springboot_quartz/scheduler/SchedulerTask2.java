package com.quartz.springboot_quartz.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SchedulerTask
 * @Author Smith
 * @Date 2019/1/24 14:20
 * @Description TODO
 * @Version 4.1
 */
@Component
public class SchedulerTask2 {
    
    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("HH:mm:ss");
    
    /**
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:22 2019/1/24
     * @Param 
     * @return void
     **/
    @Scheduled(fixedRate = 6000)
    private void process(){
        System.out.println("SpringBoot ----- > now time is " + dateFormat.format(new Date()));
    }
    
}
