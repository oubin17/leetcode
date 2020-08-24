package com.ob.algorithm.other;

/**
 * @Author: oubin
 * @Date: 2019/5/28 09:39
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abcdabcd"));
    }

    public static int firstUniqChar(String s) {
        int[] req = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            req[c - 'a'] ++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (req[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
