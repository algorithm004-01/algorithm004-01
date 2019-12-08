public class LeetCode_72_EditDistance {
    public static void main(String[] args) {
        Solution solution = new LeetCode_72_EditDistance().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {

            // 乍一看到这个题，条件反射的想到找最长子字符串，在此基础上进行增删改
            // 实际上，并不能这样解。举个例子，"abc"、"cde"，最长子字符串为"c"，
            // 如果在此基础上操作，则需要先删除"a"、"b"，再插入"d"、"e"，操作次数为 4。
            // 但是直接全部替换，操作次数只有 3。

            // a. 子问题
            //    i, j 处的最少操作次数
            //      word1[i] == word2[j]
            //        dp[i][j] = dp[i - 1][j - 1]
            //      word1[i] != word2[j]
            //        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
            // b. 状态数组定义
            // c. DP 方程
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}