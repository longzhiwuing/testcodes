package com.lzwing.testcode.thread.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * reentrantlock版本
 *
 * @author: chenzhongyong
 * Date: 2019/5/9
 * Time: 20:32
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    //Lock lock=new ReentrantLock(true);//公平锁
    //Lock lock=new ReentrantLock(false);//非公平锁
    private Condition condition = lock.newCondition();//创建 Condition
    private int i;

    public void testMethod() {
        while (i < 100) {
            try {
                lock.lock();//lock 加锁 //1:wait 方法等待:
                //System.out.println("开始 wait");
                //condition.await();
                //通过创建 Condition 对象来使线程 wait，必须先执行 lock.lock 方法获得锁
                //:2:signal 方法唤醒
                //condition.signal();//condition 对象的 signal 方法可以唤醒 wait 线程
            /*for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }*/
                condition.signal();
                condition.await();
                System.out.println(Thread.currentThread().getName() + ": " + this.i++);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        MyService myService = new MyService();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int j = 0; j <2 ; j++) {
            threadPool.execute(()->{
                myService.testMethod();
            });
        }

        threadPool.shutdown();
        Thread.currentThread().join();
    }
}