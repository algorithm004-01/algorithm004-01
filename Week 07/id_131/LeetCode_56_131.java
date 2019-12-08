package com.lzhlyle.leetcode.recite.no56;

import java.util.Arrays;

public class MergeIntervals_2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        int mergeCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[i] = null;
                    mergeCount++;
                    break;
                }
            }
        }

        int[][] result = new int[intervals.length - mergeCount][2];
        for (int i = 0, j = 0; j < intervals.length; j++) {
            if (intervals[j] != null) result[i++] = intervals[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {1, 5}, {10, 80}, {0, 6}, {2, 3}};
        // 0, 1, 1, 2, 10
        // 3, 4, 5, 6, 80
        int[][] res = new MergeIntervals_2().merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
