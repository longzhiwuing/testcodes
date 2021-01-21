package com.lzwing.testcode.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockThread thread = new ReentrantLockThread();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}