package com.lzwing.testcode.audition;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/14
 * Time: 16:09
 */
public class binarysearch {

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 5, 7, 7, 7, 9, 11, 13};

        int find = 11;

        int index = getIndex(a, find);

        assertEquals(7, index);

        a = new int[]{5};

        find = 10;

        assertEquals(-1, getIndex(a, find));

        a = null;

        find = 0;

        assertEquals(-1, getIndex(a, find));

        a = new int[]{1, 2, 5, 7, 7, 7, 7, 7, 7, 9, 11, 13};

        find = 7;

        assertEquals(3, getIndex(a, find));

        a = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        find = 1;

        assertEquals(0, getIndex(a, find));

        a = new int[]{1,15};

        find = 1;

        assertEquals(0,getIndex(a,find));

        a = new int[]{1,15};

        find = 15;

        assertEquals(1,getIndex(a,find));
    }

    /**
     * 二分查找 如果有相同的元素返回第一个值
     *
     * @param a
     * @param find
     * @return
     */
    /*public static int getIndex(int[] a, int find) {

        if (a == null) {
            return -1;
        }

        int start = 0;

        int end = a.length;

        while (end > start) {
            int mid = (start + end) / 2;
            if (a[mid] == find) {
                int ret = mid;
                for (int i = mid; i >= start; i--) {
                    if (a[i] == find) {
                        ret = i;
                    } else {
                        break;
                    }
                }
                return ret;
            } else if (a[mid] > find) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }*/
    @Test
    public void testGenerial() {
        int[] a = new int[]{1, 2, 5, 7, 9, 11, 13};

        int find = a[RandomUtils.nextInt(a.length)];

        int index = getIndex(a, find);

        int answer = Arrays.binarySearch(a, find);

        System.out.println(index);
        System.out.println(answer);


    }


    public static int getIndex(int[] a, int find) {
        if (a == null) {
            return -1;
        }

        if (a[a.length - 1] < find) {
            return -1;
        }

        int left = 0;

        int right = a.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
