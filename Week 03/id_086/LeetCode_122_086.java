# 122 买卖股票的最佳时机
# 循环遍历，算出元素之间差最大（后一个减前一个元素的差，累计最大值），每一个元素差只能计算一次，

class Solution {
    public int maxProfit(int[] prices) {
       int countProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int  tmpProfit = prices[i] - prices[i - 1];
            if (tmpProfit > 0) {
                countProfit += tmpProfit;
            }
        }
        return countProfit;
    }
}