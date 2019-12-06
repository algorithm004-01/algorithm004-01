class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // int Max = amount + 1;
        // vector<int> dp(amount + 1, Max);
        // dp[0] = 0;
        // for (int i = 1; i <= amount; i++) {
        //     for (int j = 0; j < coins.size(); j++) {
        //         if (coins[j] <= i) {
        //             dp[i] = min(dp[i], dp[i - coins[j]] + 1);
        //         }
        //     }
        // }
        // return dp[amount] > amount ? -1 : dp[amount];
        
        vector<int> need(amount+1, amount+1);
        need[0] = 0;
        for (int c : coins)
            for (int a=c; a<=amount; a++)
                need[a] = min(need[a], need[a-c] + 1);
        return need.back() > amount ? -1 : need.back();
    }
};