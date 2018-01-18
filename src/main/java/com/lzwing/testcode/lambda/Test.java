/**
 * Project Name:TestCodes
 * File Name:Test.java
 * Package Name:com.test.lambda
 * Date:2017年10月16日下午2:20:01
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.lambda;
/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年10月16日 下午2:20:01 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class Test {

	public static void main(String[] args) {
		new Thread(() -> System.out.println("hello lambda")).start();
	}
}

