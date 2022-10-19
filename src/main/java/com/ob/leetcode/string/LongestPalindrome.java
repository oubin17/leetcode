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
        System.out.println(longestPalindromeDP(x));
    }

    /**
     * 动态规划法
     *
     * @param s
     * @return
     */
    public static String longestPalindromeDP(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLength = 1;
        int begin = 0;
        //使用dp[i][j] 表示s[i...j]左闭右闭区间是否是个回文字符串
        //状态转移方程 dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
        //边界条件满足: j - 1 - (i + 1) + 1 < 2，保证小区间的长度大于2，因为如果等于1，那必然是个回文串
        //更新状态转移方程：dp[i][j] = (s[i] == s[j]) && ((j - i < 3) || dp[i + 1][j - 1])
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for(int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);

    }
    /**
     * 中心点扩散法
     * @param s
     * @return
     */
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
