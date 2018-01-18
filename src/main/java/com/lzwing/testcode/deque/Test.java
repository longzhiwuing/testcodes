/**
 * Project Name:testcode
 * File Name:Test.java
 * Package Name:com.lzwing.testcode.deque
 * Date:2018年1月17日下午4:41:34
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2018年1月17日 下午4:41:34 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class Test {

	public static void main(String[] args) {
		
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		
		System.out.println(availableProcessors);
		
//		testQueue();
		
		/*LRUCache cache = new LRUCache(3);
		
		cache.put("1", 1);
		cache.put("2", 2);
		cache.put("3", 3);
		System.out.println(cache);
		cache.put("1", 1);
		System.out.println(cache);
		cache.put("4", 4);
		System.out.println(cache);*/
		
		
	}

	public static void testQueue() {
		Deque<String> deque = new LinkedList<>();
		
		deque.addFirst("addFirst");
		deque.addLast("addLast");
		
		String peekFirst = deque.peekFirst();
		System.out.println(peekFirst);
		
		deque.offerFirst("offerFirst");
		
		String pollFirst = deque.pollFirst();
		
		System.out.println(pollFirst);
		
		deque.push("push");
		
		System.out.println(deque);
		
		String pop = deque.pop();
		deque.pop();
		deque.pop();
		
		System.out.println(deque);
	}
}

