/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    let numsLength = nums.length;
    k = k % numsLength;
    reverse(nums, 0, numsLength-1);
    reverse(nums, 0, k-1);    
    reverse(nums, k, numsLength-1);
};

var reverse = function(nums, start, end){
    let tmp;
    while(start < end){
        tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
        start++;
        end--;
    }
}