package com.ob.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: oubin
 * @date: 2019/3/28 09:11
 * @Description: 电话号码的数字组合
 */
public class LetterCombination {

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if (null == digits || "".equals(digits)) {
            return list;
        }
        String[] str = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2' : str[i] = "abc";break;
                case '3':str[i]="def";break;
                case '4':str[i]="ghi";break;
                case '5':str[i]="jkl";break;
                case '6':str[i]="mno";break;
                case '7':str[i]="pqrs";break;
                case '8':str[i]="tuv";break;
                case '9':str[i]="wxyz";break;
            }
        }
        return recursive(0, str, list, "");
    }

    private static List<String> recursive(int i, String[] str, List<String> list, String temp) {

        if (i < str.length - 1) {
            for (int j = 0; j < str[i].length(); j++) {
                recursive(i + 1, str, list, temp + str[i].charAt(j));
            }
        }else {
            for (int j = 0; j < str[i].length(); j++) {
                list.add(temp + str[i].charAt(j));
            }
        }

        return list;
    }
}
