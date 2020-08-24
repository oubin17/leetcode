package com.ob.algorithm.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: oubin
 * @date: 2019/3/25 10:30
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class StrLength {

    public static void main(String[] args) {
        int i = maxLength("abcabcbb");
        System.out.println(i);
    }

    public static int maxLength(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int max = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < chars.length; j++) {
                if (list.contains(chars[j])) {
                    break;
                }else{
                    list.add(chars[j]);
                    if (list.size() > max) {
                        max = list.size();
                    }
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
