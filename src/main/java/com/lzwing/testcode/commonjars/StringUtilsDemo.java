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
        String title = "StringUtilsDemo";
        printLog(title);
    }

    public static void printLog(String title) {
        String[] header = new String[3];
        header[0] = StringUtils.repeat("*", 50);
        header[1] = StringUtils.center(String.format("  %s  ", title), 50, "^O^");
        header[2] = header[0];
        String head = StringUtils.join(header, "\n");
        System.out.println(head);
    }
}
