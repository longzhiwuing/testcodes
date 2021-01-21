package com.lzwing.testcode.datastructor.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/26
 * Time: 8:10
 */
public class InsertSorter implements Sortable<Integer> {
    @Override
    public void sort(Integer[] data) {
        for (int i = 1; i < data.length; i++) {

            Integer saver = data[i];
            int j;
            for (j = i; j > 0 && data[j - 1] > saver; j--) {
                data[j] = data[j - 1];
            }

            int tmp = saver;
            saver = data[j];
            data[j] = tmp;
        }
    }
}
