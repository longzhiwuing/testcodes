package com.lzwing.testcode.utils.encode;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/31
 * Time: 11:38
 */

@Slf4j
public class CharsetDemo {
    public static void main(String[] args) throws Exception{
        charsetDemo();
        test();
    }

    private static void charsetDemo() throws UnsupportedEncodingException {
        String source = "中文测试";
        Charset gbkCharset = Charset.forName("gbk");
        Charset utf8Charset = Charset.forName("utf-8");
        Charset iso88591Charset = Charset.forName("iso-8859-1");

        Charset defaultCharset = Charset.defaultCharset();

        System.out.printf("defaultCharset:%s%n", defaultCharset);

        //使用StringUtils.repeat
        System.out.println(StringUtils.repeat("=",20));

        //使用StringUtils.toEncodedString
        String str1 = StringUtils.toEncodedString(source.getBytes(gbkCharset), utf8Charset);
        System.out.printf("gbk=>utf-8：%s%n", str1);

        String str4 = StringUtils.toEncodedString(source.getBytes(utf8Charset), gbkCharset);
        System.out.printf("utf-8=>gbk：%s%n", str4);

        String str2 = StringUtils.toEncodedString(source.getBytes(iso88591Charset), utf8Charset);
        System.out.printf("iso8859-1=>utf-8：%s%n", str2);

        String str5 = StringUtils.toEncodedString(source.getBytes(utf8Charset), iso88591Charset);
        System.out.printf("utf-8=>iso8859-1：%s%n", str5);

        String str3 = StringUtils.toEncodedString(source.getBytes(gbkCharset), iso88591Charset);
        System.out.printf("gbk=>iso8859-1：%s%n", str3);

        String str6 = StringUtils.toEncodedString(source.getBytes(iso88591Charset), gbkCharset);
        System.out.printf("iso8859-1=>gbk：%s%n", str6);
    }

    public static void test() {
        String source = "ÊµÕ½Ö¸ÄÏ(ÖìÐ¡ØË)";

        String s = StringUtils.toEncodedString(source.getBytes(Charset.forName("iso-8859-1")), Charset.forName("gbk"));

        log.info("s:{}",s);
    }

}
