package com.ob.algorithm.string;

/**
 * @Author: oubin
 * @Date: 2020/8/24 22:11
 * @Description: 回文数
 */
public class Palindrome {

    public static void main(String[] args) {

        System.out.println(checkPalindrome(1221));
    }

    public static boolean checkPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        int div = 1;
        while (number / div >= 10) {
            div *= 10;
        }

        while (number > 0) {
            int left = number / div;
            int right = number % 10;
            if (left != right) {
                return false;
            }
            number = (number % div) /10;
            div /= 100;
        }

        return true;
    }
}
