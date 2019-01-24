package com.quartz.springboot_quartz;

import com.quartz.springboot_quartz.scheduler.CronSchedulerJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * @ClassName MyStartupRunner
 * @Author Smith
 * @Date 2019/1/24 16:31
 * @Description 项目启动即执行
 * @Version 4.1
 */
/*@Component*/
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    public CronSchedulerJob scheduleJobs;

    @Override
    public void run(String... args) throws Exception {
        scheduleJobs.scheduleJobs();
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }
}
