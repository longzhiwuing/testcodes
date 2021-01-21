package com.lzwing.testcode.thread.deadthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/8/14
 * Time: 22:32
 */
public class Tester {
    public static void main(String[] args) throws Exception{
//        threadpoolDead();
        test();
    }

    private static void test() {
        ExecutorService pool = Executors
                .newSingleThreadExecutor();
        pool.submit(() -> {
            try {
                String qq=pool.submit(()->"QQ").get();
                System.out.println(qq);
            } catch (Exception e) {
            }
        });
    }

    private static void threadpoolDead() throws InterruptedException {
        //L1、L2阶段共用的线程池
        ExecutorService es = Executors.
                newFixedThreadPool(2);
        //L1阶段的闭锁
        CountDownLatch l1=new CountDownLatch(2);
        for (int i=0; i<2; i++){
            System.out.println("L1");
            //执行L1阶段任务
            es.execute(()->{
                //L2阶段的闭锁
                CountDownLatch l2=new CountDownLatch(2);
                //执行L2阶段子任务
                for (int j=0; j<2; j++){
                    es.execute(()->{
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                //等待L2阶段任务执行完
                try {
                    l2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }
        //等着L1阶段任务执行完
        l1.await();
        System.out.println("end");
    }
}
