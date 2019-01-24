package com.quartz.springboot_quartz.scheduler;

import com.quartz.springboot_quartz.job.SampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SampleScheduler
 * @Author Smith
 * @Date 2019/1/24 15:50
 * @Description Scheduler 启动定时任务
 * @Version 4.1
 */
@Configuration
public class SampleScheduler {

    @Bean
    public JobDetail sampleJobDetail() {
        // 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
                .usingJobData("name","World").storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger(){
        // 每隔两秒执行一次
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger")
                .withSchedule(scheduleBuilder).build();
    }


}
