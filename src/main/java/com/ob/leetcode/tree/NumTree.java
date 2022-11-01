package com.ob.leetcode.tree;

import java.util.HashMap;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * @Description: https://leetcode.cn/problems/unique-binary-search-trees/description/
 * @CreateDate: 2022/11/1 23:04
 * @Version: 1.0
 * @Author: oubin
 * 解答：https://leetcode.cn/problems/unique-binary-search-trees/solutions/1319816/a-qiu-javadi-gui-jie-fa-by-emeraki-qi2d/
 */
public class NumTree {



    public static int numTrees(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        return count(n, hashMap);

    }

    public static int count(int n, HashMap<Integer, Integer> hashMap) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        int count = 0;
        for (int i = 1; i < n; i++) {

            int leftNum = count(i - 1, hashMap);

            int right = count(n - i, hashMap);

            count += leftNum * right;
        }
        hashMap.put(n, count);

        return count;
    }


}
