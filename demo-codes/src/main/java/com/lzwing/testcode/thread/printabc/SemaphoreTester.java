package com.lzwing.testcode.thread.printabc;

import java.util.concurrent.Semaphore;

/**
 * @Auther: chenzhongyong
 * @Date: 2023/7/21 17:10
 */
public class SemaphoreTester {

    private static int state = 0;

    private static Semaphore a = new Semaphore(1);
    private static Semaphore b = new Semaphore(0);
    private static Semaphore c = new Semaphore(0);

    public static void main(String[] args) {
        Thread aThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    a.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                b.release();
            }
        });

        Thread bThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    b.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                c.release();
            }
        });

        Thread cThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    c.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                a.release();
            }
        });

        aThread.start();
        bThread.start();
        cThread.start();
    }
}
