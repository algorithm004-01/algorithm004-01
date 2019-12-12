/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = {};
    let res = [];
    for (let i = 0; i < nums.length; i++) {
        let tmp = target - nums[i];
        if(map[tmp+''] != undefined) {
            res = [map[tmp+''], i];
            break;
        } else {
            map[nums[i]+''] = i;
        }
    }
    return res;
};
// @lc code=end

