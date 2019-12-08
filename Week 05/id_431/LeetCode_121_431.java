package easy;

/**
 * @author 潘磊明
 * @date 2019/11/13
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int fir = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int tmp = prices[i] - fir;
            max = Math.max(tmp, max);
            fir = tmp > 0 ? fir : prices[i];
        }
        return max;
    }
}
