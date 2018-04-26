package com.lzwing.testcode.datastructor.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 21:25
 */
public class SelectSorter implements Sortable<Integer> {
    @Override
    public void sort(Integer[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;

            for (int j = i; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            Integer tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;

        }
    }
}
