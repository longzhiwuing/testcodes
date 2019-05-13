package com.lzwing.testcode.audition.questions;

import org.apache.commons.lang3.RandomUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/13
 * Time: 16:01
 *
 *
 *
 * 问题：给你n个无序的int整型数组arr，并且这些整数的取值范围都在0-20之间，要你在 O(n) 的时间复杂度中把这 n 个数按照从小到大的顺序打印出来。
 */
public class Tester {


    public static void main(String[] args) {
        int n=10;
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        int count = 0;
        boolean canAdd = true;
        while (count < n && canAdd) {
            int random = RandomUtils.nextInt(1, 20);
            canAdd = set.add(random);
            if (!canAdd) {
                canAdd = true;
                continue;
            }
            arr[count++] = random;
        }

        System.out.println(Arrays.toString(arr));

        int[] tempArr = new int[20];

        for (int i = 0; i < 20; i++) {
            if (i < arr.length) {
                tempArr[arr[i]] = arr[i];
            }
        }

        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (tempArr[i] != 0) {
                resList.add(tempArr[i]);
            }
        }

        System.out.println(resList);
    }
}
