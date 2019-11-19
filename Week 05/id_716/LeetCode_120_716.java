import java.util.List;

// https://leetcode-cn.com/problems/triangle
// 120. 三角形最小路径和
//

public class LeetCode_120_716 {
    private int row;

    // 1.1 递归，傻递归，复杂度较高
    // 自顶向下的递归求解，关键是找到重复性，运用递归思想，不要人肉递归
    public int minimumTotal11(List<List<Integer>> triangle) {
        row = triangle.size();
        return helper(0, 0, triangle);
    }

    private int helper(int level, int col, List<List<Integer>> triangle) {
        // terminator
        if (level == row - 1) return triangle.get(level).get(col);

        // drill down
        int left = helper(level + 1, col, triangle);
        int right = helper(level + 1, col + 1, triangle);

        // process current logic
        return Math.min(left, right) + triangle.get(level).get(col);
    }

    // 1.2 同样是使用递归，由于单纯递归的复杂度较高，考虑cache临时的中间结果，降低计算复杂度
    public int minimumTotal12(List<List<Integer>> triangle) {
        row = triangle.size();
        Integer[][] memo = new Integer[row][row];
        return helper(0, 0, memo, triangle);
    }

    private int helper(int level, int col, Integer[][] memo, List<List<Integer>> triangle) {
        // terminator
        if (level == row - 1) return triangle.get(level).get(col);

        if (memo[level][col] != null) return memo[level][col];

        // drill down
        int left = helper(level + 1, col, memo, triangle);
        int right = helper(level + 1, col + 1, memo, triangle);
        memo[level][col] = Math.min(left, right) + triangle.get(level).get(col);
        return memo[level][col];
    }

    // 2. dp, bottom-up
    //   复杂问题分解为子问题(分治)，split your big prob
    //   定义状态数组，有n个阶段的子问题，存放每个阶段的中间状态
    //   状态转移方程，dp方程，状态的推导方程
    public int minimumTotal21(List<List<Integer>> triangle) {
        row = triangle.size();
        int[][] dp = new int[row + 1][row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int col = 0; col <= level; col++) {
                dp[level][col] = Math.min(dp[level + 1][col], dp[level + 1][col + 1])
                        + triangle.get(level).get(col);
            }
        }
        return dp[0][0];
    }

    // 2.2 优化dp, bottom-up
    public int minimumTotal22(List<List<Integer>> triangle) {
        row = triangle.size();
        int[] dp = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int col = 0; col <= level; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(level).get(col);
            }
        }
        return dp[0];
    }
}