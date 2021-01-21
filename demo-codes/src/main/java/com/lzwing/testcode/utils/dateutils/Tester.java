package com.lzwing.testcode.utils.dateutils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/8/19
 * Time: 18:04
 */
public class Tester {
    public static void main(String[] args) {
        Date now = new Date();
        // Date 加 1 天
        Date addDays = DateUtils.addDays(now, 1);
        // Date 加 33 分钟
        Date addMinutes = DateUtils.addMinutes(now, 33);
        // Date 减去 233 秒
        Date addSeconds = DateUtils.addSeconds(now, -233);
        // 判断是否 Wie 同一天
        boolean sameDay = DateUtils.isSameDay(addDays, addMinutes);
        // 过滤时分秒,若 now 为 2020-05-07 22:13:00 调用 truncate 方法以后
        // 返回时间为 2020-05-07 00:00:00
        Date truncate = DateUtils.truncate(now, Calendar.DATE);
    }
}
