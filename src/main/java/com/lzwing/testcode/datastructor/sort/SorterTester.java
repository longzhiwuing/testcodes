package com.lzwing.testcode.datastructor.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 21:19
 */
public class SorterTester {
    public static void main(String[] args) {
        bubbleSortTest();
    }

    private static void bubbleSortTest() {

        int size = 100000;

        Integer[] arr2sort = makeMorkData(size);

        //int[] arr2sort = list2sort.stream().mapToInt(i -> i).toArray();

        System.out.printf("before:%d%n", arr2sort.length);
        System.out.println(Arrays.toString(arr2sort));

        TimerSorter<Integer> sortable = new TimerSorter(new BubbleSorter());

        sortable.sort(arr2sort);

        System.out.printf("after:%d%n", arr2sort.length);
        System.out.println(Arrays.toString(arr2sort));
    }

    private static Integer[] makeMorkData(int size) {
        List<Integer> list2sort = new ArrayList<>(size);

        for(int i=0;i<size;i++) {
            list2sort.add(RandomUtils.nextInt(0, size + 1));
        }

        Collections.shuffle(list2sort);

        return list2sort.toArray(new Integer[list2sort.size()]);
    }
}
