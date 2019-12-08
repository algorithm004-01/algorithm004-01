/**
 * method 1
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  for (let i = 0; i <= nums.length; i++) {
    if (nums[i] === 0) {
      // find no-zero number
      let j = i + 1;
      for (; j < nums.length; j++) {
        if (nums[j] !== 0) {
          break;
        }
      }
      // swap
      if (j === nums.length) {
        break;
      } else {
        [nums[i], nums[j]] = [nums[j], nums[i]];
      }
    }
  }
};

/**
 * method 2
 * @param {*} nums 
 */
var moveZeroes = function(nums) {
  let j = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      nums[j] = nums[i];
      if (i !== j) {
        nums[i] = 0;
      }
      j++;
    }
  }
};
