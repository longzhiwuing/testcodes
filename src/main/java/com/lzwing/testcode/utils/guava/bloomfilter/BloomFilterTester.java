package com.lzwing.testcode.utils.guava.bloomfilter;

import org.apache.curator.shaded.com.google.common.hash.BloomFilter;
import org.apache.curator.shaded.com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/11/28
 * Time: 12:14
 */
public class BloomFilterTester {
    public static void main(String[] args) {
//        testBloomFilterInteger();
        testBloomFilterString();
    }

    private static void testBloomFilterString() {
        long star = System.currentTimeMillis();
        BloomFilter<String> filter = BloomFilter.create(
                Funnels.stringFunnel(Charset.forName("utf-8")),
                10000000,
                0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i+"");
        }

        System.out.println(filter.mightContain("1"));
        System.out.println(filter.mightContain("2"));
        System.out.println(filter.mightContain("3"));
        System.out.println(filter.mightContain("10000000"));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

    private static void testBloomFilterInteger() {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        System.out.println(filter.mightContain(3));
        System.out.println(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}
