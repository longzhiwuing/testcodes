package com.lzwing.testcode.time;

import org.apache.commons.lang.time.StopWatch;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/8
 * Time: 15:45
 */
public class TimeStringUtils {

    public static void main(String[] args) {
//         testStopWatch();
        testSpringStopWatch();
//        dateTest();
//        timeStrTest();
    }

    private static void testStopWatch() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            new RuntimeException(e);
        }
        stopWatch.stop();

        System.out.println(stopWatch.getTime());
    }

    private static void testSpringStopWatch() {
        org.springframework.util.StopWatch sw = new org.springframework.util.StopWatch();

        sw.start("起床");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sw.stop();


        sw.start("洗漱");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sw.stop();


        sw.start("锁门");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sw.stop();


        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getLastTaskName());
        System.out.println(sw.getLastTaskInfo());
        System.out.println(sw.getTaskCount());
    }

    private static void dateTest() {
        Date date = new Date();
        //b的使用，月份简称
        String str = String.format(Locale.US, "英文月份简称：%tb", date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n", date);
        //B的使用，月份全称
        str = String.format(Locale.US, "英文月份全称：%tB", date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n", date);
        //a的使用，星期简称
        str = String.format(Locale.US, "英文星期的简称：%ta", date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n", date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te", date);
        //p的使用
        str = String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
        System.out.println(str);
        System.out.printf("小写字母的上午或下午标记（中）：%tp%n", date);
        //z的使用
        System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n", date);
        //Z的使用
        System.out.printf("时区缩写字符串:%tZ%n", date);
        //s的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
        //Q的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);
    }

    private static void timeStrTest() {
        Date date = new Date();

        System.out.println("sout:" + date);
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n", date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n", date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n", date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR", date);
    }
}
