/**
 * Project Name:testcode
 * File Name:Test.java
 * Package Name:com.lzwing.testcode.java8
 * Date:2018年2月7日上午11:47:37
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 */

package com.lzwing.testcode.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

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
public class TimeTest {

    public static void main(String[] args) {
//		getToday();
//		getNow();
//		getYearMonthDay();
//		getCumstomTime();
//		getDateCompare();
//		timeCompute();
//		dateCompute();
//		clockDemo();
//      beforeAfterDate();
//        changeTimeZone();
//        yearMonthDemo();
//        checkLeapYear();
//        periodDemo();
//        timeStampDemo();
//        formatDemo();
//        date2LocalDate();
        getCustomDate();
    }

    private static void date2LocalDate() {

        //Date转LocalDate
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("Date = " + date);
        System.out.println("LocalDate = " + localDate);

        //LocalDate转Date
        zoneId = ZoneId.systemDefault();
        localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        date = Date.from(zdt.toInstant());
        System.out.println("LocalDate = " + localDate);
        System.out.println("Date = " + date);
    }

    private static void formatDemo() {
        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("%s  格式化后的日期为:  %s%n", dayAfterTommorrow, formatted);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String timeStr = now.format(nomalFormat);

        System.out.println("日期转换为字符串:"+timeStr);

        //字符串转日期
        formatted = LocalDate.parse(timeStr,nomalFormat);
        System.out.println("日期类型:"+formatted);
    }

    private static void timeStampDemo() {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());
    }

    private static void periodDemo() {
        LocalDate today = LocalDate.now();

        LocalDate christmasDay = LocalDate.of(2018, 12, 25);
        LocalDate springFestival = LocalDate.of(2018, 2, 15);


        Period periodToNextJavaRelease = Period.between(today, christmasDay);
        System.out.printf("Months left between today and christmasDay : %d%n", periodToNextJavaRelease.getMonths());

        long between = ChronoUnit.DAYS.between(today, christmasDay);
        long between2springFestival = ChronoUnit.DAYS.between(today, springFestival);

        System.out.printf("距圣诞节还有%d天%n", between);
        System.out.printf("距春节还有%d天%n", between2springFestival);
    }

    private static void checkLeapYear() {
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }

    private static void yearMonthDemo() {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    private static void changeTimeZone() {
        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
        System.out.println(dateAndTimeInNewYork.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    private static void beforeAfterDate() {
        LocalDate today = LocalDate.now();

//        LocalDate tomorrow = LocalDate.of(2018,2,6);
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        if (tomorrow.isAfter(today)) {
            System.out.println("tomorrow:" + tomorrow);
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if (yesterday.isBefore(today)) {
            System.out.println("yesterday:" + yesterday);
        }
    }

    private static void clockDemo() {
        // Returns the current time based on your system clock and set to UTC.
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Clock clock = Clock.systemUTC();
        LocalDateTime now = LocalDateTime.now(clock);
        System.out.printf("utc:%s%n", now.format(dateTimeFormatter));

        ZoneId america = ZoneId.of("America/New_York");
        Clock americanClock = Clock.system(america);
        System.out.printf("america:%s%n", LocalDateTime.now(americanClock).format(dateTimeFormatter));

        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.printf("china:%s%n", LocalDateTime.now(defaultClock).format(dateTimeFormatter));
    }

    private static void getCustomDate() {
        LocalDate now = LocalDate.now();

        //前一个周一
        LocalDate previousMonday = now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));

        LocalDate previousSunday = previousMonday.plus(6, ChronoUnit.DAYS);

        System.out.println("previousSunday = " + previousSunday);

        LocalDate thisWeekMonday = previousMonday.plus(1, ChronoUnit.WEEKS);

        LocalDate nextWeekMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        System.out.println("nextWeekMonday = " + nextWeekMonday);
    }

    private static void dateCompute() {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期为:" + today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:" + nextWeek);

        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期 : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期:" + nextYear);
    }

    private static void timeCompute() {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(3);
        System.out.println("三个小时后的时间为:" + newTime);
    }

    private static void getNow() {
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期:" + time);
    }

    private static void getDateCompare() {
        LocalDate now = LocalDate.now();
        LocalDate deadlineDate = LocalDate.of(2018, 2, 25);
        MonthDay monthDay = MonthDay.of(deadlineDate.getMonth(), deadlineDate.getDayOfMonth());
        System.out.println(monthDay);
        MonthDay currentDay = MonthDay.from(now);
        System.out.println(currentDay);
    }

    private static void getCumstomTime() {
        LocalDate date2 = LocalDate.of(2018, 2, 7);
        System.out.println(date2);
    }

    private static void getYearMonthDay() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);
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
