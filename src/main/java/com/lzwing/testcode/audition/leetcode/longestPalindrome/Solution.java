package com.lzwing.testcode.audition.leetcode.longestPalindrome;

public class Solution {
    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();

        int max = 0, from = 0, to = 0;


        for (int i = 0; i < chars.length; i++) {
            int[] sameIdx = getNextSameCharIndex(chars, i);
            if (sameIdx == null || sameIdx.length == 0) {
                continue;
            } else {
                for (int j = 0; j < sameIdx.length; j++) {
                    int palindome = isPalindome(chars, i, sameIdx[j]);
                    if (palindome > 0) {
                        if (max < palindome) {
                            max = palindome;
                            from = i;
                            to = sameIdx[j] + 1;
                        }
                    }
                }
            }


        }

        if (max <= 0) {
            from = 0;
            to = 1;
        }
        String palindrome = s.substring(from, to);

        return palindrome;

    }

    private static int isPalindome(char[] chars, int from, int to) {
        int count = 0;
        boolean isSame = false;
        while (from <= to) {
            if (chars[from] == chars[to]) {
                from++;
                to--;
                count++;
                if (from == to) {
                    isSame = true;
                }
            } else {
                return 0;
            }
        }
        return isSame ? count : count + 1;
    }

    private static int[] getNextSameCharIndex(char[] chars, int i) {
        int count = 0;
        for (int j = chars.length - 1; j > 0; j--) {
            if (chars[i] == chars[j] && i < j) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        int[] idx = new int[count];

        int curr = 0;
        for (int j = chars.length - 1; j > 0; j--) {
            if (chars[i] == chars[j] && i < j) {
                idx[curr++] = j;
            }
        }

        return idx;
    }


    public static void main(String[] args) {
        String s = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
//        String s = "iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz";

        String s1 = longestPalindrome(s);

        System.out.println(s1);
    }
}