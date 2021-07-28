package com.lzwing.utils;

import com.lzwing.sort.InsertSorting;
import com.lzwing.sort.IntSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/28
 * Time: 14:00
 */
public class SortHelper {
    public static int[] generateNearOrderNoRepeatIntArray(int n,int swapTimes) {
        int[] origin = new int[n];

        for (int i = 0; i < n; i++) {
            origin[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            Random random = new Random();
            int idx1 = random.nextInt(n);
            int idx2 = random.nextInt(n);

            int temp = origin[idx1];
            origin[idx1] = origin[idx2];
            origin[idx2] = temp;
        }

        return origin;
    }

    public static int[] generateRandomNoRepeatIntArray(int n) {
        return generateNearOrderNoRepeatIntArray(n, n);
    }

    public static int[] generateRandomRepeatIntArray(int n) {
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int randomVal = random.nextInt(n);

            randomArray[i] = randomVal;
        }

        return randomArray;
    }

    public static boolean checkSortingResult(int n,IntSort intSort) {
        int[] origin = generateRandomRepeatIntArray(n);

        System.out.println("数据生成完毕.....");

        int[] copyOrigin = Arrays.copyOf(origin, origin.length);

        long start = System.currentTimeMillis();
        Arrays.sort(copyOrigin);
        long totalTime = (System.currentTimeMillis() - start);

        System.out.println("JDK排序方法执行完毕.....用时:" + totalTime + "ms");

        start = System.currentTimeMillis();
        int[] userSortArray = intSort.sort(origin);

        totalTime = (System.currentTimeMillis() - start);
        System.out.println(String.format("编写算法耗时....:%s ms", totalTime));

        boolean result = Arrays.equals(userSortArray, copyOrigin);
        System.out.println("是否正确:" + result);

        return result;
    }
}
