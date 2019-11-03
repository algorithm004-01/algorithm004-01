/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// var subsets = function(nums) {
//   let result = [];
//   let cur = [];
//   helper(nums, 0, cur, result);
//   return result;
// };

var helper = function(nums, index, cur, memo) {
  //   terminator
  if (index === nums.length) {
    memo.push(cur);
    return;
  }
  //   process current logic
  //   drill down
  helper(nums, index + 1, cur.slice(), memo); // not pick nums[index]
  cur.push(nums[index]);
  helper(nums, index + 1, cur.slice(), memo); // pick
  //   reverse state
};

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  let result = [[]];
  for (let num of nums) {
    let newset = [];
    for (let set of result) {
      let subset = set.concat(num);
      newset.push(subset);
    }
    result = result.concat(newset);
  }
  return result;
};

subsets([1, 2, 3]);
