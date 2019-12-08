/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let buff = {};
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] in buff) {
      return [buff[nums[i]], i];
    } else {
      buff[target - nums[i]] = i;
    }
  }
};
