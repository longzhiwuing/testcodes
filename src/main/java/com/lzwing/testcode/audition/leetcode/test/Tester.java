package com.lzwing.testcode.audition.leetcode.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/28
 * Time: 20:43
 */
public class Tester {
    public static void main(String[] args) {
        /*char numChar = '3';
        int  intNum = numChar - '0';
        System.out.println(numChar + ": " + intNum);*/

//        System.out.println(10 % 10);


        /*User user = new User();
        user.setName("aaa");
        System.out.println("user = " + user);
        demo(user);
        System.out.println("user = " + user);
        int i=100;
        System.out.println("i = " + i);
        demo2(i);
        System.out.println("i = " + i);*/

        Set<String> set = new HashSet<String>();

        boolean a = set.add("a");
        boolean b = set.add("b");
        boolean c = set.add("a");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    private static void demo2(int i) {
        i = 300;
    }

    private static void demo(User user) {
        user.setName("bbb");
    }
}
