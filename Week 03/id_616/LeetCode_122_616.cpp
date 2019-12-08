class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() < 2) return 0;
        int cnt = 0;
        for(int i = 1; i < prices.size(); ++i){
            int diff = prices[i] - prices[i-1];
            if(diff > 0) cnt += diff;
        }
        return cnt;
    }
};