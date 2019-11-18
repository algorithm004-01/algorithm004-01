// #### 解法一：暴力枚举
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    return calc(prices,prices.length,0)
};
function calc(prices,len,start){
    if(start >= len){
        return 0;
    }
    var max = 0;
    for(var startIndex = start;startIndex<len;startIndex++){
        var maxProfit = 0;
        for(var i = startIndex+1;i<len;i++){
            if(prices[i] > prices[startIndex]){
                // 当前剩余价值+当前价值-第一天起始点价值 == 当前组合的总价值
                var profit = calc(prices,len,i+1) + prices[i] - prices[startIndex];
                // 更新当天与第i天 最大价值和
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        // 更新每天价值最大值的和
        if(maxProfit > max){
            max = maxProfit;
        }
    }
    return max;
}
// #### 解法二
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    // 谷值
    var valley = prices[0];
    // 峰值
    var peak = prices[0];
    // 最大利润值
    var maxProfit = 0;
    var lenNeed = prices.length - 1;
    var i = 0;
    while(i < lenNeed){
        while(i < lenNeed && prices[i] > prices[i+1]){
            i++;
        }
        valley = prices[i];
        while(i < lenNeed && prices[i] <= prices[i+1]){
            i++;
        }
        peak = prices[i];
        maxProfit += peak - valley;
    }
    return maxProfit;
};