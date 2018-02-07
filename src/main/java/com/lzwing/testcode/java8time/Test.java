/**
 * Project Name:testcode
 * File Name:Test.java
 * Package Name:com.lzwing.testcode.java8time
 * Date:2018年2月7日上午11:47:37
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.java8time;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2018年2月7日 上午11:47:37 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class Test {

	public static void main(String[] args) {
//		getToday();
//		getYearMonthDay();
//		getCumstomTime();
		getDateCompare();
	}

	private static void getDateCompare() {
		LocalDate now = LocalDate.now();
        LocalDate deadlineDate = LocalDate.of(2018,2,25);
        MonthDay monthDay = MonthDay.of(deadlineDate.getMonth(),deadlineDate.getDayOfMonth());
        System.out.println(monthDay);
        MonthDay currentDay = MonthDay.from(now);
        System.out.println(currentDay);
	}

	private static void getCumstomTime() {
		LocalDate date2 = LocalDate.of(2018,2,7);
		System.out.println(date2);
	}

	private static void getYearMonthDay() {
		LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("day:"+day);
	}

	/*
		运行结果:
		今天的日期:2018-02-07
	 */
	private static void getToday() {
		LocalDate today = LocalDate.now();
		System.out.println("今天的日期:" + today);
	}
}
