package com.lzwing.testcode.datastructor.search;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/4
 * Time: 11:42
 */
public class BinarySearchRecursion {

    public static int binarySearch(int[] arr, int l, int r, int k) {

        if (r <= l) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid] == k) {
            return mid;
        } else if (arr[mid] < k) {
            l = mid + 1;
            return binarySearch(arr, l, r, k);
        } else {
            r = mid;
            return binarySearch(arr, l, r, k);
        }


    }

    public static void main(String[] args) {
        int[] samples = {1, 2, 10, 15, 100};
        System.out.println(binarySearch(samples, 0, samples.length, 15));

        System.out.println(binarySearch(samples, 0, samples.length, -2));

        System.out.println(binarySearch(samples, 0, samples.length, 101));

        System.out.println("===========");
        System.out.println(binarySearch(new int[]{}, 0, 0, 15));
        System.out.println(binarySearch(new int[]{12}, 0, 1, 15));
        System.out.println(binarySearch(new int[]{15}, 0, 1, 15));
        System.out.println("===========");

        System.out.println(binarySearch(new int[]{15, 15}, 0, 2, 15));
        System.out.println(binarySearch(new int[]{15, 16}, 0, 2, 15));
        System.out.println(binarySearch(new int[]{14, 15}, 0, 2, 15));
        System.out.println(binarySearch(new int[]{17, 18}, 0, 2, 15));
    }
}
