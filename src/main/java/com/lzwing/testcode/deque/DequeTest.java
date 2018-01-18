/**
 * Project Name:TestCodes
 * File Name:Snippet.java
 * Package Name:com.test.deck
 * Date:2018年1月11日上午10:31:43
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:Snippet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2018年1月11日 上午10:31:43 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */

public class DequeTest {

	public static void main(String[] args) {

		List<String> test = new LinkedList<>();
		testDeque();
	}

	public static void testDeque() {
		Deque<String> subway = new LinkedList<String>();
		System.out.println("龙泽站到了，前门后门各上五个人");
		for (int i = 0; i < 5; i++) {
			subway.offerFirst("前门上" + i);
			subway.offerLast("后门上" + i);
		}
		System.out.println(subway);
		System.out.println("西二旗站到了，前后门各下3个人");
		for (int i = 0; i < 3; i++) {
			subway.pollFirst();
			subway.pollLast();
		}
		System.out.println(subway);
		System.out.println("西二旗站 ，前后门各拥上15个人");
		for (int i = 6; i < 21; i++) {
			subway.offerFirst("前门上" + i);
			subway.offerLast("后门上" + i);
		}
		System.out.println(subway);
		
	}
}
