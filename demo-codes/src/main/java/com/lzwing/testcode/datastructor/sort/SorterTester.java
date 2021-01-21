package com.lzwing.testcode.datastructor.sort;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 21:19
 */
@Slf4j
public class SorterTester {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int size = 50000;

        Integer[] arr2sort = makeMorkData(size);

        Integer[] copyArray2Sort = Arrays.copyOf(arr2sort, arr2sort.length);
//        int[] arr2sort = list2sort.stream().mapToInt(i -> i).toArray();


        //bubblsort
//        TimerSorter<Integer> sortable = new TimerSorter(new BubbleSorter());
        //selectsort
//        TimerSorter<Integer> sortable = new TimerSorter(new SelectSorter());
        //insertsort
//        TimerSorter<Integer> sortable = new TimerSorter(new InsertSorter());

        showResult(arr2sort,new TimerSorter(new SelectSorter()));
        log.info(StringUtils.repeat("-",100));
        showResult(copyArray2Sort,new TimerSorter(new InsertSorter()));


    }

    private static void showResult(Integer[] arr2sort, TimerSorter sortable) {
        sortable.sort(arr2sort);
    }

    private static Integer[] makeMorkData(int size) {
        List<Integer> list2sort = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list2sort.add(RandomUtils.nextInt(0, size + 1));
        }

//        Collections.shuffle(list2sort);

        return list2sort.toArray(new Integer[list2sort.size()]);
    }
}
