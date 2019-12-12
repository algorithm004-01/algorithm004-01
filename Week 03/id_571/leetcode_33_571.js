/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  let left = 0,
    right = nums.length - 1;
  while (left < right) {
    let mid = (right + left) >>> 1;
    //     [0, mid] go up
    if (nums[mid] >= nums[0] && (target > nums[mid] || target < nums[0])) {
      left = mid + 1;
    } else if (target > nums[mid] && target < nums[0]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return left === right && nums[left] === target ? left : -1;
};

search([4, 5, 6, 7, 0, 1, 2], 7);