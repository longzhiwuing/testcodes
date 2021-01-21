package com.lzwing.testcode.thread.gist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/12/6
 * Time: 11:01
 */

public class Tester3 {
    public static void main(String[] args) throws Exception{
//        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("count", 0);

        CountDownLatch countDownLatch = new CountDownLatch(2);


        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                    map.put("count", map.get("count") + 1);
            }
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                    map.put("count", map.get("count") + 1);
            }
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println(map.get("count"));
    }
}
