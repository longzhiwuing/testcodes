/**
 * Project Name:TestCodes
 * File Name:ConsumerProducer.java
 * Package Name:com.test.thread
 * Date:2017年6月29日下午4:23:01
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.thread.ConsumerProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ConsumerProducer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年6月29日 下午4:23:01 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ConsumerProducer {
	
	List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		
		Thread consumer = new Thread(new ConsumerProducer().new Consumer());
		
		Thread producer = new Thread(new ConsumerProducer().new Producer());
		
		consumer.start();
		
		producer.start();
		
	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			while(true){
				synchronized (list) {
					if(list.size()>0){
						System.out.println("Consumer before listSize:"+list.size());
						list.remove(0);
						System.out.println("Consumer after listSize:"+list.size());
					}else{
						list.notifyAll();
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
	
	class Producer implements Runnable{
		@Override
		public void run() {
			while(true){
				synchronized (list) {
					if(list.size()==0){
						System.out.println("Producer before listSize:"+list.size());
						list.add(0);
						System.out.println("Producer after listSize:"+list.size());
					}else{
						list.notifyAll();
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
}

