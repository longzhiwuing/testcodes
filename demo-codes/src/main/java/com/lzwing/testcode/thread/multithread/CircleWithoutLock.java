package com.lzwing.testcode.thread.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class CircleWithoutLock {
	
	private static Logger logger = LoggerFactory.getLogger(CircleWithoutLock.class);
	private static volatile AtomicInteger count = new AtomicInteger(1);
	private static int N = 3;//循环线程数
	
	
	static class Task implements Runnable{
		
		int i ;
		public Task(int i) {
			super();
			
			if(i==N){//如果为N 将i置为0，因为整除取余为0
				this.i = 0;
			}else{
				this.i = i;
			}
		}
		@Override
		public void run() {
			
			while (count.get()<100) {
				
				if(count.get()%N==i){
					//因为logger为异步输出，需要改为同步
					logger.info(Thread.currentThread().getName()+":"+count.getAndIncrement());
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 1; i < (N+1); i++) {
			new Thread(new Task(i),"Thread"+i).start();
		}
		
		Thread.currentThread().join();
	}

}