package com.lzwing.testcode.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/3/30
 * Time: 20:28
 */
public class Java8TimeTester {
    public static void main(String[] args) {
//        t1();
//        t2();
//        t3();
//        t4();
//        t5();
//        t6();
//        t7();
//        t8();
//        t9();
        t10();
    }

    private static void t10() {
        LocalDate today = LocalDate.now();
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
        System.out.println(creditCardExpiry.lengthOfMonth());

        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }



        //计算距离某一个固定时间还有多少
        LocalDate java8Release = LocalDate.of(2020, Month.MARCH, 14);
        Period periodToNextJavaRelease =
                Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths() );


        //获取瞬时时间
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);

        //格式化代码
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);

        //自定义时间格式
        String goodFriday = "10 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        //转成自定义时间格式
        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }

    //时区
    private static void t9() {
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);


        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

        //印度时间
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    private static void t8() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);

        LocalDate previousYear = today.minus(1, YEARS);
        System.out.println("Date before 1 year : " + previousYear);
        LocalDate nextYear = today.plus(1, YEARS);
        System.out.println("Date after 1 year : " + nextYear);
    }

    //计算时间
    private static void t7() {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);
    }

    private static void t6() {
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
    }

    /**
     * 判断每年的生日
     */
    private static void t5() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(birthday)){
            System.out.println("Many Many happy returns of the day !!");
        }else{
            System.out.println("Sorry, today is not your birthday");
        }
    }

    private static void t4() {
        LocalDate today = LocalDate.now();
        LocalDate date1 = LocalDate.of(2019, 03, 30);
        if(date1.equals(today)){
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }
    }

    private static void t3() {
        LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
        System.out.println("Your Date of birth is : " + dateOfBirth);

    }

    private static void t2() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }

    private static void t1() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

    }
}
