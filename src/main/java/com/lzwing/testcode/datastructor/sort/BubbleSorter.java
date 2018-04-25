package com.lzwing.testcode.datastructor.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/19
 * Time: 14:13
 */
public class BubbleSorter implements Sortable<Integer>{

    @Override
    public void sort(Integer[] data) {
        for(int i=0;i<data.length-1;i++) {
            boolean isSort = true;
            for(int j=0;j<data.length-1-i;j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }
}
