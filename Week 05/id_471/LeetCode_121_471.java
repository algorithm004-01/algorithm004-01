class Solution {
    //遍历数组，然后保存最小值，根据最小值和最大值的差来求利润，最后返回最大利润
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, result = 0;
        
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            result = Math.max(result, prices[i] - minPrice);
        }
        
        return result;
    }
}