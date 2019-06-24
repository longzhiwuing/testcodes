package com.lzwing.testcode.audition.leetcode.twosum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];


        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,7,11,15};

        int target = 27;
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}