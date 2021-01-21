package com.lzwing.testcode.thread.atomic.countDemo3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDemo {
    public static void main(String[] args) {
//        Count count = new Count();
        AtomicInteger count = new AtomicInteger(0);


        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.incrementAndGet();
                }
            }
        };
        List<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        while (true) {
            if (allThreadTerminated(threads)) {// 所有线程运行结束  
                System.out.println(count.get());
                break;
            }
        }
    }

    private static boolean allThreadTerminated(List<Thread> threads) {
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                return false;
            }
        }
        return true;
    }
}

