package com.lzwing.testcode.gc;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/26
 * Time: 14:15
 */
public class MemConsumeTester {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        /*int size = 250;
        byte[] bytes = new byte[size * _1M];*/

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(10);
            int size = 250;
            if (i > 5) {
                size = 1000;
            }
            byte[] bytes = new byte[size * _1M];
        }


        Thread.currentThread().join();
    }
}
