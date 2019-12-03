/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-26 16:17:49
 * @LastEditTime: 2019-10-26 21:57:24
 */
/*
 * @lc app=leetcode id=78 lang=javascript
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (55.51%)
 * Likes:    2471
 * Dislikes: 60
 * Total Accepted:    433.8K
 * Total Submissions: 776.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 1. 暴力法迭代 循环要输入的数组和当前数组 时间O(n^2)
 2. 递归求解
 3. 动态规划,集合中每个元素的选和不选，构成了一个满二叉状态树
 4. 位运算-没有看懂
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// var subsets = function(nums) {
//   let res = [];
//   // 特殊情况处理
//   res.push([]);
//   for (let i = 0; i < nums.length; i++) {
//     let length = res.length;
//     for (let j = 0; j < length; j++) {
//       let cur = res[j];
//       res.push([...cur, nums[i]]);
//     }
//   }
//   return res;
// };
var subsets = function(nums) {
  let res = [];
  res.push([]);
  let deal = length => {
    // terminator
    if (length === nums.length) return;
    // process logic
    let len = res.length;
    for (let i = 0; i < len; i++) {
      res.push([...res[i], nums[length]]);
    }
    // drill down
    deal(length + 1);
  };
  deal(0);
  return res;
};
// var subsets = function(nums) {
//   let res = [];
//   let deal = (length, temp = []) => {
//     if (length === nums.length) {
//       res.push(temp);
//       return;
//     }
//     deal(length + 1, [...temp, nums[length]]);
//     deal(length + 1, temp);
//   };
//   deal(0);
//   return res;
// };

// 这个位运算看不懂
    // public static List<List<Integer>> binaryBit(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     for (int i = 0; i < (1 << nums.length); i++) {
    //         List<Integer> sub = new ArrayList<Integer>();
    //         for (int j = 0; j < nums.length; j++)
    //             if (((i >> j) & 1) == 1) sub.add(nums[j]);
    //         res.add(sub);
    //     }
    //     return res;
    // }

// @lc code=end
console.log(subsets([1, 2, 3]));
