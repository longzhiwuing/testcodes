package com.lzwing.sort;

import com.lzwing.utils.SortHelper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/28
 * Time: 13:35
 */
public class InsertSorting implements IntSort{
    public static void main(String[] args) {
        /*int[] origin = new int[]{4, 1, 3, 2, 5};


        IntSort insertSortting = new InsertSorting();

        origin = insertSortting.sort(origin);

        System.out.println(Arrays.toString(origin));*/

        int size = 300000;

        boolean result = SortHelper.checkSortingResult(size, new InsertSorting());

        System.out.println(result);

    }

    @Override
    public int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int currVal = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > currVal; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = currVal;
        }

        return arr;
    }
}
