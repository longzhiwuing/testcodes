package com.lzwing.testcode.thread.poolshutdown;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/1
 * Time: 21:36
 */
@Slf4j
public class Tester {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        long start = System.currentTimeMillis();
        for (int i = 0; i <= 5; i++) {
            pool.execute(new Job());
        }

        pool.shutdown();

        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            log.info("线程还在执行。。。");
        }
        long end = System.currentTimeMillis();
        log.info("一共处理了【{}】", (end - start));
    }
}
