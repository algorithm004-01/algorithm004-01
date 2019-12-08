package com.mrglint.leetcode.week07.solution56;

import java.util.*;

/**
 * 1. 先对区间排序
 * 2. 遍历区间，比较结果集中最后一个区间的尾端值是否大于当前区间，大于则合并区间；小于则将当前区间添加到结果集
 * @author luhuancheng
 * @since 2019-11-28 22:31
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 区间排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 遍历区间
        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                // 合并区间，使用两个区间尾端较大值作为合并后的尾端
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[0][0]);
    }
}

