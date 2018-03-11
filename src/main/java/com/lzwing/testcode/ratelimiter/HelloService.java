package com.lzwing.testcode.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/7
 * Time: 20:43
 */
public class HelloService {
    RateLimiter rateLimiter = RateLimiter.create(10);

    public void doRequest() {
        if (rateLimiter.tryAcquire()) {
            System.out.println("请求成功");
        } else {
            System.out.println("请求失败!被拒绝服务");
        }
    }
}
