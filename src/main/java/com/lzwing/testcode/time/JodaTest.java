/**
 * Project Name:TestCodes
 * File Name:JodaTest.java
 * Package Name:com.test
 * Date:2017年4月6日下午4:34:50
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.time;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * ClassName:JodaTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年4月6日 下午4:34:50 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class JodaTest {
	
	public static void jodaTimeCase(){
		DateTime dateTime = new DateTime(2017,6,29,15,47,07,123);
		
		dateTime = new DateTime();
		
		System.out.println(dateTime.plusDays(30).toString("E yyyy-MM-dd HH:mm:ss.SSS"));
		
		//45 天之后的某天在下一个月的当前周的最后一天的日期
		System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek().withMaximumValue().toString("E yyyy-MM-dd HH:mm:ss.SSS"));
		
		Date jdkDate = dateTime.toDate();
		
//		DateTime dateTime = SystemFactory.getClock().getDateTime();
		
		// Use a Calendar
		java.util.Calendar calendar = Calendar.getInstance();
		dateTime = new DateTime(calendar);
		// Use another Joda DateTime
		DateTime anotherDateTime = dateTime;
		dateTime = new DateTime(anotherDateTime);
		// Use a String (must be formatted properly)
		String timeString = "2006-01-26T13:30:00-06:00";
		dateTime = new DateTime(timeString);
		timeString = "2006-01-26";
		dateTime = new DateTime(timeString);
		
		System.out.println(dateTime.toString("E yyyy-MM-dd HH:mm:ss.SSS"));
		
//		LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM
		LocalDate now = new LocalDate();
		System.out.println(now.minusMonths(1).dayOfMonth().withMaximumValue().toString("E yyyy-MM-dd HH:mm:ss.SSS"));
	}

	public static void main(String[] args) {
		
		
		jodaTimeCase();
		
//		DateTime dt = new DateTime();
		
/*		//2016-08-18 15:20
		DateTime dt = new DateTime(2016,8,18,15,20);

		//2016-08-18 15:20:47
		DateTime dt2 = new DateTime(2016,8,18,15,20,47);

		//2016-08-18 15:20:47.345
		DateTime dt3 = new DateTime(2016,8,18,15,20,47,345);*/
		
		//2016-08-18 15:20:47.345
//		DateTime dt = new DateTime(2016,8,18,15,20,47,345);
		
/*		System.out.println("year: "+dt.getYear());
		System.out.println("month: "+dt.getMonthOfYear());
		System.out.println("day: "+dt.getDayOfMonth());
		System.out.println("hour: "+dt.getHourOfDay());
		System.out.println("minute: "+dt.getMinuteOfHour());
		System.out.println("second: "+dt.getSecondOfMinute());
		System.out.println("millisecond: " +dt.getMillisOfSecond());
		System.out.println("day_of_week: " +dt.getDayOfWeek());
		
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		DateTime dt1 = formatter.parseDateTime("2016-08-18 14:20");*/
		
/*		//调整时间为下午3点20
		DateTime dt = new DateTime();
		dt = dt.withHourOfDay(15).withMinuteOfHour(20);*/
		
		/*三小时五分钟后*/
//		DateTime dt = new DateTime().plusHours(3).plusMinutes(5);
		
		/*今天0点*/
/*		DateTime dt = new DateTime().withMillisOfDay(0);
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss.SSS"));*/
		
		/*下周二上午10点整*/
/*		DateTime dt = new DateTime().plusWeeks(1).withDayOfWeek(2)
		        .withMillisOfDay(0).withHourOfDay(10);*/
		
		/*明天最后一刻*/
/*		DateTime dt = new DateTime().plusDays(1).millisOfDay().withMaximumValue();
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss.SSS"));*/
		
		/*本月最后一天最后一刻*/
//		DateTime dt = new DateTime().dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue();
		
//		DateTime dt = new DateTime().plusMonths(1).dayOfMonth().withMinimumValue()
//		        .plusDays(6).withDayOfWeek(1).withMillisOfDay(0).withHourOfDay(17);
	}
}

