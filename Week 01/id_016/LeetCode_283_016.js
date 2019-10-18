/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-18 09:05:04
 * @LastEditTime: 2019-10-18 09:12:14

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