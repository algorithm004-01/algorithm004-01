import java.util.Arrays;

// https://leetcode-cn.com/problems/unique-paths
// 62. 不同路径

public class LeetCode_62_716 {
    // 1. 自顶向下的递归实现 + 记忆化搜索
    // 单纯的递归实现会超出时间限制，复杂度过高，因为是指数级的时间复杂度
    // 1.1
    public int uniquePaths11(int m, int n) {
        // 记忆状态，省去重复计算，降低时间复杂度
        int[][] memo = new int[m][n];
        return uniquePaths(m, n, memo);
    }

    private int uniquePaths(int m, int n, int[][] memo) {
        // terminator
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (memo[m][n] > 0) return memo[m][n];

        // drill down
        memo[m][n] = uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo);
        return memo[m][n];
    }

    // 2. dp loop
    public int uniquePaths2(int m, int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[j] = memo[j] + memo[j - 1];
            }
        }
        return memo[n - 1];
    }
}