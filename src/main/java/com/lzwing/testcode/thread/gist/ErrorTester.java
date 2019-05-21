package com.lzwing.testcode.thread.gist;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/20
 * Time: 18:23
 */
@Slf4j
public class ErrorTester {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService execute = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

        execute.execute(()->{
            log.info("------11----");
        });

        TimeUnit.SECONDS.sleep(5);

        execute.execute(()->{
            int count = 0;

            while (true) {
                count++;
                log.info("-----22-----");
                if (count == 10) {
                    System.out.println(1 / 0);
                }

                if (count == 20) {
                    log.info("count:{}", count);
                    break;
                }
            }
        });
    }
}
