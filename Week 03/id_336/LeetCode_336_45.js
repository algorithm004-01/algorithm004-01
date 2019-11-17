// #### 解法：贪心算法
/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    var steps = 0;
    var canJumpMax = 0;
    var last_canJumpMax = 0;
    var len = nums.length;
    for(var i = 0;i<len-1;i++){
        canJumpMax = Math.max(canJumpMax,i+nums[i]);
        if(last_canJumpMax == i){
            last_canJumpMax= canJumpMax;
            steps++;
        }
        if(last_canJumpMax >= len-1){
            break;
        }
    }
    return steps;
};