package com.ob.algorithm;

/**
 * @Author: oubin
 * @Date: 2019/6/6 08:34
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int length = nums.length;
        while (i < length && j < length) {
            if (nums[i] != 0) {
                i ++;
            }
            if (nums[j] == 0 || j < i) {
                j ++;
            }
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }

    }

    public static void moveZeroes1(int[] nums) {

        int j = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length)
        {
            nums[j++] = 0;
        }
    }

}
