package com.lzwing.testcode.thread.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteThread {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    //读
    public int handleRead(Lock lock) throws InterruptedException{
        try {
            lock.lock();
            Thread.sleep(5000); //模拟读线程
            System.out.println("读完成");
            return value;
        } finally {
            lock.unlock();
        }
    }
    //写
    public void handleWrite(Lock lock,int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(5000);
            value=index;
            System.out.println("写完成");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteThread demo = new ReadWriteThread();
        Thread t1 = new Thread(){
            public void run(){
                try {
                    demo.handleRead(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                try {
                    demo.handleRead(readLock);
                    demo.handleWrite(writeLock,2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
    }
}