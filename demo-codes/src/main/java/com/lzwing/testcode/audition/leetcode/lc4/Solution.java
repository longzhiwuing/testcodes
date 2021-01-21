package com.lzwing.testcode.audition.leetcode.lc4;


/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 均不为空。
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] combine = new int[m + n];

        int index = 0;

        for (int i = 0, j = 0; ; index++) {
            if (i + j == m + n) {
                break;
            }

            if (i == m) {
                combine[index] = nums2[j++];
            } else if (j == n) {
                combine[index] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                combine[index] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                combine[index] = nums2[j++];
            } else {
                combine[index++] = nums1[i++];
                combine[index] = nums2[j++];
            }
        }

        int mid = (m + n) / 2;

        if ((m + n) % 2 == 0) {
            return (combine[mid - 1] + combine[mid]) / 2.0;
        } else {
            return combine[mid];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};

        nums1 = new int[]{1, 2, 2, 2};
        nums2 = new int[]{2, 2, 3, 4};

        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }
}