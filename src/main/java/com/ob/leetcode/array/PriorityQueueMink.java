package com.ob.leetcode.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * PriorityQueueMink
 *
 * @Description:
 * @CreateDate: 2022/11/20 10:27
 * @Version: 1.0
 * @Author: oubin
 */
public class PriorityQueueMink {

    public void minK(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
            queue.offer(nums[i]);

            } else {
                if (nums[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }

        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,5,2};
        PriorityQueueMink mink = new PriorityQueueMink();
        mink.minK(nums, 3);
    }
}
