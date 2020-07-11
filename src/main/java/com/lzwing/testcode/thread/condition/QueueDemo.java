package com.lzwing.testcode.thread.condition;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// condition 实现队列线程安全。
public class QueueDemo {
    final Lock lock = new ReentrantLock();
    // 指定条件的等待 - 等待有空位
    final Condition notFull = lock.newCondition();
    // 指定条件的等待 - 等待不为空
    final Condition notEmpty = lock.newCondition();

    // 定义数组存储数据
    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    // 写入数据的线程,写入进来
    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("生产:" + x);
            // 数据写满了
            while (count == items.length) {
                notFull.await(); // 写入数据的线程,进入阻塞
            }
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            notEmpty.signal(); // 唤醒指定的读取线程
        } finally {
            lock.unlock();
        }
    }
    // 读取数据的线程,调用take
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // 线程阻塞在这里,等待被唤醒
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            notFull.signal(); // 通知写入数据的线程,告诉他们取走了数据,继续写入
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        QueueDemo queueDemo = new QueueDemo();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(RandomUtils.nextLong(1000,3000));
                    queueDemo.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int j = 0; j < 10; j++) {
            new Thread(()->{
                try {
                    Thread.sleep(RandomUtils.nextLong(1000,3000));
                    System.out.println("消费:"+queueDemo.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.currentThread().join();

    }
}
