package com.lzwing.testcode.thread.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/21
 * Time: 16:19
 */
public class Tester {
//    static int atomicInteger = 10000;

    static AtomicInteger atomicInteger = new AtomicInteger(10000);

    public static void main(String[] args) throws InterruptedException {

        /*AtomicInteger atomicInteger = new AtomicInteger(100);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int j = 0; j < 10000; j++) {
            threadPool.execute(() -> {
                //System.out.printf("%s:%d%n", Thread.currentThread().getName(), atomicInteger.incrementAndGet());
                while (atomicInteger.intValue()>0) {
                    System.out.printf("%s:%d%n", Thread.currentThread().getName(), atomicInteger.decrementAndGet());
                }
            });
        }

        System.out.println("final:" + atomicInteger.intValue());
        //System.out.println("final:" + atomicInteger);
//        threadPool.shutdown();*/


        /*for (int j = 0; j < 100; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (atomicInteger > 0) {
                        System.out.printf("%s:%d%n", Thread.currentThread().getName(), atomicInteger--);
                    }
                }
            }).start();
        }*/

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (atomicInteger.intValue() > 0) {
            threadPool.execute(() -> {
                System.out.printf("%s:%d%n", Thread.currentThread().getName(), atomicInteger.decrementAndGet());
            });
        }










        Thread.currentThread().join();
    }
}
