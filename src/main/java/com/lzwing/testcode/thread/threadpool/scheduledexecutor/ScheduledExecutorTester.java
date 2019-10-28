package com.lzwing.testcode.thread.threadpool.scheduledexecutor;

import org.joda.time.DateTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/10/28
 * Time: 16:40
 */
public class ScheduledExecutorTester {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(()->{
            System.out.println(new DateTime());
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
}
