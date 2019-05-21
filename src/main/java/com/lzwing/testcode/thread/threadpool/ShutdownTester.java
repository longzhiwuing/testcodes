package com.lzwing.testcode.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/21
 * Time: 21:36
 */
@Slf4j
public class ShutdownTester {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i <= 5; i++) {
            pool.execute(()->{
                log.info("{}: is Running", Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //优雅的关闭方式
        pool.shutdown();
        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            log.info("线程还在执行。。。");
        }
        long end = System.currentTimeMillis();
        log.info("一共处理了【{}】", (end - start));
    }
}
