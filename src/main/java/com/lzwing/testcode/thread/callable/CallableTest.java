/**
 * Project Name:TestCodes
 * File Name:ThreadTest.java
 * Package Name:com.test.threadTest
 * Date:2017年4月18日下午3:40:08
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:ThreadTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年4月18日 下午3:40:08 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */

class CallableThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "helloWorld"+System.currentTimeMillis();
	}
	
	
}


public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<String> future = executor.submit(new CallableThread());
		Future<String> future1 = executor.submit(new CallableThread());
		Future<String> future2 = executor.submit(new CallableThread());
		
		System.out.println("res:"+future.get());
		System.out.println("res:"+future1.get());
		System.out.println("res:"+future2.get());
		
		executor.shutdown();
		
		/*FutureTask<String> futureTask = new FutureTask<>(new CallableThread());
		
		Thread thread = new Thread(futureTask);
		
		thread.start();
		
		System.out.println(futureTask.get());*/
		
	}
}

