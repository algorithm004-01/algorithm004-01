
/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

[26. 删除排序数组中的重复项 - 力扣（LeetCode）](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
*/


/**
 * @param {number[]} nums
 * @return {number}
 */


var removeDuplicates = function(nums) {
  if(nums.length === 0) return 0;
  var i = 0;
  for (var j = 0; j<nums.length;j++) {
      if(nums[i]!==nums[j]) {
          i++;
          if(i!=j) {
              nums[i] = nums[j];
          }
      }
  }
  return i + 1
};