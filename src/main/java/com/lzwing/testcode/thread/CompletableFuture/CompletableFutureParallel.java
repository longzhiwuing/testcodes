package com.lzwing.testcode.thread.CompletableFuture;

import java.util.concurrent.*;

/**
 * 可以替换countdownlatch 多线程执行任务，结果进行汇总
 */
public class CompletableFutureParallel {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executor.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete(Thread.currentThread().getName()+"####1");
        });

        executor.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete(Thread.currentThread().getName()+"####2");
        });

        System.out.println("main Thread doSomeThing...");

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}