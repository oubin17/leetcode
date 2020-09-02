package com.ob.algorithm.array;

/**
 * @Author: oubin
 * @Date: 2020/9/2 11:38
 * @Description: 股票买卖最大价值
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};
        int[] array1 = new int[]{7,6,4,3,1};
        System.out.println(maxValue(array));
        System.out.println(maxValue(array1));

    }

    /**
     * 只买卖一次
     *
     * @param array
     * @return
     */
    public static int maxValue(int[] array) {
        int maxValue = 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i] - min);
            min = Math.min(min, array[i]);
        }
        return maxValue;
    }

    /**
     * 买卖多次
     *
     * @param array
     * @return
     */
    public static int maxValue2(int[] array) {
        int res = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                res += array[i] - array[i -1];
            }
        }
        return res;
    }

}
