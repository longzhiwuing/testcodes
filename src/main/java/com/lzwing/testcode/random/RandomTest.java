package com.lzwing.testcode.random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        int max = 20;
        int min = 10;
        System.out.println(getRandomInt(max, min));
    }

    private static int getRandomInt(int max, int min) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}