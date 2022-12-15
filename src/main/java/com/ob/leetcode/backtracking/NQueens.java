package com.ob.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题
 *
 * @Description: https://leetcode.cn/problems/n-queens/
 * @CreateDate: 2022/12/13 23:15
 * @Version: 1.0
 * @Author: oubin
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[][] map = new int[n][n];
        backTracking(map, 0);
        return result;
    }

    private void backTracking(int[][] map, int row) {
        if (row == map.length) {
            List<String> list = new ArrayList<>();
            for (int[] ints : map) {
                StringBuilder str = new StringBuilder();
                for (int anInt : ints) {
                    str.append(anInt == 0 ? "." : "Q");
                }
                list.add(str.toString());
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            //decide
            if (!canPut(map, row, i)) {
                continue;
            }
            map[row][i] = 1;
            backTracking(map, row + 1);
            map[row][i] = 0;
        }

    }

    private boolean canPut(int[][] map, int row, int col) {
        //不需要检查行，因为当前行肯定都是0
//        for (int i = 0; i < map.length; i++) {
//            if (map[row][i] == 1) {
//                return false;
//            }
//        }
        //检查当前列
        for (int i = 0; i < map.length; i++) {
            if (map[i][col] == 1) {
                return false;
            }
        }
        //检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j] == 1) {
                return false;
            }
        }
        //检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < map.length; i--, j++) {
            if (map[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        System.out.println(lists.size());
    }
}
