package com.lzwing.testcode.thread.guava;

import org.apache.curator.shaded.com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/11/15
 * Time: 16:09
 */
public class ThreadPoolTester {

    //推荐使用的线程池
    private static ExecutorService executor = new ThreadPoolExecutor(10, 10,
            60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(10));

    //guava封装的线程池
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args){

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            pool.execute(()->{
                System.out.println("time:"+new Date());
            });
        }
    }
}
