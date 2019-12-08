package com.uanei;

import java.util.List;

public class LeetCode_120_286 {

    public int minimumTotal(List<List<Integer>> triangle) {
        // 此处是因为第i行的元素个数是i+1，所以需要加1
        int[] A = new int[triangle.size() + 1];
        // 自底向上，每一层都求出最小的结果
        for (int i = triangle.size() - 1; i >= 0; i--) {
            // 对每一行的结果进行求解
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 注意： A 数组是记录每一行的求解结果，所以最终顶部的结果就是A[0]
                // 第一个 A[j] 是第 i,j 这个位置的结果
                // 第二个 A[j] 是下边一行中左边的结果
                // A[j+1] 是下边一行中右边哪个位置的结果
                // i,j 位置的结果 = 左角的结果和右角的结果的最小值 + i，j位置本身元素的值。
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

}
