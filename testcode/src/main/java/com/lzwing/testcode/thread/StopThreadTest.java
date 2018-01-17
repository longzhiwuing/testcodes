package com.lzwing.testcode.thread;

import java.util.concurrent.TimeUnit;

class StopThread extends Thread {
	private long count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("exit thread current count value is: " + count);
				return;// 退出线程
			}
			count++;
		}
		System.out.println(count);
	}
}

public class StopThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new StopThread();
		thread.start();
		TimeUnit.MILLISECONDS.sleep(3);
		thread.interrupt();
		System.out.println("end!");
	}
}