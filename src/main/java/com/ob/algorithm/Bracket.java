package com.ob.algorithm;

import java.util.*;

/**
 * @author: oubin
 * @date: 2019/4/2 09:15
 * @Description:
 */
public class Bracket {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {

        if (null == s || s.length() == 0) {
            return true;
        }
        List<Character> listLeft = new ArrayList<>();
        listLeft.add('(');
        listLeft.add('{');
        listLeft.add('[');
        Map<Integer, Character> mapLeft = new HashMap<>(16);
        mapLeft.put(1, '(');
        mapLeft.put(2, '{');
        mapLeft.put(3, '[');
        Map<Character, Integer> mapRight = new HashMap<>(16);
        mapRight.put(')', 1);
        mapRight.put('}', 2);
        mapRight.put(']', 3);

        List<Character> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (listLeft.contains(s.charAt(i))) {
                result.add(s.charAt(i));
            }else {
                if (result.size() > 0 && result.get(result.size() - 1).equals(mapLeft.get(mapRight.get(s.charAt(i))))) {
                    result.remove(result.size() - 1);
                }else {
                    return false;
                }
            }
        }
        return result.size() == 0;
    }

    public static boolean isValid2(String s) {
        Stack<String> stack=new Stack<>();
        int len=s.length();
        for(int i=0;i<len;++i){
            switch(s.charAt(i)){
                case '(': stack.push("("); break;
                case '[': stack.push("["); break;
                case '{': stack.push("{"); break;
                case ')':
                    if(stack.isEmpty()||stack.pop()!="(") {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()||stack.pop()!="[") {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty()||stack.pop()!="{") {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

}
