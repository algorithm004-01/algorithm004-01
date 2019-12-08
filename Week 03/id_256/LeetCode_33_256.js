/*
 * @lc app=leetcode.cn id=33 lang=javascript
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    if(nums.length <= 0) return -1;
    while (left < right) {
        let mid = parseInt((left + right) / 2);
        if(target < nums[0] && target > nums[mid]) {
            left = mid + 1;
        } else if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left == right && nums[left] == target ? left : -1 ;

    // let left = 0;
    // let right = nums.length - 1;
    // while (left < right) {
    //     let mid = parseInt((left + right) / 2);
    //     if(target < nums[0] && target > nums[mid]) {
    //         left = mid + 1;
    //     }else if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
    //         left = mid + 1;
    //     }else{
    //         right = mid;
    //     }
    // }
    // return left == right && nums[left] == target ? left : -1;

};
// @lc code=end
