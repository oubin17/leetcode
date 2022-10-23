package com.ob.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最大子串长度
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters
 *
 * @Description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @CreateDate: 2022/10/21 23:41
 * @Version: 1.0
 * @Author: oubin
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * dvdf
     * aab
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = 1;
        Set<Character> charSet = new HashSet<>();
        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            if (charSet.contains(chars[fast])) {
                while (chars[slow] != chars[fast]) {
                    charSet.remove(chars[slow]);
                    slow++;
                }
                slow++;
            } else {
                charSet.add(chars[fast]);
            }
            int current = charSet.size();
            if (current > length) {
                length = current;
            }
            fast++;
        }
        return length;
    }
}
