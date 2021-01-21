package com.lzwing.testcode.thread.threadlocal;

class ThreadTest implements Runnable {

    // private int count = 5;
    private static ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 5;
        }
    };

    @Override
    public void run() {
        while (count.get() - 1 >= 0) {
            Thread.yield();// 让给调度器给其他线程执行的机会。此以方法一般用于debug
            count.set(count.get() - 1);
            System.out.println(Thread.currentThread().getName() + " count:-> " + count.get());
        }
    }

}

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadTest thread = new ThreadTest();
        for (int i = 0; i < 3; i++) {
            new Thread(thread, i + "").start();
        }
    }
}