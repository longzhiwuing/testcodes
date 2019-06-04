package com.lzwing.testcode.gc;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * Created with IntelliJ IDEA.
 *
 *
 *
 * //计算指定对象及其引用树上的所有对象的综合大小，单位字节
 *         long RamUsageEstimator.sizeOf(Object obj)
 *
 * //计算指定对象本身在堆空间的大小，单位字节
 *         long RamUsageEstimator.shallowSizeOf(Object obj)
 *
 * //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
 *
 *         String RamUsageEstimator.humanSizeOf(Object obj)
 *
 * @author: chenzhongyong
 * Date: 2019/6/4
 * Time: 20:01
 */
public class RamUsageEstimatorTester {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int _1G = 1024 * 1024 * 1024 * 2 - 1;
        System.out.println(_1G);

        int _1M = 1024 * 1024;

        int _40M = 40*_1M;

        byte[] bytes = new byte[_40M];

        //System.out.println(SizeTool.getObjectSize(bytes));

        System.out.println(RamUsageEstimator.sizeOf(bytes));
        System.out.println(RamUsageEstimator.shallowSizeOf(bytes));
        System.out.println(RamUsageEstimator.humanSizeOf(bytes));
    }
}
