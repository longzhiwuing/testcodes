package com.lzwing.testcode.datastructor.search;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/6
 * Time: 20:22
 */
public class BinarySearchDemo {
    public static int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;
        while (a < b) {
//            int m = (a + b) / 2;
            int m = a + (b - a) / 2;
            if (k < arr[m]) {
                b = m;
            } else if (k > arr[m]) {
                a = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 10, 15, 100}, 15));
        System.out.println(binarySearch(new int[]{1, 2, 10, 15, 100}, -2));
        System.out.println(binarySearch(new int[]{1, 2, 10, 15, 100}, 101));
        System.out.println("===========");
        System.out.println(binarySearch(new int[]{}, 15));
        System.out.println(binarySearch(new int[]{12}, 15));
        System.out.println(binarySearch(new int[]{15}, 15));
        System.out.println("===========");
        System.out.println(binarySearch(new int[]{15, 15}, 15));
        System.out.println(binarySearch(new int[]{15, 16}, 15));
        System.out.println(binarySearch(new int[]{14, 15}, 15));
        System.out.println(binarySearch(new int[]{17, 18}, 15));

        /*int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println((a + b) / 2);
        System.out.println(a + (b - a) / 2);*/
    }


}
