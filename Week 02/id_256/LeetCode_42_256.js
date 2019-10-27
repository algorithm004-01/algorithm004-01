/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    // 暴力
    // let rain = 0;
    // for (let i = 1; i < height.length; i++) {
    //     let leftM = 0;
    //     let rightM = 0;
    //     for (let j = 0; j < i; j++) {
    //         leftM = Math.max(leftM, height[j]);
    //     }
    //     for (let k = i + 1; k < height.length; k++) {
    //         rightM = Math.max(rightM, height[k]);
    //     }
    //     let min = Math.min(leftM, rightM);
    //     if(height[i] < min) {
    //         rain +=  min - height[i];
    //     }
    // }
    // return rain;
    // 双指针法
    let left = 1;
    let right = height.length - 2;
    let left_max = 0;
    let right_max = 0;
    let rain = 0;
    for (let i = 1; i < height.length - 1; i++) {
        if(height[left - 1] < height[right + 1]){
            left_max = Math.max(left_max, height[left - 1]);
            if(left_max > height[left]) {
                rain += (left_max - height[left]);
            }
            left++;
        } else {
            right_max = Math.max(right_max, height[right + 1]);
            if(right_max > height[right]) {
                rain += (right_max - height[right]);
            }
            right--;
        }
    }
    return rain;
};
// @lc code=end

