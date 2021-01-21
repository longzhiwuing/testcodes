/**
 * Project Name:TestCodes
 * File Name:ClassLock.java
 * Package Name:com.test.thread
 * Date:2017年6月29日下午4:43:13
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.thread;
/**
 * ClassName:ClassLock <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年6月29日 下午4:43:13 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ClassLock extends Thread{
	
	public static void main(String[] args) {
		
		Thread t1 = new ClassLock();
		t1.setName("T_one");
		Thread t2 = new ClassLock();
		t2.setName("T_two");
		
		t1.start();
		t2.start();
		
	}

	@Override
	public void run() {
		print(this);
	}

	private static synchronized void print(Thread t){
		int count = 5;
		while(count-->0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+" count:"+count);
		}
	}
}

