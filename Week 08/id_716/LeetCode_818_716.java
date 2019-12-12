import java.util.Arrays;

public class LeetCode_818_716 {
    
    public int racecar(int target) {
        // dp[i] 表示到达位置i所需要的最少步数
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 到达 i...target, 每个阶段都计算一次
        // 计算每个阶段时，比较未到i之前回头再回头和过了i之后再回头
        for (int i = 1; i <= target; i++) {
            // DP 方程：到i之前回头两次的情况
            // 要遍历所有情况，从 1 开始，每次到 2^cnt1 - 1, 但是小于i
            // 固定正向走的次数的情况下，遍历反向所能到达位置的所有情况，
            // 并计算到达位置i的最小值，就是反复比较每种情况下取最小值
            int j = 1, cnt1 = 1;
            for (; j < i; j = (1 << ++cnt1) - 1) {
                for (int k = 0, cnt2 = 0; k < j; k = (1 << ++cnt2) - 1) {
                    // 正向到达j，反向距离k，总共前进 (j-k), 和i的距离是 i-(j-k)
                    // 然后要计算 dp[i-(j-k)] 所需要的最小步数，这个是重叠子问题，已经计算过了
                    // 直接从 dp 数组中取出即可，所以最后次数为：
                    //   cnt1 + 1 + cnt2 + 1 + dp[i- (j-k)]
                    dp[i] = Math.min(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)]);
                }
            }
            // DP 方程: 过了i之后再回头的情况
            // 如i正好是前进j步的值，那么最少步数就是 cnt1
            // 如果比i大了，就要回头（计数1次），回头的距离是 j-i，这个是重叠子问题
            // 因为 dp[j-i] 已经计算过了，直接取值即可
            dp[i] = Math.min(dp[i], cnt1 + (i == j ? 0 : 1 + dp[j - i]));
        }

        return dp[target];
    }
}