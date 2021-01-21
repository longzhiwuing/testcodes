package com.lzwing.testcode.thread.ExecutorCompletionService;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/7/31
 * Time: 22:42
 */
public class Tester {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        for (int i = 0 ; i < 5 ;i++) {
            int seqNo = i;
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int randomInt = RandomUtils.nextInt(5, 10);
                    System.out.println("randomInt:" + randomInt);
                    TimeUnit.SECONDS.sleep(randomInt);
                    return "HelloWorld-" + randomInt + "-" + Thread.currentThread().getName();
                }
            });
        }
        for (int j = 0 ; j < 5; j++) {
            try {
                System.out.println(service.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
