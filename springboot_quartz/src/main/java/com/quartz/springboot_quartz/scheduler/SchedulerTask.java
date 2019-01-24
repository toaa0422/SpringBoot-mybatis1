package com.quartz.springboot_quartz.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName SchedulerTask
 * @Author Smith
 * @Date 2019/1/24 14:20
 * @Description TODO
 * @Version 4.1
 */
@Component
public class SchedulerTask {
    
    private int count = 0;
    
    /**
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param 
     * @return void
     **/
    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println(" SpringBoot ----- > this is scheduler task running " + (count++));
    }
    
}
