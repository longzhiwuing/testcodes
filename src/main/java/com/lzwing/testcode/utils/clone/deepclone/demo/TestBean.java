/**
 * Project Name:TestCodes
 * File Name:BaseEntity.java
 * Package Name:com.test.clone
 * Date:2017年7月28日下午4:39:36
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.utils.clone.deepclone.demo;

import lombok.Data;

/**
 * ClassName:BaseEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年7月28日 下午4:39:36 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Data
public class TestBean implements Cloneable{

	public String name;
	
	public String id;

	public PropertyBean propertyBean;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		TestBean testBean = (TestBean)super.clone();
		testBean.setPropertyBean((PropertyBean) propertyBean.clone());
		return testBean;
	}
}

