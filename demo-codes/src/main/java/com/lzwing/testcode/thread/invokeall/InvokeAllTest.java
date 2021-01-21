package com.lzwing.testcode.thread.invokeall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/20
 * Time: 15:51
 */
public class InvokeAllTest {
    public static void main(String[] args) throws Exception {
//        invokeAllDemo();

        CompletionServiceDemo();
    }

    private static void CompletionServiceDemo() throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(10);

        final BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<Future<Integer>>(
                10);
        //实例化CompletionService
        final CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
                exec, queue);

        // 提交10个任务
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            exec.submit(new Callable<String>() {
                public String call() throws InterruptedException {
                    int sleepTime = new Random().nextInt(1000);
                    Thread.sleep(sleepTime);
                    return "线程" + finalI + "睡了" + sleepTime + "秒";
                }
            });
        }

// 输出结果
        for (int i = 0; i < 10; i++) {
            // 获取包含返回结果的future对象（若整个阻塞队列中还没有一条线程返回结果，那么调用take将会被阻塞，当然你可以调用poll，不会被阻塞，若没有结果会返回null，poll和take返回正确的结果后会将该结果从队列中删除）
            Future<Integer> future = completionService.take();
            // 从future中取出执行结果，这里存储的future已经拥有执行结果，get不会被阻塞
            Integer result = future.get();
            System.out.println(result);
        }
    }

    private static void invokeAllDemo() throws Exception {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 创建存储任务的容器
        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        // 提交10个任务
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Callable<String> task = new Callable<String>() {
                public String call() throws InterruptedException {
                    int sleepTime = new Random().nextInt(1000);
                    Thread.sleep(sleepTime);
                    return "线程" + finalI + "睡了" + sleepTime + "秒";
                }
            };
            executorService.submit(task);
            // 将task添加进任务队列
            tasks.add(task);
        }

        // 获取10个任务的返回结果
        List<Future<String>> results = executorService.invokeAll(tasks);

        // 输出结果
        for (int i = 0; i < 10; i++) {
            // 获取包含返回结果的future对象
            Future<String> future = results.get(i);
            // 从future中取出执行结果（若尚未返回结果，则get方法被阻塞，直到结果被返回为止）
            String result = future.get();
            System.out.println(result);
        }
    }
}
