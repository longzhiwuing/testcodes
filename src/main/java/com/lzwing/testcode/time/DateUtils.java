package com.lzwing.testcode.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/3
 * Time: 13:51
 */
public class DateUtils {

    public static String getTimeSpan(Date start, Date end) {
        if (start == null || end == null) {
            return null;
        }

        String startTimeStr = DateUtils.getTime(start);
        String endTimeStr = DateUtils.getTime(end);
        return String.format("%s-%s", startTimeStr, endTimeStr);
    }

    public static Date str2Date(String timeStr) {
        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(timeStr, nomalFormat);
        return localDateTime2Date(localDateTime);
    }

    public static String getThisWeekSpanStr() {
        LocalDate now = LocalDate.now();
        LocalDate nextWeekMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate thisWeekMonday = nextWeekMonday.plus(-1, ChronoUnit.WEEKS);

        Date thisMonday = DateUtils.localDate2Date(thisWeekMonday);
        Date nextMonday = DateUtils.localDate2Date(nextWeekMonday);

        String thisWeekSpan = String.format("%s - %s", getDateStr(thisMonday), getDateStr(nextMonday));

        return thisWeekSpan;
    }

    public static String getNextWeekSpanStr() {
        LocalDate now = LocalDate.now();
        LocalDate nextWeekMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate nextNextWeekMonday = nextWeekMonday.plus(1, ChronoUnit.WEEKS);

        Date nextMonday = DateUtils.localDate2Date(nextWeekMonday);
        Date nextNextMonday = DateUtils.localDate2Date(nextNextWeekMonday);

        String thisWeekSpan = String.format("%s - %s", getDateStr(nextMonday), getDateStr(nextNextMonday));

        return thisWeekSpan;
    }


    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static LocalDateTime date2localDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static String getDateStr(Date date) {
        if (date == null) {
            return "";
        }
        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDateTime localDate = instant.atZone(zoneId).toLocalDateTime();

        return localDate.format(nomalFormat);
    }

    public static String getTime(Date date) {
        if (date == null) {
            return "";
        }
        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("HH:mm");
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDateTime localDate = instant.atZone(zoneId).toLocalDateTime();

        return localDate.format(nomalFormat);
    }

    public static String getDate(Date date) {
        if (date == null) {
            return "";
        }
        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("MM月dd日");
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDateTime localDate = instant.atZone(zoneId).toLocalDateTime();

        return localDate.format(nomalFormat);
    }

    public static String getYearDate(Date date) {
        if (date == null) {
            return "";
        }
        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDateTime localDate = instant.atZone(zoneId).toLocalDateTime();

        return localDate.format(nomalFormat);
    }

    public static String getWeekDay(Date date) {
        if (date == null) {
            return "";
        }
        DateTimeFormatter nomalFormat = DateTimeFormatter.ofPattern("E", Locale.SIMPLIFIED_CHINESE);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDateTime localDate = instant.atZone(zoneId).toLocalDateTime();

        String weekDay = localDate.format(nomalFormat);

        weekDay = weekDay.replaceAll("星期", "周");

        return weekDay;
    }
}
