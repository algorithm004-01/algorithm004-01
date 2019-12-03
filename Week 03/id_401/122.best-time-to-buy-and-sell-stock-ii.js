/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var valley = prices[0];
    var peak = prices[0];
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