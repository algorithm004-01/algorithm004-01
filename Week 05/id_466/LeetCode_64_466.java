//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划
package com.aseara.leetcode.editor.cn.a64;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 64.最小路径和 <br />
 * Date: 2019/11/14 <br/>
 *
 * @author qiujingde
 */
class MinimumPathSum {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        assertEquals(7, solution.minPathSum(grid));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[n - 1] = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                memo[j] = Math.min(memo[j], memo[j + 1]) + grid[i][j];
            }
        }

        return memo[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
