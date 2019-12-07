/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var i = 0;
    nums.forEach(function (elem) {
        if (elem !== nums[i]) {
            nums[++i] = elem;
        }
    });
    return nums.length && i + 1;
};