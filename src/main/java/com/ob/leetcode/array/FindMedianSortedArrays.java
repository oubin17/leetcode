package com.ob.leetcode.array;

/**
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @Description: https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 * @CreateDate: 2022/10/19 22:20
 * @Version: 1.0
 * @Author: oubin
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] A = {0,0};
        int[] B = {0,0};
        System.out.println(findMedianSortedArrays1(A, B));
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int current = 0, pre = 0;
        int index1 = 0, index2 = 0;
        for (int i = 0; i <= length >> 1; i++) {
            pre = current;
            if (index1 < m &&( index2 >= n || nums1[index1] < nums2[index2])) {
                current = nums1[index1 ++];
            } else {
                current = nums2[index2 ++];
            }
        }
        if ((length & 1) == 1) {
            return current;
        } else {
            return (current + pre) / 2.0;
        }




    }

    public static double findMedianSortedArrays(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }
}
