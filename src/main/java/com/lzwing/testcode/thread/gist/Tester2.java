package com.lzwing.testcode.thread.gist;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/14
 * Time: 15:13
 */
public class Tester2 {
    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> dataMap = new HashMap<>();
//        Map<String, Integer> dataMap = new ConcurrentHashMap<>();
//        Map<String, Integer> dataMap = Collections.synchronizedMap(new HashMap<>());
//        Hashtable<String, Integer> dataMap = new Hashtable<>();
        dataMap.put("res", 0);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        THREAD_POOL.execute(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 0;
            synchronized (Tester2.class) {
                i = dataMap.get("res") + 1;
                dataMap.put("res", i);
            }
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 0;
            synchronized (Tester2.class) {
                i = dataMap.get("res") + 2;
                dataMap.put("res", i);
            }
            countDownLatch.countDown();
        });

        THREAD_POOL.execute(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 0;
            synchronized (Tester2.class) {
                i = dataMap.get("res") + 3;
                dataMap.put("res", i);
            }
            countDownLatch.countDown();
        });

        THREAD_POOL.execute(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 0;
            synchronized (Tester2.class) {
                i = dataMap.get("res") + 4;
                dataMap.put("res", i);
            }
            countDownLatch.countDown();
        });

        countDownLatch.await();
        System.out.println(dataMap);
        THREAD_POOL.shutdown();
    }
}
