package com.lzwing.testcode.thread.ratelimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/7
 * Time: 20:44
 */
public class Demo {
    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(()->{
                try {
                    countDownLatch.await();
                    TimeUnit.MILLISECONDS.sleep(200);
                    helloService.doRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            thread.start();
        }

        countDownLatch.countDown();
    }
}
