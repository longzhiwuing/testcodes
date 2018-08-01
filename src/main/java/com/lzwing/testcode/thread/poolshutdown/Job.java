package com.lzwing.testcode.thread.poolshutdown;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/1
 * Time: 21:37
 */
public class Job implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName()+":done...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
