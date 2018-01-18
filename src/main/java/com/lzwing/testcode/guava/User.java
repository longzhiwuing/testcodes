/**
 * Project Name:TestCodes
 * File Name:User.java
 * Package Name:com.test.guava
 * Date:2017年10月27日下午4:21:49
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.guava;
/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年10月27日 下午4:21:49 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class User {

	String name;
	int age;
	boolean isMale;
	
	public User() {
	}
	public User(String name) {
		this.name = name;
		System.out.println("contructor name:"+name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", isMale=" + isMale + "]";
	}
	
	
	
}

