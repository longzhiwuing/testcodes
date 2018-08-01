package com.lzwing.testcode.thread.deadthread;

public class DeadThreadTest {
    public static void main(String[] args) {
        DeadThread thread = new DeadThread();
        Thread t1 = new Thread(thread);
        t1.setName("a");
        Thread t2 = new Thread(thread);
        t2.setName("b");
        t1.start();
        t2.start();
    }
}