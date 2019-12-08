/*
 * @lc app=leetcode.cn id=213 lang=javascript
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    //DP
    var n = nums.length;
    if(n == 1){
        return nums[0];
    }else if(n == 0){
        return 0;
    }
    function dpGO(nums){
        let dp = new Array(n);
        dp[0] = 0;
        dp[1] = nums[0];
        for (let i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n-1];
    }
    var need1 = dpGO(nums.slice(1));
    var need2 = dpGO(nums.slice(0,nums.length-1));
    return Math.max(need1,need2);
};
// @lc code=end

