import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-12 15:45
 **/

public class Leetcode_120_371 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int shortPath = minimumTotal3(triangle);
        System.out.println("shortPath = " + shortPath);
    }

    /**
     * 仿解3:dP(自底向上) +去掉额外的缓存数组
     *
     * @author Shaobo.Qian
     * @date 2019/11/12
     * @link https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
     */
    public static int minimumTotal3(List<List<Integer>> triangle) {
        int row = triangle.size();
        for (int level = row - 2; level >= 0; level--) {
            for (int col = 0; col <= level; col++) {
                //得到这一行与下一行相邻数的和的最小值
                int res = Math.min(triangle.get(level + 1).get(col), triangle.get(level + 1).get(col + 1)) + triangle.get(level).get(col);
                triangle.get(level).set(col, res);
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * 仿解2:dP(自底向上)
     *
     * @author Shaobo.Qian
     * @date 2019/11/12
     * @link https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
     * @link https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int col = 0; col <= level; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(level).get(col);
            }
        }
        return dp[0];
    }

    /**
     * 仿解1:DFS+记忆化数组 = 自顶向下的dp
     *
     * @author Shaobo.Qian
     * @date 2019/11/12
     * @link https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
     * @link https://leetcode.com/problems/triangle/discuss/159686/Java-Recursive-greaterTop-Down-greater-Bottom-up-greater-Bottom-Up-%2B-Optimal-Spacee
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        //记忆化数组,因为相邻节点很多要重复计算
        Integer[][] memo = new Integer[row][row];

        return recur(0, 0, row, triangle, memo);
    }

    private static int recur(int level, int col, int row, List<List<Integer>> triangle, Integer[][] memo) {
        if (memo[level][col] != null) {
            return memo[level][col];
        }
        if (level == row - 1) {
            return triangle.get(level).get(col);
        }
        int left = recur(level + 1, col, row, triangle, memo);
        int right = recur(level + 1, col + 1, row, triangle, memo);
        return memo[level][col] = Math.min(left, right) + triangle.get(level).get(col);
    }

    /**
     * 原解1:暴力(没考虑到:每一步只能移动到下一行中相邻的结点上。)
     *
     * @author Shaobo.Qian
     * @date 2019/11/12
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int shortPath = 0;
        for (int i = 0; i < triangle.size(); i++) {
            int lineMin = Integer.MAX_VALUE;
            List<Integer> subList = triangle.get(i);
            for (int j = 0; j < subList.size(); j++) {
                lineMin = Math.min(lineMin, subList.get(j));
            }
            shortPath += lineMin;
        }
        return shortPath;
    }
}
