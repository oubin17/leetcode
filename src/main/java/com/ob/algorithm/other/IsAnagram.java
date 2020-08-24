package com.ob.algorithm.other;

/**
 * @Author: oubin
 * @Date: 2019/5/27 09:39
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abcd", "bacd"));
    }

    public static boolean isAnagram(String s, String t) {

        int[] x = new int[26];
        int[] y = new int[26];
        for (Character c : s.toCharArray()) {
            x[c - 'a']++;
        }
        for (Character c : t.toCharArray()) {
            y[c - 'a']++;
        }
        for (int i = 0; i < 26; i ++) {
            if (x[i] != y[i]) {
                return false;
            }
        }
        return true;

    }
}
