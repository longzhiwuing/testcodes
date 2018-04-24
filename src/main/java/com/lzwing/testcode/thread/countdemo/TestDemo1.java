package com.lzwing.testcode.thread.countdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/21
 * Time: 12:03
 */
public class TestDemo1 {
    public static int totalThreadCount = 200;
    public static int clientTotal = 5000;

    //static int count = 0;
    static AtomicInteger count = new AtomicInteger(0);

    static Map map = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(totalThreadCount);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    add();
                    //map.put(finalI, finalI);
                    semaphore.release();
                    countDownLatch.countDown();
                }
            });

        }

        executorService.shutdown();
        countDownLatch.await();
        System.out.println(count.get());
        //System.out.println(map.size());

    }

    private static void add() {
//        count++;
        count.incrementAndGet();
    }
}
