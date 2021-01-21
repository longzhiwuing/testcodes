package com.lzwing.testcode.thread.gist;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/27
 * Time: 17:23
 */
public class Tester4 {
    Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Tester4 tester4 = new Tester4();
         new Thread(()->{
             tester4.handle();
         }).start();
        new Thread(()->{
            tester4.handle();
        }).start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println("mainThread notify....");
        tester4.notifyThread();

        Thread.currentThread().join();
    }

    public void handle() {
        synchronized (obj) {
            System.out.printf("%s get lock.....%n", Thread.currentThread().getName());
            try {
                System.out.printf("%s wait.....%n", Thread.currentThread().getName());
                obj.wait();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s finish.....%n", Thread.currentThread().getName());
    }

    public void notifyThread() throws InterruptedException {
        synchronized (obj) {
            System.out.printf("%s notify.....%n", Thread.currentThread().getName());
            obj.notifyAll();
            TimeUnit.SECONDS.sleep(3);
            System.out.printf("%s notify release lock.....%n", Thread.currentThread().getName());
        }
    }
}
