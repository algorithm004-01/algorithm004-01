package homework.week03;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class LeetCode_122_501{
    /**
     * 思路：涨的话交易，跌就不交易
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1;i < prices.length; i ++){
            int val = prices[i] - prices[i-1];
            if(val > 0){
                sum += val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}