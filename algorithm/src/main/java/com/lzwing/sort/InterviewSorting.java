package com.lzwing.sort;

import com.lzwing.utils.SortHelper;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/10/11
 * Time: 21:51
 */
public class InterviewSorting implements IntSort{
    @Override
    public int[] sort(int[] origin) {
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length; j++) {
                if (origin[i] < origin[j]) {
                    int tmp = origin[i];
                    origin[i] = origin[j];
                    origin[j] = tmp;
                }
            }
        }

        return origin;
    }

    public static void main(String[] args) {
        int[] origin = new int[]{4, 1, 3, 2, 5};


        IntSort insertSortting = new InterviewSorting();

        origin = insertSortting.sort(origin);

        System.out.println(Arrays.toString(origin));

        /*int size = 300000;

        boolean result = SortHelper.checkSortingResult(size, new InsertSorting());

        System.out.println(result);*/

    }
}
