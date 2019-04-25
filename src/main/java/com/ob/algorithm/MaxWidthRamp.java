package com.ob.algorithm;

import java.util.Arrays;

/**
 * @Author: oubin
 * @Date: 2019/4/25 08:39
 * @Description:
 */
public class MaxWidthRamp {

    public static void main(String[] args) {
        int[] a = new int[]{7,2,5,4};
        System.out.println(maxWidthRamp(a));
    }
    public static int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i) {
            B[i] = i;
        }
        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
