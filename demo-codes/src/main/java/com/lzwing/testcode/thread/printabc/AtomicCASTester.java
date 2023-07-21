package com.lzwing.testcode.thread.printabc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: chenzhongyong
 * @Date: 2023/7/21 16:47
 */
public class AtomicCASTester {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread aThread = new Thread(() -> {
            for (int i = 0; i < 100; ) {
                if (counter.get() % 3 == 0) {
                    System.out.println("A");
                    counter.compareAndSet(counter.get(), counter.get() + 1);
                    i++;
                }
            }
        });

        Thread bThread = new Thread(() -> {
            for (int i = 0; i < 100; ) {
                if (counter.get() % 3 == 1) {
                    System.out.println("B");
                    counter.compareAndSet(counter.get(), counter.get() + 1);
                    i++;
                }
            }
        });

        Thread cThread = new Thread(() -> {
            for (int i = 0; i < 100; ) {
                if (counter.get() % 3 == 2) {
                    System.out.println("C");
                    counter.compareAndSet(counter.get(), counter.get() + 1);
                    i++;
                }
            }
        });

        aThread.start();
        bThread.start();
        cThread.start();
    }

}
