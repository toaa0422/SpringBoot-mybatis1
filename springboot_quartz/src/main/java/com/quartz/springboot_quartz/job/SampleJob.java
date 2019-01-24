package com.quartz.springboot_quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName SampleJob
 * @Author Smith
 * @Date 2019/1/24 15:48
 * @Description TODO
 * @Version 4.1
 */
public class SampleJob extends QuartzJobBean {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz ---->  Hello, " + this.name);
    }
}
