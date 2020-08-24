package com.ob.algorithm.other;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: oubin
 * @Date: 2019/5/22 08:55
 * @Description:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class OnlyOneAppear {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }

    /**
     * 使用异或实现：相同的数字异或后为0,0异或任何数都是那个数
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i ++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
