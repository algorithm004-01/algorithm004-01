class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0 ;
        while(i < prices.length - 1){
            while(i < pricrs.length - 1 && prices[i] >= prices[ i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    //贪心算法
    public int maxProfit(int[] prices){
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            int diff = prices[i + 1] - price[i];
            if(diff > 0){
                res += diff;
            }
        }
        return res;

    }
}