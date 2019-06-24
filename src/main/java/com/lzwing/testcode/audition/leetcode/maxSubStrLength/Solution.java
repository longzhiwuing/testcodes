package com.lzwing.testcode.audition.leetcode.maxSubStrLength;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> subStr = new HashSet<Character>();
            for (int j = i; j < s.length(); j++) {
                boolean res = subStr.add(s.charAt(j));
                if (!res) {
                    break;
                }
            }
            max = subStr.size() > max ? subStr.size() : max;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int max = lengthOfLongestSubstring(s);
        System.out.println("max = " + max);
    }
}