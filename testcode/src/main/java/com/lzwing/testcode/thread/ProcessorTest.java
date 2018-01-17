/**
 * Project Name:TestCodes
 * File Name:ProcessorTest.java
 * Package Name:com.test.thread
 * Date:2017年12月26日上午9:51:20
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * ClassName:ProcessorTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年12月26日 上午9:51:20 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ProcessorTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int cpuNums = Runtime.getRuntime().availableProcessors();
		
		ExecutorService pool = Executors.newFixedThreadPool(cpuNums);
		
		/*Future<?> submit = pool.submit(new FutureTask(new Callable<String>() {

			@Override
			public String call() throws Exception {
				
				return null;
			}
			
		}));*/
		
		System.out.println(cpuNums);
	}
}

