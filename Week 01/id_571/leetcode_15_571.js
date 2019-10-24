/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  nums = nums.sort((a, b) => a - b);
  let result = [];
  for (let k = 0; k < nums.length; k++) {
    if (nums[k] >= 0) break;
    let i = k + 1,
      j = nums.length - 1;
    while (i < j) {
      let s = nums[k] + nums[i] + nums[j];
      if (s < 0) {
        i++;
        while (nums[i] === nums[i - 1]) {
          i++;
        }
      } else if (s > 0) {
        j--;
        while (nums[j] === nums[j + 1]) {
          j--;
        }
      } else if (s === 0) {
        result.push([nums[k], nums[i], nums[j]]);
        break;
      }
    }
  }
  return result;
};

threeSum([-1, 0, 1, 2, -1, -4]);