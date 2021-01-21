package com.lzwing.testcode.thread.ratelimiter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/2
 * Time: 17:05
 */
@Slf4j
public class CounterDemo {
    private static long timeStamp = System.currentTimeMillis();

    private static volatile long limitCount = 10;

    private static long interval = 1000;

    private static AtomicLong reqCount = new AtomicLong();

    private static List<String> taskList = new ArrayList<>();

    public static boolean grant() {
        long now = System.currentTimeMillis();

        if (now < timeStamp + interval) {
            if (reqCount.get() < limitCount) {
                reqCount.incrementAndGet();
                return true;
            } else {
                return false;
            }
        } else {
            timeStamp = System.currentTimeMillis();
            reqCount = new AtomicLong(0);
            log.info("===超时===");
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            new Thread(new Task(i)).start();
        }

        while (taskList.size() <= 49) {
            TimeUnit.SECONDS.sleep(1);
        }

        log.info("taskSize:{}",taskList.size());
        log.info("task:{}",taskList);
        int complete = 0;
        int undo = 0;
        for (String s : taskList) {
            if (s.startsWith("执行业务")) {
                complete++;
                log.info(s);
            }
            if (s.startsWith("限流")) {
                undo++;
            }
        }

        log.info("compete:{}",complete);
        log.info("undo:{}",undo);
    }

    static class Task implements Runnable {

        int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            String res;
            synchronized (CounterDemo.class) {
                if (grant()) {
                    res = "执行业务" + i;
                    log.info(res);
                } else {
                    res = "限流" + i;
                    log.info(res);
                }
            }
            taskList.add(res);
        }
    }


}
