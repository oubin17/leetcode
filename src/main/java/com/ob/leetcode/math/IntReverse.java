package com.ob.leetcode.math;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @Description: https://leetcode.cn/problems/reverse-integer/
 * @CreateDate: 2022/10/29 20:28
 * @Version: 1.0
 * @Author: oubin
 */
public class IntReverse {


    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;

    }

    /**
     * 官方解法
     *
     * @param x
     * @return
     */
    public static int reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * 123  321
     * -123  -321
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x > 0) {
            String s = String.valueOf(x);
            char[] chars = s.toCharArray();
            int mid = chars.length / 2;
            for (int i = 0; i < mid; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = temp;
            }
            try {
                return Integer.parseInt(String.valueOf(chars));
            } catch (Exception e) {
                return 0;
            }
        } else if (x < 0) {
            String s = String.valueOf(x);
            String sub = s.substring(1);
            char[] chars = sub.toCharArray();
            int mid = chars.length / 2;
            for (int i = 0; i < mid; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = temp;
            }
            try {
                return Integer.parseInt("-" + String.valueOf(chars));

            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
//        String s = String.valueOf(x);
//        System.out.println(s);
//        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
        int x = -1;
        System.out.println(x / 10);
        System.out.println(x % 10);

    }

}
