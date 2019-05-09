package com.lzwing.testcode.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/9
 * Time: 16:14
 */
public class Tester {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            threadPool.execute(() -> {
                System.out.printf("%s is Running....%n", Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
