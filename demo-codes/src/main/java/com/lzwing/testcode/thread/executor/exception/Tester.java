package com.lzwing.testcode.thread.executor.exception;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/16
 * Time: 13:40
 */
public class Tester {

    private static final ExecutorService executor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

    public static void main(String[] args){

        try {
            checkExecuteException();

//            checkSubmitException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static int checkExecuteException() {
        executor.execute(()->{
            System.out.println("Execute....");
            throw new RuntimeException("execute runtime exception...");
        });

        return 1;
    }

    private static int checkSubmitException() {
        executor.submit(()->{
            System.out.println("Submit..");
            throw new RuntimeException("submit runtime exception...");
        });

        return 1;
    }
}
