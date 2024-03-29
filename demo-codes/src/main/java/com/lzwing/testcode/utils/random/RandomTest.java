package com.lzwing.testcode.utils.random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        int min = 10;
        int max = 11;

        //[a,b)
        System.out.println(RandomUtils.nextInt(min, max));
        //[a,b]
        System.out.println(getRandomInt(min,max));
    }

    private static int getRandomInt(int min,int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
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
}