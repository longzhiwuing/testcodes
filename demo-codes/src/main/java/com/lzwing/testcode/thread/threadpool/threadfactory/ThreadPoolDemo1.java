package com.lzwing.testcode.thread.threadpool.threadfactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,
                10,
                60L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5), new CustomThreadFactory());
        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("由线程：" + Thread.currentThread().getName() + "执行任务完成");
            });
        }
    }
}