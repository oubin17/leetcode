package com.ob.algorithm;


/**
 * @Author: oubin
 * @Date: 2019/5/24 16:25
 * @Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class Palindrome {

    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for(Character c : chars) {
            if (c >= '0' && c<= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' ) {
                stringBuilder.append(c);
            }
        }
        String newStr = stringBuilder.toString().toUpperCase();
        String reverse = stringBuilder.reverse().toString().toUpperCase();
        return newStr.equals(reverse);
//        char[] charsNew = newStr.toCharArray();
//        if (charsNew.length == 0 || charsNew.length == 1) {
//            return true;
//        } else if (charsNew.length == 2) {
//            if (charsNew[0] == charsNew[1]) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        boolean check = true;
//        int num = charsNew.length/2 -1;
//        for (int i = 0; i <= num; i++) {
//            if (charsNew[i] != charsNew[charsNew.length - i - 1]) {
//                check = false;
//                break;
//            }
//        }
//        return check;
    }
}
