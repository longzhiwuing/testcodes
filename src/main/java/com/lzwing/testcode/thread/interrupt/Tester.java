package com.lzwing.testcode.thread.interrupt;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/11/25
 * Time: 20:14
 */
public class Tester {
    static class TestRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Thread is running...");
                System.out.println("Thread.currentThread().isInterrupted():" + Thread.currentThread().isInterrupted());
                //去系统时间的毫秒数
                long time = System.currentTimeMillis();
                while ((System.currentTimeMillis() - time < 1000)) {
                    //程序循环1秒钟，不同于sleep(1000)会阻塞进程。
                }
            }
        }
    }


    static class TestRunnable2 implements Runnable {
        @Override
        public void run() {
            try {
                //这个线程将被阻塞1000秒
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //do more work and return.
            }
        }
    }

    public static void main(String[] args) {
//        testInterruptThread();
        testInterruptThread2();
    }

    private static void testInterruptThread2() {
        Runnable tr = new TestRunnable2();
        Thread th1 = new Thread(tr);
        th1.start(); //开始执行分线程
        while (true) {
            th1.interrupt();  //中断这个分线程
        }

        /*
        * 运行结果:
        * java.lang.InterruptedException: sleep interrupted
                at java.lang.Thread.sleep(Native Method)
                at com.lzwing.testcode.thread.interrupt.Tester$TestRunnable2.run(Tester.java:36)
                at java.lang.Thread.run(Thread.java:748)
        * */
    }

    private static void testInterruptThread() {
        Runnable r = new TestRunnable();
        Thread th1 = new Thread(r);
        th1.start();

        //非打断sleep
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th1.interrupt();
    }
}
