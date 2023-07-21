package com.lzwing.testcode.thread.printabc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Auther: chenzhongyong
 * @Date: 2023/7/21 17:26
 */
public class CyclicBarrierTester {

    private static int state = 0;

    private static int threadNum = 3;

    private static CyclicBarrier barrier = new CyclicBarrier(threadNum, () -> {
        switch (state) {
            case 0:
                System.out.println("A");
                break;
            case 1:
                System.out.println("B");
                break;
            case 2:
                System.out.println("C");
                break;
            default:
                break;
        }

        state = (state + 1) % threadNum;
        System.out.println(Thread.currentThread().getName());
    });

    public static void main(String[] args) {

        Executor executor = Executors.newFixedThreadPool(threadNum);

        for (int i = 0; i < 3; i++) {
            executor.execute(()->{
                for (int j = 0; j < 100; j++) {
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
