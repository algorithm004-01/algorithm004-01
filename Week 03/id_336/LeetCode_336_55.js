// 解法一：暴力递归
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    function canJumpFromWhere(position,nums){
        // 跳到终点了
        if(position == nums.length - 1){
            return true;
        }
        // 当前位置可跳的最远距离索引位置，取min是因为最远距离不能超过nums的长度对应的索引值
        var furthestPosition = Math.min(position+nums[position],nums.length - 1);
        for(var nextPosition = position+1;nextPosition <= furthestPosition;nextPosition++){
            if(canJumpFromWhere(nextPosition,nums)){
                return true;
            }
        }
        return false;
    }
    return canJumpFromWhere(0,nums);
};
// 解法二：贪心算法
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    var canJumpMax = 0;
    var len = nums.length;
    for(var i = 0;i<len;i++){
        if(i > canJumpMax){
         return false;
        }
        canJumpMax = Math.max(canJumpMax,i+nums[i]);
        if(canJumpMax >= len-1){
            return true;
        }
    }
};