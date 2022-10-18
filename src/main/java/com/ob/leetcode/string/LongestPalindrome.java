package com.ob.leetcode.string;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * A string is called a palindrome string if the reverse of that string is the same as the original string.
 *
 * @Description: https://leetcode.cn/problems/longest-palindromic-substring/
 * @CreateDate: 2022/10/17 23:17
 * @Version: 1.0
 * @Author: oubin
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String x = "cbbd";
        System.out.println(longestPalindrome(x));
    }

    public static String longestPalindrome(String s) {
        String palindrome = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = subString(s, i, i);
            String s2 = s1;
            if (s.charAt(i) == s.charAt(i + 1)) {
            s2 = subString(s, i, i + 1);
            }
            palindrome = palindrome.length() > s1.length() ? palindrome : s1;
            palindrome = palindrome.length() > s2.length() ? palindrome : s2;
        }
        return palindrome;

    }

    public static String subString(String origin, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < origin.length() && origin.charAt(leftIndex) == origin.charAt(rightIndex)) {
            leftIndex --;
            rightIndex ++;
        }
        if (rightIndex - leftIndex > 1) {
            return origin.substring(leftIndex + 1, rightIndex);
        } else  {
            return origin.substring(leftIndex, rightIndex + 1);
        }
    }
}
