//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp =new int[n];
        for (int i = 0; i< n;i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }


        for (int i = n - 2; i >= 0;i--) {
            int len = i + 1;
            for (int j = 0; j <len;j++) {
                dp[j] = Math.min(dp[j] , dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
