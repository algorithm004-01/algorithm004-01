package Greedy;

public class LeetCode_122_276 {
    public int maxProfile(int[] prices) {
        int max = 0;
        for (int i=0; i<prices.length-1;++i) {
            max += prices[i] > prices[i+1] ? prices[i]-prices[i+1] : 0;
        }
        return max;
    }
}
