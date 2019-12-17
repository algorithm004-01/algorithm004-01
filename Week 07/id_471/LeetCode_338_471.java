class Solution {
    //dp[i] = dp[i / 2] + (i & 1);
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        int results[] = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
            results[i] = dp[i];
        }

        return results;
    }
}