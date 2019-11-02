/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    if(!nums || nums.length==0 || k<=0) return nums;
    for(i=0;i<k;i++) {
        const temp = nums.pop();
        nums.unshift(temp);
    }
    return nums;
};