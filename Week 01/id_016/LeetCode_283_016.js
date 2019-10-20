/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-18 09:05:04
 * @LastEditTime: 2019-10-18 09:14:21

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 case
  输入: [0,1,0,3,12]
  输出: [1,3,12,0,0]
 */

var moveZeroes = function(nums) {
  if (!nums.length) return;
  let length = nums.length;
  for (let i = 0; i < length; i++) {
    if (nums[i] === 0) {
      let temp = nums[i];
      nums.splice(i--, 1);
      nums.push(temp);
      length--;
    }
  }
  return nums;
};

console.log(moveZeroes([0, 1, 0, 3, 12]));