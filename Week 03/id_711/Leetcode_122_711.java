package Week3;

public class Leetcode_122_711 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 思路:
     *      当第二日的价格大于第一天价格买入，第二天小于第一天价格时卖出
     * 执行用时 :1 ms, 在所有 java 提交中击败了99.99%的用户
     * 内存消耗 :37.6 MB, 在所有 java 提交中击败了53.47%的用户
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        boolean flag = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                if (!flag) {
                    buy = prices[i];
                    flag = true;
                }
            }
            else if (flag) {
                maxProfit += prices[i] - buy;
                flag = false;
            }
        }
        if (flag) {
            maxProfit += prices[prices.length - 1] - buy;
        }
        return maxProfit;

    }
}
