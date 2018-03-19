package com.lzwing.testcode.sort;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/19
 * Time: 14:13
 */
public class BubbleTest {
    public static void main(String[] args) {
        List<Integer> list2sort = Lists.newArrayList(1,2,3,4,5,6,7,8,9);

        Collections.shuffle(list2sort);

//        Integer[] arr2sort = list2sort.toArray(new Integer[list2sort.size()]);

        int[] arr2sort = list2sort.stream().mapToInt(i -> i).toArray();

        System.out.println("before");
        System.out.println(Arrays.toString(arr2sort));

        bubbleSort(arr2sort);

        System.out.println("after");
        System.out.println(Arrays.toString(arr2sort));
    }

    private static void bubbleSort(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length-1;i++) {
            boolean isSort = true;
            for(int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
                count++;
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(count);
    }
}
