package com.lzwing.testcode.thread.ratelimiter;

import org.apache.curator.shaded.com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/2
 * Time: 19:19
 */
public class LimitDemo {
    public static ConcurrentHashMap<String, RateLimiter> resourceRateLimiter = new ConcurrentHashMap<>();

    static {
        createResourceLimiter("order", 50);
    }

    private static void createResourceLimiter(String resource, int qps) {
        if (resourceRateLimiter.contains(resource)) {
            resourceRateLimiter.get(resource).setRate(qps);
        } else {
            RateLimiter rateLimiter = RateLimiter.create(qps);
            resourceRateLimiter.putIfAbsent(resource, rateLimiter);
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            new Thread(()->{
                if (resourceRateLimiter.get("order").tryAcquire(10, TimeUnit.MILLISECONDS)) {
                    System.out.println("执行业务");
                } else {
                    System.out.println("限流");
                }
            }).start();

        }
    }
}
