/**
 * LeetCode_122_576
 */
public class LeetCode_122_576 {
    // 1. Greedy O(n)
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) 
                total += prices[i+1] - prices[i];
        }
        return total;
    }
}