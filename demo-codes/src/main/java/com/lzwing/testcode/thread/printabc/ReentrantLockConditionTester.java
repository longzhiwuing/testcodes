package com.lzwing.testcode.thread.printabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: chenzhongyong
 * @Date: 2023/7/21 16:24
 */
public class ReentrantLockConditionTester {

    private static int state = 0;
    private static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition aCondition = lock.newCondition();
    private static Condition bCondition = lock.newCondition();
    private static Condition cCondition = lock.newCondition();

    public static void main(String[] args) {
        Thread aThread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 0) {
                        try {
                            aCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("A");
                    state++;
                    bCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread bThread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 1) {
                        try {
                            bCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("B");
                    state++;
                    cCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread cThread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 2) {
                        try {
                            cCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("C");
                    state++;
                    System.out.println(String.format("====count:%d====", ++count));
                    aCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        });

        aThread.start();
        bThread.start();
        cThread.start();

    }
}
