package com.lzwing.testcode.thread.gist;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/12
 * Time: 20:56
 */
@Slf4j
public class Tester {
    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               counter.incrementAndGet();
            }).start();
        }
    }
}

@Slf4j
class Counter{
    AtomicLong count = new AtomicLong(0);
//    long count = 0;

    public void incrementAndGet() {
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synchronized (this) {
            count.incrementAndGet();
            log.info("count:{}", count.get());
        }
        /*synchronized (this) {
            count++;

        }*/
    }
}
