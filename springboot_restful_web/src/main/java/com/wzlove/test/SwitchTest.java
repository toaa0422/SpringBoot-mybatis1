package com.wzlove.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName SwitchTest
 * @Author wz157
 * @Date 2018/12/8 16:41
 * @Description 使用Java提供的MXBean来监控jvm创建了哪些线程
 */
public class SwitchTest {

    public static void main(String[] args) {
        System.out.println("HelloWorld");
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(allThreadIds);

        for (ThreadInfo info : threadInfo) {
            System.out.println(info.getThreadId() + " : " + info.getThreadName());
        }

    }

}
