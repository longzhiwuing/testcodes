package com.lzwing.testcode.utils.string;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/27
 * Time: 16:04
 */
@Slf4j
public class StringUtilsDemo {
    public static void main(String[] args) {

        testEmojo();

//        testchomp();

//        testMidAndDigits();

//        testsubStringAfter();

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

        testcommaDelimitedListToStringArray();
    }

    private static void testEmojo() {

//        IOUtils.toString(inputMessage.getBody());

//        StringUtil.parseEmojiUnicodeToAlias(content);
    }

    private static void testcommaDelimitedListToStringArray() {
        String[] dataArray = org.springframework.util.StringUtils.commaDelimitedListToStringArray("a,b,c");

        List<String> dataList = Arrays.asList(dataArray);

        for (String s : dataList) {
            log.info("s:{}", s);
        }


    }

    private static void testchomp() {
//        String chomp = StringUtils.chomp(" 邱晓玲\n ".trim());
        String chomp = StringUtils.strip("英二阅读真题详解（2014年Text 1+Text 2）\naaaa");
        System.out.println("chomp = " + chomp);
        System.out.println(StringUtils.strip("aa \t\r\n abc    "));
    }

    public static void testMidAndDigits() {
        String str = "0123456789";
        //从中间截到几位
        System.out.println(StringUtils.mid(str,6,2));
        System.out.println(StringUtils.getDigits("abc123weg653"));

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
