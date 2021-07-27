package com.lzwing.testcode.random;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/20
 * Time: 17:19
 */
public class RandomTester {


    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int rv = random.nextInt(100 - 0) + 100;
            System.out.println(rv);
        }
    }
}
