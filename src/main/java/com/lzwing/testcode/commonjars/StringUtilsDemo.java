package com.lzwing.testcode.commonjars;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/27
 * Time: 16:04
 */
public class StringUtilsDemo {
    public static void main(String[] args) {
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
