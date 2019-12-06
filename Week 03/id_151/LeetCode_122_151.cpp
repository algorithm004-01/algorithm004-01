class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty())
            return 0;
        
        int have = prices[0];
        int earn = 0;
        for (int i = 1; i < prices.size(); ++i) {
            if (prices[i] > have) {
                earn += prices[i] - have;   
            }
            have = prices[i];
        }
        
        return earn;
    }
};
