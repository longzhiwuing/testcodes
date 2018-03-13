package com.lzwing.testcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/13
 * Time: 10:55
 */
public class ReentrantLockConditionTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("t1拿到锁，接着进入等待，并且释放锁");
            condition.await();
            Thread.sleep(4000);
            System.out.println("t1又拿到锁");
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockConditionTest thread = new ReentrantLockConditionTest();
        Thread t1 = new Thread(thread);
        t1.start();
        Thread.sleep(5000);
        lock.lock();
        System.out.println("主线程占用锁");
        condition.signal();
        System.out.println("唤醒成功，主线程释放锁");
        lock.unlock();
    }
}
