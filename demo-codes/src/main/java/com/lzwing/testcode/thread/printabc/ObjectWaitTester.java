package com.lzwing.testcode.thread.printabc;

/**
 * @Auther: chenzhongyong
 * @Date: 2023/7/21 16:07
 */
public class ObjectWaitTester {

    private static int state = 0;
    private static int count = 0;

    public static void main(String[] args) {

        Object lock = new Object();

        Thread aThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    while (state % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("A");
                    state++;
                    lock.notifyAll();
                }
            }
        });

        Thread bThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    while (state % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("B");
                    state++;
                    lock.notifyAll();
                }
            }
        });

        Thread cThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    while (state % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("C");
                    System.out.println(String.format("===count=%d==", ++count));
                    state++;
                    lock.notifyAll();
                }
            }
        });

        aThread.start();
        bThread.start();
        cThread.start();

    }
}
