package com.lzwing.testcode.datastructor.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/21
 * Time: 17:29
 */
public class DelayQueueTester {
    private static DelayQueue delayQueue  = new DelayQueue();
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {

                delayQueue.offer(new Order("t3000",3000));
                delayQueue.offer(new Order("t4000",4000));
                delayQueue.offer(new Order("t2000",2000));
                delayQueue.offer(new Order("t6000",6000));
                delayQueue.offer(new Order("t1000",1000));

            }
        }).start();

        while (true) {
            Delayed order = delayQueue.take();

            System.out.println(order);

        }
    }
}
