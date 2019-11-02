class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int beginInt = 0;
        for(int i = 0; i < prices.length; i ++){
            if(i == 0){
                beginInt = prices[i];
            } else if (prices[i] <= beginInt){
                beginInt = prices[i];
            } else {
                result +=  prices[i] - beginInt;
                beginInt = prices[i];
            }
        }

        return result;
    }
}
