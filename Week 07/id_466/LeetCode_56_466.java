//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组
package com.aseara.leetcode.editor.cn.a56;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 56.合并区间 <br />
 * Date: 2019/11/27 <br/>
 *
 * @author qiujingde
 */
class MergeIntervals {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected1 = {{1,6},{8,10},{15,18}};
        assertArrayEquals(expected1, solution.merge(intervals1));

        int[][] intervals2 = {{1,4},{4,5}};
        int[][] expected2 = {{1,5}};
        assertArrayEquals(expected2, solution.merge(intervals2));

        int[][] intervals3 = {{2,3},{4,6},{5,7},{3,4}};
        int[][] expected3 = {{2,7}};
        assertArrayEquals(expected3, solution.merge(intervals3));

        int[][] intervals4 = {{1,4},{0,0}};
        int[][] expected4 = {{0,0},{1,4}};
        assertArrayEquals(expected4, solution.merge(intervals4));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        return merge3(intervals);
    }

    private int[][] merge1(int[][] intervals) {
        List<int[]> result = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] mer = new int[2];
            mer[0] = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                i ++;
                end = Math.max(end, intervals[i][1]);
            }
            mer[1] = end;
            result.add(mer);
        }
        return result.toArray(new int[0][0]);
    }

    // 归并排序实现
    private int[][] merge2(int[][] intervals, int start, int end) {
        if (start == end) {
            return new int[][] {intervals[start]};
        }
        int mid = (start + end) >> 1;
        int[][] left = merge2(intervals, start, mid);
        int[][] right = merge2(intervals, mid + 1, end);
        List<int[]> result = new ArrayList<>(end - start);
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            int[] min = left[i][0] < right[j][0] ? left[i++] : right[j++];
            int l = min[0];
            int r = min[1];

            while ((i < left.length && r >= left[i][0]) || (j < right.length && r >= right[j][0])) {
                if (i < left.length && r >= left[i][0]) {
                    r = Math.max(r, left[i++][1]);
                }
                if (j < right.length && r >= right[j][0]) {
                    r = Math.max(r, right[j++][1]);
                }
            }
            result.add(new int[] {l, r});
        }
        for(; i < left.length; i++) {
            result.add(left[i]);
        }
        for(; j < right.length; j++) {
            result.add(right[j]);
        }
        return result.toArray(new int[0][0]);
    }

    //
    private int[][] merge3(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        int cnt = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    if (intervals[i][0] < intervals[j][0]) {
                        intervals[j][0] = intervals[i][0];
                    }
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    intervals[i] = null;
                    cnt ++;
                    break;
                }
            }
        }
        int[][] result = new int[intervals.length - cnt][];
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                result[j++] = intervals[i];
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
