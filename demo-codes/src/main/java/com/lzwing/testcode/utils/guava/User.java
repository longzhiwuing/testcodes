/**
 * Project Name:TestCodes
 * File Name:User.java
 * Package Name:com.test.guava
 * Date:2017年10月27日下午4:21:49
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.utils.guava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年10月27日 下午4:21:49 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private String name;
	private int age;
	private boolean isMale;
	
}

