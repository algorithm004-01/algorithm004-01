/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    // 暴力法 似乎会超时
    // let valley = 0; //谷
    // let peak = 0; //峰
    // let maxprofit = 0; //最大利润
    // let i = 0;
    // while(i < prices.length) {
    //     while(i < prices.length && prices[i] >= prices[i+1])
    //         i++;
    //     valley = prices[i];
    //     while(i < prices.length && prices[i] <= prices[i + 1])
    //         i++;
    //     peak = prices[i];
    //     maxprofit += (peak - valley);
    // }
    // return maxprofit;
    // 方法二
    let maxprofit = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1])
            maxprofit += prices[i] - prices[i - 1];
    }
    return maxprofit;

};
// @lc code=end

