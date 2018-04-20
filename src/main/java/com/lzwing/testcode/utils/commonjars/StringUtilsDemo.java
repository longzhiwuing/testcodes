package com.lzwing.testcode.utils.commonjars;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/27
 * Time: 16:04
 */
public class StringUtilsDemo {
    public static void main(String[] args) {

        testsubStringAfter();

//        testSubStringBetween();

//        testSplit();

//        testSpringStopWatch();

//        testStopWatch();

//        testEscapte();

//        testRandomUtils();

        /*
         * 输出样例
         **************************************************
         ^O^^O^^O^^O^^O^  StringUtilsDemo  ^O^^O^^O^^O^^O^^
         **************************************************
         */
//        printLogHeader("StringUtilsDemo");

        //补零 输出00123
//      System.out.println(getLeftPad("123",5,"0"));
    }

    private static void testsubStringAfter() {
        String demo = "name=zhangsan&age=18&gender=male";

        String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens(demo,"&");
        String name = StringUtils.substringAfter(strings[0], "=");
        String age = StringUtils.substringAfter(strings[1], "=");
        String gender = StringUtils.substringAfter(strings[2], "=");

        System.out.println(name + ":" + age + ":" + gender);
    }

    private static void testSubStringBetween() {
        JSONObject obj = new JSONObject();
        obj.put("aaa", "111");
        obj.put("bbb", "222");
        System.out.println(obj.toJSONString());
        System.out.println(StringUtils.substringBetween(obj.toJSONString(), "\"aaa\":\"", "\",\"bbb\""));
    }

    private static void testSplit() {
        /**
            split()方法： 分割字符串过程中会自动忽略所有的空项；
            splitByWholeSeparator方法：分割字符串过程中会忽略中间的空项，保留末尾的空项；
            splitByWholeSeparatorPreserveAllToKens方法及splitPreserveAllToKens方法作用相同：分割字符串过程中会按照每个分隔符进行分割，不忽略任何空白项；
            splitByCharacterType方法及splitByCharacterTypeCamelCase方法：按照字符类型进行分割。*/
        String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens("aaa|bbb|ccc", "|");

        Arrays.stream(strings).forEach(System.out::println);
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

    private static void testEscapte() {
        String str = "<select id=\"id_select\" class=\"selectpicker bla bla bli input-sm\" multiple data-live-search=\"true\">\n" +
                "\t\t        <option value=\"9\">序号</option>\n" +
                "\t\t        <option value=\"abcd\">区域代码</option>\n" +
                "\t\t        <option value=\"eeee\">统计日期</option>\n" +
                "\t\t        <option>身份证号</option>\n" +
                "\t\t        <option>出生日期</option>\n" +
                "\t\t        <option>责任医生</option>\n" +
                "\t\t    </select>";
        System.out.println(str);
        System.out.println(StringEscapeUtils.unescapeHtml(str));
    }

    /**
     * 生成随机字符串的工具
     */
    public static void testRandomUtils() {
        //产生5位长度的随机字符串，中文环境下是乱码
        System.out.println(RandomStringUtils.random(5));

        //使用指定的字符生成5位长度的随机字符串
        System.out.println(RandomStringUtils.random(5, new char[]{'a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3'}));

        //生成指定长度的字母和数字的随机组合字符串
        System.out.println(RandomStringUtils.randomAlphanumeric(5));

        //生成随机数字字符串
        System.out.println(RandomStringUtils.randomNumeric(5));

        //生成随机[a-z]字符串，包含大小写
        System.out.println(RandomStringUtils.randomAlphabetic(5));

        //生成从ASCII 32到126组成的随机字符串
        System.out.println(RandomStringUtils.randomAscii(4));
    }

    public static void printLogHeader(String title) {
        String[] header = new String[3];
        header[0] = StringUtils.repeat("*", 50);
        header[1] = StringUtils.center(String.format("  %s  ", title), 50, "^O^");
        header[2] = header[0];
        String head = StringUtils.join(header, "\n");
        System.out.println(head);
    }

    public static String getLeftPad(String decimal, int numCount, String padStr) {
        for (int j = decimal.length(); j < numCount; j++) {
            // 直接使用StringUtils类的leftPad方法处理补零
            decimal = StringUtils.leftPad(decimal, j + 1, padStr);
        }
        return decimal;
    }
}
