package com.lzwing.testcode.thread.deadthread.superlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/3/15
 * Time: 17:49
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("LoggingWidget dosomething...done");
        super.doSomething();
        System.out.println("begin out...");
    }

    public static void main(String[] args) throws InterruptedException {
         Widget widget = new Widget();

         LoggingWidget loggingWidget = new LoggingWidget();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(()->{
            widget.doSomething();
        });

        executor.execute(()->{
            loggingWidget.doSomething();
        });

        System.out.println("main...join....");
        Thread.currentThread().join();


    }
}
