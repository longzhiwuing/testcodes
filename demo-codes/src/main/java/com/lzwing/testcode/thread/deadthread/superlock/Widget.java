package com.lzwing.testcode.thread.deadthread.superlock;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/3/15
 * Time: 17:48
 */
public class Widget {
    public synchronized void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("widget dosomething...done");
    }
}
